package com.elytradev.infraredstone.block;

import com.elytradev.infraredstone.block.enums.InactiveSelection;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Waterloggable;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;

import javax.annotation.Nullable;

public class AndGateBlock extends Block implements Waterloggable {
	//declare our properties - waterloggability, north/south/east/orientation, logic mode, and which input is inactive
	public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;
	public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;
	public static final BooleanProperty BOOLEAN_MODE = BooleanProperty.of("boolean_mode");
	public static final EnumProperty<InactiveSelection> INACTIVE = EnumProperty.of("inactive", InactiveSelection.class);

	public AndGateBlock(Settings settings) {
		super(settings);
	}

	// append our properties to the state manager, so the game knows our block actually needs them
	@Override
	protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
		builder.add(WATERLOGGED, FACING, BOOLEAN_MODE, INACTIVE);
	}

	// set our placement state, so it faces away from the player when placed
	@Nullable
	@Override
	public BlockState getPlacementState(ItemPlacementContext ctx) {
		return this.getDefaultState().with(FACING, ctx.getPlayerFacing());
	}
}
