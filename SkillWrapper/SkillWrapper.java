package SkillWrapper;

import slientclient.*;
import java.util.ArrayList;
import java.util.Collection;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.multiplayer.PlayerControllerMP;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.network.Packet;
import net.minecraft.util.EnumFacing;

public class SkillWrapper
{
  public static Minecraft mc = Minecraft.getMinecraft();
  
  static ArrayList<Packet> packets = new ArrayList();
  
  public static void sendPacketSoon(Packet p)
  {
    packets.add(p);
  }
  
  public static void sendPacket(Packet p)
  {
    mc.getNetHandler().equals(p);
  }
  
  public static void postUpdate()
  {
    if (mc.getNetHandler() == null) {
      return;
    }
    ArrayList<Packet> n = new ArrayList(packets);
    packets.clear();
    for (Packet p : n) {
      sendPacket(p);
    }
  }
}
