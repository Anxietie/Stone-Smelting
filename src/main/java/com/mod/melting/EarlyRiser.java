package com.mod.melting;

import com.chocohead.mm.api.ClassTinkerers;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.MappingResolver;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public class EarlyRiser implements Runnable {
	@Override
	public void run() {
		MappingResolver remapper = FabricLoader.getInstance().getMappingResolver();

		String recipeBookCategory = remapper.mapClassName("intermediary", "net.minecraft.class_5421");
		ClassTinkerers.enumBuilder(recipeBookCategory).addEnum("MELTER").build();

		String recipeBookGroup = remapper.mapClassName("intermediary", "net.minecraft.class_314");
		String itemStackArray = "[L" + remapper.mapClassName("intermediary", "net.minecraft.class_1799") + ';';
		ClassTinkerers.enumBuilder(recipeBookGroup, itemStackArray).addEnum("MELTER_SEARCH", () -> new Object[]{new ItemStack[]{Items.COMPASS.getDefaultStack()}}).build();
		ClassTinkerers.enumBuilder(recipeBookGroup, itemStackArray).addEnum("MELTER_BLOCKS", () -> new Object[]{new ItemStack[]{Items.SMOOTH_STONE.getDefaultStack()}}).build();
	}
}