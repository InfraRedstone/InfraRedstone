package com.elytradev.infraredstone.block;

import com.elytradev.infraredstone.block.enums.ShifterDirection;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;

import javax.annotation.Nullable;
import java.util.Set;

public class ShifterBlock extends ModuleBaseBlock {
	public static EnumProperty<ShifterDirection> SELECTION = EnumProperty.of("selection", ShifterDirection.class);

	public ShifterBlock(Settings settings) {
		super(settings);
	}

	@Override
	protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
		super.appendProperties(builder);
		builder.add(SELECTION);
	}

	@Override
	Set<Direction> getOutputDirections(BlockView view, BlockPos pos, BlockState state) {
		return null;
	}

	@Override
	Set<Direction> getInputDirections(BlockView view, BlockPos pos, BlockState state) {
		return null;
	}

	@Nullable
	@Override
	public BlockEntity createBlockEntity(BlockView view) {
		return null;
	}
}
