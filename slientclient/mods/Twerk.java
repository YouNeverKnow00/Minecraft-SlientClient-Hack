package slientclient.mods;

import org.lwjgl.input.Keyboard;

import net.minecraft.client.Minecraft;
import slientclient.main.Category;
import slientclient.notification_system.Notification;
import slientclient.notification_system.NotificationManager;
import slientclient.notification_system.NotificationType;

public class Twerk extends Module{
	

	public Twerk() {
		super("Twerk", 0, Category.OTHER);
	}
	
	public void onEnable() {
		NotificationManager.show(new Notification(NotificationType.INFO, "Twerk", "Twerk was enabled.", 2));
	}
	
	public void onDisable(){
		NotificationManager.show(new Notification(NotificationType.INFO, "Twerk", "Twerk was disabled.", 2));
		super.onDisable();
	}
	
	public void onUpdate(){
		if(this.isToggled()){
		    Minecraft.getMinecraft().gameSettings.keyBindSneak.pressed = 
		    	      (!Minecraft.getMinecraft().gameSettings.keyBindSneak.pressed);
		    	  }
		    	}
}
