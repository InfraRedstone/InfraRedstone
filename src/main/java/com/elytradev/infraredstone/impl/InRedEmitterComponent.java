package com.elytradev.infraredstone.impl;

import com.elytradev.infraredstone.api.InRedSignalComponent;
import net.minecraft.nbt.CompoundTag;

public class InRedEmitterComponent implements InRedSignalComponent {
	@Override
	public int getSignalValue() {
		return 0;
	}

	@Override
	public boolean isOutput() {
		return false;
	}

	@Override
	public void fromTag(CompoundTag compoundTag) {

	}

	@Override
	public CompoundTag toTag(CompoundTag compoundTag) {
		return null;
	}
}
