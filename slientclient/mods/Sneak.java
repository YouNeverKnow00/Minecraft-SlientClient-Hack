package slientclient.mods;

import org.lwjgl.input.Keyboard;

import net.minecraft.client.Minecraft;
import slientclient.main.Category;
import slientclient.notification_system.Notification;
import slientclient.notification_system.NotificationManager;
import slientclient.notification_system.NotificationType;

public class Sneak extends Module{
	

	public Sneak() {
		super("Sneak", 0, Category.MOVEMENT);
	}
	
	public void onEnable() {
		NotificationManager.show(new Notification(NotificationType.INFO, "Sneak", "Sneak was enabled.", 2));
	}
	
	public void onDisable(){
		NotificationManager.show(new Notification(NotificationType.INFO, "Sneak", "Sneak was disabled.", 2));
		super.onDisable();
    }
	
	public void onUpdate(){
		if(this.isToggled()){
		    Minecraft.getMinecraft().gameSettings.keyBindSneak.isPressed();
		    	  }
		    	}
}
