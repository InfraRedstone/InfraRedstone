package com.elytradev.infraredstone.block.entity;

import com.elytradev.infraredstone.api.InRedLogic;
import net.fabricmc.fabric.api.block.entity.BlockEntityClientSerializable;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.Tickable;

public abstract class ModuleBaseBlockEntity extends BlockEntity implements BlockEntityClientSerializable, Tickable {
	//TODO: signal and lastSignal fields here?

	public ModuleBaseBlockEntity(BlockEntityType<?> type) {
		super(type);
	}

	public abstract int getOutputSignal();

	public abstract void updateSignal();

	@Override
	public void tick() {
		if (InRedLogic.isIRTick() && !world.isClient) {
			updateSignal();
		}
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
