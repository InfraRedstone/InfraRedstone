package com.elytradev.infraredstone.impl;

import com.elytradev.infraredstone.api.InRedSignalComponent;
import com.elytradev.infraredstone.block.entity.ModuleBaseBlockEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

public class ModuleOutputSignal implements InRedSignalComponent {
	private ModuleBaseBlockEntity be;

	public ModuleOutputSignal(BlockView world, BlockPos pos) {
		this((ModuleBaseBlockEntity)world.getBlockEntity(pos));
	}

	public ModuleOutputSignal(ModuleBaseBlockEntity be) {
		this.be = be;
	}

	@Override
	public int getSignalValue() {
		return be.getOutputSignal();
	}

	@Override
	public boolean isOutput() {
		return true;
	}
}
