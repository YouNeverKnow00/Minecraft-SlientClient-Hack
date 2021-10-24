package slientclient.mods;

import org.lwjgl.input.Keyboard;

import net.minecraft.client.entity.EntityPlayerSP;
import slientclient.compatibility.WMinecraft;
import slientclient.event.EventTarget;
import slientclient.event.PlayerUpdateEvent;
import slientclient.main.Category;
import slientclient.notification_system.Notification;
import slientclient.notification_system.NotificationManager;
import slientclient.notification_system.NotificationType;

public class Bhop2 extends Module{
	
	public Bhop2() {
		super("Bhop (AAC)", 0, Category.MOVEMENT);
	}
	
	public void onEnable() {
		NotificationManager.show(new Notification(NotificationType.INFO, "Bhop2 (AAC)", "Bhop2 was enabled.", 2));
	}
	
	public void onDisable(){
		NotificationManager.show(new Notification(NotificationType.INFO, "Bhop2 (AAC)", "Bhop2 was disabled.", 2));
    }
	
	  @EventTarget
	  public void onUpdate()
	  {
	    if (!this.isToggled()) {
	      return;
	    }
	    EntityPlayerSP player = WMinecraft.getPlayer();
	    if ((player.onGround) && (player.isSprinting())) {
	      player.jump();
	    }
	  }
}
	 
	   