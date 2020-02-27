package com.elytradev.infraredstone.api;

import nerdhub.cardinal.components.api.component.Component;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.World;

import java.util.Set;

//TODO: how best to structure this to allow diagonals? Not sure this is set up very well...
public interface InRedCableComponent extends Component {

	/**
	 * List which positions relative to the current position are possible to connect to.
	 * @return A set of all connectable offsets as relative block vectors.
	 */
	Set<Vec3i> getConnectableOffsets();

	boolean shouldConnectTo(World world, BlockPos pos, Vec3i offset);

	@Override
	default void fromTag(CompoundTag tag) {
		//NO-OP
	}

	@Override
	default CompoundTag toTag(CompoundTag tag) {
		//NO-OP
		return tag;
	}
}
