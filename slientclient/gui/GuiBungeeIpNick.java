/*    */ package slientclient.gui;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.util.List;
/*    */ import slientclient.utils.Wrapper;
/*    */ import slientclient.utils.HackPack;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.gui.GuiButton;
/*    */ import net.minecraft.client.gui.GuiScreen;
/*    */ import net.minecraft.client.gui.GuiTextField;
/*    */ import org.lwjgl.input.Keyboard;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class GuiBungeeIpNick
/*    */   extends GuiScreen
/*    */ {
/*    */   private GuiScreen parentScreen;
/*    */   private GuiTextField usernameTextField;
/*    */   private GuiTextField usernameTextField2;
/*    */   private String error;
/*    */   
/*    */   public GuiBungeeIpNick(GuiScreen parentScreen2)
/*    */   {
/* 27 */     this.parentScreen = parentScreen2;
/*    */   }
/*    */   
/*    */   public void updateScreen() {
/* 31 */     this.usernameTextField.updateCursorCounter();
/* 32 */     this.usernameTextField2.updateCursorCounter();
/*    */   }
/*    */   
/*    */   public void onGuiClosed() {
/* 36 */     Keyboard.enableRepeatEvents(false);
/*    */   }
/*    */   
/*    */   protected void actionPerformed(GuiButton guibutton) {
/* 40 */     if (!guibutton.enabled) {
/* 41 */       return;
/*    */     }
/* 43 */     if (guibutton.id == 1) {
/* 44 */       this.mc.displayGuiScreen(this.parentScreen);
/* 45 */     } else if (guibutton.id == 0) {
/* 46 */       Wrapper.getHackPack();HackPack.setFakeNick(this.usernameTextField2.getText());
/* 47 */       Wrapper.getHackPack();HackPack.setFakeIP(this.usernameTextField.getText());
/*    */     }
/* 49 */     this.mc.displayGuiScreen(this.parentScreen);
/*    */   }
/*    */   
/*    */   protected void keyTyped(char c, int i) {
/* 53 */     this.usernameTextField.textboxKeyTyped(c, i);
/* 54 */     this.usernameTextField2.textboxKeyTyped(c, i);
/* 55 */     if ((c == '\t') && 
/* 56 */       (this.usernameTextField.isFocused())) {
/* 57 */       this.usernameTextField.setFocused(false);
/*    */     }
/*    */     
/* 60 */     if (c == '\r') {
/* 61 */       actionPerformed((GuiButton)this.buttonList.get(0));
/*    */     }
/*    */   }
/*    */   
/*    */   protected void mouseClicked(int i, int j, int k) throws IOException {
/* 66 */     super.mouseClicked(i, j, k);
/* 67 */     this.usernameTextField.mouseClicked(i, j, k);
/* 68 */     this.usernameTextField2.mouseClicked(i, j, k);
/*    */   }
/*    */   
/*    */   public void initGui() {
/* 72 */     Keyboard.enableRepeatEvents(true);
/* 73 */     this.buttonList.clear();
/* 74 */     this.buttonList.add(new GuiButton(0, this.width / 2 - 100, this.height / 4 + 96 + 12, "Done"));
/* 75 */     this.buttonList.add(new GuiButton(1, this.width / 2 - 100, this.height / 4 + 120 + 12, "Cancel"));
/* 76 */     this.usernameTextField = new GuiTextField(2, this.fontRendererObj, this.width / 2 - 100, 116, 200, 20);
/* 77 */     this.usernameTextField2 = new GuiTextField(3, this.fontRendererObj, this.width / 2 - 100, 96, 200, 20);
/* 78 */     this.usernameTextField.setMaxStringLength(500);
/* 79 */     this.usernameTextField2.setMaxStringLength(500);
/*    */   }
/*    */   
/*    */   public void drawScreen(int i, int j, float f) {
/* 83 */     drawDefaultBackground();
/* 84 */     this.usernameTextField.drawTextBox();
/* 85 */     drawCenteredString(this.fontRendererObj, "↑ Nick, ↓ IP.", this.width / 2, this.height / 4 - 60 + 20, 16777215);
/* 86 */     this.usernameTextField2.drawTextBox();
/* 87 */     super.drawScreen(i, j, f);
/*    */   }
/*    */ }


/* Location:              C:\Users\User\Desktop\Crasher.jar!\jessica\gui\GuiBungeeIpNick.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */