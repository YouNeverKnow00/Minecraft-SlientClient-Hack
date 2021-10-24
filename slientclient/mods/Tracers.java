package slientclient.mods;

import java.awt.Color;

import org.lwjgl.input.Keyboard;
import net.minecraft.client.entity.EntityOtherPlayerMP;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;

import org.lwjgl.opengl.GL11;

import slientclient.event.EventManager;
import slientclient.main.Category;
import slientclient.notification_system.Notification;
import slientclient.notification_system.NotificationManager;
import slientclient.notification_system.NotificationType;

public class Tracers extends Module{

	private int acik;

	public Tracers() {
		super("Tracers", 0, Category.RENDER);
	}
	
	  public void onEnable()
	  {
		NotificationManager.show(new Notification(NotificationType.INFO, "Tracers", "Tracers was enabled.", 2));
		acik = 2;
	    EventManager.register(this);
	    onUpdate();
	  }
	  
	  public void onDisable()
	  {
		NotificationManager.show(new Notification(NotificationType.INFO, "Tracers", "Tracers was disabled.", 2));
		acik = -1;
	    EventManager.unregister(this);
	  }
	
	@Override
	public void onRender() {
	    drawTracers();
	}
	
	public void drawTracers() {
		if(acik > 1){
			
	      for(int x = 0; x < mc.world.playerEntities.size(); x++) {
	          EntityPlayer entity = (EntityPlayer) mc.world.playerEntities.get(x);
	          if(mc.player.getDistanceToEntity(entity) >= 6) {
	          if(entity == mc.player){
	                continue;
	          }
	          GL11.glBlendFunc(770, 771);
	          GL11.glLineWidth(1.4F);
	          GL11.glDisable(3553);
	          GL11.glDisable(2929);

	          double X = (entity.lastTickPosX + (entity.posX - entity.lastTickPosX) * (double)mc.timer.renderPartialTicks) - mc.getRenderManager().renderPosX;;
				double Y = (entity.lastTickPosY + (entity.posY - entity.lastTickPosY) * (double)mc.timer.renderPartialTicks) - mc.getRenderManager().renderPosY;
				double Z = (entity.lastTickPosZ + (entity.posZ - entity.lastTickPosZ) * (double)mc.timer.renderPartialTicks) - mc.getRenderManager().renderPosZ;
	            GL11.glBegin(GL11.GL_LINES);
	            
	            float r = 0F, g = 0F, b = 0F;
	          

	            if (mc.player.getDistanceToEntity(entity) > 40) {
	            	r = Color.BLUE.getRed();
	            	g = Color.BLUE.getGreen();
	            	b = Color.BLUE.getBlue();
	            }
	            if (mc.player.getDistanceToEntity(entity) <= 40) {
	            	r = Color.BLUE.getRed();
	            	g = Color.WHITE.getGreen();
	            	b = Color.WHITE.getBlue();
	            }
	            if (mc.player.getDistanceToEntity(entity) <= 20) {
	            	r = Color.WHITE.getRed();
	            	g = Color.WHITE.getGreen();
	            	b = Color.WHITE.getBlue();
	            }
	            
	            GL11.glColor4f(r, g, b, 1f);
	            
	            GL11.glVertex2d(0f, mc.player.isSneaking() ? 1.54F : 1.62F); 
	            GL11.glVertex3d(X, Y + 1, Z);
	            GL11.glEnd();
	            GL11.glBegin(GL11.GL_LINES);
	            
	            GL11.glEnd();
	            GL11.glEnable(2929);
	            GL11.glEnable(3553);
	            GL11.glColor3f(1, 1, 1);
	          }
	      
	      }
	    }
	}
}