package com.elytradev.infraredstone.block.entity;

import com.elytradev.infraredstone.api.InRedLogic;
import com.elytradev.infraredstone.block.AndGateBlock;
import com.elytradev.infraredstone.block.InRedBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.WorldPosition;

public class AndGateBlockEntity extends ModuleBaseBlockEntity {
    private int lastSignal = -1;
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
        BlockState state = getCachedState();
        Direction front = state.get(AndGateBlock.FACING);
        Direction left = front.rotateYCounterclockwise();
        Direction back = front.getOpposite();
        Direction right = front.rotateYClockwise();
        int signalLeft = InRedLogic.findIRValue(world, pos, left);
        int signalBack = InRedLogic.findIRValue(world, pos, back);
        int signalRight = InRedLogic.findIRValue(world, pos, right);
        int value;

        switch(state.get(AndGateBlock.INACTIVE)) {
            case LEFT:
                value = signalBack & signalRight;
                break;
            case BACK:
                value = signalLeft & signalRight;
                break;
            case RIGHT:
                value = signalLeft & signalBack;
                break;
            default:
                value = signalLeft & signalBack & signalRight;
        }

        signal = value;
        System.out.println("and gate has signal " + signal);
        if (signal != lastSignal) {
            lastSignal = signal;
            if (!world.isClient) save();
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
