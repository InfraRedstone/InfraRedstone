package com.elytradev.infraredstone.block.entity;

import com.elytradev.infraredstone.api.InRedLogic;
import net.fabricmc.fabric.api.block.entity.BlockEntityClientSerializable;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.Tickable;

public abstract class ModuleBaseBlockEntity extends BlockEntity implements BlockEntityClientSerializable, Tickable {
	//TODO: signal and lastSignal fields here?
	private boolean firstTick = true;

	public ModuleBaseBlockEntity(BlockEntityType<?> type) {
		super(type);
	}

	public abstract int getOutputSignal();

	public abstract void updateSignal();

	@Override
	public void tick() {
		if (InRedLogic.isIRTick() && !world.isClient) {
			if (firstTick) {
				firstTick = false;
				updateSignal();
				save();
			}
			updateSignal();
		}
	}

	@Override
	public void fromTag(CompoundTag tag) {
		super.fromTag(tag);
		firstTick = tag.getBoolean("FirstTick");
	}

	@Override
	public CompoundTag toTag(CompoundTag tag) {
		super.toTag(tag);
		tag.putBoolean("FirstTick", firstTick);
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

	public void save() {
		if (!world.isClient) sync();
		markDirty();
	}
}
