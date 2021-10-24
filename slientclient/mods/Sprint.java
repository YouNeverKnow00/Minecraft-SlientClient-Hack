package slientclient.mods;

import org.lwjgl.input.Keyboard;

import slientclient.main.Category;
import slientclient.notification_system.Notification;
import slientclient.notification_system.NotificationManager;
import slientclient.notification_system.NotificationType;

public class Sprint extends Module {

	private int sprintacil;
	public Sprint() {
		super("Sprint", Keyboard.KEY_V, Category.MOVEMENT);
	}
	
	public void onEnable(){
		sprintacil = 2;
		NotificationManager.show(new Notification(NotificationType.INFO, "Sprint", "Sprint was enabled.", 2));
	}
	
	public void onDisable(){
		sprintacil = -1;
		NotificationManager.show(new Notification(NotificationType.INFO, "Sprint", "Sprint was disabled.", 2));
	}
	
	@Override
	public void onUpdate() {
	 if(sprintacil > 1){
			super.onUpdate();
			
			if(mc.player.movementInput.field_192832_b > 0) {
				mc.player.setSprinting(true);
	 }
		}
	}

}
