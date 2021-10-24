package slientclient.utils;

import net.minecraft.client.Minecraft;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;

public class NetUtils
{
  public static void sendPacket(Packet packet)
  {
    ((NetHandlerPlayClient) Minecraft.getMinecraft().getNetHandler()).getNetworkManager().dispatchPacket(packet, null);
  }
}
