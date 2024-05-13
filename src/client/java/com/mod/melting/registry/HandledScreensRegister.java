package com.mod.melting.registry;

import com.mod.melting.gui.screen.ingame.MelterScreen;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.ingame.HandledScreens;

@Environment(EnvType.CLIENT)
public class HandledScreensRegister {
	public static void registerHandledScreens() {}

	static {
		HandledScreens.register(ScreenHandlerTypeRegister.MELTER, MelterScreen::new);
	}
}
