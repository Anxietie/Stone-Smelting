package com.mod.melting;

import com.mod.melting.registry.HandledScreensRegister;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

import static com.mod.melting.StoneSmelting.LOGGER;

@Environment(EnvType.CLIENT)
public class StoneSmeltingClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		HandledScreensRegister.registerHandledScreens();
		LOGGER.info("handled screens registered");
	}
}
