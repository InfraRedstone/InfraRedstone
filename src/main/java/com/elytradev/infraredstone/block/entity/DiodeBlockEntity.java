package com.elytradev.infraredstone.block.entity;

import com.elytradev.infraredstone.api.InRedLogic;
import com.elytradev.infraredstone.block.DiodeBlock;
import com.elytradev.infraredstone.block.InRedBlocks;
import com.elytradev.infraredstone.block.ModuleBaseBlock;
import net.minecraft.block.BlockState;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;

public class DiodeBlockEntity extends ModuleBaseBlockEntity {
	private int lastSignal = -1;
	private int signal = 0;

	public DiodeBlockEntity() {
		super(InRedBlocks.DIODE_BE);
	}

	@Override
	public int getOutputSignal() {
		return signal;
	}

	//TODO: put fromTag and toTag stuff into module base?

	@Override
	public void fromTag(CompoundTag tag) {
		super.fromTag(tag);
		tag.putInt("Signal", signal);
		tag.putInt("LastSignal", lastSignal);
	}

	@Override
	public CompoundTag toTag(CompoundTag tag) {
		super.toTag(tag);
		signal = tag.getInt("Signal");
		lastSignal = tag.getInt("LastSignal");
		return tag;
	}

	@Override
	public void updateSignal() {
		BlockState state = getCachedState();
		Direction dir = state.get(ModuleBaseBlock.FACING).getOpposite();

		int back = InRedLogic.findIRValue(world, pos, dir);
		if (back == 0) {
			//no IR signal, so get redstone input and multiply by 4
			//TODO: temporary, this actually belongs in the Encoder
			BlockPos newPos = pos.offset(dir);
			back = world.getEmittedRedstonePower(newPos, dir.getOpposite()) * 4;
		}
		signal = back & getBitMask();
		System.out.println("Diode at " + pos.toString() + " has signal " + signal);
		if (signal != lastSignal) {
			lastSignal = signal;
			if (!world.isClient) save();
			BlockPos frontPos = pos.offset(dir.getOpposite());
			world.getBlockState(frontPos).neighborUpdate(world, frontPos, state.getBlock(), pos, true);
		}
	}

	private int getBitMask() {
		int ret = 0;
		BlockState state = getCachedState();
		//a bit being false means that signal is allowed through
		if (state.get(DiodeBlock.BIT_0)) ret |= 0b00_0001;
		if (state.get(DiodeBlock.BIT_1)) ret |= 0b00_0010;
		if (state.get(DiodeBlock.BIT_2)) ret |= 0b00_0100;
		if (state.get(DiodeBlock.BIT_3)) ret |= 0b00_1000;
		if (state.get(DiodeBlock.BIT_4)) ret |= 0b01_0000;
		if (state.get(DiodeBlock.BIT_5)) ret |= 0b10_0000;
		return ret;
	}
}
