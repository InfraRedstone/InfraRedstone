package com.elytradev.infraredstone.item;

import com.elytradev.infraredstone.InfraRedstone;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class InRedItems {
	public static final Item PCB = register("pcb", new Item(new Item.Settings().group(InfraRedstone.IN_RED_GROUP)));
	public static final Item MULTIMETER = register("multimeter", new Item(new Item.Settings().group(InfraRedstone.IN_RED_GROUP))); //TODO: proper multimeter item

	public static Item register(String name, Item item) {
		return Registry.register(Registry.ITEM, new Identifier(InfraRedstone.MODID, name), item);
	}

	public static void init() {

	}
}
