/*    */ package slientclient.event;
/*    */ 
/*    */ import slientclient.*;
/*    */ 
/*    */ public final class KeyPressEvent implements Event
/*    */ {
/*    */   private final int keyCode;
/*    */   
/*    */   public KeyPressEvent(int keyCode)
/*    */   {
/* 11 */     this.keyCode = keyCode;
/*    */   }
/*    */   
/*    */   public int getKeyCode()
/*    */   {
/* 16 */     return this.keyCode;
/*    */   }
/*    */ }