package com.elytradev.infraredstone.block.entity;

import com.elytradev.infraredstone.api.InRedLogic;
import com.elytradev.infraredstone.block.InRedBlocks;
import com.elytradev.infraredstone.block.NotGateBlock;
import net.minecraft.block.BlockState;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.math.Direction;

public class NotGateBlockEntity extends ModuleBaseBlockEntity {
    private int lastSignal = -1;
    private int signal = 0;


    public NotGateBlockEntity() {
        super(InRedBlocks.NOT_GATE_BE);
    }

    @Override
    public int getOutputSignal() {
        return signal;
    }

    @Override
    public void updateSignal() {
        BlockState state = getCachedState();
        Direction front = state.get(NotGateBlock.FACING);
        Direction back = front.getOpposite();
        int signalBack = InRedLogic.findIRValue(world, pos, back);
        System.out.println("Not gate finds signal of " + signalBack);

        int value = signalBack;
        // bitwise NOT
        value = ~value;

        signal = value;
        if (signal != lastSignal) {
            lastSignal = signal;
            if (!world.isClient) save();
        }
    }

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
