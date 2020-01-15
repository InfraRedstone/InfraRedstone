package com.elytradev.infraredstone.block;

import com.elytradev.infraredstone.InfraRedstone;
import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class InRedBlocks {
    public static final Block AND_GATE = register(new Block(FabricBlockSettings.of(Material.PART).build()), "and_gate");

    public static Block register(Block block, String name) {
        Registry.register(Registry.BLOCK, new Identifier(InfraRedstone.MODID, name), block);
        return block;
    }

    public static void init() {

	}

}
