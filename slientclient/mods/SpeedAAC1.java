package slientclient.mods;

import net.minecraft.client.Minecraft;
import net.minecraft.util.math.AxisAlignedBB;
import slientclient.main.Category;
import slientclient.notification_system.Notification;
import slientclient.notification_system.NotificationManager;
import slientclient.notification_system.NotificationType;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Iterator;

import net.minecraft.block.Block;
import net.minecraft.block.BlockAir;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemFood;
import net.minecraft.potion.Potion;
import net.minecraft.util.math.*;
import net.minecraft.util.MovementInput;

import org.lwjgl.input.Keyboard;

public class SpeedAAC1 extends Module{

	public static int aacticks;
	public static double aacmoveSpeed;
	private double aaclastDist;
	
	public SpeedAAC1() {
		super("SpeedAAC1", 0, Category.MOVEMENT);
	}
	
	public void onDisable(){
		NotificationManager.show(new Notification(NotificationType.INFO, "SpeedAAC1", "SpeedAAC1 was disabled.", 2));
	}
	
	public void onEnable() {
		NotificationManager.show(new Notification(NotificationType.INFO, "SpeedAAC1", "SpeedAAC1 was enabled.", 2));
	}
	
	public void onUpdate() {
		onPreUpdate();
	}
	
	public void onPreUpdate() {
		setModuleDisplayName("Speed | AAC | Low");
		if((!this.mc.player.isCollidedHorizontally) && (!mc.player.isOnLadder() && (Minecraft.player.moveForward > 0.17D))) {
		
		boolean down = false;
	      if ((!mc.gameSettings.keyBindJump.pressed) && (!Minecraft.player.isOnLadder()) && 
	        (!Minecraft.player.isInsideOfMaterial(Material.WATER)) && 
	        (!Minecraft.player.isInsideOfMaterial(Material.LAVA)) && (!Minecraft.player.isInWater()) && (
	        ((!(getBlock(-1.1D) instanceof BlockAir)) && (!(getBlock(-1.1D) instanceof BlockAir))) || (
	        (!(getBlock(-0.1D) instanceof BlockAir)) && (Minecraft.player.motionX != 0.0D) && 
	        (Minecraft.player.motionZ != 0.0D) && (!Minecraft.player.onGround) && 
	        (Minecraft.player.fallDistance < 3.0F)))) {
	        down = true;
	      }
	      if (down) {
	        Minecraft.player.motionY = -0.315D;
	      }
		
		if (Minecraft.player.onGround)
	      {
	        Minecraft.player.motionY = 0.42D;
	        mc.player.motionY = 0.42D;
	      }
	      if ((aacticks == 1) && ((Minecraft.player.moveForward != 0.0F) || (Minecraft.player.moveStrafing != 0.0F)))
	      {
	        aacticks = 2;
	      }
	      else if (aacticks == 2)
	      {
	        aacticks = 3;
	      }
	      else if (aacticks == 3)
	      {
	        aacticks = 4;

	      }
	      else if ((Minecraft.getMinecraft().world.getCollisionBoxes(Minecraft.player, Minecraft.player.boundingBox.offset(0.0D, Minecraft.player.motionY, 0.0D)).size() > 0) || 
	        (Minecraft.player.isCollidedVertically))
	      {
	        aacticks = 1;
	      }
	      aacmoveSpeed = 0.38000059604645D;
	      
	      MovementInput movementInput = Minecraft.player.movementInput;
	      float forward = movementInput.field_192832_b;
	      float strafe = movementInput.moveStrafe;
	      
	      Minecraft.getMinecraft();float yaw = Minecraft.player.rotationYaw;
	      if ((forward == 0.0F) && (strafe == 0.0F))
	      {
	    	  mc.player.motionX = 0.0D;
	    	  mc.player.motionZ = 0.0D;
	      }
	      else if (forward != 0.0F)
	      {
	        if (strafe >= 1.0F)
	        {
	          yaw += (forward > 0.0F ? -45 : 45);
	          strafe = 0.0F;
	        }
	        else if (strafe <= -1.0F)
	        {
	          yaw += (forward > 0.0F ? 45 : -45);
	          strafe = 0.0F;
	        }
	        if (forward > 0.0F) {
	          forward = 1.0F;
	        } else if (forward < 0.0F) {
	          forward = -1.0F;
	        }
	      }
	      double mx = Math.cos(Math.toRadians(yaw + 90.0F));
	      double mz = Math.sin(Math.toRadians(yaw + 90.0F));
	      double motionX = forward * aacmoveSpeed * mx + strafe * mz;
	      double motionZ = forward * aacmoveSpeed * mz - strafe * mx;
	      
	      mc.player.motionX = (forward * aacmoveSpeed * mx + strafe * mz);
	      mc.player.motionZ = (forward * aacmoveSpeed * mz - strafe * mx);
	      if ((forward == 0.0F) && (strafe == 0.0F))
	      {
	    	  mc.player.motionX = 0.0D;
	    	  mc.player.motionZ = 0.0D;
	      }
	      else
	      {
	        boolean collideCheck = false;
	        Minecraft.getMinecraft();
	        if (Minecraft.getMinecraft().world.getCollisionBoxes(Minecraft.player, Minecraft.player.boundingBox.expand(0.5D, 0.0D, 0.5D)).size() > 0) {
	          collideCheck = true;
	        }
	        if (forward != 0.0F)
	        {
	          if (strafe >= 1.0F)
	          {
	            yaw += (forward > 0.0F ? -45 : 45);
	            strafe = 0.0F;
	          }
	          else if (strafe <= -1.0F)
	          {
	            yaw += (forward > 0.0F ? 45 : -45);
	            strafe = 0.0F;
	          }
	          if (forward > 0.0F) {
	            forward = 1.0F;
	          } else if (forward < 0.0F) {
	            forward = -1.0F;
	          }
	        }
	    }
	}
	      
	  double xDist = Minecraft.player.posX - Minecraft.player.prevPosX;
	  double zDist = Minecraft.player.posZ - Minecraft.player.prevPosZ;
	  this.aaclastDist = Math.sqrt(xDist * xDist + zDist * zDist);
	      
	}
	
	public Block getBlock(AxisAlignedBB bb)
	  {
	    int y = (int)bb.minY;
	    for (int x = MathHelper.floor(bb.minX); x < MathHelper.floor(bb.maxX) + 1; x++) {
	      for (int z = MathHelper.floor(bb.minZ); z < MathHelper.floor(bb.maxZ) + 1; z++)
	      {
	        Block block = Minecraft.getMinecraft().world.getBlockState(new BlockPos(x, y, z)).getBlock();
	        if (block != null) {
	          return block;
	        }
	      }
	    }
	    return null;
	  }
	  
	  public Block getBlock(double offset)
	  {
	    return getBlock(Minecraft.player.getEntityBoundingBox().offset(0.0D, offset, 0.0D));
	  }
	  
	
}
