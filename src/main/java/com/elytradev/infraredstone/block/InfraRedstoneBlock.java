package com.elytradev.infraredstone.block;

import com.elytradev.infraredstone.InfraRedstone;
import com.elytradev.infraredstone.impl.InRedBlockSignal;
import nerdhub.cardinal.components.api.ComponentType;
import nerdhub.cardinal.components.api.component.BlockComponentProvider;
import nerdhub.cardinal.components.api.component.Component;
import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;

import javax.annotation.Nullable;
import java.util.Collections;
import java.util.Set;

public class InfraRedstoneBlock extends Block implements BlockComponentProvider {
	public InfraRedstoneBlock(Settings settings) {
		super(settings);
	}

	@Override
	public <T extends Component> boolean hasComponent(BlockView view, BlockPos pos, ComponentType<T> type, @Nullable Direction direction) {
		return type == InfraRedstone.IN_RED_SIGNAL;
	}

	@Nullable
	@Override
	@SuppressWarnings("unchecked")
	public <T extends Component> T getComponent(BlockView view, BlockPos pos, ComponentType<T> type, @Nullable Direction direction) {
		if (type == InfraRedstone.IN_RED_SIGNAL) return (T) InRedBlockSignal.INSTANCE;
		return null;
	}

	@Override
	public Set<ComponentType<?>> getComponentTypes(BlockView view, BlockPos pos, @Nullable Direction direction) {
		return Collections.singleton(InfraRedstone.IN_RED_SIGNAL);
	}
}
