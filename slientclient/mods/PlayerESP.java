package slientclient.mods;

import org.lwjgl.input.Keyboard;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import slientclient.main.Category;
import slientclient.notification_system.Notification;
import slientclient.notification_system.NotificationManager;
import slientclient.notification_system.NotificationType;
import slientclient.utils.RenderUtils;

public class PlayerESP extends Module{


	public PlayerESP() {
		super("PlayerESP", 0, Category.RENDER);
	}
	
	public void onEnable() {
		NotificationManager.show(new Notification(NotificationType.INFO, "PlayerESP", "PlayerESP was enabled.", 2));
	}
	
	public void onDisable(){
		NotificationManager.show(new Notification(NotificationType.INFO, "PlayerESP", "PlayerESP was disabled.", 2));
    }
	
	  public void onRender()
	  {
	    if (!this.isToggled()) {
	      return;
	    }
	    for (Object theObject : Minecraft.getMinecraft().world.loadedEntityList) {
	      if ((theObject instanceof EntityLivingBase))
	      {
	        EntityLivingBase entity = (EntityLivingBase)theObject;
	        if (((entity instanceof EntityPlayer)) && 
	          (entity != Minecraft.getMinecraft().player)) {
	          player(entity);
	        }
	      }
	    }
	    super.onRender();
	  }
	  
	  public void player(EntityLivingBase entity)
	  {
	    float red = 0.5F;
	    float green = 0.5F;
	    float blue = 1.0F;
	    
	    Minecraft.getMinecraft().getRenderManager();double xPos = entity.lastTickPosX + (entity.posX - entity.lastTickPosX) * Minecraft.getMinecraft().timer.renderPartialTicks - RenderManager.renderPosX;
	    Minecraft.getMinecraft().getRenderManager();double yPos = entity.lastTickPosY + (entity.posY - entity.lastTickPosY) * Minecraft.getMinecraft().timer.renderPartialTicks - RenderManager.renderPosY;
	    Minecraft.getMinecraft().getRenderManager();double zPos = entity.lastTickPosZ + (entity.posZ - entity.lastTickPosZ) * Minecraft.getMinecraft().timer.renderPartialTicks - RenderManager.renderPosZ;
	    
	    render(red, green, blue, xPos, yPos, zPos, entity.width, entity.height);
	  }
	  
	  public void render(float red, float green, float blue, double x, double y, double z, float width, float height)
	  {
	    RenderUtils.drawEntityESP(x, y, z, width, height, red, green, blue, 0.45F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F);
	  }
	
}