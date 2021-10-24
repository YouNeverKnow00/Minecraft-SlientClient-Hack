package slientclient.mods;

import java.util.Iterator;

import org.lwjgl.input.Keyboard;

import net.minecraft.client.entity.EntityOtherPlayerMP;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.play.client.CPacketPlayerDigging;
import net.minecraft.network.play.client.CPacketPlayerDigging.Action;
import net.minecraft.network.play.client.CPacketUseEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import slientclient.main.Category;
import slientclient.notification_system.Notification;
import slientclient.notification_system.NotificationManager;
import slientclient.notification_system.NotificationType;

public class KillAura extends Module {

	private int ticks = 0;
	
	public KillAura() {
		super("KillAura", Keyboard.KEY_R, Category.COMBAT);
	}
	
	public void onDisable(){
		NotificationManager.show(new Notification(NotificationType.INFO, "KillAura", "KillAura was disabled.", 2));
	}
	
	public void onEnable() {
		NotificationManager.show(new Notification(NotificationType.INFO, "KillAura", "KillAura was enabled.", 2));
	}
	
	public void onUpdate() {
		if(this.isToggled()) {
			ticks++;
			if(ticks >= 20 - speed()) {
				ticks = 0;
				mc.player.rotationYaw +=0.2F;
				for(Iterator<Entity> entities = mc.world.loadedEntityList.iterator(); entities.hasNext();) {
					Object object = entities.next();
					if(object instanceof EntityLivingBase) {
						EntityLivingBase e = (EntityLivingBase) object;
						if(e instanceof EntityPlayerSP) continue;
						if(mc.player.getDistanceToEntity(e) <= 7F) {
							if(e.isInvisible()) {
								break;
							}
							if(e.isEntityAlive()) {
								if(mc.player.getHeldItemMainhand() != null) {
									mc.player.attackTargetEntityWithCurrentItem(e);
								}
								if(mc.player.isActiveItemStackBlocking()) {
									mc.player.connection.sendPacket(new CPacketPlayerDigging(Action.RELEASE_USE_ITEM, new BlockPos(0, 0, 0), EnumFacing.UP));
								}
								mc.player.connection.sendPacket(new CPacketUseEntity(e));
	                            mc.player.swingArm(EnumHand.MAIN_HAND);
	                            break;
							}
						}
					}
				}
			}
		}
	}
	
	private int speed() {
		return 18;
	}

}
