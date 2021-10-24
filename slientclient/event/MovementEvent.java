/*    */ package slientclient.event;
/*    */ 
/*    */ import slientclient.*;
/*    */ 
/*    */ public final class MovementEvent implements Event
/*    */ {
/*    */   private double motionX;
/*    */   private double motionY;
/*    */   private double motionZ;
/*    */   
/*    */   public MovementEvent(double x, double y, double z)
/*    */   {
/* 13 */     this.motionX = x;
/* 14 */     this.motionY = y;
/* 15 */     this.motionZ = z;
/*    */   }
/*    */   
/*    */   public double getMotionX()
/*    */   {
/* 20 */     return this.motionX;
/*    */   }
/*    */   
/*    */   public void setMotionX(double motionX)
/*    */   {
/* 25 */     this.motionX = motionX;
/*    */   }
/*    */   
/*    */   public double getMotionY()
/*    */   {
/* 30 */     return this.motionY;
/*    */   }
/*    */   
/*    */   public void setMotionY(double motionY)
/*    */   {
/* 35 */     this.motionY = motionY;
/*    */   }
/*    */   
/*    */   public double getMotionZ()
/*    */   {
/* 40 */     return this.motionZ;
/*    */   }
/*    */   
/*    */   public void setMotionZ(double motionZ)
/*    */   {
/* 45 */     this.motionZ = motionZ;
/*    */   }
/*    */ }
