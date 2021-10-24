package slientclient.mods;

import org.lwjgl.input.Keyboard;

import slientclient.main.*;
import slientclient.notification_system.Notification;
import slientclient.notification_system.NotificationManager;
import slientclient.notification_system.NotificationType;
import slientclient.*;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.player.EntityPlayer;

public class AntiAFK extends Module{

	public AntiAFK() {
		super("AntiAFK", 0, Category.OTHER);
	}
  
  int delay = 0;
  
  public void onUpdate()
  {
    this.delay += 1;
    if ((this.isToggled()) && 
      (this.delay > 60) && (this.delay < 65))
    {
      EntityPlayer p = Minecraft.getMinecraft().player;
      if (p.onGround) {
        Minecraft.getMinecraft().player.jump();
      }
      this.delay = 0;
    }
  }
  
  public void onDisable() {
		NotificationManager.show(new Notification(NotificationType.INFO, "AntiAFK", "AntiAFK was disabled.", 2));
  }
  
  public void onEnable()
  {
	  	NotificationManager.show(new Notification(NotificationType.INFO, "AntiAFK", "AntiAFK was enabled.", 2));
    this.delay = 0;
  }
}
