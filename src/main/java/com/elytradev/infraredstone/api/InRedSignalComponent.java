package com.elytradev.infraredstone.api;

import nerdhub.cardinal.components.api.component.Component;

public interface InRedSignalComponent extends Component {
	/**
	 * @return The signal value to transmit at the current time. If not isOutput(), return 0.
	 */
	int getSignalValue();

	/**
	 * @return Whether this component is an emitting node or not.
	 */
	boolean isOutput();
}
