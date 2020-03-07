package com.elytradev.infraredstone.api;

import com.elytradev.infraredstone.InfraRedstone;
import nerdhub.cardinal.components.api.component.BlockComponentProvider;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

public class InRedLogic {
	private static final int INTER_IR_TICKS = 2;
	private static int CURRENT_TICKS = 0;

	public static boolean isIRTick() {
		return CURRENT_TICKS == 0;
	}

	public static void tickIR() {
		CURRENT_TICKS++;
		CURRENT_TICKS %= INTER_IR_TICKS;
	}

	public static int findIRValue(World world, BlockPos pos, Direction searchDir) {
		BlockPos initialPos = pos.offset(searchDir);
		if (!checkCandidacy(world, initialPos, searchDir)) {
			BlockPos up = initialPos.up();
			if (checkCandidacy(world, up, searchDir)) {
				System.out.println("Found a connection up");
				initialPos = up;
			} else {
				BlockPos down = initialPos.down();
				if (checkCandidacy(world, down, searchDir)) {
					System.out.println("Found a connection down");
					initialPos = down;
				} else {
					return world.getEmittedRedstonePower(initialPos, searchDir) != 0? 1 : 0;
				}
			}
		}
		if (world.isAir(initialPos)) return 0;
		BlockState state = world.getBlockState(initialPos);
		BlockComponentProvider provider = BlockComponentProvider.get(state);
		if (provider.hasComponent(world, initialPos, InfraRedstone.IN_RED_CABLE, searchDir.getOpposite())) {
			// Search!
			return wireSearch(world, initialPos, searchDir);
		}

		if (provider.hasComponent(world, initialPos, InfraRedstone.IN_RED_SIGNAL, searchDir.getOpposite())) {
			InRedSignalComponent comp = provider.getComponent(world, initialPos, InfraRedstone.IN_RED_SIGNAL, searchDir.getOpposite());
			return comp.getSignalValue();
		}

		// Oh. Okay. No wires or machines. Well, return the vanilla redstone value as
		// the bottom bit here and call it a day.
		return (world.getEmittedRedstonePower(initialPos, searchDir) != 0) ? 1 : 0;
	}

	public static boolean checkCandidacy(World world, BlockPos pos, Direction side) {
		if (world.isAir(pos)) return false;
		BlockState state = world.getBlockState(pos);
		BlockComponentProvider provider = BlockComponentProvider.get(state);
		if (provider.hasComponent(world, pos, InfraRedstone.IN_RED_SIGNAL, side.getOpposite())) {
			InRedSignalComponent comp = provider.getComponent(world, pos, InfraRedstone.IN_RED_SIGNAL, side.getOpposite());
			return comp != null && comp.isOutput();
		}
		if (provider.hasComponent(world, pos, InfraRedstone.IN_RED_CABLE, side.getOpposite())) {
			//TODO: still not 100% sure with cable component...
			return true;
		}
		return false;
	}

	private static int wireSearch(World world, BlockPos pos, Direction dir) {
		//TODO: implement for real
		return 0;
	}

}
