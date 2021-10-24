package slientclient.mods;

import org.lwjgl.input.Keyboard;

import slientclient.main.Category;
import slientclient.notification_system.Notification;
import slientclient.notification_system.NotificationManager;
import slientclient.notification_system.NotificationType;

public class Bhop extends Module{
	
	public static float flyHackSpeed = 0.1f;

	public Bhop() {
		super("Bhop1", Keyboard.KEY_B, Category.MOVEMENT);
	}
	
	public void onEnable() {
		NotificationManager.show(new Notification(NotificationType.INFO, "Bhop (NCP)", "Bhop was enabled.", 2));
	}
	
	public void onDisable(){
		NotificationManager.show(new Notification(NotificationType.INFO, "Bhop (NCP)", "Bhop was disabled.", 2));
    }
	
	public void onUpdate(){
		if(this.isToggled()){
	        if(mc.player != null && mc.world != null) {
	            if(mc.gameSettings.keyBindForward.pressed && !mc.player.isCollidedHorizontally) {
	                mc.gameSettings.keyBindJump.pressed = false;
	                if(mc.player.onGround) {
	                    mc.player.jump();
	                    mc.player.motionX *= 1.0708F;
	                    mc.player.motionZ *= 1.0708F;
	                    mc.player.moveStrafing *= 2;
	                } else {
	                    mc.player.jumpMovementFactor = 0.0265F;
	                }
	            }
	        }
	    }
	}
}
	   