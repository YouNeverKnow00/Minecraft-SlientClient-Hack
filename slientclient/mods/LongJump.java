package slientclient.mods;

import org.lwjgl.input.Keyboard;

import slientclient.main.Category;
import slientclient.notification_system.Notification;
import slientclient.notification_system.NotificationManager;
import slientclient.notification_system.NotificationType;

public class LongJump extends Module{

	public LongJump() {
		super("LongJump", Keyboard.KEY_K, Category.MOVEMENT);
	}
	
	public void onDisable(){
		NotificationManager.show(new Notification(NotificationType.INFO, "LongJump", "LongJump was disabled.", 2));
	}
	
	public void onEnable() {
		NotificationManager.show(new Notification(NotificationType.INFO, "LongJump", "LongJump was enabled.", 2));
	}
	
	public void onUpdate() {
		if(this.isToggled()) {
			if(mc.gameSettings.keyBindForward.isPressed() 
					|| mc.gameSettings.keyBindBack.isPressed()
					|| mc.gameSettings.keyBindRight.isPressed()
					|| mc.gameSettings.keyBindLeft.isPressed()) {
				if(mc.player.isAirBorne) {
					mc.player.motionX *= 1.6;
					mc.player.motionZ *= 1.6;
				}
			}
			else
			{
				mc.player.motionX *= 1;
				mc.player.motionZ *= 1;
			}
		}
	}

}
