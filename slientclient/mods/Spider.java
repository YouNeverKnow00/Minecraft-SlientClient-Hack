package slientclient.mods;

import org.lwjgl.input.Keyboard;

import slientclient.main.Category;
import slientclient.notification_system.Notification;
import slientclient.notification_system.NotificationManager;
import slientclient.notification_system.NotificationType;

public class Spider extends Module{
	
	public Spider() {
		super("Spider", Keyboard.KEY_Z, Category.MOVEMENT);
	}
	
	public void onEnable() {
		NotificationManager.show(new Notification(NotificationType.INFO, "Spider", "Spider was enabled.", 2));
	}
	
	public void onDisable(){
		if(this.isToggled()){
			if(mc.player.isCollidedHorizontally){
				NotificationManager.show(new Notification(NotificationType.INFO, "Spider", "Spider was disabled.", 2));
				mc.player.motionY = 0.0D;
				super.onDisable();
			}
		}
	}
	
	public void onUpdate(){
		if(this.isToggled()){
			if(mc.player.isCollidedHorizontally){
				mc.player.motionY = 0.0000000001D;
			}
		}
	}

}