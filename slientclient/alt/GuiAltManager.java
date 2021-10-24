/*     */ package slientclient.alt;
/*     */ 
/*     */ import com.google.common.base.Splitter;
/*     */ import com.google.common.collect.Lists;
/*     */ import slientclient.alt.GuiPlus;
/*     */ import java.io.IOException;
/*     */ import java.util.List;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.GuiButton;
/*     */ import net.minecraft.client.gui.GuiScreen;
/*     */ import net.minecraft.client.multiplayer.ServerData;
/*     */ import net.minecraft.client.multiplayer.ServerList;
/*     */ import net.minecraft.client.network.ServerPinger;
/*     */ import net.minecraft.util.Session;
/*     */ import org.apache.logging.log4j.LogManager;
/*     */ import org.apache.logging.log4j.Logger;
/*     */ import org.lwjgl.input.Keyboard;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class GuiAltManager
/*     */   extends GuiScreen
/*     */ {
/*  28 */   private final ServerPinger oldServerPinger = new ServerPinger();
/*     */   private GuiPlus parentScreen;
/*     */   public ServerList savedServerList;
/*     */   private GuiButton btnEditServer;
/*     */   private GuiButton btnSelectServer;
/*     */   private GuiButton btnDeleteServer;
/*     */   private boolean deletingServer;
/*     */   private boolean addingServer;
/*     */   private boolean editingServer;
/*     */   private boolean directConnect;
/*     */   private String field_146812_y;
/*     */   private ServerData selectedServer;
/*     */   private boolean initialized;
/*     */   private static final String __OBFID = "CL_00000814";
/*     */   public AltSelectionList serverListSelector;
/*     */   
/*     */   public GuiAltManager(GuiPlus parentScreen) {
/*  45 */     this.parentScreen = parentScreen;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void initGui()
/*     */   {
/*  53 */     Keyboard.enableRepeatEvents(true);
/*  54 */     this.buttonList.clear();
/*     */     
/*  56 */     if (!this.initialized)
/*     */     {
/*  58 */       this.initialized = true;
/*  59 */       this.savedServerList = new ServerList(this.mc);
/*  60 */       this.savedServerList.loadServerList();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  68 */     createButtons();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void handleMouseInput()
/*     */     throws IOException
/*     */   {
/*  76 */     super.handleMouseInput();
/*     */   }
/*     */   
/*     */   public void createButtons()
/*     */   {
/*  84 */     this.buttonList.add(new GuiButton(4, this.width / 2 - 50, this.height - 52, 100, 20, "Acoount Login"));
/*  86 */     this.buttonList.add(new GuiButton(0, this.width / 2 + 4 + 76, this.height - 28, 75, 20, "Back"));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void updateScreen()
/*     */   {
/*  94 */     super.updateScreen();
/*     */     
/*  96 */     this.oldServerPinger.pingPendingNetworks();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void onGuiClosed()
/*     */   {
/* 104 */     Keyboard.enableRepeatEvents(false);
/*     */     
/* 106 */     this.oldServerPinger.clearPendingNetworks();
/*     */   }
/*     */   
/*     */   protected void actionPerformed(GuiButton button) throws IOException
/*     */   {
/* 111 */     if (button.enabled)
/*     */     {
/* 113 */       if (button.id == 0)
/*     */       {
/* 115 */         this.mc.displayGuiScreen(this.parentScreen);
/*     */       }
/* 117 */       else if (button.id == 4)
/*     */       {
/* 119 */         this.mc.displayGuiScreen(new GuiDirectLogin(this));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private void refreshServerList()
/*     */   {
/* 126 */     this.mc.displayGuiScreen(new GuiAltManager(this.parentScreen));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void confirmClicked(boolean result, int id) {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void drawScreen(int mouseX, int mouseY, float partialTicks)
/*     */   {
/* 143 */     this.field_146812_y = null;
/* 144 */     drawDefaultBackground();
/* 145 */     this.serverListSelector = new AltSelectionList(this.parentScreen, this.mc, this.width, this.height, 32, this.height - 64, 36);
/* 146 */     this.serverListSelector.drawScreen(mouseX, mouseY, partialTicks);
/* 147 */     drawCenteredString(this.fontRendererObj, "Alt Manager", this.width / 2, 20, 16777215);
/*     */     
/* 149 */     drawString(this.fontRendererObj, "§fUsername: §7" + this.mc.getSession().getUsername(), 3, 3, 16777215);
/*     */     
/* 151 */     super.drawScreen(mouseX, mouseY, partialTicks);
/*     */     
/* 153 */     if (this.field_146812_y != null)
/*     */     {
/* 155 */       drawHoveringText(Lists.newArrayList(Splitter.on("\n").split(this.field_146812_y)), mouseX, mouseY);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public void func_146793_a(String p_146793_1_)
/*     */   {
/* 162 */     this.field_146812_y = p_146793_1_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   protected void mouseClicked(int mouseX, int mouseY, int mouseButton)
/*     */     throws IOException
/*     */   {
/* 170 */     super.mouseClicked(mouseX, mouseY, mouseButton);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   protected void mouseReleased(int mouseX, int mouseY, int state)
/*     */   {
/* 178 */     super.mouseReleased(mouseX, mouseY, state);
/*     */   }
/*     */   
/*     */   public ServerList getServerList()
/*     */   {
/* 183 */     return this.savedServerList;
/*     */   }
/*     */ }
