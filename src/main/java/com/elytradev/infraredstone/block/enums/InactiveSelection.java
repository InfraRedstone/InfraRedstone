package com.elytradev.infraredstone.block.enums;

import net.minecraft.util.StringIdentifiable;

public enum InactiveSelection implements StringIdentifiable {
	LEFT("left"),
	BACK("back"),
	RIGHT("right");

	private String name;

	InactiveSelection(String name) {
		this.name = name;
	}

	@Override
	public String asString() {
		return name;
	}

	public static InactiveSelection forName(String name) {
		for (InactiveSelection sel : values()) {
			if (sel.name.equals(name)) {
				return sel;
			}
		}
		return BACK;
	}
}
