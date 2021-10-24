package slientclient.gui;

import org.darkstorm.minecraft.gui.component.Frame;
import org.darkstorm.minecraft.gui.util.GuiManagerDisplayScreen;

import net.minecraft.client.Minecraft;
import slientclient.main.*;

public class UIRenderer {
	
	public static void renderAndUpdateFrames(){
		for(Frame f: Slient.guiManager.getFrames()){
			f.update();
		}
		for(Frame f: Slient.guiManager.getFrames()){
			if(f.isPinned() || Minecraft.getMinecraft().currentScreen instanceof GuiManagerDisplayScreen){
				f.render();
			}
		}
	}

}
