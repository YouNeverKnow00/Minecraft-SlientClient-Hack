/*     */ package slientclient.gui.server;
/*     */ 
/*     */ import com.google.common.collect.Lists;
/*     */ import slientclient.alt.GuiPlus;
/*     */ import slientclient.gui.server.checker.GuiPortChecker;
/*     */ import slientclient.gui.server.checker.gh.GuiGHChecker;
/*     */ import slientclient.gui.server.finder.*;
/*     */ import java.io.IOException;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.GuiButton;
/*     */ import net.minecraft.client.gui.GuiScreen;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class GuiServerChecks
/*     */   extends GuiScreen
/*     */ {
/*     */   protected GuiPlus parentScreen;
/*     */   protected String messageLine1;
/*     */   private String messageLine2;
/*  28 */   private final List field_175298_s = Lists.newArrayList();
/*     */   
/*     */   protected String confirmButtonText;
/*     */   
/*     */   protected String cancelButtonText;
/*     */   
/*     */   protected int parentButtonClickedId;
/*     */   
/*     */   private int ticksUntilEnable;
/*     */   private static final String __OBFID = "CL_00000684";
/*     */   
/*     */   public GuiServerChecks(GuiPlus p_i1082_1_)
/*     */   {
/*  41 */     this.parentScreen = p_i1082_1_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void initGui()
/*     */   {
/*  49 */     this.buttonList.add(new GuiButton(25564, this.width / 2 - 100, 62, 200, 20, "Server Finder"));
/*  50 */     this.buttonList.add(new GuiButton(25565, this.width / 2 - 100, 87, 200, 20, "Server Checker"));
/*  51 */     this.buttonList.add(new GuiButton(25566, this.width / 2 - 100, 112, 200, 20, "Checker (GH)"));
/*     */     
/*  53 */     this.buttonList.add(new GuiButton(666, this.width / 2 - 100, this.height - 50, 200, 20, "Back to connection utils"));
/*     */   }
/*     */   
		protected void actionPerformed(GuiButton button)
				throws IOException
		{
			if (button.enabled) {
				if (button.id == 666) {
					this.mc.displayGuiScreen(this.parentScreen);
				} else if (button.id == 25564) {
					this.mc.displayGuiScreen(new GuiServerFinder(this.parentScreen.parentScreen, this));
				} else if (button.id == 25565) {
					this.mc.displayGuiScreen(new GuiPortChecker(this.parentScreen.parentScreen, this));
				} else if (button.id == 25566) {
					this.mc.displayGuiScreen(new GuiGHChecker(this.parentScreen.parentScreen, this));
	      }
	    }
	  }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void drawScreen(int mouseX, int mouseY, float partialTicks)
/*     */   {
/*  83 */     drawDefaultBackground();
/*     */     
/*  85 */     drawCenteredString(this.fontRendererObj, "Server Connection Utils", this.width / 2, 20, 
/*  86 */       16777215);
/*  87 */     drawCenteredString(this.fontRendererObj, "Here you can find some connection utils.", this.width / 2, 35, 
/*  88 */       10526880);
/*  89 */     drawCenteredString(this.fontRendererObj, 
/*  90 */       "Press back to return to connection utils", this.width / 2, 45, 10526880);
/*     */     
/*  92 */     super.drawScreen(mouseX, mouseY, partialTicks);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setButtonDelay(int p_146350_1_)
/*     */   {
/*  99 */     this.ticksUntilEnable = p_146350_1_;
/*     */     
/*     */     GuiButton var3;
/* 102 */     for (Iterator var2 = this.buttonList.iterator(); var2.hasNext(); var3.enabled = false)
/*     */     {
/* 104 */       var3 = (GuiButton)var2.next();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void updateScreen()
/*     */   {
/* 113 */     super.updateScreen();
/*     */     
/*     */ 
/* 116 */     if (--this.ticksUntilEnable == 0) {
/*     */       GuiButton var2;
/* 118 */       for (Iterator var1 = this.buttonList.iterator(); var1.hasNext(); var2.enabled = true)
/*     */       {
/* 120 */         var2 = (GuiButton)var1.next();
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\User\Desktop\Cloudy.jar!\it\Seba4316\Loup\gui\mcscreens\server\GuiServerChecks.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */