/*    */ package slientclient.event;
/*    */ 
/*    */ public abstract class EventCancellable implements Event
/*    */ {
/*    */   private boolean cancelled;
/*    */   
/*    */   public boolean isCancelled()
/*    */   {
/*  9 */     return this.cancelled;
/*    */   }
/*    */   
/*    */   public void setCancelled(boolean cancelled)
/*    */   {
/* 14 */     this.cancelled = cancelled;
/*    */   }
/*    */ }