/*     */ package slientclient.gui.server.checker.gh;
/*     */ 
/*     */ import slientclient.gui.server.GuiServerChecks;
/*     */ import java.io.IOException;
/*     */ import java.net.UnknownHostException;
/*     */ import java.util.List;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.GuiButton;
/*     */ import net.minecraft.client.gui.GuiMultiplayer;
/*     */ import net.minecraft.client.gui.GuiScreen;
/*     */ import net.minecraft.client.gui.GuiTextField;
/*     */ import net.minecraft.client.gui.ServerSelectionList;
/*     */ import net.minecraft.client.multiplayer.ServerData;
/*     */ import net.minecraft.client.multiplayer.ServerList;
/*     */ import net.minecraft.client.network.ServerPinger;
/*     */ import org.lwjgl.input.Keyboard;
/*     */ 
/*     */ public class GuiGHChecker extends GuiScreen
/*     */ {
/*  20 */   private static final String[] stateStrings = { "", "‚§2Searching...", 
/*  21 */     "‚§2Resolving...", "‚§4Unknown Host!", "‚§4Cancelled!", "‚§2Done!", 
/*  22 */     "‚§4An error occurred!" };
/*     */   
/*     */   private GuiMultiplayer prevMenu;
/*     */   private GuiServerChecks prevPls;
/*     */   private GuiTextField ipBox;
/*     */   private GuiTextField portBox;
/*     */   private GuiTextField maxThreadsBox;
/*     */   private int checked;
/*     */   private int working;
/*     */   
/*     */   public GuiGHChecker(GuiMultiplayer prevMultiplayerMenu, GuiServerChecks prevPlus)
/*     */   {
/*  34 */     this.prevMenu = prevMultiplayerMenu;
/*  35 */     this.prevPls = prevPlus;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void updateScreen()
/*     */   {
/*  44 */     this.ipBox.updateCursorCounter();
/*     */     
/*  46 */     ((GuiButton)this.buttonList.get(0)).displayString = "Search";
/*  47 */     this.ipBox.setEnabled(true);
/*  48 */     this.portBox.setEnabled(true);
/*  49 */     this.maxThreadsBox.setEnabled(true);
/*     */     
/*  51 */     ((GuiButton)this.buttonList.get(0)).enabled = 
/*  52 */       ((isInteger(this.maxThreadsBox.getText())) && 
/*  53 */       (!this.ipBox.getText().isEmpty()));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void initGui()
/*     */   {
/*  63 */     Keyboard.enableRepeatEvents(true);
/*  64 */     this.working = 0;
/*  65 */     this.checked = 0;
/*  66 */     this.buttonList.clear();
/*  67 */     this.buttonList.add(new GuiButton(0, this.width / 2 - 100, this.height / 4 + 96 + 12 + 16, 
/*  68 */       "Check"));
/*  69 */     this.buttonList.add(new GuiButton(2, this.width / 2 - 100, this.height / 4 + 120 + 12 + 16, 
/*  70 */       "Back"));
/*  71 */     this.ipBox = 
/*  72 */       new GuiTextField(0, this.fontRendererObj, this.width / 2 - 100, 
/*  73 */       this.height / 4 + 34, 200, 20);
/*  74 */     this.ipBox.setMaxStringLength(200);
/*  75 */     this.ipBox.setText("127.0.0.1");
/*  76 */     this.ipBox.setFocused(true);
/*  77 */     this.portBox = 
/*  78 */       new GuiTextField(1, this.fontRendererObj, this.width / 2 - 32, 
/*  79 */       this.height / 4 + 76, 40, 12);
/*  80 */     this.portBox.setMaxStringLength(5);
/*  81 */     this.portBox.setFocused(false);
/*  82 */     this.portBox.setText(Integer.toString(25599));
/*  83 */     this.maxThreadsBox = 
/*  84 */       new GuiTextField(1, this.fontRendererObj, this.width / 2 - 32, 
/*  85 */       this.height / 4 + 58, 40, 12);
/*  86 */     this.maxThreadsBox.setMaxStringLength(5);
/*  87 */     this.maxThreadsBox.setFocused(false);
/*  88 */     this.maxThreadsBox.setText(Integer.toString(25500));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void onGuiClosed()
/*     */   {
/*  97 */     Keyboard.enableRepeatEvents(false);
/*     */   }
/*     */   
/*     */ 
/*     */   protected void actionPerformed(GuiButton clickedButton)
/*     */   {
/* 103 */     if (clickedButton.enabled) {
/* 104 */       if (clickedButton.id == 0)
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 181 */         new Thread("ports")
/*     */         {
/*     */           public void run()
/*     */           {
/*     */             try
/*     */             {
/* 150 */               for (int i = Integer.parseInt(GuiGHChecker.this.maxThreadsBox.getText()); i <= Integer.parseInt(GuiGHChecker.this.portBox.getText()); i++)
/*     */               {
/* 152 */                 String serverip = GuiGHChecker.this.ipBox.getText() + ":" + i;
/* 153 */                 ServerPinger pinger = new ServerPinger();
/*     */                 try
/*     */                 {
/* 156 */                   ServerData data = new ServerData("‚§aGH Checking " + i, serverip, isDaemon());
/* 157 */                   pinger.ping(data);
/* 158 */                   Thread.sleep(500L);
/* 159 */                   if (data.pingToServer > 0L)
/*     */                   {
/* 161 */                     GuiGHChecker.this.prevMenu.savedServerList.addServerData(data);
/* 162 */                     GuiGHChecker.this.working += 1;
/*     */                   }
/*     */                 }
/*     */                 catch (UnknownHostException localUnknownHostException) {}catch (Exception localException) {}
/*     */                 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 171 */                 pinger.clearPendingNetworks();
/* 172 */                 GuiGHChecker.this.checked += 1;
/* 173 */                 GuiGHChecker.this.prevMenu.savedServerList.saveServerList();
/* 174 */                 GuiGHChecker.this.prevMenu.serverListSelector.updateOnlineServers(GuiGHChecker.this.prevMenu.savedServerList);
/*     */               }
/*     */               
/*     */ 
/*     */             }
/*     */             catch (Exception localException1) {}
/*     */           }
/*     */         }.start();
/* 182 */       } else if (clickedButton.id == 2)
/*     */       {
/* 184 */         this.mc.displayGuiScreen(this.prevPls);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private boolean serverInList(String ip) {
/* 190 */     for (int i = 0; i < this.prevMenu.savedServerList.countServers(); i++) {
/* 191 */       if (this.prevMenu.savedServerList.getServerData(i).serverIP.equals(ip))
/* 192 */         return true;
/*     */     }
/* 194 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected void keyTyped(char par1, int par2)
/*     */   {
/* 204 */     this.ipBox.textboxKeyTyped(par1, par2);
/* 205 */     this.maxThreadsBox.textboxKeyTyped(par1, par2);
/* 206 */     this.portBox.textboxKeyTyped(par1, par2);
/*     */     
/* 208 */     if ((par2 == 28) || (par2 == 156)) {
/* 209 */       actionPerformed((GuiButton)this.buttonList.get(0));
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected void mouseClicked(int par1, int par2, int par3)
/*     */     throws IOException
/*     */   {
/* 221 */     super.mouseClicked(par1, par2, par3);
/* 222 */     this.ipBox.mouseClicked(par1, par2, par3);
/* 223 */     this.maxThreadsBox.mouseClicked(par1, par2, par3);
/* 224 */     this.portBox.mouseClicked(par1, par2, par3);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void drawScreen(int par1, int par2, float par3)
/*     */   {
/* 233 */     drawDefaultBackground();
/* 234 */     drawCenteredString(this.fontRendererObj, "Server checker (GH Bypass)", this.width / 2, 20, 
/* 235 */       16777215);
/* 236 */     drawCenteredString(this.fontRendererObj, 
/* 237 */       "This will search for servers in the port range", this.width / 2, 40, 
/* 238 */       10526880);
/* 239 */     drawCenteredString(this.fontRendererObj, 
/* 240 */       "of the IP you type into the field below.", this.width / 2, 50, 10526880);
/* 241 */     drawCenteredString(this.fontRendererObj, 
/* 242 */       "The servers it finds will be added to your server list.", 
/* 243 */       this.width / 2, 60, 10526880);
/* 244 */     drawString(this.fontRendererObj, "Server address:", this.width / 2 - 100, 
/* 245 */       this.height / 4 + 24, 10526880);
/* 246 */     this.ipBox.drawTextBox();
/* 247 */     this.portBox.drawTextBox();
/* 248 */     drawString(this.fontRendererObj, "Port number:", this.width / 2 - 100, 
/* 249 */       this.height / 4 + 60, 10526880);
/* 250 */     this.maxThreadsBox.drawTextBox();
/* 251 */     drawString(this.fontRendererObj, "Port number:", this.width / 2 - 100, 
/* 252 */       this.height / 4 + 60 + 20, 10526880);
/* 253 */     drawCenteredString(this.fontRendererObj, "", this.width / 2, 
/* 254 */       this.height / 4 + 1, 10526880);
/*     */     
/* 256 */     drawString(this.fontRendererObj, "Checked: " + this.checked, 
/* 257 */       this.width / 2 - 100, this.height / 4 + 84 + 16, 10526880);
/* 258 */     drawString(this.fontRendererObj, "Working: " + this.working, this.width / 2 - 100, 
/* 259 */       this.height / 4 + 94 + 16, 10526880);
/* 260 */     super.drawScreen(par1, par2, par3);
/*     */   }
/*     */   
/*     */   public boolean isInteger(String s)
/*     */   {
/*     */     try
/*     */     {
/* 267 */       Integer.parseInt(s);
/*     */     }
/*     */     catch (NumberFormatException e) {
/* 270 */       return false;
/*     */     }
/* 272 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\User\Desktop\Cloudy.jar!\it\Seba4316\Loup\gui\mcscreens\server\checker\gh\GuiGHChecker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */