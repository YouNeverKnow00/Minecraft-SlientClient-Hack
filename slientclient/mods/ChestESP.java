package slientclient.mods;

import org.lwjgl.input.Keyboard;

import net.minecraft.tileentity.TileEntityChest;
import slientclient.main.Category;
import slientclient.notification_system.Notification;
import slientclient.notification_system.NotificationManager;
import slientclient.notification_system.NotificationType;
import slientclient.utils.RenderUtils;

public class ChestESP extends Module{

	public ChestESP() {
		super("ChestESP", Keyboard.KEY_Y, Category.RENDER);
	}
	
	public void onEnable() {
		NotificationManager.show(new Notification(NotificationType.INFO, "ChestESP", "ChestESP was enabled.", 2));
	}
	
	public void onDisable(){
		NotificationManager.show(new Notification(NotificationType.INFO, "ChestESP", "ChestESP was disabled.", 2));
    }
	
	public void onRender() {
		if(this.isToggled()){
			for(Object o: mc.world.loadedTileEntityList){
				if(o instanceof TileEntityChest){
					RenderUtils.blockESPBox(((TileEntityChest)o).getPos());
				}
			}
		}
	}

}
