package slientclient.mods;

import org.lwjgl.input.Keyboard;

import net.minecraft.entity.MoverType;
import slientclient.main.Category;
import slientclient.notification_system.Notification;
import slientclient.notification_system.NotificationManager;
import slientclient.notification_system.NotificationType;

public class Speed extends Module {

	public Speed() {
		super("Speed", Keyboard.KEY_M, Category.MOVEMENT);
	}
	
	public void onEnable() {
		NotificationManager.show(new Notification(NotificationType.INFO, "Speed", "Speed was enabled.", 2));
	}
	
	public void onDisable(){
		NotificationManager.show(new Notification(NotificationType.INFO, "Speed", "Speed was disabled.", 2));
    }
	
	public void onUpdate() {
		if(this.isToggled()) {
	        if (mc.world != null && mc.player != null) {
	            mc.gameSettings.keyBindJump.pressed = false;
	            if (mc.gameSettings.keyBindForward.pressed && !mc.player.isCollidedHorizontally) {
	                if (mc.player.onGround) {
	                    mc.player.jump();
	                    mc.player.motionX *= 1.07F;
	                    mc.player.motionZ *= 1.07F;
	                } else {
	                    mc.player.jumpMovementFactor = 0.0265F;
	                    double speed = 1;
	                    double currentMotion = Math.sqrt(
	                            mc.player.motionX * mc.player.motionX + mc.player.motionZ * mc.player.motionZ);
	                }
	            }
	        }
	    }
	}
}
