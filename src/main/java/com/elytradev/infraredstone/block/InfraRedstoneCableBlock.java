package com.elytradev.infraredstone.block;

import nerdhub.cardinal.components.api.ComponentType;
import nerdhub.cardinal.components.api.component.BlockComponentProvider;
import nerdhub.cardinal.components.api.component.Component;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Waterloggable;
import net.minecraft.block.enums.WireConnection;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;

import javax.annotation.Nullable;
import java.util.Set;

public class InfraRedstoneCableBlock extends Block implements Waterloggable, BlockComponentProvider {
	public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;
	public static final EnumProperty<WireConnection> NORTH = Properties.NORTH_WIRE_CONNECTION;
	public static final EnumProperty<WireConnection> SOUTH = Properties.SOUTH_WIRE_CONNECTION;
	public static final EnumProperty<WireConnection> EAST = Properties.EAST_WIRE_CONNECTION;
	public static final EnumProperty<WireConnection> WEST = Properties.WEST_WIRE_CONNECTION;

	public InfraRedstoneCableBlock(Settings settings) {
		super(settings);
		setDefaultState(this.getStateManager().getDefaultState()
				.with(NORTH, WireConnection.NONE)
				.with(SOUTH, WireConnection.NONE)
				.with(EAST, WireConnection.NONE)
				.with(WEST, WireConnection.NONE)
		);
	}

	@Override
	protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
		builder.add(WATERLOGGED, NORTH, EAST, SOUTH, WEST);
	}

	@Override
	public <T extends Component> boolean hasComponent(BlockView blockView, BlockPos blockPos, ComponentType<T> componentType, @Nullable Direction direction) {
		return false;
	}

	@Nullable
	@Override
	public <T extends Component> T getComponent(BlockView blockView, BlockPos blockPos, ComponentType<T> componentType, @Nullable Direction direction) {
		return null;
	}

	@Override
	public Set<ComponentType<?>> getComponentTypes(BlockView blockView, BlockPos blockPos, @Nullable Direction direction) {
		return null;
	}
}
