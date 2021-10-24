/*    */ package slientclient.event;

/*    */ 
/*    */ import net.minecraft.util.text.ITextComponent;
/*    */ import slientclient.*;
/*    */ 
/*    */ public final class DisplayComponentEvent implements Event
/*    */ {
/*    */   private ITextComponent component;
/*    */   
/*    */   public DisplayComponentEvent(ITextComponent component)
/*    */   {
/* 12 */     this.component = component;
/*    */   }
/*    */   
/*    */   public ITextComponent getComponent()
/*    */   {
/* 17 */     return this.component;
/*    */   }
/*    */   
/*    */   public void setComponent(ITextComponent component)
/*    */   {
/* 22 */     this.component = component;
/*    */   }
/*    */ }
