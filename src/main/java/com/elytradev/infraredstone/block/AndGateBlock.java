package com.elytradev.infraredstone.block;

import com.elytradev.infraredstone.block.enums.InactiveSelection;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.EnumProperty;

public class AndGateBlock extends ModuleBaseBlock {
	//declare our properties - waterloggability, north/south/east/orientation, logic mode, and which input is inactive
	public static final BooleanProperty BOOLEAN_MODE = BooleanProperty.of("boolean_mode");
	public static final EnumProperty<InactiveSelection> INACTIVE = EnumProperty.of("inactive", InactiveSelection.class);

	public AndGateBlock(Settings settings) {
		super(settings);
		setDefaultState(this.getStateManager().getDefaultState()
				.with(WATERLOGGED, false)
				.with(BOOLEAN_MODE, false)
				.with(INACTIVE, InactiveSelection.NONE));
	}

	// append our properties to the state manager, so the game knows our block actually needs them
	@Override
	protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
		super.appendProperties(builder);
		builder.add(BOOLEAN_MODE, INACTIVE);
	}

}
