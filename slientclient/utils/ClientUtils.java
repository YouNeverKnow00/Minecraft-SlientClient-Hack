package slientclient.utils;

import java.util.ArrayList;
import java.util.List;
import slientclient.*;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.multiplayer.PlayerControllerMP;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.client.resources.IReloadableResourceManager;
import net.minecraft.client.resources.LanguageManager;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.entity.Entity;
import net.minecraft.network.Packet;
import net.minecraft.util.ChatAllowedCharacters;
import net.minecraft.*;
import net.minecraft.util.MovementInput;
import net.minecraft.util.ResourceLocation;

public final class ClientUtils
{
  
  public static Minecraft mc()
  {
    return Minecraft.getMinecraft();
  }
  
  public static EntityPlayerSP player()
  {
    return mc().player;
  }
  
  public static PlayerControllerMP playerController()
  {
    return mc().playerController;
  }
  
  public static WorldClient world()
  {
    return mc().world;
  }
  
  public static List<Entity> loadedEntityList()
  {
    List<Entity> loadedList = new ArrayList(world().loadedEntityList);
    loadedList.remove(player());
    return loadedList;
  }
  
  public static GameSettings gamesettings()
  {
    return mc().gameSettings;
  }
  
  public static MovementInput movementInput()
  {
    return player().movementInput;
  }
  
  public static double x()
  {
    return player().posX;
  }
  
  public static void x(double x)
  {
    player().posX = x;
  }
  
  public static double y()
  {
    return player().posY;
  }
  
  public static void y(double y)
  {
    player().posY = y;
  }
  
  public static double z()
  {
    return player().posZ;
  }
  
  public static void z(double z)
  {
    player().posZ = z;
  }
  
  public static float yaw()
  {
    return player().rotationYaw;
  }
  
  public static void yaw(float yaw)
  {
    player().rotationYaw = yaw;
  }
  
  public static float pitch()
  {
    return player().rotationPitch;
  }
  
  public static void pitch(float pitch)
  {
    player().rotationPitch = pitch;
  }

public static FontRenderer clientFont() {
	// TODO Auto-generated method stub
	return null;
}
 
}
