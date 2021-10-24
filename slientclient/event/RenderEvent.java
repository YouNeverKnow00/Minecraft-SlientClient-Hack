/*    */ package slientclient.event;
/*    */ 
/*    */ import slientclient.*;
/*    */ 
/*    */ public final class RenderEvent implements Event
/*    */ {
/*    */   private final float partialTicks;
/*    */   
/*    */   public RenderEvent(float partialTicks)
/*    */   {
/* 11 */     this.partialTicks = partialTicks;
/*    */   }
/*    */   
/*    */   public float getPartialTicks()
/*    */   {
/* 16 */     return this.partialTicks;
/*    */   }
/*    */ }
