package com.elytradev.infraredstone.item;

import com.elytradev.infraredstone.InfraRedstone;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class InRedItems {
	public static final Item PCB = register("pcb", new Item(new Item.Settings()));

	public static Item register(String name, Item item) {
		return Registry.register(Registry.ITEM, new Identifier(InfraRedstone.MODID, name), item);
	}

	public static void init() {

	}
}
