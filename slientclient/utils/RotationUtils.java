package slientclient.utils;

import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.network.play.client.CPacketPlayer.Rotation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.Vec3d;
import slientclient.compatibility.WConnection;
import slientclient.compatibility.WMath;
import slientclient.compatibility.WMinecraft;

public class RotationUtils
{
  private static boolean fakeRotation;
  private static float serverYaw;
  private static float serverPitch;
  
  public static Vec3d getEyesPos()
  {
    return new Vec3d(WMinecraft.getPlayer().posX, 
      WMinecraft.getPlayer().posY + WMinecraft.getPlayer().getEyeHeight(), 
      WMinecraft.getPlayer().posZ);
  }
  
  public static Vec3d getClientLookVec()
  {
    float f = WMath.cos(-WMinecraft.getPlayer().rotationYaw * 0.017453292F - 
      3.1415927F);
    float f1 = WMath.sin(-WMinecraft.getPlayer().rotationYaw * 0.017453292F - 
      3.1415927F);
    float f2 = 
      -WMath.cos(-WMinecraft.getPlayer().rotationPitch * 0.017453292F);
    float f3 = 
      WMath.sin(-WMinecraft.getPlayer().rotationPitch * 0.017453292F);
    return new Vec3d(f1 * f2, f3, f * f2);
  }
  
  public static Vec3d getServerLookVec()
  {
    float f = WMath.cos(-serverYaw * 0.017453292F - 3.1415927F);
    float f1 = WMath.sin(-serverYaw * 0.017453292F - 3.1415927F);
    float f2 = -WMath.cos(-serverPitch * 0.017453292F);
    float f3 = WMath.sin(-serverPitch * 0.017453292F);
    return new Vec3d(f1 * f2, f3, f * f2);
  }
  
  private static float[] getNeededRotations(Vec3d vec)
  {
    Vec3d eyesPos = getEyesPos();
    
    double diffX = vec.xCoord - eyesPos.xCoord;
    double diffY = vec.yCoord - eyesPos.yCoord;
    double diffZ = vec.zCoord - eyesPos.zCoord;
    
    double diffXZ = Math.sqrt(diffX * diffX + diffZ * diffZ);
    
    float yaw = (float)Math.toDegrees(Math.atan2(diffZ, diffX)) - 90.0F;
    float pitch = (float)-Math.toDegrees(Math.atan2(diffY, diffXZ));
    
    return new float[] { WMath.wrapDegrees(yaw), WMath.wrapDegrees(pitch) };
  }
  
  private static float[] getNeededRotations2(Vec3d vec)
  {
    Vec3d eyesPos = getEyesPos();
    
    double diffX = vec.xCoord - eyesPos.xCoord;
    double diffY = vec.yCoord - eyesPos.yCoord;
    double diffZ = vec.zCoord - eyesPos.zCoord;
    
    double diffXZ = Math.sqrt(diffX * diffX + diffZ * diffZ);
    
    float yaw = (float)Math.toDegrees(Math.atan2(diffZ, diffX)) - 90.0F;
    float pitch = (float)-Math.toDegrees(Math.atan2(diffY, diffXZ));
    
    return new float[] {
      WMinecraft.getPlayer().rotationYaw + 
      WMath.wrapDegrees(yaw - WMinecraft.getPlayer().rotationYaw), 
      WMinecraft.getPlayer().rotationPitch + 
      WMath.wrapDegrees(pitch - WMinecraft.getPlayer().rotationPitch) };
  }
  
  public static double getAngleToLastReportedLookVec(Vec3d vec)
  {
    float[] needed = getNeededRotations(vec);
    
    EntityPlayerSP player = WMinecraft.getPlayer();
    float lastReportedYaw = WMath.wrapDegrees(player.lastReportedYaw);
    float lastReportedPitch = WMath.wrapDegrees(player.lastReportedPitch);
    
    float diffYaw = lastReportedYaw - needed[0];
    float diffPitch = lastReportedPitch - needed[1];
    
    return Math.sqrt(diffYaw * diffYaw + diffPitch * diffPitch);
  }
  
  public static float limitAngleChange(float current, float intended, float maxChange)
  {
    float change = WMath.wrapDegrees(intended - current);
    
    change = WMath.clamp(change, -maxChange, maxChange);
    
    return WMath.wrapDegrees(current + change);
  }
  
  public static boolean faceVectorPacket(Vec3d vec)
  {
    fakeRotation = true;
    
    float[] rotations = getNeededRotations(vec);
    
    serverYaw = limitAngleChange(serverYaw, rotations[0], 30.0F);
    serverPitch = rotations[1];
    
    return Math.abs(serverYaw - rotations[0]) < 1.0F;
  }
  
  public static void faceVectorPacketInstant(Vec3d vec)
  {
    float[] rotations = getNeededRotations2(vec);
    
    WConnection.sendPacket(new CPacketPlayer.Rotation(rotations[0], 
      rotations[1], WMinecraft.getPlayer().onGround));
  }
  
  public static boolean faceVectorClient(Vec3d vec)
  {
    float[] rotations = getNeededRotations(vec);
    
    float oldYaw = WMinecraft.getPlayer().prevRotationYaw;
    float oldPitch = WMinecraft.getPlayer().prevRotationPitch;
    
    WMinecraft.getPlayer().rotationYaw = 
      limitAngleChange(oldYaw, rotations[0], 30.0F);
    WMinecraft.getPlayer().rotationPitch = rotations[1];
    
    return Math.abs(oldYaw - rotations[0]) + 
      Math.abs(oldPitch - rotations[1]) < 1.0F;
  }
  
  public static boolean faceEntityClient(Entity entity)
  {
    Vec3d eyesPos = getEyesPos();
    Vec3d lookVec = getServerLookVec();
    
    AxisAlignedBB bb = entity.boundingBox;
    if (faceVectorClient(bb.getCenter())) {
      return true;
    }
    return bb.calculateIntercept(eyesPos, 
      eyesPos.add(lookVec.scale(6.0D))) != null;
  }
  
  public static boolean faceEntityPacket(Entity entity)
  {
    Vec3d eyesPos = getEyesPos();
    Vec3d lookVec = getServerLookVec();
    
    AxisAlignedBB bb = entity.boundingBox;
    if (faceVectorPacket(bb.getCenter())) {
      return true;
    }
    return bb.calculateIntercept(eyesPos, 
      eyesPos.add(lookVec.scale(6.0D))) != null;
  }
  
  public static boolean faceVectorForWalking(Vec3d vec)
  {
    float[] rotations = getNeededRotations(vec);
    
    float oldYaw = WMinecraft.getPlayer().prevRotationYaw;
    
    WMinecraft.getPlayer().rotationYaw = 
      limitAngleChange(oldYaw, rotations[0], 30.0F);
    WMinecraft.getPlayer().rotationPitch = 0.0F;
    
    return Math.abs(oldYaw - rotations[0]) < 1.0F;
  }
  
  public static float getAngleToClientRotation(Vec3d vec)
  {
    float[] needed = getNeededRotations(vec);
    
    float diffYaw = 
      WMath.wrapDegrees(WMinecraft.getPlayer().rotationYaw) - needed[0];
    float diffPitch = 
      WMath.wrapDegrees(WMinecraft.getPlayer().rotationPitch) - needed[1];
    
    float angle = 
      (float)Math.sqrt(diffYaw * diffYaw + diffPitch * diffPitch);
    
    return angle;
  }
  
  public static float getHorizontalAngleToClientRotation(Vec3d vec)
  {
    float[] needed = getNeededRotations(vec);
    
    float angle = 
      WMath.wrapDegrees(WMinecraft.getPlayer().rotationYaw) - needed[0];
    
    return angle;
  }
  
  public static float getAngleToServerRotation(Vec3d vec)
  {
    float[] needed = getNeededRotations(vec);
    
    float diffYaw = serverYaw - needed[0];
    float diffPitch = serverPitch - needed[1];
    
    float angle = 
      (float)Math.sqrt(diffYaw * diffYaw + diffPitch * diffPitch);
    
    return angle;
  }
  
  public static void updateServerRotation()
  {
    if (fakeRotation)
    {
      fakeRotation = false;
      return;
    }
    serverYaw = 
      limitAngleChange(serverYaw, WMinecraft.getPlayer().rotationYaw, 30.0F);
    serverPitch = WMinecraft.getPlayer().rotationPitch;
  }
  
  public static float getServerYaw()
  {
    return serverYaw;
  }
  
  public static float getServerPitch()
  {
    return serverPitch;
  }
}
