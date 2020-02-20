package com.elytradev.infraredstone.block.entity;

import com.elytradev.infraredstone.block.InRedBlocks;
import net.minecraft.nbt.CompoundTag;

public class DiodeBlockEntity extends ModuleBaseBlockEntity {
	private int signal = 5;

	public DiodeBlockEntity() {
		super(InRedBlocks.DIODE_BE);
	}

	@Override
	int getOutputSignal() {
		return signal;
	}

	@Override
	public void fromTag(CompoundTag tag) {
		super.fromTag(tag);
	}

	@Override
	public CompoundTag toTag(CompoundTag tag) {
		super.toTag(tag);

		return tag;
	}

	@Override
	public void fromClientTag(CompoundTag tag) {
		fromTag(tag);
	}

	@Override
	public CompoundTag toClientTag(CompoundTag tag) {
		return toTag(tag);
	}
}
