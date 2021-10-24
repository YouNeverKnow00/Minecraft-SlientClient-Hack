package slientclient.mods;

import java.util.Timer;

import org.apache.logging.log4j.core.async.EventRoute;
import org.lwjgl.input.Keyboard;

import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.GuiHopper;
import net.minecraft.client.gui.inventory.GuiChest;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.gui.inventory.GuiDispenser;
import net.minecraft.client.gui.inventory.GuiFurnace;
import net.minecraft.client.multiplayer.PlayerControllerMP;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;

import net.minecraft.client.gui.inventory.GuiChest;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.ContainerChest;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import slientclient.event.EventManager;
import slientclient.event.EventTarget;
import slientclient.event.EventUpdate;
import slientclient.event.UpdateEvent;
import slientclient.main.Category;
import slientclient.main.Values;
import slientclient.notification_system.Notification;
import slientclient.notification_system.NotificationManager;
import slientclient.notification_system.NotificationType;
import slientclient.utils.TimeHelper;
import slientclient.utils.TimeHelper3;
import slientclient.utils.TimeHelper4;
import slientclient.utils.ClientUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.inventory.GuiChest;
import net.minecraft.client.multiplayer.PlayerControllerMP;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.client.gui.inventory.GuiChest;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ContainerChest;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import slientclient.*;
import slientclient.event.*;

public class ChestStealer extends Module{

	private static final ItemStack[] Inventory = null;

	public TimeHelper3 timerr = new TimeHelper3();
	
	public int etkin = 0;
	
    private TimeHelper3 timer = new TimeHelper3();
	
	public ChestStealer() {
		super("ChestStealer", 0, Category.PLAYER);
	}

	public void onEnable() {
		etkin = 1;
		System.out.println("Acildi kardes.");
		NotificationManager.show(new Notification(NotificationType.INFO, "ChestStealer", "ChestStealer was enabled.", 2));
	}
	
	public void onDisable(){
		etkin = 0;
		System.out.println("Kapandi kardes.");
		NotificationManager.show(new Notification(NotificationType.INFO, "ChestStealer", "ChestStealer was disabled.", 2));
    }
	
	
	private TimeHelper4 time = new TimeHelper4();
	
	public void onUpdate() {
	  if(etkin == 1) {
		if ((mc.currentScreen != null) && ((mc.currentScreen instanceof GuiChest))) {
			System.out.println("Update icinde Kardes");
			ContainerChest container = (ContainerChest)mc.player.openContainer;
			for (int i = 0; i < container.getLowerChestInventory().getSizeInventory(); i++) {
		    	  if ((container.getLowerChestInventory().getStackInSlot(i) != null) && (this.time.hasReached((long) Values.getValues().cheststealerdelay))) {
			          mc.playerController.windowClick(container.windowId, i, 0, 1, mc.player);
			          this.time.reset();
		    	  }
			}	
			
			if (empty()){
	        	mc.player.closeScreen();
	        }
	    } else {
	    	this.time.reset();
	    }
	  }
	}
	
	  public void onTick() {
			if ((mc.currentScreen != null) && ((mc.currentScreen instanceof GuiChest))) {
				ContainerChest container = (ContainerChest)mc.player.openContainer;
				for (int i = 0; i < container.getLowerChestInventory().getSizeInventory(); i++) {
			    	  if ((container.getLowerChestInventory().getStackInSlot(i) != null) && (this.time.hasReached((long) Values.getValues().cheststealerdelay))) {
				          mc.playerController.windowClick(container.windowId, i, 0, 1, mc.player);
				          this.time.reset();
			    	  }
				}	
				
				if (empty()){
		        	mc.player.closeScreen();
		        }
		    } else {
		    	this.time.reset();
		    }
	  }

	  public boolean empty() {
	    boolean voll = true;
	    int i = 0;
	    for (int slotAmount = mc.player.openContainer.inventorySlots.size() == 90 ? 54 : 27; i < slotAmount; i++) {
	      if (mc.player.openContainer.getSlot(i).getHasStack()) {
	    	  voll = false;
	      }
	    }
	    return voll;
	  }
	
}
 
