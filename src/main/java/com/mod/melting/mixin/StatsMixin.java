package com.mod.melting.mixin;

import com.mod.melting.stats.ModStats;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.stat.StatFormatter;
import net.minecraft.stat.StatType;
import net.minecraft.stat.Stats;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static com.mojang.text2speech.Narrator.LOGGER;

@Mixin(Stats.class)
public abstract class StatsMixin {
	@Shadow
	public static @Final StatType<Identifier> CUSTOM;

	@Inject(method = "register", at = @At("TAIL"))
	private static void register(String id, StatFormatter formatter, CallbackInfoReturnable<Identifier> cir) {
		if (id.equals("interact_with_loom")) {
			Identifier identifier = ModStats.INTERACT_WITH_MELTER;
			Registry.register(Registries.CUSTOM_STAT, identifier, identifier);
			CUSTOM.getOrCreateStat(identifier, StatFormatter.DEFAULT);
			LOGGER.info("stats registered");
		}
	}
}
