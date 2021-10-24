/*     */ package slientclient.gui.server.finder;
/*     */ 
/*     */ import slientclient.gui.server.GuiServerChecks;
/*     */ import java.io.IOException;
/*     */ import java.net.InetAddress;
/*     */ import java.net.UnknownHostException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.GuiButton;
/*     */ import net.minecraft.client.gui.GuiMultiplayer;
/*     */ import net.minecraft.client.gui.GuiScreen;
/*     */ import net.minecraft.client.gui.GuiTextField;
/*     */ import net.minecraft.client.gui.ServerSelectionList;
/*     */ import net.minecraft.client.multiplayer.ServerData;
/*     */ import net.minecraft.client.multiplayer.ServerList;
/*     */ import org.lwjgl.input.Keyboard;
/*     */ 
/*     */ public class GuiServerFinder extends GuiScreen
/*     */ {
/*  21 */   private static final String[] stateStrings = { "", "‚§2Searching...", 
/*  22 */     "‚§2Resolving...", "‚§4Unknown Host!", "‚§4Cancelled!", "‚§2Done!", 
/*  23 */     "‚§4An error occurred!" };
/*     */   private GuiMultiplayer prevMenu;
/*     */   private GuiServerChecks prevPls;
/*     */   
/*  27 */   static enum ServerFinderState { NOT_RUNNING, 
/*  28 */     SEARCHING, 
/*  29 */     RESOLVING, 
/*  30 */     UNKNOWN_HOST, 
/*  31 */     CANCELLED, 
/*  32 */     DONE, 
/*  33 */     ERROR;
/*     */     
/*     */     public boolean isRunning()
/*     */     {
/*  37 */       return (this == SEARCHING) || (this == RESOLVING);
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/*  43 */       return GuiServerFinder.stateStrings[ordinal()];
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private GuiTextField ipBox;
/*     */   
/*     */   private GuiTextField portBox;
/*     */   
/*     */   private GuiTextField maxThreadsBox;
/*     */   private int checked;
/*     */   private int working;
/*     */   private ServerFinderState state;
/*     */   public GuiServerFinder(GuiMultiplayer prevMultiplayerMenu, GuiServerChecks prevPlus)
/*     */   {
/*  58 */     this.prevMenu = prevMultiplayerMenu;
/*  59 */     this.prevPls = prevPlus;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void updateScreen()
/*     */   {
/*  68 */     this.ipBox.updateCursorCounter();
/*     */     
/*  70 */     ((GuiButton)this.buttonList.get(0)).displayString = 
/*  71 */       (this.state.isRunning() ? "Cancel" : "Search");
/*  72 */     this.ipBox.setEnabled(!this.state.isRunning());
/*  73 */     this.portBox.setEnabled(!this.state.isRunning());
/*  74 */     this.maxThreadsBox.setEnabled(!this.state.isRunning());
/*     */     
/*  76 */     ((GuiButton)this.buttonList.get(0)).enabled = 
/*  77 */       ((isInteger(this.maxThreadsBox.getText())) && 
/*  78 */       (!this.ipBox.getText().isEmpty()));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void initGui()
/*     */   {
/*  88 */     Keyboard.enableRepeatEvents(true);
/*  89 */     this.buttonList.clear();
/*  90 */     this.buttonList.add(new GuiButton(0, this.width / 2 - 100, this.height / 4 + 96 + 12 + 16, 
/*  91 */       "Search"));
/*  92 */     this.buttonList.add(new GuiButton(2, this.width / 2 - 100, this.height / 4 + 120 + 12 + 16, 
/*  93 */       "Back"));
/*  94 */     this.ipBox = 
/*  95 */       new GuiTextField(0, this.fontRendererObj, this.width / 2 - 100, 
/*  96 */       this.height / 4 + 34, 200, 20);
/*  97 */     this.ipBox.setMaxStringLength(200);
/*  98 */     this.ipBox.setFocused(true);
/*  99 */     this.portBox = 
/* 100 */       new GuiTextField(1, this.fontRendererObj, this.width / 2 - 32, 
/* 101 */       this.height / 4 + 76, 40, 12);
/* 102 */     this.portBox.setMaxStringLength(5);
/* 103 */     this.portBox.setFocused(true);
/* 104 */     this.portBox.setText(
/* 105 */       Integer.toString(25565));
/* 106 */     this.maxThreadsBox = 
/* 107 */       new GuiTextField(1, this.fontRendererObj, this.width / 2 - 32, 
/* 108 */       this.height / 4 + 58, 48, 12);
/* 109 */     this.maxThreadsBox.setMaxStringLength(5);
/* 110 */     this.maxThreadsBox.setFocused(false);
/* 111 */     this.maxThreadsBox.setText(
/* 112 */       Integer.toString(128));
/*     */     
/* 114 */     this.state = ServerFinderState.NOT_RUNNING;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void onGuiClosed()
/*     */   {
/* 123 */     this.state = ServerFinderState.CANCELLED;
/* 124 */     Keyboard.enableRepeatEvents(false);
/*     */   }
/*     */   
/*     */ 
/*     */   protected void actionPerformed(GuiButton clickedButton)
/*     */   {
/* 130 */     if (clickedButton.enabled) {
/* 131 */       if (clickedButton.id == 0)
/*     */       {
/* 133 */         if (this.state.isRunning())
/*     */         {
/* 135 */           this.state = ServerFinderState.CANCELLED;
/*     */         }
/*     */         else
/*     */         {
/* 139 */           this.state = ServerFinderState.RESOLVING;
/* 140 */           this.checked = 0;
/* 141 */           this.working = 0;
/*     */           
/* 143 */           new Thread("Server Finder")
/*     */           {
/*     */ 
/*     */             public void run()
/*     */             {
/*     */               try
/*     */               {
/* 150 */                 InetAddress addr = 
/* 151 */                   InetAddress.getByName(GuiServerFinder.this.ipBox.getText()
/* 152 */                   .split(":")[0].trim());
/*     */                 
/* 154 */                 int port = Integer.parseInt(GuiServerFinder.this.portBox.getText());
/*     */                 
/* 156 */                 int[] ipParts = new int[4];
/* 157 */                 for (int i = 0; i < 4; i++) {
/* 158 */                   ipParts[i] = (addr.getAddress()[i] & 0xFF);
/*     */                 }
/* 160 */                 GuiServerFinder.this.state = GuiServerFinder.ServerFinderState.SEARCHING;
/* 161 */                 ArrayList<Checker> pingers = 
/* 162 */                   new ArrayList();
/* 163 */                 int[] changes = { 0, 1, -1, 2, -2, 3, -3 };
/* 164 */                 int[] arrayOfInt1; int j = (arrayOfInt1 = changes).length; for (int i = 0; i < j; i++) { int change = arrayOfInt1[i];
/* 165 */                   for (int i2 = 0; i2 <= 1020; i2++)
/*     */                   {
/* 167 */                     if (GuiServerFinder.this.state == GuiServerFinder.ServerFinderState.CANCELLED) {
/* 168 */                       return;
/*     */                     }
/* 170 */                     int[] ipParts2 = (int[])ipParts.clone();
/* 171 */                     ipParts2[2] = 
/* 172 */                       (ipParts[2] + change & 0xFF);
/* 173 */                     ipParts2[3] = i2;
/* 174 */                     String ip = 
/* 175 */                       ipParts2[0] + "." + ipParts2[1] + 
/* 176 */                       "." + ipParts2[2] + "." + 
/* 177 */                       ipParts2[3];
/*     */                     
/*     */ 
/*     */ 
/* 181 */                     Checker pinger = 
/* 182 */                       new Checker();
/* 183 */                     pinger.ping(ip, port);
/* 184 */                     pingers.add(pinger);
/* 185 */                     while (pingers.size() >= Integer.parseInt(GuiServerFinder.this.maxThreadsBox.getText()))
/*     */                     {
/* 187 */                       if (GuiServerFinder.this.state == GuiServerFinder.ServerFinderState.CANCELLED) {
/* 188 */                         return;
/*     */                       }
/* 190 */                       GuiServerFinder.this.updatePingers(pingers);
/*     */                     }
/*     */                   } }
/* 193 */                 while (pingers.size() > 0)
/*     */                 {
/* 195 */                   if (GuiServerFinder.this.state == GuiServerFinder.ServerFinderState.CANCELLED) {
/* 196 */                     return;
/*     */                   }
/* 198 */                   GuiServerFinder.this.updatePingers(pingers);
/*     */                 }
/* 200 */                 GuiServerFinder.this.state = GuiServerFinder.ServerFinderState.DONE;
/*     */               }
/*     */               catch (UnknownHostException e) {
/* 203 */                 GuiServerFinder.this.state = GuiServerFinder.ServerFinderState.UNKNOWN_HOST;
/*     */               }
/*     */               catch (Exception e) {
/* 206 */                 e.printStackTrace();
/* 207 */                 GuiServerFinder.this.state = GuiServerFinder.ServerFinderState.ERROR;
/*     */               }
/*     */             }
/*     */           }.start();
/*     */         }
/*     */       }
/* 213 */       else if (clickedButton.id == 2)
/* 214 */         this.mc.displayGuiScreen(this.prevPls);
/*     */     }
/*     */   }
/*     */   
/*     */   private boolean serverInList(String ip) {
/* 219 */     for (int i = 0; i < this.prevMenu.savedServerList.countServers(); i++) {
/* 220 */       if (this.prevMenu.savedServerList.getServerData(i).serverIP.equals(ip))
/* 221 */         return true;
/*     */     }
/* 223 */     return false;
/*     */   }
/*     */   
/*     */   private void updatePingers(ArrayList<Checker> pingers)
/*     */   {
/* 228 */     for (int i = 0; i < pingers.size(); i++) {
/* 229 */       if (!((Checker)pingers.get(i)).isStillPinging())
/*     */       {
/* 231 */         this.checked += 1;
/* 232 */         if (((Checker)pingers.get(i)).isWorking())
/*     */         {
/* 234 */           this.working += 1;
/*     */           
/* 236 */           if (!serverInList(((Checker)pingers.get(i)).server.serverIP))
/*     */           {
/*     */ 
/* 239 */             this.prevMenu.savedServerList.addServerData(new ServerData("§cServer " + 
/* 240 */               this.working, ((Checker)pingers.get(i)).server.serverIP, allowUserInput));
/* 241 */             this.prevMenu.savedServerList
/* 242 */               .saveServerList();
/* 243 */             this.prevMenu.serverListSelector
/* 244 */               .setSelectedSlotIndex(-1);
/* 245 */             this.prevMenu.serverListSelector
/* 246 */               .updateOnlineServers(this.prevMenu.savedServerList);
/*     */           }
/*     */         }
/* 249 */         pingers.remove(i);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected void keyTyped(char par1, int par2)
/*     */   {
/* 260 */     this.ipBox.textboxKeyTyped(par1, par2);
/* 261 */     this.maxThreadsBox.textboxKeyTyped(par1, par2);
/* 262 */     this.portBox.textboxKeyTyped(par1, par2);
/*     */     
/* 264 */     if ((par2 == 28) || (par2 == 156)) {
/* 265 */       actionPerformed((GuiButton)this.buttonList.get(0));
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
/* 277 */     super.mouseClicked(par1, par2, par3);
/* 278 */     this.ipBox.mouseClicked(par1, par2, par3);
/* 279 */     this.maxThreadsBox.mouseClicked(par1, par2, par3);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void drawScreen(int par1, int par2, float par3)
/*     */   {
/* 288 */     drawDefaultBackground();
/* 289 */     drawCenteredString(this.fontRendererObj, "Server Finder", this.width / 2, 20, 
/* 290 */       16777215);
/* 291 */     drawCenteredString(this.fontRendererObj, 
/* 292 */       "This will search for servers with similar IPs", this.width / 2, 40, 
/* 293 */       10526880);
/* 294 */     drawCenteredString(this.fontRendererObj, 
/* 295 */       "to the IP you type into the field below.", this.width / 2, 50, 10526880);
/* 296 */     drawCenteredString(this.fontRendererObj, 
/* 297 */       "The servers it finds will be added to your server list.", 
/* 298 */       this.width / 2, 60, 10526880);
/* 299 */     drawString(this.fontRendererObj, "Server address:", this.width / 2 - 100, 
/* 300 */       this.height / 4 + 24, 10526880);
/* 301 */     this.ipBox.drawTextBox();
/* 302 */     this.portBox.drawTextBox();
/* 303 */     drawString(this.fontRendererObj, "Max. threads:", this.width / 2 - 100, 
/* 304 */       this.height / 4 + 60, 10526880);
/* 305 */     this.maxThreadsBox.drawTextBox();
/* 306 */     drawString(this.fontRendererObj, "Port number:", this.width / 2 - 100, 
/* 307 */       this.height / 4 + 60 + 20, 10526880);
/* 308 */     drawCenteredString(this.fontRendererObj, this.state.toString(), this.width / 2, 
/* 309 */       this.height / 4 + 1, 10526880);
/*     */     
/* 311 */     drawString(this.fontRendererObj, "Checked: " + this.checked + " / 7147", 
/* 312 */       this.width / 2 - 100, this.height / 4 + 84 + 16, 10526880);
/* 313 */     drawString(this.fontRendererObj, "Working: " + this.working, this.width / 2 - 100, 
/* 314 */       this.height / 4 + 94 + 16, 10526880);
/* 315 */     super.drawScreen(par1, par2, par3);
/*     */   }
/*     */   
/*     */   public boolean isInteger(String s)
/*     */   {
/*     */     try
/*     */     {
/* 322 */       Integer.parseInt(s);
/*     */     }
/*     */     catch (NumberFormatException e) {
/* 325 */       return false;
/*     */     }
/* 327 */     return true;
/*     */   }
/*     */ }
