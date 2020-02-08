package com.elytradev.infraredstone.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.Waterloggable;
import net.minecraft.entity.EntityContext;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

import javax.annotation.Nullable;

public abstract class ModuleBaseBlock extends Block implements Waterloggable {
	public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;
	public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;

	public static final VoxelShape BASE_SHAPE = VoxelShapes.cuboid(0, 0, 0, 1, 3/16f, 1);

	public ModuleBaseBlock(Settings settings) {
		super(settings);
	}

	@Override
	protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
		builder.add(WATERLOGGED, FACING);
	}

	@Nullable
	@Override
	public BlockState getPlacementState(ItemPlacementContext ctx) {
		return this.getDefaultState().with(FACING, ctx.getPlayerFacing());
	}

	@Override
	public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, EntityContext ePos) {
		return BASE_SHAPE;
	}
}
