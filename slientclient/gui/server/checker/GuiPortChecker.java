/*     */ package slientclient.gui.server.checker;
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
/*     */ 
/*     */ public class GuiPortChecker
/*     */   extends GuiScreen
/*     */ {
/*  22 */   private static final String[] stateStrings = { "", "§2Searching...", 
/*  23 */     "‚§2Resolving...", "Unknown Host!", "‚§4Cancelled!", "§2Done!", 
/*  24 */     "‚§4An error occurred!" };
/*     */   
/*     */   private GuiMultiplayer prevMenu;
/*     */   private slientclient.gui.server.GuiServerChecks prevPls;
/*     */   private GuiTextField ipBox;
/*     */   private GuiTextField portBox;
/*     */   private GuiTextField maxThreadsBox;
/*     */   private int checked;
/*     */   private int working;
/*     */   
/*     */   public GuiPortChecker(GuiMultiplayer prevMultiplayerMenu, GuiServerChecks prevPlus)
/*     */   {
/*  36 */     this.prevMenu = prevMultiplayerMenu;
/*  37 */     this.prevPls = prevPlus;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void updateScreen()
/*     */   {
/*  46 */     this.ipBox.updateCursorCounter();
/*     */     
/*  48 */     ((GuiButton)this.buttonList.get(0)).displayString = "Search";
/*  49 */     this.ipBox.setEnabled(true);
/*  50 */     this.portBox.setEnabled(true);
/*  51 */     this.maxThreadsBox.setEnabled(true);
/*     */     
/*  53 */     ((GuiButton)this.buttonList.get(0)).enabled = 
/*  54 */       ((isInteger(this.maxThreadsBox.getText())) && 
/*  55 */       (!this.ipBox.getText().isEmpty()));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void initGui()
/*     */   {
/*  65 */     Keyboard.enableRepeatEvents(true);
/*  66 */     this.working = 0;
/*  67 */     this.checked = 0;
/*  68 */     this.buttonList.clear();
/*  69 */     this.buttonList.add(new GuiButton(0, this.width / 2 - 100, this.height / 4 + 96 + 12 + 16, 
/*  70 */       "Check"));
/*  71 */     this.buttonList.add(new GuiButton(2, this.width / 2 - 100, this.height / 4 + 120 + 12 + 16, 
/*  72 */       "Back"));
/*  73 */     this.ipBox = 
/*  74 */       new GuiTextField(0, this.fontRendererObj, this.width / 2 - 100, 
/*  75 */       this.height / 4 + 34, 200, 20);
/*  76 */     this.ipBox.setMaxStringLength(200);
/*  77 */     this.ipBox.setText("127.0.0.1");
/*  78 */     this.ipBox.setFocused(true);
/*  79 */     this.portBox = 
/*  80 */       new GuiTextField(1, this.fontRendererObj, this.width / 2 - 32, 
/*  81 */       this.height / 4 + 76, 40, 12);
/*  82 */     this.portBox.setMaxStringLength(5);
/*  83 */     this.portBox.setFocused(false);
/*  84 */     this.portBox.setText(Integer.toString(25599));
/*  85 */     this.maxThreadsBox = 
/*  86 */       new GuiTextField(1, this.fontRendererObj, this.width / 2 - 32, 
/*  87 */       this.height / 4 + 58, 40, 12);
/*  88 */     this.maxThreadsBox.setMaxStringLength(5);
/*  89 */     this.maxThreadsBox.setFocused(false);
/*  90 */     this.maxThreadsBox.setText(Integer.toString(25500));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void onGuiClosed()
/*     */   {
/*  99 */     Keyboard.enableRepeatEvents(false);
/*     */   }
/*     */   
/*     */ 
/*     */   protected void actionPerformed(GuiButton clickedButton)
/*     */   {
/* 105 */     if (clickedButton.enabled) {
/* 106 */       if (clickedButton.id == 0)
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
/* 173 */         new Thread("ports")
/*     */         {
/*     */           public void run()
/*     */           {
/*     */             try
/*     */             {
/* 147 */               for (int i = Integer.parseInt(GuiPortChecker.this.maxThreadsBox.getText()); i <= Integer.parseInt(GuiPortChecker.this.portBox.getText()); i++)
/*     */               {
/* 149 */                 String serverip = GuiPortChecker.this.ipBox.getText() + ":" + i;
/* 150 */                 ServerPinger pinger = new ServerPinger();
/*     */                 try
/*     */                 {
/* 153 */                   pinger.ping(new ServerData("‚§aPort Checking " + i, serverip, isDaemon()));
/* 154 */                   GuiPortChecker.this.prevMenu.savedServerList.addServerData(new ServerData("‚§aPort Checking " + i, serverip, isDaemon()));
/* 155 */                   GuiPortChecker.this.working += 1;
/*     */                 }
/*     */                 catch (UnknownHostException localUnknownHostException) {}catch (Exception localException) {}
/*     */                 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 163 */                 pinger.clearPendingNetworks();
/* 164 */                 GuiPortChecker.this.checked += 1;
/* 165 */                 GuiPortChecker.this.prevMenu.savedServerList.saveServerList();
/* 166 */                 GuiPortChecker.this.prevMenu.serverListSelector.updateOnlineServers(GuiPortChecker.this.prevMenu.savedServerList);
/*     */               }
/*     */               
/*     */ 
/*     */             }
/*     */             catch (Exception localException1) {}
/*     */           }
/*     */         }.start();
/* 174 */       } else if (clickedButton.id == 2)
/*     */       {
/* 176 */         this.mc.displayGuiScreen(this.prevPls);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private boolean serverInList(String ip) {
/* 182 */     for (int i = 0; i < this.prevMenu.savedServerList.countServers(); i++) {
/* 183 */       if (this.prevMenu.savedServerList.getServerData(i).serverIP.equals(ip))
/* 184 */         return true;
/*     */     }
/* 186 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected void keyTyped(char par1, int par2)
/*     */   {
/* 196 */     this.ipBox.textboxKeyTyped(par1, par2);
/* 197 */     this.maxThreadsBox.textboxKeyTyped(par1, par2);
/* 198 */     this.portBox.textboxKeyTyped(par1, par2);
/*     */     
/* 200 */     if ((par2 == 28) || (par2 == 156)) {
/* 201 */       actionPerformed((GuiButton)this.buttonList.get(0));
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
/* 213 */     super.mouseClicked(par1, par2, par3);
/* 214 */     this.ipBox.mouseClicked(par1, par2, par3);
/* 215 */     this.maxThreadsBox.mouseClicked(par1, par2, par3);
/* 216 */     this.portBox.mouseClicked(par1, par2, par3);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void drawScreen(int par1, int par2, float par3)
/*     */   {
/* 225 */     drawDefaultBackground();
/* 226 */     drawCenteredString(this.fontRendererObj, "Port checker", this.width / 2, 20, 
/* 227 */       16777215);
/* 228 */     drawCenteredString(this.fontRendererObj, 
/* 229 */       "This will search for servers in the port range", this.width / 2, 40, 
/* 230 */       10526880);
/* 231 */     drawCenteredString(this.fontRendererObj, 
/* 232 */       "of the IP you type into the field below.", this.width / 2, 50, 10526880);
/* 233 */     drawCenteredString(this.fontRendererObj, 
/* 234 */       "The servers it finds will be added to your server list.", 
/* 235 */       this.width / 2, 60, 10526880);
/* 236 */     drawString(this.fontRendererObj, "Server address:", this.width / 2 - 100, 
/* 237 */       this.height / 4 + 24, 10526880);
/* 238 */     this.ipBox.drawTextBox();
/* 239 */     this.portBox.drawTextBox();
/* 240 */     drawString(this.fontRendererObj, "Port number:", this.width / 2 - 100, 
/* 241 */       this.height / 4 + 60, 10526880);
/* 242 */     this.maxThreadsBox.drawTextBox();
/* 243 */     drawString(this.fontRendererObj, "Port number:", this.width / 2 - 100, 
/* 244 */       this.height / 4 + 60 + 20, 10526880);
/* 245 */     drawCenteredString(this.fontRendererObj, "", this.width / 2, 
/* 246 */       this.height / 4 + 1, 10526880);
/*     */     
/* 248 */     drawString(this.fontRendererObj, "Checked: " + this.checked, 
/* 249 */       this.width / 2 - 100, this.height / 4 + 84 + 16, 10526880);
/* 250 */     drawString(this.fontRendererObj, "Working: " + this.working, this.width / 2 - 100, 
/* 251 */       this.height / 4 + 94 + 16, 10526880);
/* 252 */     super.drawScreen(par1, par2, par3);
/*     */   }
/*     */   
/*     */   public boolean isInteger(String s)
/*     */   {
/*     */     try
/*     */     {
/* 259 */       Integer.parseInt(s);
/*     */     }
/*     */     catch (NumberFormatException e) {
/* 262 */       return false;
/*     */     }
/* 264 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\User\Desktop\Cloudy.jar!\it\Seba4316\Loup\gui\mcscreens\server\checker\GuiPortChecker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */