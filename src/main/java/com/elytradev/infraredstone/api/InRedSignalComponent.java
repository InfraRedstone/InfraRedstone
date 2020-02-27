package com.elytradev.infraredstone.api;

import nerdhub.cardinal.components.api.component.Component;
import net.minecraft.nbt.CompoundTag;

public interface InRedSignalComponent extends Component {
	/**
	 * @return The signal value to transmit at the current time. If not isOutput(), return 0.
	 */
	int getSignalValue();

	/**
	 * @return Whether this component is an emitting node or not.
	 */
	boolean isOutput();

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
