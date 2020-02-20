package com.elytradev.infraredstone.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;

import javax.annotation.Nullable;
import java.util.HashSet;
import java.util.Set;

public class EncoderBlock extends ModuleBaseBlock {
	public EncoderBlock(Settings settings) {
		super(settings);
	}

	@Override
	Set<Direction> getOutputDirections(BlockView view, BlockPos pos, BlockState state) {
		Set<Direction> ret = new HashSet<>();
		ret.add(state.get(FACING));
		return ret;
	}

	@Override
	Set<Direction> getInputDirections(BlockView view, BlockPos pos, BlockState state) {
		return new HashSet<>();
	}

	@Nullable
	@Override
	public BlockEntity createBlockEntity(BlockView view) {
		return null;
	}
}
