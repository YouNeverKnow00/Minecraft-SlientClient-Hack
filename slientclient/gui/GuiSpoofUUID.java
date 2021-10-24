/*    */ package slientclient.gui;
/*    */ 
/*    */ import java.util.List;
/*    */ import slientclient.utils.HackPack;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.gui.GuiButton;
/*    */ import net.minecraft.client.gui.GuiScreen;
/*    */ import net.minecraft.client.gui.GuiTextField;
/*    */ import org.lwjgl.input.Keyboard;
/*    */ 
/*    */ public class GuiSpoofUUID extends GuiScreen
/*    */ {
/*    */   private GuiScreen parentScreen;
/*    */   private GuiTextField usernameTextField;
/*    */   private GuiTextField usernameTextField2;
/*    */   private String error;
/*    */   
/*    */   public GuiSpoofUUID(GuiScreen parentScreen2)
/*    */   {
/* 20 */     this.parentScreen = parentScreen2;
/*    */   }
/*    */   
/*    */   public void updateScreen() {
/* 24 */     this.usernameTextField.updateCursorCounter();
/* 25 */     this.usernameTextField2.updateCursorCounter();
/*    */   }
/*    */   
/*    */   public void onGuiClosed() {
/* 29 */     Keyboard.enableRepeatEvents(false);
/*    */   }
/*    */   
/*    */   protected void actionPerformed(GuiButton guibutton) {
/* 33 */     if (!guibutton.enabled) {
/* 34 */       return;
/*    */     }
/* 36 */     if (guibutton.id == 1) {
/* 37 */       this.mc.displayGuiScreen(this.parentScreen);
/* 38 */     } else if (guibutton.id == 0) {
/* 39 */       slientclient.utils.Wrapper.getHackPack();HackPack.setFakeUUID(this.usernameTextField2.getText());
/* 40 */       slientclient.utils.Wrapper.getHackPack();HackPack.setFakeIP(this.usernameTextField.getText());
/*    */     }
/* 42 */     this.mc.displayGuiScreen(this.parentScreen);
/*    */   }
/*    */   
/*    */   protected void keyTyped(char c, int i) {
/* 46 */     this.usernameTextField.textboxKeyTyped(c, i);
/* 47 */     this.usernameTextField2.textboxKeyTyped(c, i);
/* 48 */     if ((c == '\t') && 
/* 49 */       (this.usernameTextField.isFocused())) {
/* 50 */       this.usernameTextField.setFocused(false);
/*    */     }
/*    */     
/* 53 */     if (c == '\r') {
/* 54 */       actionPerformed((GuiButton)this.buttonList.get(0));
/*    */     }
/*    */   }
/*    */   
/*    */   protected void mouseClicked(int i, int j, int k) throws java.io.IOException {
/* 59 */     super.mouseClicked(i, j, k);
/* 60 */     this.usernameTextField.mouseClicked(i, j, k);
/* 61 */     this.usernameTextField2.mouseClicked(i, j, k);
/*    */   }
/*    */   
/*    */   public void initGui() {
/* 65 */     Keyboard.enableRepeatEvents(true);
/* 66 */     this.buttonList.clear();
/* 67 */     this.buttonList.add(new GuiButton(0, this.width / 2 - 100, this.height / 4 + 96 + 12, "Done"));
/* 68 */     this.buttonList.add(new GuiButton(1, this.width / 2 - 100, this.height / 4 + 120 + 12, "Cancel"));
/* 69 */     this.usernameTextField = new GuiTextField(2, this.fontRendererObj, this.width / 2 - 100, 116, 200, 20);
/* 70 */     this.usernameTextField2 = new GuiTextField(3, this.fontRendererObj, this.width / 2 - 100, 96, 200, 20);
/* 71 */     this.usernameTextField.setMaxStringLength(500);
/* 72 */     this.usernameTextField2.setMaxStringLength(500);
/*    */   }
/*    */   
/*    */   public void drawScreen(int i, int j, float f) {
/* 76 */     drawDefaultBackground();
/* 77 */     this.usernameTextField.drawTextBox();
/* 78 */     drawCenteredString(this.fontRendererObj, "↑ UUID, ↓ IP.", this.width / 2, this.height / 4 - 60 + 20, 16777215);
/* 79 */     this.usernameTextField2.drawTextBox();
/* 80 */     super.drawScreen(i, j, f);
/*    */   }
/*    */ }


/* Location:              C:\Users\User\Desktop\Crasher.jar!\jessica\gui\GuiSpoofUUID.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */