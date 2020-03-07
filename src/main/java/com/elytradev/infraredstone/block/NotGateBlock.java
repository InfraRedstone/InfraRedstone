package com.elytradev.infraredstone.block;

import com.elytradev.infraredstone.block.entity.NotGateBlockEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;

import javax.annotation.Nullable;
import java.util.Collections;
import java.util.Set;

public class NotGateBlock extends ModuleBaseBlock {
    public static final BooleanProperty BOOLEAN_MODE = BooleanProperty.of("boolean_mode");

    public NotGateBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
        builder.add(BOOLEAN_MODE);
    }

    @Override
    Set<Direction> getOutputDirections(BlockView view, BlockPos pos, BlockState state) {
        return Collections.singleton(state.get(FACING));
    }

    @Override
    Set<Direction> getInputDirections(BlockView view, BlockPos pos, BlockState state) {
        return Collections.singleton(state.get(FACING).getOpposite());
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockView view) {
        return new NotGateBlockEntity();
    }
}
