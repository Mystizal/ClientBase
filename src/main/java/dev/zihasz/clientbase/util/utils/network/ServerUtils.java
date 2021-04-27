package dev.zihasz.clientbase.util.utils.network;

import dev.zihasz.clientbase.ClientBase;
import dev.zihasz.clientbase.util.Util;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.network.NetHandlerLoginClient;
import net.minecraft.network.EnumConnectionState;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.handshake.client.C00Handshake;
import net.minecraft.network.login.client.CPacketLoginStart;

import java.net.InetAddress;

public class ServerUtils extends Util {

	private static NetworkManager networkManager;

	public static void connect(String ip, int port) {
		try {
			ClientBase.LOGGER.info("Trying to connect to " + ip + ":" + port);

			networkManager = NetworkManager.createNetworkManagerAndConnect(InetAddress.getByName(ip), port, mc.gameSettings.isUsingNativeTransport());
			networkManager.setNetHandler(new NetHandlerLoginClient(networkManager, mc, new GuiMainMenu()));
			networkManager.sendPacket(new C00Handshake(ip, port, EnumConnectionState.LOGIN, true));
			networkManager.sendPacket(new CPacketLoginStart(mc.getSession().getProfile()));

			ClientBase.LOGGER.info("Connected to " + ip + ":" + port);
		} catch (Exception ex) {
			ClientBase.LOGGER.info("Failed to connect!");
			ex.printStackTrace();
		}
	}

}
