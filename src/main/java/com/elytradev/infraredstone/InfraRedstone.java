package com.elytradev.infraredstone;

import com.elytradev.infraredstone.block.InRedBlocks;
import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class InfraRedstone implements ModInitializer {
	public static final String MODID = "infraredstone";

	public static final Logger logger = LogManager.getLogger();

	@Override
	public void onInitialize() {
		InRedBlocks.init();
		System.out.println("I have initialized. UwU");
	}
}
