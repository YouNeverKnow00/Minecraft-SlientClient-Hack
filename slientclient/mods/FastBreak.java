package slientclient.mods;

import slientclient.event.PreMotionUpdateEvent;
import slientclient.*;
import slientclient.compatibility.WMinecraft;
import slientclient.event.EventManager;
import slientclient.event.EventTarget;
import slientclient.event.EventUpdate;
import slientclient.event.Listener;
import slientclient.event.PlayerDamageBlockEvent;
import slientclient.main.Category;
import slientclient.main.Slient;
import slientclient.notification_system.Notification;
import slientclient.notification_system.NotificationManager;
import slientclient.notification_system.NotificationType;
import slientclient.utils.Wrapper;
import net.minecraft.client.Minecraft;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.multiplayer.PlayerControllerMP;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.network.play.client.CPacketPlayerDigging;
import net.minecraft.network.play.client.CPacketPlayerDigging.Action;

import org.lwjgl.input.Keyboard;

import SkillWrapper.SkillWrapper;
import net.minecraft.*;
import net.minecraft.block.state.IBlockState;

public class FastBreak extends Module implements Listener{
	
		
	private int etkin;


	public FastBreak() {
		super("FastBreak", 0, Category.PLAYER);
	}
	
	  public void onEnable()
	  {
		NotificationManager.show(new Notification(NotificationType.INFO, "FastBreak", "FastBreak was enabled.", 2));
		etkin = 2;
	    EventManager.register(this);
	    onUpdate();
	  }
	  
	  public void onDisable(){
		  NotificationManager.show(new Notification(NotificationType.INFO, "FastBreak", "FastBreak was disabled.", 2));
		  etkin = -1;
	  }
	  
	@EventTarget
		public void onUpdate() {
		if(etkin > 1){
		    if ((double)this.mc.playerController.curBlockDamageMP > 0.75F) {
		        this.mc.playerController.curBlockDamageMP = 1F;
		    }
		}
	}
	}