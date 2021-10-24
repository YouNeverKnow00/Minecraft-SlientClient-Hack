package slientclient.mods;

import org.lwjgl.input.Keyboard;

import net.minecraft.network.play.client.CPacketPlayer;
import slientclient.main.Category;
import slientclient.notification_system.Notification;
import slientclient.notification_system.NotificationManager;
import slientclient.notification_system.NotificationType;
import slientclient.utils.EventHandler;
import slientclient.utils.Wrapper;
import net.minecraft.*;
import slientclient.*;
import slientclient.event.EventTarget;
import slientclient.event.IngameTickEvent;
import slientclient.event.MovementEvent;

public class Dolphin extends Module{

 
	public Dolphin() {
		super("Dolphin", 0, Category.MOVEMENT);
	}
	
	public void onEnable() {
		NotificationManager.show(new Notification(NotificationType.INFO, "Dolphin", "Dolphin was enabled.", 2));
	}
	
	public void onDisable(){
		NotificationManager.show(new Notification(NotificationType.INFO, "Dolphin", "Dolphin was disabled.", 2));
    }
	
	
	/*    */   @EventTarget
	/*    */   public void onMovement(MovementEvent event)
	/*    */   {
	/* 18 */     if (slientclient.compatibility.WMinecraft.getPlayer().isInWater())
	/*    */     {
	/* 20 */       event.setMotionX(event.getMotionX() * 2.0D);
	/* 21 */       event.setMotionY(event.getMotionY() * 2.0D);
	/* 22 */       event.setMotionZ(event.getMotionZ() * 2.0D);
	/*    */     }
	/*    */   }
	/*    */ }


	