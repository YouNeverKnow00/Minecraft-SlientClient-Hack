package slientclient.mods;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import org.lwjgl.input.Keyboard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.InventoryEffectRenderer;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.network.play.client.CPacketClickWindow;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovementInput;
import slientclient.compatibility.WEnchantments;
import slientclient.compatibility.WItem;
import slientclient.compatibility.WMinecraft;
import slientclient.compatibility.WPlayerController;
import slientclient.event.EventManager;
import slientclient.event.EventTarget;
import slientclient.event.NetworkManagerPacketSendEvent;
import slientclient.event.PlayerUpdateEvent;
import slientclient.main.Category;
import slientclient.main.Slient;
import slientclient.notification_system.Notification;
import slientclient.notification_system.NotificationManager;
import slientclient.notification_system.NotificationType;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.InventoryEffectRenderer;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.network.play.client.CPacketClickWindow;
import net.minecraft.util.DamageSource;


public class AutoArmor extends Module {

	private int acilma;
	private int timer;
	private ItemArmor item;

	public AutoArmor() {
		super("AutoArmor", 0, Category.COMBAT);
	}
	
	  public void onEnable()
	  {
		NotificationManager.show(new Notification(NotificationType.INFO, "AutoArmor", "AutoArmor was enabled.", 2));  
		this.timer = 0;
		acilma = 2;
	    EventManager.register(this);
	    onUpdate();
	  }
	  
	  public void onDisable()
	  {
		NotificationManager.show(new Notification(NotificationType.INFO, "AutoArmor", "AutoArmor was disabled.", 2));  
		acilma = -1;
	    EventManager.unregister(this);
	  }
	  
	
	@Override
	public void onUpdate()
	{
			
     if(acilma > 1){
     
		// wait for timer
		if(timer > 0)
			
		{
			timer--;
			return;
		}
		
		// check screen
		if(mc.currentScreen instanceof GuiContainer
			&& !(mc.currentScreen instanceof InventoryEffectRenderer))
			return;
		
		EntityPlayerSP player = WMinecraft.getPlayer();
		InventoryPlayer inventory = player.inventory;
		
		// store slots and values of best armor pieces
		int[] bestArmorSlots = new int[4];
		int[] bestArmorValues = new int[4];
		
		// initialize with currently equipped armor
		for(int type = 0; type < 4; type++)
		{
			bestArmorSlots[type] = -1;
			
			ItemStack stack = inventory.armorItemInSlot(type);
			if(WItem.isNullOrEmpty(stack)
				|| !(stack.getItem() instanceof ItemArmor))
				continue;
			
			ItemArmor item = (ItemArmor)stack.getItem();
			bestArmorValues[type] = getArmorValue(item, stack);
		}
		
		// search inventory for better armor
		for(int slot = 0; slot < 36; slot++)
		{
			ItemStack stack = inventory.getStackInSlot(slot);
			
			if(WItem.isNullOrEmpty(stack)
				|| !(stack.getItem() instanceof ItemArmor))
				continue;
			
			ItemArmor item = (ItemArmor)stack.getItem();
			int armorType = WItem.getArmorType(item);
			int armorValue = getArmorValue(item, stack);
			
			if(armorValue > bestArmorValues[armorType])
			{
				bestArmorSlots[armorType] = slot;
				bestArmorValues[armorType] = armorValue;
			}
		}
		
		// equip better armor in random order
		ArrayList<Integer> types = new ArrayList<>(Arrays.asList(0, 1, 2, 3));
		Collections.shuffle(types);
		for(int type : types)
		{
			// check if better armor was found
			int slot = bestArmorSlots[type];
			if(slot == -1)
				continue;
				
			// check if armor can be swapped
			// needs 1 free slot where it can put the old armor
			ItemStack oldArmor = inventory.armorItemInSlot(type);
			if(!WItem.isNullOrEmpty(oldArmor)
				&& inventory.getFirstEmptyStack() == -1)
				continue;
			
			// hotbar fix
			if(slot < 9)
				slot += 36;
			
			// swap armor
			if(!WItem.isNullOrEmpty(oldArmor))
				WPlayerController.windowClick_QUICK_MOVE(8 - type);
			WPlayerController.windowClick_QUICK_MOVE(slot);
			
			break;
			
			 }
		}
	
	}
	
	/*     */   @EventTarget
	/* 136 */   public void onPacket(NetworkManagerPacketSendEvent event) { if ((event.getPacket() instanceof CPacketClickWindow)) {
	/* 137 */       this.timer = 2;
	/*     */     }
	/*     */   }
	
	private int getArmorValue(ItemArmor item, ItemStack stack)
	{
		int armorPoints = item.damageReduceAmount;
		int prtPoints = 0;
		int armorToughness = (int)WItem.getArmorToughness(item);
		int armorType = item.getArmorMaterial()
			.getDamageReductionAmount(slientclient.compatibility.WEntityEquipmentSlot.LEGS);
		
		{
			Enchantment protection = WEnchantments.PROTECTION;
			int prtLvl = WEnchantments.getEnchantmentLevel(protection, stack);
			
			EntityPlayerSP player = WMinecraft.getPlayer();
			DamageSource dmgSource = DamageSource.causePlayerDamage(player);
			prtPoints = protection.calcModifierDamage(prtLvl, dmgSource);
		}
		
		return armorPoints * 5 + prtPoints * 3 + armorToughness + armorType;
	}
}

