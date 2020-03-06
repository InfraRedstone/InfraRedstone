package com.elytradev.infraredstone.block;

import com.elytradev.infraredstone.InfraRedstone;
import com.elytradev.infraredstone.block.entity.AndGateBlockEntity;
import com.elytradev.infraredstone.block.entity.DiodeBlockEntity;
import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.function.Supplier;

public class InRedBlocks {
	public static final Block INFRA_REDSTONE = register(new InfraRedstoneCableBlock(defaultSettings()), "infra_redstone");
	public static final Block INFRA_REDSTONE_SCAFFOLD = register(new InfraRedstoneScaffoldBlock(FabricBlockSettings.of(Material.PART).build()), "infra_redstone_scaffold");
	public static final Block INFRA_REDSTONE_BLOCK = register(new InfraRedstoneBlock(FabricBlockSettings.of(Material.PART).build()), "infra_redstone_block");
	public static final Block DIODE = register(new DiodeBlock(defaultSettings()), "diode");
	public static final Block AND_GATE = register(new AndGateBlock(defaultSettings()), "and_gate");
	public static final Block NOT_GATE = register(new NotGateBlock(defaultSettings()), "not_gate");
	public static final Block XOR_GATE = register(new XorGateBlock(defaultSettings()), "xor_gate");
	public static final Block TRANSISTOR = register(new TransistorBlock(defaultSettings()), "transistor");
	public static final Block SHIFTER = register(new ShifterBlock(defaultSettings()), "shifter");
	public static final Block OSCILLATOR = register(new OscillatorBlock(defaultSettings()), "oscillator");
	public static final Block ENCODER = register(new EncoderBlock(defaultSettings()), "encoder");

	public static final BlockEntityType<DiodeBlockEntity> DIODE_BE = register(DiodeBlockEntity::new, "diode", DIODE);
	public static final BlockEntityType<AndGateBlockEntity> AND_GATE_BE = register(AndGateBlockEntity::new, "and_gate", AND_GATE);
	public static final BlockEntityType<AndGateBlockEntity> NOT_GATE_BE = register(AndGateBlockEntity::new, "not_gate", NOT_GATE);

	public static Block register(Block block, String name) {
		Registry.register(Registry.BLOCK, new Identifier(InfraRedstone.MODID, name), block);
		Registry.register(Registry.ITEM, new Identifier(InfraRedstone.MODID, name), new BlockItem(block, new Item.Settings().group(InfraRedstone.IN_RED_GROUP)));
		return block;
	}

	public static <T extends BlockEntity> BlockEntityType<T> register(Supplier<T> supplier, String name, Block... blocks) {
		return Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(InfraRedstone.MODID, name), BlockEntityType.Builder.create(supplier, blocks).build(null));
	}
	
	public static Block.Settings defaultSettings() {
		return FabricBlockSettings.of(Material.PART).noCollision().build();
	}

	public static void init() {

	}

}
