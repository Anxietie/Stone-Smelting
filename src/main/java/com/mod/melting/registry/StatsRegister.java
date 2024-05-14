package com.mod.melting.registry;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.stat.StatFormatter;
import net.minecraft.stat.Stats;
import net.minecraft.util.Identifier;

import static com.mod.melting.StoneSmelting.MODID;

public class StatsRegister {
	public static final Identifier INTERACT_WITH_MELTER = new Identifier(MODID, "interact_with_melter");

	public static void registerStats() {
		// register(INTERACT_WITH_MELTER);
	}

	private static Identifier register(Identifier id) {
		Registry.register(Registries.CUSTOM_STAT, id, id);
		Stats.CUSTOM.getOrCreateStat(id, StatFormatter.DEFAULT);
		return id;
	}
}
