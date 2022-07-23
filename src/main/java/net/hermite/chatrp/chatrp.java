package net.hermite.chatrp;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.message.v1.ServerMessageEvents;
import net.hermite.chatrp.handlers.ChatHandler;
import net.hermite.chatrp.utils.ModRegistries;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

public class chatrp implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger("modid");

	public static ArrayList<String> ListeEspion = new ArrayList<String>();
	public static Boolean StopChat = false;
	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		ModRegistries.registerModStuffs();

		LOGGER.info("Hello Fabric world!");
		ServerMessageEvents.ALLOW_CHAT_MESSAGE.register((message, sender, typeKey) ->
		{
			ChatHandler.ChatRP(message, sender);
			return false;
		});
	}
}
