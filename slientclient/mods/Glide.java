package slientclient.mods;

import org.lwjgl.input.Keyboard;

import net.minecraft.block.material.Material;
import slientclient.main.Category;
import slientclient.notification_system.Notification;
import slientclient.notification_system.NotificationManager;
import slientclient.notification_system.NotificationType;

public class Glide extends Module{

	public Glide() {
		super("Glide", Keyboard.KEY_G, Category.MOVEMENT);
	}
	
	public void onDisable(){
		NotificationManager.show(new Notification(NotificationType.INFO, "Glide", "Glide was disabled.", 2));
	}
	
	public void onEnable() {
		NotificationManager.show(new Notification(NotificationType.INFO, "Glide", "Glide was enabled.", 2));
	}
	
	public void onUpdate(){
		double oldY = mc.player.motionY;
		float oldJ = mc.player.jumpMovementFactor;
		if(this.isToggled()){
			if((mc.player.motionY < 0.0d) && (mc.player.isAirBorne) && (!mc.player.isInWater()) && (!mc.player.isOnLadder())){
				if(!mc.player.isInsideOfMaterial(Material.LAVA)){
					mc.player.motionY = -.125d;
					mc.player.jumpMovementFactor *= 1.12337f;
				}
			}
		}else{
			mc.player.motionY = oldY;
			mc.player.jumpMovementFactor = oldJ;
		}
	}

}
