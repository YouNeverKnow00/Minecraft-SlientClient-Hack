package slientclient.mods;

import org.lwjgl.input.Keyboard;

import net.minecraft.network.play.client.CPacketPlayer;
import slientclient.main.Category;
import slientclient.notification_system.Notification;
import slientclient.notification_system.NotificationManager;
import slientclient.notification_system.NotificationType;

public class Nofall extends Module{

	public Nofall() {
		super("Nofall", Keyboard.KEY_N, Category.PLAYER);
	}

	public void onDisable(){
		NotificationManager.show(new Notification(NotificationType.INFO, "Nofall", "Nofall was disabled.", 2));
	}
	
	public void onEnable() {
		NotificationManager.show(new Notification(NotificationType.INFO, "Nofall", "Nofall was enabled.", 2));
	}
	
	public void onUpdate() {
		
		if(this.isToggled()) {	
			if(mc.player.fallDistance >= 2F) {
				mc.player.connection.sendPacket(new CPacketPlayer(true));
			}
		}
	}	

}
