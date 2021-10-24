package slientclient.mods;

import org.lwjgl.input.Keyboard;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.play.client.CPacketCloseWindow;
import slientclient.compatibility.WConnection;
import slientclient.compatibility.WMinecraft;
import slientclient.compatibility.WPlayerController;
import slientclient.event.EventTarget;
import slientclient.event.PlayerUpdateEvent;
import slientclient.event.PostMotionUpdateEvent;
import slientclient.main.Category;
import slientclient.notification_system.Notification;
import slientclient.notification_system.NotificationManager;
import slientclient.notification_system.NotificationType;

public class AutoSoup extends Module{
	
	 int soupCount = 0;
	 int previous = -1;

	public AutoSoup() {
		super("AutoSoup", 0, Category.COMBAT);
	}
	
	  public void onEnable()
	  {
		  NotificationManager.show(new Notification(NotificationType.INFO, "AutoSoup", "AutoSoup was enabled.", 2));
	  }
	  
	  public void onDisable()
	  {
		  NotificationManager.show(new Notification(NotificationType.INFO, "AutoSoup", "AutoSoup was disabled.", 2));
	  }
	  
	  @EventTarget
	  public void onUpdate(PlayerUpdateEvent event)
	  {
	    updateSoupCount();
	    if ((WMinecraft.getPlayer().getHealth() <= 14.0F) && (this.soupCount > 0) && 
	      (!WMinecraft.getPlayer().isPotionActive(MobEffects.REGENERATION)))
	    {
	      this.previous = -1;
	      int soupSlot = -1;
	      for (int inventorySlot = 0; inventorySlot < 9; inventorySlot++)
	      {
	        ItemStack currentItem = WMinecraft.getPlayer().inventory
	          .getStackInSlot(inventorySlot);
	        if ((currentItem != null) && 
	          (currentItem.getItem() == Item.getItemById(282)))
	        {
	          soupSlot = inventorySlot;
	          break;
	        }
	      }
	      if (soupSlot == -1)
	      {
	        for (int inventorySlot = 9; inventorySlot < 36; inventorySlot++) {
	          if (WMinecraft.getPlayer().inventoryContainer.getSlot(inventorySlot).getHasStack())
	          {
	            ItemStack currentItem = 
	              WMinecraft.getPlayer().inventoryContainer
	              .getSlot(inventorySlot).getStack();
	            if ((currentItem != null) && 
	              (currentItem.getItem() == Item.getItemById(282)))
	            {
	              soupSlot = inventorySlot;
	              break;
	            }
	          }
	        }
	        if (soupSlot == -1)
	        {
	          this.soupCount = 0;
	          return;
	        }
	        cleanUp();
	        WPlayerController.windowClick_QUICK_MOVE(soupSlot);
	        return;
	      }
	      this.previous = WMinecraft.getPlayer().inventory.currentItem;
	      WMinecraft.getPlayer().inventory.currentItem = soupSlot;
	      WPlayerController.processRightClick();
	      WConnection.sendPacket(new CPacketCloseWindow());
	    }
	  }
	  
	  @EventTarget
	  public void onPostUpdate(PostMotionUpdateEvent event)
	  {
	    if (this.previous != -1)
	    {
	      WMinecraft.getPlayer().inventory.currentItem = this.previous;
	      this.previous = -1;
	      cleanUp();
	    }
	  }
	  
	  public void cleanUp()
	  {
	    boolean hasRoom = false;
	    for (int inventorySlot = 9; inventorySlot < 36; inventorySlot++)
	    {
	      ItemStack currentItem = 
	        WMinecraft.getPlayer().inventoryContainer.getSlot(inventorySlot)
	        .getStack();
	      if ((currentItem == null) || (
	        (currentItem.getItem() == Item.getItemById(281)) && 
	        (currentItem.stackSize < 65))) {
	        hasRoom = true;
	      }
	    }
	    for (int inventorySlot = 36; inventorySlot < 45; inventorySlot++) {
	      if (WMinecraft.getPlayer().inventoryContainer.getSlot(inventorySlot).getHasStack())
	      {
	        ItemStack currentItem = 
	          WMinecraft.getPlayer().inventoryContainer
	          .getSlot(inventorySlot).getStack();
	        if ((currentItem != null) && 
	          (currentItem.getItem() == Item.getItemById(281)))
	        {
	          if (hasRoom)
	          {
	            WPlayerController.windowClick_QUICK_MOVE(inventorySlot);
	            break;
	          }
	          WPlayerController.windowClick_PICKUP(inventorySlot);
	          WPlayerController.windowClick_PICKUP(64537);
	          break;
	        }
	      }
	    }
	  }
	  
	  private void updateSoupCount()
	  {
	    int soupCount = 0;
	    for (int inventorySlot = 0; inventorySlot < 45; inventorySlot++)
	    {
	      ItemStack currentItem = 
	        WMinecraft.getPlayer().inventoryContainer.getSlot(inventorySlot)
	        .getStack();
	      if ((currentItem != null) && 
	        (currentItem.getItem() == Item.getItemById(282))) {
	        soupCount++;
	      }
	    }
	    this.soupCount = soupCount;
	  }
	}