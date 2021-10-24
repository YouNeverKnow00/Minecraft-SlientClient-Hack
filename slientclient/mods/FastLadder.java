package slientclient.mods;

import org.lwjgl.input.Keyboard;

import slientclient.event.EventTarget;
import slientclient.main.Category;
import slientclient.notification_system.Notification;
import slientclient.notification_system.NotificationManager;
import slientclient.notification_system.NotificationType;

public class FastLadder extends Module{
	
	private int ticks = 0;

	public FastLadder() {
		super("FastLadder", 0, Category.MOVEMENT);
	}
	
	public void onEnable() {
		NotificationManager.show(new Notification(NotificationType.INFO, "FastLadder", "FastLadder was enabled.", 2));
	}	
	
	public void onDisable(){
		NotificationManager.show(new Notification(NotificationType.INFO, "FastLadder", "FastLadder was disabled.", 2));
		super.onDisable();
	}
	
	@EventTarget	
	public void onUpdate(){
		if(this.isToggled()){
			ticks++;
			if(mc.player.isOnLadder())
				mc.player.motionY = 0.180;
		}
	}
}