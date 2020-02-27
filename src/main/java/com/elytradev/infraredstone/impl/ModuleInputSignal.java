package com.elytradev.infraredstone.impl;

import com.elytradev.infraredstone.api.InRedSignalComponent;

public class ModuleInputSignal implements InRedSignalComponent {
	public static final ModuleInputSignal INSTANCE = new ModuleInputSignal();

	private ModuleInputSignal() { }

	@Override
	public int getSignalValue() {
		return 0;
	}

	@Override
	public boolean isOutput() {
		return false;
	}
}
