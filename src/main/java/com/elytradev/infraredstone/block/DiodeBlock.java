package com.elytradev.infraredstone.block;

import com.elytradev.infraredstone.block.entity.DiodeBlockEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.Collections;
import java.util.Set;

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
	public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
		//TODO: toggle bits
		return super.onUse(state, world, pos, player, hand, hit);
	}

	@Override
	protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
		super.appendProperties(builder);
		builder.add(BIT_0, BIT_1, BIT_2, BIT_3, BIT_4, BIT_5);
	}

	@Override
	Set<Direction> getOutputDirections(BlockView view, BlockPos pos, BlockState state) {
		return Collections.singleton(state.get(FACING));
	}

	@Override
	Set<Direction> getInputDirections(BlockView view, BlockPos pos, BlockState state) {
		return Collections.singleton(state.get(FACING).getOpposite());
	}

	@Nullable
	@Override
	public BlockEntity createBlockEntity(BlockView view) {
		return new DiodeBlockEntity();
	}

	@Override
	public int getStrongRedstonePower(BlockState state, BlockView view, BlockPos pos, Direction facing) {
		if (facing == state.get(FACING).getOpposite()) {
			DiodeBlockEntity be = (DiodeBlockEntity)view.getBlockEntity(pos);
			int signal = be.getOutputSignal();
			return (int) Math.floor(signal / 4d);
		}
		return super.getStrongRedstonePower(state, view, pos, facing);
	}

	@Override
	public int getWeakRedstonePower(BlockState state, BlockView view, BlockPos pos, Direction facing) {
		return getStrongRedstonePower(state, view, pos, facing);
	}

	@Override
	public boolean emitsRedstonePower(BlockState state) {
		return true;
	}

}
