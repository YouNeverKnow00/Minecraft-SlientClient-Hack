package slientclient.utils;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;

public class RenderUtils {
	
	
	public static void entityESPBox(Entity entity, int mode)
	{
		GL11.glBlendFunc(770, 771);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glLineWidth(2.0F);
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		GL11.glDisable(GL11.GL_DEPTH_TEST);
		GL11.glDepthMask(false);
		if(mode == 0)// Enemy
			GL11.glColor4d(
				1 - Minecraft.getMinecraft().player
					.getDistanceToEntity(entity) / 40,
				Minecraft.getMinecraft().player.getDistanceToEntity(entity) / 40,
				0, 0.5F);
		else if(mode == 1)// Friend
			GL11.glColor4d(0, 0, 1, 0.5F);
		else if(mode == 2)// Other
			GL11.glColor4d(1, 1, 0, 0.5F);
		else if(mode == 3)// Target
			GL11.glColor4d(1, 0, 0, 0.5F);
		else if(mode == 4)// Team
			GL11.glColor4d(0, 1, 0, 0.5F);
		Minecraft.getMinecraft().getRenderManager();
		RenderGlobal.drawSelectionBoundingBox(
			new AxisAlignedBB(
				entity.boundingBox.minX
					- 0.05
					- entity.posX
					+ (entity.posX - Minecraft.getMinecraft()
						.getRenderManager().renderPosX),
				entity.boundingBox.minY
					- entity.posY
					+ (entity.posY - Minecraft.getMinecraft()
						.getRenderManager().renderPosY),
				entity.boundingBox.minZ
					- 0.05
					- entity.posZ
					+ (entity.posZ - Minecraft.getMinecraft()
						.getRenderManager().renderPosZ),
				entity.boundingBox.maxX
					+ 0.05
					- entity.posX
					+ (entity.posX - Minecraft.getMinecraft()
						.getRenderManager().renderPosX),
				entity.boundingBox.maxY
					+ 0.1
					- entity.posY
					+ (entity.posY - Minecraft.getMinecraft()
						.getRenderManager().renderPosY),
				entity.boundingBox.maxZ
					+ 0.05
					- entity.posZ
					+ (entity.posZ - Minecraft.getMinecraft()
						.getRenderManager().renderPosZ)), 1.0F, 1.0F, 0.0F, 0.8F);
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glEnable(GL11.GL_DEPTH_TEST);
		GL11.glDepthMask(true);
		GL11.glDisable(GL11.GL_BLEND);
	}
	
	public static void blockESPBox(BlockPos blockPos)
	{
		double x =
			blockPos.getX()
				- Minecraft.getMinecraft().getRenderManager().renderPosX;
		double y =
			blockPos.getY()
				- Minecraft.getMinecraft().getRenderManager().renderPosY;
		double z =
			blockPos.getZ()
				- Minecraft.getMinecraft().getRenderManager().renderPosZ;
		GL11.glBlendFunc(770, 771);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glLineWidth(2.0F);
		GL11.glColor4d(0, 1, 0, 0.15F);
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		GL11.glDisable(GL11.GL_DEPTH_TEST);
		GL11.glDepthMask(false);
		//drawColorBox(new AxisAlignedBB(x, y, z, x + 1.0, y + 1.0, z + 1.0));
		GL11.glColor4d(0, 0, 1, 0.5F);
		RenderGlobal.drawSelectionBoundingBox(new AxisAlignedBB(x, y, z, x + 1.0F, y + 1.0F, z + 1.0F), 1.5F, 2.0F, 2.0F, 1.8F);
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glEnable(GL11.GL_DEPTH_TEST);
		GL11.glDepthMask(true);
		GL11.glDisable(GL11.GL_BLEND);
	}
	
	//
	
	  public static void drawOutlinedBlockESP(double x, double y, double z, float red, float green, float blue, float alpha, float lineWidth)
	  {
	    GL11.glPushMatrix();
	    GL11.glEnable(3042);
	    GL11.glBlendFunc(770, 771);
	    
	    GL11.glDisable(3553);
	    GL11.glEnable(2848);
	    GL11.glDisable(2929);
	    GL11.glDepthMask(false);
	    GL11.glLineWidth(lineWidth);
	    GL11.glColor4f(red, green, blue, alpha);
	    RenderGlobal.drawSelectionBoundingBox(new AxisAlignedBB(x, y, z, x + 1.0F, y + 1.0F, z + 1.0F), 1.0F, 2.0F, 2.0F, 1.8F);
	    GL11.glDisable(2848);
	    GL11.glEnable(3553);
	    
	    GL11.glEnable(2929);
	    GL11.glDepthMask(true);
	    GL11.glDisable(3042);
	    GL11.glPopMatrix();
	  }
	  
	  public static void drawBlockESP(double x, double y, double z, float red, float green, float blue, float alpha, float lineRed, float lineGreen, float lineBlue, float lineAlpha, float lineWidth)
	  {
	    GL11.glPushMatrix();
	    GL11.glEnable(3042);
	    GL11.glBlendFunc(770, 771);
	    
	    GL11.glDisable(3553);
	    GL11.glEnable(2848);
	    GL11.glDisable(2929);
	    GL11.glDepthMask(false);
	    GL11.glColor4f(red, green, blue, alpha);
	    RenderGlobal.drawSelectionBoundingBox(new AxisAlignedBB(x, y, z, x + 1.0F, y + 1.0F, z + 1.0F), 1.0F, 2.0F, 2.0F, 1.8F);
	    GL11.glLineWidth(lineWidth);
	    GL11.glColor4f(lineRed, lineGreen, lineBlue, lineAlpha);
	    RenderGlobal.drawSelectionBoundingBox(new AxisAlignedBB(x, y, z, x + 1.0F, y + 1.0F, z + 1.0F), 1.0F, 2.0F, 2.0F, 1.8F);
	    GL11.glDisable(2848);
	    GL11.glEnable(3553);
	    
	    GL11.glEnable(2929);
	    GL11.glDepthMask(true);
	    GL11.glDisable(3042);
	    GL11.glPopMatrix();
	  }
	  
	  public static void drawSolidBlockESP(double x, double y, double z, float red, float green, float blue, float alpha)
	  {
	    GL11.glPushMatrix();
	    GL11.glEnable(3042);
	    GL11.glBlendFunc(770, 771);
	    
	    GL11.glDisable(3553);
	    GL11.glEnable(2848);
	    GL11.glDisable(2929);
	    GL11.glDepthMask(false);
	    GL11.glColor4f(red, green, blue, alpha);
	    RenderGlobal.drawSelectionBoundingBox(new AxisAlignedBB(x, y, z, x + 1.0F, y + 1.0F, z + 1.0F), 1.0F, 2.0F, 2.0F, 1.8F);
	    GL11.glDisable(2848);
	    GL11.glEnable(3553);
	    
	    GL11.glEnable(2929);
	    GL11.glDepthMask(true);
	    GL11.glDisable(3042);
	    GL11.glPopMatrix();
	  }
	  
	  public static void drawOutlinedEntityESP(double x, double y, double z, double width, double height, float red, float green, float blue, float alpha)
	  {
	    GL11.glPushMatrix();
	    GL11.glEnable(3042);
	    GL11.glBlendFunc(770, 771);
	    
	    GL11.glDisable(3553);
	    GL11.glEnable(2848);
	    GL11.glDisable(2929);
	    GL11.glDepthMask(false);
	    GL11.glColor4f(red, green, blue, alpha);
	    RenderGlobal.drawSelectionBoundingBox(new AxisAlignedBB(x - width, y, z - width, x + width, y + height, z + width), alpha, alpha, alpha, alpha);
	    GL11.glDisable(2848);
	    GL11.glEnable(3553);
	    
	    GL11.glEnable(2929);
	    GL11.glDepthMask(true);
	    GL11.glDisable(3042);
	    GL11.glPopMatrix();
	  }
	  
	  public static void drawSolidEntityESP(double x, double y, double z, double width, double height, float red, float green, float blue, float alpha)
	  {
	    GL11.glPushMatrix();
	    GL11.glEnable(3042);
	    GL11.glBlendFunc(770, 771);
	    
	    GL11.glDisable(3553);
	    GL11.glEnable(2848);
	    GL11.glDisable(2929);
	    GL11.glDepthMask(false);
	    GL11.glColor4f(red, green, blue, alpha);
	    RenderGlobal.drawSelectionBoundingBox(new AxisAlignedBB(x - width, y, z - width, x + width, y + height, z + width), alpha, alpha, alpha, alpha);
	    GL11.glDisable(2848);
	    GL11.glEnable(3553);
	    
	    GL11.glEnable(2929);
	    GL11.glDepthMask(true);
	    GL11.glDisable(3042);
	    GL11.glPopMatrix();
	  }
	  
	  public static void drawEntityESP(double x, double y, double z, double width, double height, float red, float green, float blue, float alpha, float lineRed, float lineGreen, float lineBlue, float lineAlpha, float lineWdith)
	  {
	    GL11.glPushMatrix();
	    GL11.glEnable(3042);
	    GL11.glBlendFunc(770, 771);
	    
	    GL11.glDisable(3553);
	    GL11.glEnable(2848);
	    GL11.glDisable(2929);
	    GL11.glDepthMask(false);
	    GL11.glColor4f(red, green, blue, alpha);
	    RenderGlobal.drawSelectionBoundingBox(new AxisAlignedBB(x - width, y, z - width, x + width, y + height, z + width), lineWdith, lineWdith, lineWdith, lineWdith);
	    GL11.glLineWidth(lineWdith);
	    GL11.glColor4f(lineRed, lineGreen, lineBlue, lineAlpha);
	    RenderGlobal.drawSelectionBoundingBox(new AxisAlignedBB(x - width, y, z - width, x + width, y + height, z + width), lineWdith, lineWdith, lineWdith, lineWdith);
	    GL11.glDisable(2848);
	    GL11.glEnable(3553);
	    GL11.glEnable(2929);
	    GL11.glDepthMask(true);
	    GL11.glDisable(3042);
	    GL11.glPopMatrix();
	  }
	  
	  public static void drawTracerLine(double x, double y, double z, float red, float green, float blue, float alpha, float lineWdith)
	  {
	    GL11.glPushMatrix();
	    GL11.glEnable(3042);
	    GL11.glEnable(2848);
	    GL11.glDisable(2929);
	    
	    GL11.glDisable(3553);
	    GL11.glBlendFunc(770, 771);
	    GL11.glEnable(3042);
	    GL11.glLineWidth(lineWdith);
	    GL11.glColor4f(red, green, blue, alpha);
	    GL11.glBegin(2);
	    GL11.glVertex3d(0.0D, 0.0D + Minecraft.getMinecraft().player.getEyeHeight(), 0.0D);
	    GL11.glVertex3d(x, y, z);
	    GL11.glEnd();
	    GL11.glDisable(3042);
	    GL11.glEnable(3553);
	    GL11.glEnable(2929);
	    GL11.glDisable(2848);
	    GL11.glDisable(3042);
	    
	    GL11.glPopMatrix();
	  }
	  
	  public static void drawOutlinedBox(AxisAlignedBB boundingBox, int color)
	  {
	    drawOutlinedBox(boundingBox, color, true);
	  }
	  
	  public static void drawOutlinedBox(AxisAlignedBB boundingBox, int color, boolean disableDepth)
	  {
	    if (boundingBox == null) {
	      return;
	    }
	    enableRender3D(disableDepth);
	    setColor(color);
	    
	    GL11.glBegin(3);
	    GL11.glVertex3d(boundingBox.minX, boundingBox.minY, boundingBox.minZ);
	    GL11.glVertex3d(boundingBox.maxX, boundingBox.minY, boundingBox.minZ);
	    GL11.glVertex3d(boundingBox.maxX, boundingBox.minY, boundingBox.maxZ);
	    GL11.glVertex3d(boundingBox.minX, boundingBox.minY, boundingBox.maxZ);
	    GL11.glVertex3d(boundingBox.minX, boundingBox.minY, boundingBox.minZ);
	    GL11.glEnd();
	    GL11.glBegin(3);
	    GL11.glVertex3d(boundingBox.minX, boundingBox.maxY, boundingBox.minZ);
	    GL11.glVertex3d(boundingBox.maxX, boundingBox.maxY, boundingBox.minZ);
	    GL11.glVertex3d(boundingBox.maxX, boundingBox.maxY, boundingBox.maxZ);
	    GL11.glVertex3d(boundingBox.minX, boundingBox.maxY, boundingBox.maxZ);
	    GL11.glVertex3d(boundingBox.minX, boundingBox.maxY, boundingBox.minZ);
	    GL11.glEnd();
	    GL11.glBegin(1);
	    GL11.glVertex3d(boundingBox.minX, boundingBox.minY, boundingBox.minZ);
	    GL11.glVertex3d(boundingBox.minX, boundingBox.maxY, boundingBox.minZ);
	    GL11.glVertex3d(boundingBox.maxX, boundingBox.minY, boundingBox.minZ);
	    GL11.glVertex3d(boundingBox.maxX, boundingBox.maxY, boundingBox.minZ);
	    GL11.glVertex3d(boundingBox.maxX, boundingBox.minY, boundingBox.maxZ);
	    GL11.glVertex3d(boundingBox.maxX, boundingBox.maxY, boundingBox.maxZ);
	    GL11.glVertex3d(boundingBox.minX, boundingBox.minY, boundingBox.maxZ);
	    GL11.glVertex3d(boundingBox.minX, boundingBox.maxY, boundingBox.maxZ);
	    GL11.glEnd();
	    
	    enableRender3D(disableDepth);
	  }

	private static void enableRender3D(boolean disableDepth) {
		// TODO Auto-generated method stub
		
	}

	private static void setColor(int color) {
		// TODO Auto-generated method stub
		
	}
	/*     */ 
	/*     */ 
	/*     */   public static void drawLine3D(double x1, double y1, double z1, double x2, double y2, double z2, int color, boolean disableDepth)
	/*     */   {
	/*  51 */     enableRender3D(disableDepth);
	/*  52 */     setColor(color);
	/*     */     
	/*  54 */     GL11.glBegin(1);
	/*  55 */     GL11.glVertex3d(x1, y1, z1);
	/*  56 */     GL11.glVertex3d(x2, y2, z2);
	/*  57 */     GL11.glEnd();
	/*     */     
	/*  59 */     enableRender3D(disableDepth);
	/*     */   }


	public static void drawLine3D(double renderX1, double renderY1, double renderZ1, double renderX2, double renderY2,
			double renderZ2, Object glPopMatrix) {
		// TODO Auto-generated method stub
		
	}
	
}
