/*     */ package slientclient.alt;
/*     */ 
/*     */ import com.google.common.collect.Lists;
/*     */ import slientclient.alt.GuiAltManager;
import slientclient.gui.GuiCrasher;
import slientclient.gui.GuiSpoofUUID;
import slientclient.gui.server.GuiServerChecks;
import slientclient.gui.server.checker.GuiPortChecker;
import slientclient.gui.server.checker.gh.GuiGHChecker;
import slientclient.gui.server.finder.GuiServerFinder;
import slientclient.utils.ChatColor;

/*     */ import java.io.IOException;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiIngameMenu;
/*     */ import net.minecraft.client.gui.GuiMultiplayer;
/*     */ import net.minecraft.client.gui.GuiScreen;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class GuiPlus
/*     */   extends GuiScreen
/*     */ {
/*     */   public GuiMultiplayer parentScreen;
/*     */   protected String messageLine1;
/*     */   private String messageLine2;
/*  26 */   private final List field_175298_s = Lists.newArrayList();
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
/*     */   public GuiPlus(GuiMultiplayer p_i1082_1_)
/*     */   {
/*  39 */     this.parentScreen = p_i1082_1_;
/*     */   }

			public GuiPlus(GuiIngameMenu guiIngameMenu) {

			}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void initGui()
/*     */   {
/*  49 */     this.buttonList.add(new GuiButton(25566, this.width / 2 - 100, this.height / 4 + 0 + 12, "§aAlt Manager"));
	          this.buttonList.add(new GuiButton(287, this.width / 2 - 100, this.height / 4 + 24 + 12, "§bServer Crasher (IPWL)"));
	          this.buttonList.add(new GuiButton(2104, this.width / 2 - 100, this.height / 4 + 48 + 12, "§dServer Check"));;
/*  55 */     this.buttonList.add(new GuiButton(5, this.width / 2 - 100, this.height / 4 + 72 + 12, ChatColor.RED + "Set nick/UUID"));
			  this.buttonList.add(new GuiButton(666, this.width / 2 - 100, this.height - 50, 200, 20, "Back to servers"));
/*     */   }
/*     */   
/*     */   protected void actionPerformed(GuiButton button) throws IOException
/*     */   {
/*  60 */     if (button.enabled)
/*     */     {
/*  62 */       if (button.id == 666)
/*     */       {
/*  64 */         this.mc.displayGuiScreen(this.parentScreen);
/*     */       }
/*  66 */       else if (button.id == 25566)
/*     */     	{
/*  74 */         this.mc.displayGuiScreen(new GuiAltManager(this));
/*  75 */       }
				else if (button.id == 287)
				{
					this.mc.displayGuiScreen(new GuiCrasher(this));
/*     */       }
/*  60 */       else if (button.id == 664)
/*     */       {
/*  62 */         this.mc.displayGuiScreen(this.parentScreen);
				}
				else if (button.id == 2104)
				{
					this.mc.displayGuiScreen(new GuiServerChecks(this));
				}
			    else if (button.id == 5)
			    {
			       this.mc.displayGuiScreen(new GuiFakeParams(this));
			    }
/*     */       
              }
}

/*     */  
/*     */ 
/*     */ 
/*     */ 
/*     */   public void drawScreen(int mouseX, int mouseY, float partialTicks)
/*     */   {
/*  96 */     drawDefaultBackground();
/*     */     
/*  98 */     drawCenteredString(this.fontRendererObj, "Tools", this.width / 2, 20, 
/*  99 */       16777215);
/* 100 */     drawCenteredString(this.fontRendererObj, "You can find tools here", this.width / 2, 35, 
/* 101 */       10526880);
/* 102 */     drawCenteredString(this.fontRendererObj, 
/* 103 */       "Press back to return to Multiplayer screen", this.width / 2, 45, 10526880);
/*     */     
/* 105 */     super.drawScreen(mouseX, mouseY, partialTicks);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setButtonDelay(int p_146350_1_)
/*     */   {
/* 112 */     this.ticksUntilEnable = p_146350_1_;
/*     */     
/*     */     GuiButton var3;
/* 115 */     for (Iterator var2 = this.buttonList.iterator(); var2.hasNext(); var3.enabled = false)
/*     */     {
/* 117 */       var3 = (GuiButton)var2.next();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void updateScreen()
/*     */   {
/* 126 */     super.updateScreen();
/*     */     
/*     */ 
/* 129 */     if (--this.ticksUntilEnable == 0) {
/*     */       GuiButton var2;
/* 131 */       for (Iterator var1 = this.buttonList.iterator(); var1.hasNext(); var2.enabled = true)
/*     */       {
/* 133 */         var2 = (GuiButton)var1.next();
/*     */       }
/*     */     }
/*     */   }
/*     */ }

