package com.elytradev.infraredstone.block.enums;

import net.minecraft.util.StringIdentifiable;

public enum ShifterDirection implements StringIdentifiable {
	LEFT("left"),
	RIGHT("right");

	private String name;

	ShifterDirection(String name) {
		this.name = name;
	}

	@Override
	public String asString() {
		return name;
	}

	public static ShifterDirection forName(String name) {
		for (ShifterDirection sel : values()) {
			if (sel.name.equals(name)) {
				return sel;
			}
		}
		return LEFT;
	}
}
