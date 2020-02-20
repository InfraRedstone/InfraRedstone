package com.elytradev.infraredstone.block.entity;

import net.fabricmc.fabric.api.block.entity.BlockEntityClientSerializable;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.nbt.CompoundTag;

public abstract class ModuleBaseBlockEntity extends BlockEntity implements BlockEntityClientSerializable {
	public ModuleBaseBlockEntity(BlockEntityType<?> type) {
		super(type);
	}

	abstract int getOutputSignal();

	@Override
	public void fromClientTag(CompoundTag tag) {
		fromTag(tag);
	}

	@Override
	public CompoundTag toClientTag(CompoundTag tag) {
		return toTag(tag);
	}
}
