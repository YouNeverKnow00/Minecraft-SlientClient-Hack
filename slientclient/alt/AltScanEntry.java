/*    */ package slientclient.alt;
/*    */ 
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.gui.FontRenderer;
/*    */ import net.minecraft.client.gui.GuiScreen;
/*    */ 
/*    */ public class AltScanEntry implements net.minecraft.client.gui.GuiListExtended.IGuiListEntry
/*    */ {
/*  9 */   private final Minecraft field_148288_a = Minecraft.getMinecraft();
/*    */   private static final String __OBFID = "CL_00000815";
/*    */   
/*    */   public void drawEntry(int slotIndex, int x, int y, int listWidth, int slotHeight, int mouseX, int mouseY, boolean isSelected)
/*    */   {
/* 14 */     int var9 = y + slotHeight / 2 - this.field_148288_a.fontRendererObj.FONT_HEIGHT / 2;
/* 15 */     this.field_148288_a.fontRendererObj.drawString("Waiting for user operation...", this.field_148288_a.currentScreen.width / 2 - this.field_148288_a.fontRendererObj.getStringWidth("Waiting for user operation...") / 2, var9, 16777215);
/* 17 */     String var10; String var101; switch ((int)(Minecraft.getSystemTime() / 300L % 4L))
/*    */     {
/*    */     case 0: 
/*    */     default: 
/* 21 */       var101 = "O o o";
/* 22 */       break;
/*    */     
/*    */     case 1: 
/*    */     case 3: 
/* 26 */       var101 = "o O o";
/* 27 */       break;
/*    */     
/*    */     case 2: 
/* 30 */       var101 = "o o O";
/*    */     }
/*    */     
/* 33 */     this.field_148288_a.fontRendererObj.drawString(var101, this.field_148288_a.currentScreen.width / 2 - this.field_148288_a.fontRendererObj.getStringWidth(var101) / 2, var9 + this.field_148288_a.fontRendererObj.FONT_HEIGHT, 8421504);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public void setSelected(int p_178011_1_, int p_178011_2_, int p_178011_3_) {}
/*    */   
/*    */ 
/*    */   public boolean mousePressed(int p_148278_1_, int p_148278_2_, int p_148278_3_, int p_148278_4_, int p_148278_5_, int p_148278_6_)
/*    */   {
/* 43 */     return false;
/*    */   }
/*    */   
/*    */   public void mouseReleased(int slotIndex, int x, int y, int mouseEvent, int relativeX, int relativeY) {}
/*    */
@Override
public void func_192633_a(int p_192633_1_, int p_192633_2_, int p_192633_3_, float p_192633_4_) {
	// TODO Auto-generated method stub
	
}
@Override
public void func_192634_a(int p_192634_1_, int p_192634_2_, int p_192634_3_, int p_192634_4_, int p_192634_5_,
		int p_192634_6_, int p_192634_7_, boolean p_192634_8_, float p_192634_9_) {
	// TODO Auto-generated method stub
	
} }
