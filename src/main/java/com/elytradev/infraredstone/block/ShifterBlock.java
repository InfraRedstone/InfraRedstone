package com.elytradev.infraredstone.block;

import com.elytradev.infraredstone.block.enums.ShifterDirection;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.EnumProperty;

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
}
