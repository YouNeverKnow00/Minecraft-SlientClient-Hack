package slientclient.mods;

import org.lwjgl.input.Keyboard;

import slientclient.main.Category;
import slientclient.notification_system.Notification;
import slientclient.notification_system.NotificationManager;
import slientclient.notification_system.NotificationType;

public class Fullbright extends Module {

	public Fullbright() {
		super("Fullbright", Keyboard.KEY_C, Category.RENDER);
	}
	
	public void onDisable(){
		NotificationManager.show(new Notification(NotificationType.INFO, "Fullbright", "Fullbright was disabled.", 2));
	}
	
	public void onEnable() {
		NotificationManager.show(new Notification(NotificationType.INFO, "Fullbright", "Fullbright was enabled.", 2));
	}
	
	public void onUpdate() {
		if(isToggled()){
			mc.gameSettings.gammaSetting = 100f;
		}else{
			mc.gameSettings.gammaSetting = 0f;
		}
	}
	
}
