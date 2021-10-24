/*    */ package slientclient.event;
/*    */ 
/*    */ import java.lang.reflect.Method;
/*    */ 
/*    */ public final class EventRegistryEntry
/*    */ {
/*    */   private final Listener listener;
/*    */   private final Method method;
/*    */   private final byte priority;
/*    */   
/*    */   public EventRegistryEntry(Listener listener, Method method, byte priority)
/*    */   {
/* 13 */     this.listener = listener;
/* 14 */     this.method = method;
/* 15 */     this.priority = priority;
/*    */   }
/*    */   
/*    */   public byte getPriority()
/*    */   {
/* 20 */     return this.priority;
/*    */   }
/*    */   
/*    */   public Listener getListener()
/*    */   {
/* 25 */     return this.listener;
/*    */   }
/*    */   
/*    */   public Method getMethod()
/*    */   {
/* 30 */     return this.method;
/*    */   }
/*    */ }


/* Location:              C:\Users\User\Desktop\Wolfram MC 1.12.jar!\net\wolframclient\event\EventRegistryEntry.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */