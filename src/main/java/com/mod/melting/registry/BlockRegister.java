package com.mod.melting.registry;

import com.mod.melting.block.MelterBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static com.mod.melting.StoneSmelting.MODID;

public class BlockRegister {
	public static final Block MELTER = new MelterBlock(AbstractBlock.Settings.copy(Blocks.OBSIDIAN).luminance(Blocks.createLightLevelFromLitBlockState(13)));

	public static void registerBlocks() {
		register("melter", MELTER);
		BlockEntityRegister.registerBlockEntities();
	}

	private static Block register(String id, Block block) {
		return Registry.register(Registries.BLOCK, Identifier.of(MODID, id), block);
	}
}
