/*    */ package slientclient.gui;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.util.List;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.gui.GuiButton;
/*    */ import net.minecraft.client.gui.GuiScreen;
/*    */ import net.minecraft.client.gui.GuiTextField;
/*    */ import net.minecraft.util.Session;
/*    */ import org.lwjgl.input.Keyboard;
/*    */ 
/*    */ public class GuiOfflineName
/*    */   extends GuiScreen
/*    */ {
/*    */   private GuiScreen parentScreen;
/*    */   private GuiTextField usernameTextField;
/*    */   
/*    */   public GuiOfflineName(GuiScreen guiscreen)
/*    */   {
/* 20 */     this.parentScreen = guiscreen;
/*    */   }
/*    */   
/*    */   public void updateScreen() {
/* 24 */     this.usernameTextField.updateCursorCounter();
/*    */   }
/*    */   
/*    */   public void onGuiClosed() {
/* 28 */     Keyboard.enableRepeatEvents(false);
/*    */   }
/*    */   
/*    */   protected void actionPerformed(GuiButton guibutton) {
/* 32 */     if (!guibutton.enabled) {
/* 33 */       return;
/*    */     }
/* 35 */     if (guibutton.id == 1) {
/* 36 */       this.mc.displayGuiScreen(this.parentScreen);
/* 37 */     } else if (guibutton.id == 0) {
/* 38 */       this.mc.session = new Session(this.usernameTextField.getText(), "", "", "");
/*    */     }
/* 40 */     this.mc.displayGuiScreen(this.parentScreen);
/*    */   }
/*    */   
/*    */   protected void keyTyped(char c, int i) {
/* 44 */     this.usernameTextField.textboxKeyTyped(c, i);
/* 45 */     if ((c == '\t') && 
/* 46 */       (this.usernameTextField.isFocused())) {
/* 47 */       this.usernameTextField.setFocused(false);
/*    */     }
/*    */     
/* 50 */     if (c == '\r') {
/* 51 */       actionPerformed((GuiButton)this.buttonList.get(0));
/*    */     }
/*    */   }
/*    */   
/*    */   protected void mouseClicked(int i, int j, int k) throws IOException {
/* 56 */     super.mouseClicked(i, j, k);
/* 57 */     this.usernameTextField.mouseClicked(i, j, k);
/*    */   }
/*    */   
/*    */   public void initGui() {
/* 61 */     Keyboard.enableRepeatEvents(true);
/* 62 */     this.buttonList.clear();
/* 63 */     this.buttonList.add(new GuiButton(0, this.width / 2 - 100, this.height / 4 + 96 + 12, "Done"));
/* 64 */     this.buttonList.add(new GuiButton(1, this.width / 2 - 100, this.height / 4 + 120 + 12, "Cancel"));
/* 65 */     this.usernameTextField = new GuiTextField(2, this.fontRendererObj, this.width / 2 - 100, 116, 200, 20);
/*    */   }
/*    */   
/*    */   public void drawScreen(int i, int j, float f)
/*    */   {
/* 70 */     drawDefaultBackground();
/* 71 */     drawCenteredString(this.fontRendererObj, "Change nick", this.width / 2, this.height / 4 - 60 + 20, 16777215);
/* 72 */     drawString(this.fontRendererObj, "Nick", this.width / 2 - 100, 104, 10526880);
/* 73 */     this.usernameTextField.drawTextBox();
/* 74 */     super.drawScreen(i, j, f);
/*    */   }
/*    */ }


/* Location:              C:\Users\User\Desktop\Crasher.jar!\jessica\gui\GuiOfflineName.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */