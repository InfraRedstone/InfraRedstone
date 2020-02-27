package com.elytradev.infraredstone.block;

import com.elytradev.infraredstone.InfraRedstone;
import com.elytradev.infraredstone.impl.ModuleInputSignal;
import com.elytradev.infraredstone.impl.ModuleOutputSignal;
import nerdhub.cardinal.components.api.ComponentType;
import nerdhub.cardinal.components.api.component.BlockComponentProvider;
import nerdhub.cardinal.components.api.component.Component;
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
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

import javax.annotation.Nullable;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public abstract class ModuleBaseBlock extends Block implements Waterloggable, BlockEntityProvider, BlockComponentProvider {
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

	abstract Set<Direction> getOutputDirections(BlockView view, BlockPos pos, BlockState state);
	abstract Set<Direction> getInputDirections(BlockView view, BlockPos pos, BlockState state);

	@Override
	public <T extends Component> boolean hasComponent(BlockView view, BlockPos pos, ComponentType<T> type, @Nullable Direction direction) {
		if (type == InfraRedstone.IN_RED_SIGNAL) {
			BlockState state = view.getBlockState(pos);
			return getInputDirections(view, pos, state).contains(direction) || getOutputDirections(view, pos, state).contains(direction);
		}
		return false;
	}

	@Nullable
	@Override
	@SuppressWarnings("unchecked")
	public <T extends Component> T getComponent(BlockView view, BlockPos pos, ComponentType<T> type, @Nullable Direction direction) {
		if (type == InfraRedstone.IN_RED_SIGNAL) {
			BlockState state = view.getBlockState(pos);
			if (getInputDirections(view, pos, state).contains(direction)) {
				return (T) ModuleInputSignal.INSTANCE;
			} else if (getOutputDirections(view, pos, state).contains(direction)) {
				return (T) new ModuleOutputSignal(view, pos);
			}
		}
		return null;
	}

	@Override
	public Set<ComponentType<?>> getComponentTypes(BlockView view, BlockPos pos, @Nullable Direction direction) {
		BlockState state = view.getBlockState(pos);
		if (getInputDirections(view, pos, state).contains(direction) || getOutputDirections(view, pos, state).contains(direction)) {
			return Collections.singleton(InfraRedstone.IN_RED_SIGNAL);
		}
		return new HashSet<>();
	}
}
