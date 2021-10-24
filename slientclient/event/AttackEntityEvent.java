/*    */ package slientclient.event;
/*    */ 
/*    */ import net.minecraft.entity.Entity;
/*    */ import slientclient.*;
	     import net.minecraft.*;
/*    */ 
/*    */ public final class AttackEntityEvent extends EventCancellable
/*    */ {
/*    */   private final Entity target;
/*    */   
/*    */   public AttackEntityEvent(Entity target)
/*    */   {
/* 12 */     this.target = target;
/*    */   }
/*    */   
/*    */   public Entity getTarget()
/*    */   {
/* 17 */     return this.target;
/*    */   }
/*    */ }


/* Location:              C:\Users\User\Desktop\Wolfram MC 1.12.jar!\net\wolframclient\event\events\AttackEntityEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */