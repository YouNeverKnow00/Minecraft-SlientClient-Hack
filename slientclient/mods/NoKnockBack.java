package slientclient.mods;

import org.lwjgl.input.Keyboard;

import net.minecraft.entity.MoverType;
import slientclient.main.Category;
import slientclient.notification_system.Notification;
import slientclient.notification_system.NotificationManager;
import slientclient.notification_system.NotificationType;

public class NoKnockBack extends Module {

	public NoKnockBack() {
		super("NoKnockBack", 0, Category.COMBAT);
	}
	
	public void onDisable(){
		NotificationManager.show(new Notification(NotificationType.INFO, "NoKnockBack", "NoKnockBack was disabled.", 2));
	}
	
	public void onEnable() {
		NotificationManager.show(new Notification(NotificationType.INFO, "NoKnockBack", "NoKnockBack was enabled.", 2));
	}
	
	public void onUpdate() {
		if(this.isToggled()) {
		    if(mc.player.hurtTime > 0) {
		        mc.player.motionX /= 3;
		        mc.player.motionZ /= 3;
		    }
		}
	}
}
