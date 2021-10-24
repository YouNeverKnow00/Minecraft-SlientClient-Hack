/*    */ package slientclient.event;
/*    */ 
/*    */ import slientclient.event.EventCancellable;
/*    */ 
/*    */ public final class SendChatMessageEvent extends EventCancellable
/*    */ {
/*    */   private String message;
/*    */   
/*    */   public SendChatMessageEvent(String message)
/*    */   {
/* 11 */     this.message = message;
/*    */   }
/*    */   
/*    */   public String getMessage()
/*    */   {
/* 16 */     return this.message;
/*    */   }
/*    */   
/*    */   public void setMessage(String message)
/*    */   {
/* 21 */     this.message = message;
/*    */   }
/*    */ }


/* Location:              C:\Users\User\Desktop\Wolfram MC 1.12.jar!\net\wolframclient\event\events\SendChatMessageEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */