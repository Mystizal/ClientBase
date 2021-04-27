package dev.zihasz.clientbase;

import club.minnced.discord.rpc.DiscordEventHandlers;
import club.minnced.discord.rpc.DiscordRPC;
import club.minnced.discord.rpc.DiscordRichPresence;

public class DiscordPresence {

	private static final DiscordRPC rpc = DiscordRPC.INSTANCE;
	private static final DiscordRichPresence presence = new DiscordRichPresence();

	private static final String version = ClientBase.MOD_VER;
	private static final String name    = ClientBase.MOD_NAME;

	public static final String APP_ID = "";
	public static final String STEAM_ID = "";

	public static void start() {
		DiscordEventHandlers eventHandlers = new DiscordEventHandlers();
		eventHandlers.disconnected = ((var1, var2) -> System.out.println("Discord RPC disconnected, var1: " + var1 + ", var2: " + var2));
		rpc.Discord_Initialize(APP_ID, eventHandlers, true, STEAM_ID);

		presence.largeImageKey = "large";
		presence.largeImageText = "";
		presence.largeImageKey = "small";
		presence.largeImageText = "";

		presence.details = "";
		presence.state   = "";

		presence.startTimestamp = System.currentTimeMillis() / 1000L;

		rpc.Discord_UpdatePresence(presence);
	}

	public static void stop() {
		rpc.Discord_Shutdown();
		rpc.Discord_ClearPresence();
	}

	public static void updatePresence(String details, String state) {
		presence.details = details;
		presence.state   = state;

		rpc.Discord_UpdatePresence(presence);
	}

	public static String getState() { return presence.state; }
	public static String getDetails() { return presence.details; }

}
