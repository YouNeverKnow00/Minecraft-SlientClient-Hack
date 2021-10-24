package slientclient.mods;

import org.lwjgl.input.Keyboard;

import net.minecraft.network.play.client.CPacketKeepAlive;
import net.minecraft.network.status.client.CPacketPing;
import slientclient.event.EventManager;
import slientclient.event.EventPacketSend;
import slientclient.event.EventTarget;
import slientclient.event.PacketSent;
import slientclient.main.Category;
import slientclient.notification_system.Notification;
import slientclient.notification_system.NotificationManager;
import slientclient.notification_system.NotificationType;

public class PingSpoof extends Module{
	

	public PingSpoof() {
		super("PingSpoof", 0, Category.PLAYER);
	}
	  
	  public void onEnable()
	  {
		NotificationManager.show(new Notification(NotificationType.INFO, "PingSpoof", "PingSpoof was enabled.", 2));
	    EventManager.register(this);
	  }
	  
	  public void onDisable()
	  {
		NotificationManager.show(new Notification(NotificationType.INFO, "PingSpoof", "PingSpoof was disabled.", 2));
	    EventManager.unregister(this);
	  }
	  
		@EventTarget
		public void onPacketSent(PacketSent event2){
			final PacketSent event = (PacketSent)event2;
			if (event.getPacket() instanceof CPacketKeepAlive) {
				final CPacketKeepAlive packet = (CPacketKeepAlive)event.getPacket();
				packet.key = 0;
			}
		}	
	}