package com.mod.melting;

import com.mod.melting.registry.*;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StoneSmelting implements ModInitializer {
	public static final String MODID = "melting";
	public static final Logger LOGGER = LoggerFactory.getLogger(MODID);

	@Override
	public void onInitialize() {
		BlockRegister.registerBlocks();
		LOGGER.info("blocks and block entities registered");

		ItemRegister.registerItems();
		LOGGER.info("items registered");

		RecipeTypeRegister.registerRecipeTypes();
		LOGGER.info("recipe types registered");

		ScreenHandlerTypeRegister.registerScreenHandlerTypes();
		LOGGER.info("screen handler types registered");
	}
}
