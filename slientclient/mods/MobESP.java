package slientclient.mods;

import org.lwjgl.input.Keyboard;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import slientclient.main.Category;
import slientclient.notification_system.Notification;
import slientclient.notification_system.NotificationManager;
import slientclient.notification_system.NotificationType;
import slientclient.utils.RenderUtils;

public class MobESP extends Module{

	public MobESP() {
		super("MobESP", Keyboard.KEY_H, Category.RENDER);
	}
	
	public void onDisable(){
		NotificationManager.show(new Notification(NotificationType.INFO, "MobESP", "MobESP was disabled.", 2));
	}
	
	public void onEnable() {
		NotificationManager.show(new Notification(NotificationType.INFO, "MobESP", "MobESP was enabled.", 2));
	}
	
	@Override
	public void onRender() {
		if(this.isToggled()){
			for(Object e: mc.world.loadedEntityList){
				if(e instanceof EntityLiving){
					RenderUtils.entityESPBox((Entity)e, 0);
				}
			}
		}
	}

}
