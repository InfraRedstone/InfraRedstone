package com.elytradev.infraredstone.api;

import com.elytradev.infraredstone.InfraRedstone;
import nerdhub.cardinal.components.api.component.BlockComponentProvider;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

public class InRedLogic {
	public static boolean isIRTick() {
		//TODO: impl - once every other tick by default, possibly configurable?
		return true;
	}

	public static int findIRValue(World world, BlockPos pos, Direction searchDir) {
		//TODO: impl wire search, currently only does direct adjacent
		BlockPos newPos = pos.offset(searchDir);
		BlockState checkState = world.getBlockState(newPos);
		BlockComponentProvider provider = BlockComponentProvider.get(checkState);
		if (provider.hasComponent(world, newPos, InfraRedstone.IN_RED_SIGNAL, searchDir.getOpposite())) {
			InRedSignalComponent comp = provider.getComponent(world, newPos, InfraRedstone.IN_RED_SIGNAL, searchDir.getOpposite());
			if (comp.isOutput()) return comp.getSignalValue();
		}
		//TODO: return 0 or -1 if no signal value? Have another method for seeing if there's no signal value?
		return 0;
	}

}
