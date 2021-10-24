package slientclient.mods;

import org.darkstorm.minecraft.gui.util.GuiManagerDisplayScreen;
import org.lwjgl.input.Keyboard;

import slientclient.gui.UIRenderer;
import slientclient.main.Category;
import slientclient.main.Slient;
import slientclient.notification_system.Notification;
import slientclient.notification_system.NotificationManager;
import slientclient.notification_system.NotificationType;

public class ClickGui extends Module{

	public ClickGui() {
		super("Click Gui", Keyboard.KEY_GRAVE, Category.OTHER);
	}
	
	@Override
	public void onEnable(){
		if(!(mc.currentScreen instanceof GuiManagerDisplayScreen)){
			NotificationManager.show(new Notification(NotificationType.INFO, "Click Gui", "Click Gui was enabled.", 2));
			mc.displayGuiScreen(new GuiManagerDisplayScreen(Slient.guiManager));
			UIRenderer.renderAndUpdateFrames();
		}
	}
	
	public void onDisable(){
		NotificationManager.show(new Notification(NotificationType.INFO, "Click Gui", "Click Gui was disabled.", 2));
    }

}
