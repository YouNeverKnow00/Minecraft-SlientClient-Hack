package slientclient.utils;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.passive.IAnimals;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.pathfinding.Path;
import net.minecraft.pathfinding.PathFinder;
import net.minecraft.pathfinding.PathPoint;
import net.minecraft.pathfinding.WalkNodeProcessor;
import net.minecraft.util.Timer;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.*;
import slientclient.compatibility.WMath;
import slientclient.compatibility.WMinecraft;
import slientclient.*;


public class EntityHelper
{
  private static PathFinder pathFinder = new PathFinder(new WalkNodeProcessor());
  
  public static double[] interpolate(Entity entity)
  {
    double partialTicks = 
      Minecraft.getMinecraft().timer.renderPartialTicks;
    double[] pos = {
      entity.lastTickPosX + 
      (entity.posX - entity.lastTickPosX) * partialTicks, 
      entity.lastTickPosY + 
      (entity.posY - entity.lastTickPosY) * partialTicks, 
      entity.lastTickPosZ + 
      (entity.posZ - entity.lastTickPosZ) * partialTicks };
    
    return pos;
  }
  
  public static void faceEntity(Entity entity)
  {
    faceEntity(entity, 20.0F);
  }
  
  public static void faceEntity(Entity entity, float limit)
  {
    if (entity == null) {
      return;
    }
    double diffX = entity.posX - WMinecraft.getPlayer().posX;
    double diffZ = entity.posZ - WMinecraft.getPlayer().posZ;
    double diffY;
    double diffY1;
    if ((entity instanceof EntityLivingBase))
    {
      EntityLivingBase entityLivingBase = (EntityLivingBase)entity;
      diffY1 = entityLivingBase.posY + entityLivingBase.getEyeHeight() - (
        WMinecraft.getPlayer().posY + 
        WMinecraft.getPlayer().getEyeHeight());
    }
    else
    {
      diffY1 = (entity.boundingBox.minY + entity.boundingBox.maxY) / 2.0D - (
        WMinecraft.getPlayer().posY + 
        WMinecraft.getPlayer().getEyeHeight());
    }
    double dist = Math.sqrt(diffX * diffX + diffZ * diffZ);
    
    float yaw = 
      (float)(Math.atan2(diffZ, diffX) * 180.0D / 3.141592653589793D) - 90.0F;
    float pitch = 
      (float)-(Math.atan2(diffY1, dist) * 180.0D / 3.141592653589793D);
    
    float diffYaw = 
      WMath.wrapDegrees(yaw - WMinecraft.getPlayer().rotationYaw);
    float diffPitch = 
      WMath.wrapDegrees(pitch - WMinecraft.getPlayer().rotationPitch);
    if (diffYaw > limit) {
      diffYaw = limit;
    } else if (diffYaw < -limit) {
      diffYaw = -limit;
    }
    WMinecraft.getPlayer().rotationYaw += diffYaw;
    WMinecraft.getPlayer().rotationPitch += diffPitch;
  }
  
  public static void facePos(double posX, double posY, double posZ)
  {
    facePos(posX, posY, posZ, true);
  }
  
  public static void facePos(double posX, double posY, double posZ, boolean shouldLimit)
  {
    double diffX = posX - WMinecraft.getPlayer().posX;
    double diffZ = posZ - WMinecraft.getPlayer().posZ;
    double diffY = posY - WMinecraft.getPlayer().posY;
    
    double dist = Math.sqrt(diffX * diffX + diffZ * diffZ);
    
    float yaw = 
      (float)(Math.atan2(diffZ, diffX) * 180.0D / 3.141592653589793D) - 90.0F;
    float pitch = 
      (float)-(Math.atan2(diffY, dist) * 180.0D / 3.141592653589793D);
    
    float diffYaw = 
      WMath.wrapDegrees(yaw - WMinecraft.getPlayer().rotationYaw);
    float diffPitch = 
      WMath.wrapDegrees(pitch - WMinecraft.getPlayer().rotationPitch) + 5.0F;
    if (shouldLimit) {
      if (diffYaw > 20.0F) {
        diffYaw = 20.0F;
      } else if (diffYaw < -20.0F) {
        diffYaw = -20.0F;
      }
    }
    WMinecraft.getPlayer().rotationYaw += diffYaw;
    WMinecraft.getPlayer().rotationPitch += diffPitch;
  }
  
  public static boolean isAttackable(EntityLivingBase entity)
  {
    return (entity != null) && (entity != WMinecraft.getPlayer()) && 
      (entity.isEntityAlive());
  }
  
  public static boolean isCloser(Entity entityCompared, Entity referenceEntity)
  	{
    return WMinecraft.getPlayer()
      .getDistanceToEntity(entityCompared) < WMinecraft.getPlayer()
      .getDistanceToEntity(referenceEntity);
  }
}
