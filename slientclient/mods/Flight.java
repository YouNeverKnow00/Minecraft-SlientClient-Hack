package slientclient.mods;

import org.lwjgl.input.Keyboard;

import slientclient.main.Category;
import slientclient.notification_system.Notification;
import slientclient.notification_system.NotificationManager;
import slientclient.notification_system.NotificationType;

public class Flight extends Module{
	
	public static float flyHackSpeed = 0.1f;

	public Flight() {
		super("Flight", 0, Category.MOVEMENT);
	}
	
	public void onDisable(){
		NotificationManager.show(new Notification(NotificationType.INFO, "Flight", "Flight was disabled.", 2));
		mc.player.capabilities.isFlying = false;
		super.onDisable();
	}
	
	public void onEnable() {
		NotificationManager.show(new Notification(NotificationType.INFO, "Flight", "Flight was enabled.", 2));
	}
	
	public void onUpdate(){
		if(this.isToggled()){
			mc.player.capabilities.isFlying = true;
			
			if(mc.gameSettings.keyBindJump.isPressed()){
				mc.player.motionY += 0.2;
			}
			
			if(mc.gameSettings.keyBindSneak.isPressed()){
				mc.player.motionY -= 0.2;
			}
			
			if(mc.gameSettings.keyBindForward.isPressed()){
				mc.player.capabilities.setFlySpeed(flyHackSpeed);
			}
			super.onUpdate();
		}
	}

}