package slientclient.utils;

import slientclient.main.*;
import net.minecraft.*;
import slientclient.*;
import slientclient.event.EventManager;

import java.io.File;
import java.util.HashMap;

import javax.print.DocFlavor.URL;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.multiplayer.PlayerControllerMP;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.network.Packet;
import net.minecraft.util.ChatAllowedCharacters;
import org.apache.commons.io.FileUtils;
import org.lwjgl.opengl.Display;
import net.minecraft.util.Timer;

public class Wrapper
{
  public static Minecraft getMinecraft()
  {
    return Minecraft.getMinecraft();
  }
  
  
  public static Minecraft mc()
  {
    return Minecraft.getMinecraft();
  }
  
  
  public static EntityPlayerSP player()
  {
    return Minecraft.getMinecraft().player;
  }
  
  public static EntityPlayerSP getPlayer()
  {
    return getMinecraft().player;
  }
  
  public static HackPack getHackPack() {
	return getHackPack();
  }
  
  public static WorldClient getWorld()
  {
    return getMinecraft().world;
  }
  
  public static FontRenderer getFontRenderer()
  {
    return getMinecraft().fontRendererObj;
  }
  
  public static EntityRenderer getRenderer()
  {
    return getMinecraft().entityRenderer;
  }
  
  public static GameSettings getGameSettings()
  {
    return getMinecraft().gameSettings;
  }
  
  public static Timer getTimer()
  {
    return getMinecraft().timer;
  }
  
  public static NetHandlerPlayClient getSendQueue()
  {
    return getPlayer().connection;
  }
  
  public static ScaledResolution getScaledResolution()
  {
    return new ScaledResolution(getMinecraft());
  }
}
