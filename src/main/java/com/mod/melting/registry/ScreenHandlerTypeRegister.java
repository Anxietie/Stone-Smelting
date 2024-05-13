package com.mod.melting.registry;

import com.mod.melting.screen.MelterScreenHandler;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.resource.featuretoggle.FeatureFlags;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

import static com.mod.melting.StoneSmelting.MODID;

public class ScreenHandlerTypeRegister {
	public static final ScreenHandlerType<MelterScreenHandler> MELTER = new ScreenHandlerType<>(MelterScreenHandler::new, FeatureFlags.VANILLA_FEATURES);

	public static void registerScreenHandlerTypes() {
		register("melter", MELTER);
	}

	private static <T extends ScreenHandler> ScreenHandlerType<T> register(String id, ScreenHandlerType<T> screenHandlerType) {
		return Registry.register(Registries.SCREEN_HANDLER, Identifier.of(MODID, id), screenHandlerType);
	}
}
