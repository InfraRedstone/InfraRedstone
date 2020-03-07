package com.elytradev.infraredstone.block.entity;

import com.elytradev.infraredstone.block.InRedBlocks;
import net.minecraft.nbt.CompoundTag;

public class XorGateBlockEntity extends ModuleBaseBlockEntity {
    private int lastSignal = -1;
    private int signal = 0;

    public XorGateBlockEntity() {
        super(InRedBlocks.XOR_GATE_BE);
    }

    @Override
    public int getOutputSignal() {
        return signal;
    }

    @Override
    public void updateSignal() {
        int value = signal;

        value^=value;

        signal = value;

        if (signal != lastSignal) {
            lastSignal = signal;
            if (!world.isClient) sync();
        }
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
}
