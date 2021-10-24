package slientclient.main;

import java.awt.Color;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import slientclient.gui.UIRenderer;
import slientclient.main.*;
import slientclient.mods.Module;
import slientclient.utils.RenderHelper;

public class GuiInGameHook extends GuiIngame  {

	private static final String Category = null;
	Minecraft mc = Minecraft.getMinecraft();

	public GuiInGameHook(Minecraft mcIn) {
		super(mcIn);
		mc = mcIn;
	}
	
	public void renderGameOverlay(float partialTicks) {
		super.renderGameOverlay(partialTicks);
		
		int ping;
		
		ScaledResolution sr = new ScaledResolution(this.mc);
		this.mc.entityRenderer.setupOverlayRendering();
		
		//ArrayList
		
		final int[] countera = {1};
		GlStateManager.scale(2, 2, 2);
		mc.fontRendererObj.drawStringWithShadow("§lSlient", 2, 2, rainbow (countera[0] * 1));
		GlStateManager.scale(0.5, 0.5, 0.5);
		countera[0]++;
		
		GlStateManager.scale(2, 2, 2);
		mc.fontRendererObj.drawStringWithShadow("§lClient", 36, 2, 0x2F97FF);
		GlStateManager.scale(0.5, 0.5, 0.5);
		
		// Fps
		final int[] counters = {1};
		Minecraft.getMinecraft().fontRendererObj.drawString("FPS: " + mc.getDebugFPS() , 9, 150, rainbow (counters[0] * 300));
		counters[0]++;
		
		// X
		final int[] counteras = {1};
		Minecraft.getMinecraft().fontRendererObj.drawString("X: " + Math.round(mc.player.posX) , 9, 180, rainbow (counteras[0] * 10));
		counteras[0]++;
		
		// Y
		final int[] counterass = {1};
		Minecraft.getMinecraft().fontRendererObj.drawString("Y: " + Math.round(mc.player.posY) , 9, 195, rainbow (counterass[0] * 10));
		counterass[0]++;
		
		final int[] counterasss = {1};
		Minecraft.getMinecraft().fontRendererObj.drawString("Z: " + Math.round(mc.player.posZ) , 9, 210, rainbow (counterasss[0] * 10));
		counterasss[0]++;
		
		// Ping
		if(mc.isSingleplayer()){
			ping = 0;
		}else{
			ping = (int) mc.getCurrentServerData().pingToServer;
		}
		final int[] counterss = {1};
		Minecraft.getMinecraft().fontRendererObj.drawString("PING: " + ping, 9, 165, rainbow (counterss[0] * 300));
		counterss[0]++;{
			
		}
		
		int yCount = 2;
		int index = 0;
		int x = 0;
		final int[] counter = {1};
		for(Module m: Slient.getModules()){
			if(m.isToggled()) {
				int right = sr.getScaledWidth() - mc.fontRendererObj.getStringWidth(m.getName());
				mc.fontRendererObj.drawStringWithShadow(m.getName(), right - 2, yCount, rainbow (counter[0] * 300));
				counter[0]++;
				yCount+=10;
				index++;
				x++;
			}
		}
		UIRenderer.renderAndUpdateFrames();
		drawTabGui();
	}

	public static int rainbow(int delay) {
	      double rainbowState = Math.ceil((System.currentTimeMillis() + delay) / 20.0);
	      rainbowState %= 360;
	      return Color.getHSBColor((float) (rainbowState / 360.0f), 0.8f, 0.7f).getRGB();
	}
	
	public void drawTabGui(){
		final int[] counter = {1};
		
		// Render
		drawRect(8, 20, 5, 40, Slient.tabManager.getCurrentTab()==0 ? rainbow (counter[0] * 300) : 0x000000);
		mc.fontRendererObj.drawString("Render", 10, 26, 0xFFFFFF);
		counter[0]++;
		
		// Movement
		drawRect(8, 40, 5, 60, Slient.tabManager.getCurrentTab()==1 ? rainbow (counter[0] * 300) : 0x000000);
		mc.fontRendererObj.drawString("Movement", 10, 46, 0xFFFFFF);
		counter[0]++;
		
		// Player
		drawRect(8, 60, 5, 80, Slient.tabManager.getCurrentTab()==2 ? rainbow (counter [0] * 300) : 0x000000);
		mc.fontRendererObj.drawString("Player", 10, 66, 0xFFFFFF);
		counter[0]++;
		
		// Combat
		drawRect(8, 80, 5, 100, Slient.tabManager.getCurrentTab()==3 ? rainbow (counter [0] * 300) : 0x000000);
		mc.fontRendererObj.drawString("Combat", 10, 86, 0xFFFFFF);
		counter[0]++;
		
		// Other 
		drawRect(8, 100, 5, 120, Slient.tabManager.getCurrentTab()==4 ? rainbow (counter [0] * 300) : 0x000000);
		mc.fontRendererObj.drawString("Other", 10, 106, 0xFFFFFF);
		counter[0]++;
		
		// Exploit
		drawRect(8, 120, 5, 140, Slient.tabManager.getCurrentTab()==5 ? rainbow (counter [0] * 300) : 0x000000);
		mc.fontRendererObj.drawString("Exploit", 10, 126, 0xFFFFFF);
		counter[0]++;
		
		// Mod listesi
		
		if(Slient.tabManager.getTabs().get(5).isExpanded()){
			drawRect(79, 120, 82, 140, Slient.tabManager.getCurrentExploitMod() == 0 ? rainbow (counter[0] * 300) : 0x000000);
			mc.fontRendererObj.drawString("Crash", 85, 126, 0xFFFFFF);
		}
		
		// Other Menu
		
		if(Slient.tabManager.getTabs().get(4).isExpanded()){
			drawRect(79, 100, 82, 120, Slient.tabManager.getCurrentOtherMod() == 0 ? rainbow (counter[0] * 300) : 0x000000);
			mc.fontRendererObj.drawString("ClickGui", 85, 106, 0xFFFFFF);
			drawRect(79, 120, 82, 140, Slient.tabManager.getCurrentOtherMod() == 1 ? rainbow (counter[0] * 300) : 0x000000);
			mc.fontRendererObj.drawString("Twerk", 85, 126, 0xFFFFFF);
			drawRect(79, 140, 82, 160, Slient.tabManager.getCurrentOtherMod() == 2 ? rainbow (counter[0] * 300) : 0x000000);
			mc.fontRendererObj.drawString("AntiAFK", 85, 146, 0xFFFFFF);
		}
		
		// Combat Menu
		
		if(Slient.tabManager.getTabs().get(3).isExpanded()){
			drawRect(79, 80, 82, 100, Slient.tabManager.getCurrentCombatMod() == 0 ? rainbow (counter[0] * 300) : 0x000000);
			mc.fontRendererObj.drawString("KillAura", 85, 86, 0xFFFFFF);
			drawRect(79, 100, 82, 120, Slient.tabManager.getCurrentCombatMod() == 1 ? rainbow (counter[0] * 300) : 0x000000);
			mc.fontRendererObj.drawString("NoKnockBack", 85, 106, 0xFFFFFF);
			drawRect(79, 120, 82, 140, Slient.tabManager.getCurrentCombatMod() == 2 ? rainbow (counter[0] * 300) : 0x000000);
			mc.fontRendererObj.drawString("AutoArmor", 85, 126, 0xFFFFFF);
			drawRect(79, 140, 82, 160, Slient.tabManager.getCurrentCombatMod() == 3 ? rainbow (counter[0] * 300) : 0x000000);
			mc.fontRendererObj.drawString("Criticals", 85, 146, 0xFFFFFF);
		}
		
		// Player Menu
		
		if(Slient.tabManager.getTabs().get(2).isExpanded()){
			drawRect(79, 60, 82, 80, Slient.tabManager.getCurrentPlayerMod() == 0 ? rainbow (counter[0] * 300) : 0x000000);
			mc.fontRendererObj.drawString("Nofall", 85, 66, 0xFFFFFF);
			drawRect(79, 80, 82, 100, Slient.tabManager.getCurrentPlayerMod() == 1 ? rainbow (counter[0] * 300) : 0x000000);
			mc.fontRendererObj.drawString("PingSpoof", 85, 86, 0xFFFFFF);
			drawRect(79, 100, 82, 120, Slient.tabManager.getCurrentPlayerMod() == 2 ? rainbow (counter[0] * 300) : 0x000000);
			mc.fontRendererObj.drawString("ChestStealer", 85, 106, 0xFFFFFF);
			drawRect(79, 120, 82, 140, Slient.tabManager.getCurrentPlayerMod() == 3 ? rainbow (counter[0] * 300) : 0x000000);
			mc.fontRendererObj.drawString("FastBreak", 85, 126, 0xFFFFFF);
			drawRect(79, 140, 82, 160, Slient.tabManager.getCurrentPlayerMod() == 4 ? rainbow (counter[0] * 300) : 0x000000);
			mc.fontRendererObj.drawString("FastPlace", 85, 146, 0xFFFFFF);
			
		}
		
		// Render Menu
		
		if(Slient.tabManager.getTabs().get(0).isExpanded()){
			drawRect(79, 20, 82, 40, Slient.tabManager.getCurrentRenderMod() == 0 ? rainbow (counter[0] * 300) : 0x000000);
			mc.fontRendererObj.drawString("Fullbright", 85, 26, 0xFFFFFF);
			drawRect(79, 40, 82, 60, Slient.tabManager.getCurrentRenderMod() == 1 ? rainbow (counter[0] * 300) : 0x000000);
			mc.fontRendererObj.drawString("ChestESP", 85, 46, 0xFFFFFF);
			drawRect(79, 60, 82, 80, Slient.tabManager.getCurrentRenderMod() == 2 ? rainbow (counter[0] * 300) : 0x000000);
			mc.fontRendererObj.drawString("MobESP", 85, 66, 0xFFFFFF);
			drawRect(79, 80, 82, 100, Slient.tabManager.getCurrentRenderMod() == 3 ? rainbow (counter[0] * 300) : 0x000000);
			mc.fontRendererObj.drawString("PlayerESP", 85, 86, 0xFFFFFF);
			drawRect(79, 100, 82, 120, Slient.tabManager.getCurrentRenderMod() == 4 ? rainbow (counter[0] * 300) : 0x000000);
			mc.fontRendererObj.drawString("Tracers", 85, 106, 0xFFFFFF);
			drawRect(79, 120, 82, 140, Slient.tabManager.getCurrentRenderMod() == 5 ? rainbow (counter[0] * 300) : 0x000000);
			mc.fontRendererObj.drawString("ItemESP", 85, 126, 0xFFFFFF);
			drawRect(79, 140, 82, 160, Slient.tabManager.getCurrentRenderMod() == 6 ? rainbow (counter[0] * 300) : 0x000000);
			mc.fontRendererObj.drawString("NameTags", 85, 146, 0xFFFFFF);
		}
		
		// Movement Menu
		
		if(Slient.tabManager.getTabs().get(1).isExpanded()){
			drawRect(79, 40, 82, 60, Slient.tabManager.getCurrentMovementMod() == 0 ? rainbow (counter[0] * 300) : 0x000000);
			mc.fontRendererObj.drawString("Flight", 85,  46,  0xFFFFFF);
			drawRect(79, 60, 82, 80, Slient.tabManager.getCurrentMovementMod() == 1 ? rainbow (counter[0] * 300) : 0x000000);
			mc.fontRendererObj.drawString("Glide", 85,  66,  0xFFFFFF);
			drawRect(79, 80, 82, 100, Slient.tabManager.getCurrentMovementMod() == 2 ? rainbow (counter[0] * 300) : 0x000000);
			mc.fontRendererObj.drawString("Sprint", 85,  86,  0xFFFFFF);
			drawRect(79, 100, 82, 120, Slient.tabManager.getCurrentMovementMod() == 3 ? rainbow (counter[0] * 300) : 0x000000);
			mc.fontRendererObj.drawString("LongJump", 85,  106,  0xFFFFFF);
			drawRect(79, 120, 82, 140, Slient.tabManager.getCurrentMovementMod() == 4 ? rainbow (counter[0] * 300) : 0x000000);
			mc.fontRendererObj.drawString("Speed", 85,  126,  0xFFFFFF);
			drawRect(79, 140, 82, 160, Slient.tabManager.getCurrentMovementMod() == 5 ? rainbow (counter[0] * 300) : 0x000000);
			mc.fontRendererObj.drawString("Spider", 85,  146,  0xFFFFFF);
			drawRect(79, 160, 82, 180, Slient.tabManager.getCurrentMovementMod() == 6 ? rainbow (counter[0] * 300) : 0x000000);
			mc.fontRendererObj.drawString("FastLadder", 85,  166,  0xFFFFFF);
			drawRect(79, 180, 82, 200, Slient.tabManager.getCurrentMovementMod() == 7 ? rainbow (counter[0] * 300) : 0x000000);
			mc.fontRendererObj.drawString("Bhop (NCP)", 85,  186,  0xFFFFFF);
			drawRect(79, 200, 82, 220, Slient.tabManager.getCurrentMovementMod() == 8 ? rainbow (counter[0] * 300) : 0x000000);
			mc.fontRendererObj.drawString("Bhop (AAC)", 85,  206,  0xFFFFFF);
			drawRect(79, 220, 82, 240, Slient.tabManager.getCurrentMovementMod() == 9 ? rainbow (counter[0] * 300) : 0x000000);
			mc.fontRendererObj.drawString("NoWeb", 85,  226,  0xFFFFFF);
		}		
		
	}

}
