package slientclient.mods;

import org.lwjgl.input.Keyboard;

import net.minecraft.client.Minecraft;
import slientclient.main.Category;
import slientclient.notification_system.Notification;
import slientclient.notification_system.NotificationManager;
import slientclient.notification_system.NotificationType;

public class FastPlace extends Module{

	public FastPlace() {
		super("FastPlace", 0, Category.PLAYER);
	}
	
	public void onEnable() {
		NotificationManager.show(new Notification(NotificationType.INFO, "FastPlace", "FastPlace was enabled.", 2));
	}
	
	public void onDisable(){
		NotificationManager.show(new Notification(NotificationType.INFO, "FastPlace", "FastPlace was disabled.", 2));
		super.onDisable();
	}
	
	public void onUpdate(){
		if(this.isToggled()){
		    Minecraft.getMinecraft().rightClickDelayTimer = 0;
		    	
		}
	
	}
}