package com.elytradev.infraredstone.impl;

import com.elytradev.infraredstone.api.InRedSignalComponent;
import net.minecraft.nbt.CompoundTag;

public class InRedComponentImpl implements InRedSignalComponent {
	@Override
	public int getSignalValue() {
		return 0;
	}

	@Override
	public boolean isOutput() {
		return false;
	}

	@Override
	public void fromTag(CompoundTag tag) {
		//NOOP
	}

	@Override
	public CompoundTag toTag(CompoundTag tag) {
		//NOOP
		return new CompoundTag();
	}
}
