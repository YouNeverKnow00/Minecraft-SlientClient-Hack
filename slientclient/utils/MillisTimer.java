/*    */ package slientclient.utils;
/*    */ 
/*    */ 
/*    */ public class MillisTimer
/*    */ {
/*    */   private long previousTime;
/*    */   
/*    */ 
/*    */   public MillisTimer()
/*    */   {
/* 11 */     this.previousTime = -1L;
/*    */   }
/*    */   
/*    */   public boolean check(float milliseconds)
/*    */   {
/* 16 */     return (float)(getCurrentTime() - this.previousTime) >= milliseconds;
/*    */   }
/*    */   
/*    */   public void reset()
/*    */   {
/* 21 */     this.previousTime = getCurrentTime();
/*    */   }
/*    */   
/*    */   public short convert(float perSecond)
/*    */   {
/* 26 */     return (short)(int)(1000.0F / perSecond);
/*    */   }
/*    */   
/*    */   public long get()
/*    */   {
/* 31 */     return getCurrentTime() - this.previousTime;
/*    */   }
/*    */   
/*    */   protected long getCurrentTime()
/*    */   {
/* 36 */     return System.currentTimeMillis();
/*    */   }
/*    */ }
