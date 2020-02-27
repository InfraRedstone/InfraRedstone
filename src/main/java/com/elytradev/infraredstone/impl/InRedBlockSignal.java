package com.elytradev.infraredstone.impl;

import com.elytradev.infraredstone.api.InRedSignalComponent;

public class InRedBlockSignal implements InRedSignalComponent {
	public static final InRedBlockSignal INSTANCE = new InRedBlockSignal();

	private InRedBlockSignal() { }

	@Override
	public int getSignalValue() {
		return 63;
	}

	@Override
	public boolean isOutput() {
		return true;
	}
}
