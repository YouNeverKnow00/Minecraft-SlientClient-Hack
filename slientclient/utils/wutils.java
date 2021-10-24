package slientclient.utils;

import java.io.File;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.network.Packet;
import net.minecraft.util.ChatAllowedCharacters;
import slientclient.main.ChatComponentText;

import org.apache.commons.io.FileUtils;
import org.lwjgl.opengl.Display;

public class wutils
{
  private static HackPack hackpack;
  private static String version = "1.8.8";
  private static String clientname = "Crasher";
  public static String IPKick = "";
  public static int PortKick = 25565;
  
  public wutils()
  {
    hackpack = new HackPack();
    
    File geo = new File(mc().mcDataDir, "Jessica/GeoIP2-City.mmdb");
    if (!geo.exists())
    {
      URL source = getClass().getResource("/Files/GeoIP2-City.mmdb");
      File dest = new File(mc().mcDataDir, "Jessica/GeoIP2-City.mmdb");
      try
      {
        FileUtils.copyURLToFile(source, dest);
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }
    Display.setTitle(getClientName() + " " + getVesrion());
  }
  
  public static Minecraft mc()
  {
    return Minecraft.getMinecraft();
  }
  
  public static WorldClient world()
  {
    return mc().world;
  }
  
  public static String getVesrion()
  {
    return version;
  }
  
  public static String currentDate()
  {
    return new SimpleDateFormat("yyyy-MM-dd_HH.mm.ss").format(new Date());
  }
  
  public static HackPack getHackPack()
  {
    return hackpack;
  }
  
  public static String getClientName()
  {
    return clientname;
  }
  
  public static EntityPlayerSP player()
  {
    return mc().player;
  }
  
  public static void sendPacket(Packet p)
  {
    player().sendQueue.addToSendQueue(p);
  }
}
