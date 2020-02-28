package com.elytradev.infraredstone.block;

import com.elytradev.infraredstone.block.enums.InactiveSelection;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;

import javax.annotation.Nullable;
import java.util.Set;

public class AndGateBlock extends ModuleBaseBlock {
	public static final BooleanProperty BOOLEAN_MODE = BooleanProperty.of("boolean_mode");
	public static final EnumProperty<InactiveSelection> INACTIVE = EnumProperty.of("inactive", InactiveSelection.class);

	public AndGateBlock(Settings settings) {
		super(settings);
		setDefaultState(this.getStateManager().getDefaultState()
				.with(WATERLOGGED, false)
				.with(BOOLEAN_MODE, false)
				.with(INACTIVE, InactiveSelection.NONE));
	}

	@Override
	protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
		super.appendProperties(builder);
		builder.add(BOOLEAN_MODE, INACTIVE);
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
