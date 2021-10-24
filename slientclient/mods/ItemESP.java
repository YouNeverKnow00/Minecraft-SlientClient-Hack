package slientclient.mods;

import java.util.ArrayList;

import org.darkstorm.minecraft.gui.GuiManager;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.Vec3d;

import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.util.math.AxisAlignedBB;
import slientclient.compatibility.WItem;
import slientclient.compatibility.WMinecraft;
import slientclient.event.EventTarget;
import slientclient.event.WorldRenderEvent;
import slientclient.main.Category;
import slientclient.notification_system.Notification;
import slientclient.notification_system.NotificationManager;
import slientclient.notification_system.NotificationType;
import slientclient.utils.EntityHelper;
import slientclient.utils.RenderUtils;
import slientclient.utils.RotationUtils;
import slientclient.utils.WEntityRenderer;

public class ItemESP extends Module{
	
	 public int calisartik;
	 private int itemBox;
	 private final ArrayList<EntityItem> items = new ArrayList();

	public ItemESP() {
		super("ItemESP", 0, Category.RENDER);	
	}
	
	
	public void onDisable(){
		calisartik = -1;
		NotificationManager.show(new Notification(NotificationType.INFO, "ItemESP", "ItemESP was disabled.", 2));
	}
	
	public void onEnable() {
	    calisartik = 1;
		NotificationManager.show(new Notification(NotificationType.INFO, "ItemESP", "ItemESP was enabled.", 2));
	}
	
	public void onRender() {
	    if(calisartik == 1) {
	    for (Object object : WMinecraft.getWorld().loadedEntityList) {
	      if ((object instanceof EntityItem))
	      {
	        EntityItem item = (EntityItem)object;
	        double[] pos = EntityHelper.interpolate(item);
	        double x = pos[0] - RenderManager.renderPosX;
	        double y = pos[1] - RenderManager.renderPosY + 0.1D;
	        double z = pos[2] - RenderManager.renderPosZ;
	        
	        GL11.glPushMatrix();
	        GL11.glTranslated(x, y, z);
	        RenderUtils.drawOutlinedBox(
	          new AxisAlignedBB(item.width / 2.0D, 0.0D, -(item.width / 2.0D), 
	          -item.width / 2.0D, item.height, item.width / 2.0D), 
	          GuiManager.getHexMainColor());
	        GL11.glPopMatrix();
	      }
	     }
	    }
	  }
	
}
