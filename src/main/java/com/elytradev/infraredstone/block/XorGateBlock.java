package com.elytradev.infraredstone.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;

public class XorGateBlock extends ModuleBaseBlock {
	public static final BooleanProperty BOOLEAN_MODE = BooleanProperty.of("boolean_mode");

	public XorGateBlock(Settings settings) {
		super(settings);
	}

	@Override
	protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
		super.appendProperties(builder);
		builder.add(BOOLEAN_MODE);
	}
}
