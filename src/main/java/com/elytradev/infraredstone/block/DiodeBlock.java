package com.elytradev.infraredstone.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;

import javax.annotation.Nullable;
import java.util.HashSet;
import java.util.Set;

public class DiodeBlock extends ModuleBaseBlock {
	public static final BooleanProperty BIT_0 = BooleanProperty.of("bit_0");
	public static final BooleanProperty BIT_1 = BooleanProperty.of("bit_1");
	public static final BooleanProperty BIT_2 = BooleanProperty.of("bit_2");
	public static final BooleanProperty BIT_3 = BooleanProperty.of("bit_3");
	public static final BooleanProperty BIT_4 = BooleanProperty.of("bit_4");
	public static final BooleanProperty BIT_5 = BooleanProperty.of("bit_5");

	public DiodeBlock(Settings settings) {
		super(settings);
	}

	@Override
	protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
		super.appendProperties(builder);
		builder.add(BIT_0, BIT_1, BIT_2, BIT_3, BIT_4, BIT_5);
	}

	@Override
	Set<Direction> getOutputDirections(BlockView view, BlockPos pos, BlockState state) {
		Set<Direction> ret = new HashSet<>();
		ret.add(state.get(FACING));
		return ret;
	}

	@Override
	Set<Direction> getInputDirections(BlockView view, BlockPos pos, BlockState state) {
		Set<Direction> ret = new HashSet<>();
		ret.add(state.get(FACING).getOpposite());
		return ret;
	}

	@Nullable
	@Override
	public BlockEntity createBlockEntity(BlockView view) {
		return null;
	}
}
