package com.elytradev.infraredstone.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;

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
}
