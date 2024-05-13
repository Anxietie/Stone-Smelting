package com.mod.melting.registry;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static com.mod.melting.StoneSmelting.MODID;

public class ItemRegister {
	public static void registerItems() {
		registerBlockItems();
		registerItemGroups();
	}

	private static void registerBlockItems() {
		register("melter", new BlockItem(BlockRegister.MELTER, new Item.Settings()));
	}

	private static void registerItemGroups() {
		ItemStack melter = BlockRegister.MELTER.asItem().getDefaultStack();
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(content -> content.addAfter(Items.BLAST_FURNACE, melter));
	}

	private static Item register(String id, Item item) {
		return Registry.register(Registries.ITEM, Identifier.of(MODID, id), item);
	}
}
