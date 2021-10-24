/*    */ package slientclient.event;
/*    */ 
/*    */ import net.minecraft.entity.Entity;
/*    */ import slientclient.event.EventCancellable;
		 import slientclient.*;
/*    */ 
/*    */ public final class NametagRenderEvent extends EventCancellable
/*    */ {
/*    */   private final Entity entity;
/*    */   private String name;
/*    */   
/*    */   public NametagRenderEvent(Entity entity, String name)
/*    */   {
/* 13 */     this.entity = entity;
/* 14 */     this.name = name;
/*    */   }
/*    */   
/*    */   public Entity getEntity()
/*    */   {
/* 19 */     return this.entity;
/*    */   }
/*    */   
/*    */   public String getName()
/*    */   {
/* 24 */     return this.name;
/*    */   }
/*    */   
/*    */   public void setName(String name)
/*    */   {
/* 29 */     this.name = name;
/*    */   }
/*    */ }
