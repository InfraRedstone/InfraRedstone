package com.elytradev.infraredstone.block.entity;

import com.elytradev.infraredstone.block.InRedBlocks;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.nbt.CompoundTag;

public class AndGateBlockEntity extends ModuleBaseBlockEntity {
    private int lastSignal = 0;
    private int signal = 0;

    public AndGateBlockEntity() {
        super(InRedBlocks.AND_GATE_BE);
    }

    @Override
    public int getOutputSignal() {
        return signal;
    }

    @Override
    public void updateSignal() {
        // TODO: signal update logic
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
    public void fromClientTag(CompoundTag tag) {
        fromTag(tag);
    }

    @Override
    public CompoundTag toClientTag(CompoundTag tag) {
        return toTag(tag);
    }


}
