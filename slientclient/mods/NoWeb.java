package slientclient.mods;

import org.lwjgl.input.Keyboard;

import net.minecraft.client.Minecraft;
import slientclient.main.Category;
import slientclient.notification_system.Notification;
import slientclient.notification_system.NotificationManager;
import slientclient.notification_system.NotificationType;

public class NoWeb extends Module{

	public NoWeb() {
		super("NoWeb", 0, Category.MOVEMENT);
	}
	
	public void onDisable(){
		NotificationManager.show(new Notification(NotificationType.INFO, "NoWeb", "NoWeb was disabled.", 2));
	}
	
	public void onEnable() {
		NotificationManager.show(new Notification(NotificationType.INFO, "NoWeb", "NoWeb was enabled.", 2));
	}
	
	public void onUpdate(){
		if(this.isToggled()){
		    if (Minecraft.getMinecraft().player.isInWeb) {
		        if (Minecraft.getMinecraft().player.onGround)
		        {
		          Minecraft.getMinecraft().player.motionY = 15.0D;
		        }
		        else
		        {
		          Minecraft.getMinecraft().player.isInWeb = false;
		          Minecraft.getMinecraft().player.motionY = 0.0D;
		        }
		      }
		    }
	}
}