package slientclient.mods;

import org.lwjgl.input.Keyboard;

import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketPlayerDigging;
import slientclient.event.EventTarget;
import slientclient.event.EventUpdate;
import slientclient.main.Category;
import slientclient.notification_system.Notification;
import slientclient.notification_system.NotificationManager;
import slientclient.notification_system.NotificationType;
import net.minecraft.network.play.client.CPacketPlayerDigging.Action;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.EnumFacing;
import org.lwjgl.input.Keyboard;

public class AutoGapple extends Module{
	

	public AutoGapple() {
		super("AutoGapple", 0, Category.COMBAT);
	}
	
    @EventTarget
    public void onUpdate(EventUpdate event) {
        if(mc.player.isActiveItemStackBlocking()){
            mc.player.sendQueue.addToSendQueue((Packet) new CPacketPlayerDigging(Action.RELEASE_USE_ITEM, new BlockPos(0,0,0), EnumFacing.UP));
        }
    }
    
    public void onEnable() {
    	NotificationManager.show(new Notification(NotificationType.INFO, "AutoGapple", "AutoGapple was enabled.", 2));
    }
    
    public void onDisable() {
    	NotificationManager.show(new Notification(NotificationType.INFO, "AutoGapple", "AutoGapple was disabled.", 2));
    }
}