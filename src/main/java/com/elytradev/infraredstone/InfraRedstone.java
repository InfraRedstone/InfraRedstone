package com.elytradev.infraredstone;

import com.elytradev.infraredstone.block.InRedBlocks;
import com.elytradev.infraredstone.item.InRedItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class InfraRedstone implements ModInitializer {
	public static final String MODID = "infraredstone";

	public static final ItemGroup IN_RED_GROUP = FabricItemGroupBuilder.build(new Identifier(MODID, "in_red_group"), () -> new ItemStack(InRedBlocks.INFRA_REDSTONE));

	public static final Logger logger = LogManager.getLogger();

	@Override
	public void onInitialize() {
		InRedBlocks.init();
		InRedItems.init();
		logger.info("I have initialized. UwU");
	}
}
