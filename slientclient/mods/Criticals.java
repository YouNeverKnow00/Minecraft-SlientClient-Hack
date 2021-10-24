package slientclient.mods;

import org.lwjgl.input.Keyboard;

import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.network.play.client.CPacketUseEntity;
import slientclient.compatibility.WConnection;
import slientclient.compatibility.WMinecraft;
import slientclient.event.EventLocation;
import slientclient.event.EventPacket;
import slientclient.event.EventSendPacket;
import slientclient.event.EventTarget;
import slientclient.event.EventUpdate;
import slientclient.event.JumpEvent;
import slientclient.event.LeftClickListener;
import slientclient.event.LeftClickListener.LeftClickEvent;
import slientclient.event.PlayerAttackEntityEvent;
import slientclient.event.PlayerUpdateEvent;
import slientclient.event.PostMotionUpdateEvent;
import slientclient.event.PreMotionUpdateEvent;
import slientclient.main.Category;
import slientclient.main.Slient;
import slientclient.notification_system.Notification;
import slientclient.notification_system.NotificationManager;
import slientclient.notification_system.NotificationType;
import slientclient.utils.ClientUtils;
import slientclient.utils.EventHandler;
import slientclient.utils.Wrapper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.multiplayer.PlayerControllerMP;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.network.play.client.CPacketUseEntity;
import net.minecraft.network.play.client.CPacketUseEntity.Action;
import slientclient.compatibility.WConnection;
import net.minecraft.network.play.client.CPacketUseEntity;
import net.minecraft.network.play.client.CPacketPlayer;

public class Criticals extends Module{
	
 private boolean wasOnGround = true;
 private double fallDistance = 0.0D;
 private double newFallDistance = 0.0D;
 private boolean shouldJump = false;
 public int acik;
 
 public static int jump = 0;
 
 int time = 0;
 
	public Criticals() {
		super("Criticals", 0, Category.COMBAT);
	}
	
	public void onEnable() {
		acik = 1;
		System.out.println("Acik");
		NotificationManager.show(new Notification(NotificationType.INFO, "Criticals", "Criticals was enabled.", 2));
	}
	
	public void onDisable(){
		acik = 0;
		System.out.println("Kapali");
		NotificationManager.show(new Notification(NotificationType.INFO, "Criticals", "Criticals was disabled.", 2));
    }
	
	public void onUpdate() {
		if(acik == 1) {
		    if ((mc.objectMouseOver == null) || 
		  	      (!(mc.objectMouseOver.entityHit instanceof EntityLivingBase))) {
		  	      return;
		  	    }
		       System.out.println("Deneme");
		  	   onLeftClick(null);
		}
	}
	
	  public void onLeftClick(LeftClickListener.LeftClickEvent event)
	  {
	   if(acik == 1) {
	    if ((mc.objectMouseOver == null) || 
	      (!(mc.objectMouseOver.entityHit instanceof EntityLivingBase))) {
	      return;
	    }
	    doCritical();
	   }
	  }
	  
	  public void doCritical()
	  {
	   if(acik == 1) {
	    if (!WMinecraft.getPlayer().onGround) {
	      return;
	    }
	    if ((WMinecraft.getPlayer().isInWater()) || 
	      (WMinecraft.getPlayer().isInLava())) {
	      return;
	    }
	      if(jump == 0) {
	      WMinecraft.getPlayer().motionY = 0.10000000149011612D;
	      WMinecraft.getPlayer().fallDistance = 0.1F;
	      WMinecraft.getPlayer().onGround = false;
	      } 
	      else {
			  System.out.println("Packet Modunda");
		   double posX = WMinecraft.getPlayer().posX;
		   double posY = WMinecraft.getPlayer().posY;
		   double posZ = WMinecraft.getPlayer().posZ;
	      WConnection.sendPacket(
	        new CPacketPlayer.Position(posX, posY + 0.0625D, posZ, true));
	      WConnection.sendPacket(
	        new CPacketPlayer.Position(posX, posY, posZ, false));
	      WConnection.sendPacket(
	        new CPacketPlayer.Position(posX, posY + 1.1E-5D, posZ, false));
	      WConnection.sendPacket(
	        new CPacketPlayer.Position(posX, posY, posZ, false));
	    }
	  }
	 }
}


	