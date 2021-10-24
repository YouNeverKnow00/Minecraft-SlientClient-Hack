package slientclient.mods;

import org.darkstorm.minecraft.gui.GuiManager;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import com.mojang.realmsclient.gui.ChatFormatting;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityOtherPlayerMP;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.GlStateManager.TexGen;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderEntityItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityArmorStand;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.passive.IAnimals;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.ITextComponent;
import slientclient.compatibility.WMinecraft;
import slientclient.event.EventPostRender3D;
import slientclient.event.EventTarget;
import slientclient.event.NametagRenderEvent;
import slientclient.event.WorldRenderEvent;
import slientclient.main.Category;
import slientclient.notification_system.Notification;
import slientclient.notification_system.NotificationManager;
import slientclient.notification_system.NotificationType;
import slientclient.utils.BoolValue;
import slientclient.utils.ChatColor;
import slientclient.utils.GLUtil;
import slientclient.utils.RenderHelper;
import slientclient.utils.RenderUtils;
import slientclient.utils.TextUtils;
import slientclient.utils.Wrapper;

public class NameTags extends Module{

	public int healthCol;
	public BoolValue formatting = new BoolValue(true);
    public BoolValue armour = new BoolValue(true);
	
	private static NameTags instance;
	public int acilsusanacil;
	private boolean enabled;
	private Object moduleSettings;
	
	public NameTags() {
		super("NameTags", 0, Category.RENDER);
	}

	public void onDisable(){
		acilsusanacil = -1;
		NotificationManager.show(new Notification(NotificationType.INFO, "NameTags", "NameTags was disabled.", 2));
	}
	
	public void onEnable() {
		acilsusanacil = 1;
		NotificationManager.show(new Notification(NotificationType.INFO, "NameTags", "NameTags was enabled.", 2));
	}
	
	  @EventTarget
	  public void onRender()
	  {
	   if(acilsusanacil == 1) {
	    for (Object o : Minecraft.getMinecraft().world.playerEntities)
	    {
	      EntityPlayer p = (EntityPlayer)o;
	      if ((p != mc.getRenderViewEntity()) && (p.isEntityAlive()))
	      {
	        mc.getRenderManager();double pX = p.lastTickPosX + (p.posX - p.lastTickPosX) * mc.timer.renderPartialTicks - RenderManager.renderPosX;
	        mc.getRenderManager();double pY = p.lastTickPosY + (p.posY - p.lastTickPosY) * mc.timer.renderPartialTicks - RenderManager.renderPosY;
	        mc.getRenderManager();double pZ = p.lastTickPosZ + (p.posZ - p.lastTickPosZ) * mc.timer.renderPartialTicks - RenderManager.renderPosZ;
	        
	        renderNameTag(p, this.formatting.getValue() ? p.getDisplayName().getFormattedText() : p.getName(), pX, pY, pZ);
	      }
	    }
	   }
	  }
	  
	  public void renderNameTag(EntityPlayer entity, String tag, double pX, double pY, double pZ)
	  {
	    FontRenderer var12 = mc.fontRendererObj;
	    pY += (entity.isSneaking() ? 0.5D : 0.7D);
	    float var13 = Minecraft.player.getDistanceToEntity(entity) / 4.0F;
	    if (var13 < 1.6F) {
	      var13 = 1.6F;
	    }
	    int colour = 16777215;
	    if (!this.formatting.getValue()) {
	      tag = ChatColor.stripColor(tag);
	    }
	    else
	    {
	      if (entity.isInvisible()) {
	        return;
	      }
	      if (entity.isSneaking()) {
	        colour = 11468800;
	      }
	    }
	    double health = Math.ceil(entity.getHealth() + entity.getAbsorptionAmount()) / 2.0D;
	    String healthStr;
	    String healthStr1;
	    if (Math.floor(health) == health) {
	      healthStr1 = String.valueOf((int)Math.floor(health));
	    } else {
	      healthStr1 = String.valueOf(health);
	    };
	    if ((entity.getAbsorptionAmount() > 0.0F) && (entity.getHealth() + entity.getAbsorptionAmount() >= entity.getMaxHealth()))
	    {
	      healthCol = 5635925;
	    }
	    else
	    {
	      switch ((int)Math.floor(health * 2.0D))
	      {
	      case 13: 
	      case 14: 
	      case 15: 
	      case 16: 
	      case 17: 
	      case 18: 
	      case 19: 
	      case 20: 
	        healthCol = 5635925;
	        break;
	      case 8: 
	      case 9: 
	      case 10: 
	      case 12: 
	        healthCol = 16777045;
	        break;
	      case 1: 
	      case 2: 
	      case 3: 
	      case 4: 
	      case 5: 
	      case 6: 
	      case 7: 
	        healthCol = 16733525;
	        break;
	      case 11: 
	      default: 
	        healthCol = 5635925;
	      }
	    }
	    RenderManager renderManager = mc.getRenderManager();
	    int color = 16776960;
	    float scale = var13;
	    scale /= 80.0F;
	    GL11.glPushMatrix();
	    GL11.glTranslatef((float)pX, (float)pY + 1.4F, (float)pZ);
	    GL11.glNormal3f(0.0F, 1.0F, 0.0F);
	    GL11.glRotatef(-RenderManager.playerViewY, 0.0F, 1.0F, 0.0F);
	    GL11.glRotatef(RenderManager.playerViewX, 1.0F, 0.0F, 0.0F);
	    GL11.glScalef(-scale, -scale, scale);
	    GLUtil.setGLCap(2896, false);
	    GLUtil.setGLCap(2929, false);
	    Tessellator var14 = Tessellator.getInstance();
	    BufferBuilder var15 = var14.getBuffer();
	    int width = mc.fontRendererObj.getStringWidth(tag + " " + healthStr1) / 2;
	    
	    GLUtil.setGLCap(3042, true);
	    GL11.glBlendFunc(770, 771);
	    RenderHelper.drawBorderedRect(-width - 2, -(mc.fontRendererObj.FONT_HEIGHT + 1), width + 2, 2.0F, 1.3F, -14496513, -2013265920);
	    
	    // Gerekirse kaldýr
	    var12.drawString(tag, -width, -(mc.fontRendererObj.FONT_HEIGHT - 1), colour, true);
	    var12.drawString(healthStr1, -width + mc.fontRendererObj.getStringWidth(tag + " "), -(mc.fontRendererObj.FONT_HEIGHT - 1), healthCol, true);
	    //
	    GL11.glPushMatrix();
	    if ((this.armour.getValue()) && (Minecraft.getMinecraft().player.getDistanceSqToEntity(entity) <= 900.0D))
	    {
	      int xOffset = 0;
	      NonNullList<ItemStack> arrayOfItemStack1;
	        xOffset -= 8;
	        xOffset += 16;
	      }
	      NonNullList<ItemStack> arrayOfItemStack2;
	      int k = (arrayOfItemStack2 = entity.inventory.armorInventory).length;
	    GL11.glPopMatrix();
	    GLUtil.revertAllCaps();
	    GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	    GL11.glPopMatrix();
	    }
	  
	  public void renderItemStack(ItemStack stack, int x, int y)
	  {
	    GL11.glPushMatrix();
	    GL11.glDepthMask(true);
	    GlStateManager.clear(256);
	    RenderHelper.enableStandardItemLighting();
	    mc.getRenderItem().zLevel = -150.0F;
	    // Null ile y sil
	    whatTheFuckOpenGLThisFixesItemGlint(null, y);
	    //
	    mc.getRenderItem().renderItemAndEffectIntoGUI(stack, x, y);
	    mc.getRenderItem().zLevel = 0.0F;
	    RenderHelper.disableStandardItemLighting();
	    GlStateManager.disableCull();
	    GlStateManager.enableAlpha();
	    GlStateManager.disableBlend();
	    GlStateManager.disableLighting();
	    GlStateManager.scale(0.5D, 0.5D, 0.5D);
	    GlStateManager.disableDepth();
	    renderEnchantText(stack, x, y);
	    GlStateManager.enableDepth();
	    GlStateManager.scale(2.0F, 2.0F, 2.0F);
	    GL11.glPopMatrix();
	  }
	  
	  public void renderEnchantText(ItemStack stack, int x, int y)
	  {

	  }
	  
	  // GlStateManager.TexGen texGen, int param Felan gerekirse sil
	  public void whatTheFuckOpenGLThisFixesItemGlint(GlStateManager.TexGen texGen, int param)
	  {
	    GlStateManager.disableLighting();
	    GlStateManager.disableDepth();
	    GlStateManager.disableBlend();
	    GlStateManager.enableLighting();
	    GlStateManager.enableDepth();
	    GlStateManager.disableLighting();
	    GlStateManager.disableDepth();
	    //
	    GlStateManager.disableTexGenCoord(null);
	    //
	    GlStateManager.disableAlpha();
	    GlStateManager.disableBlend();
	    GlStateManager.enableBlend();
	    GlStateManager.enableAlpha();
	    // gerekirse sil
		GlStateManager.texGen(texGen, param);
		//
	    GlStateManager.enableLighting();
	    GlStateManager.enableDepth();
	  }
	
}

