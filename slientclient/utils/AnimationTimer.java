/*    */ package slientclient.utils;
/*    */ 
/*    */ 
/*    */ public class AnimationTimer
/*    */ {
/*    */   private final int delay;
/*    */   
/*    */   private int bottom;
/*    */   private int top;
/*    */   private int timer;
/*    */   private boolean wasRising;
/*    */   
/*    */   public AnimationTimer(int delay)
/*    */   {
/* 15 */     this.delay = delay;
/* 16 */     this.top = delay;
/* 17 */     this.bottom = 0;
/*    */   }
/*    */   
/*    */   public void update(boolean increment)
/*    */   {
/* 22 */     if (increment)
/*    */     {
/* 24 */       if (this.timer < this.delay)
/*    */       {
/* 26 */         if (!this.wasRising)
/* 27 */           this.bottom = this.timer;
/* 28 */         this.timer += 1;
/*    */       }
/* 30 */       this.wasRising = true;
/*    */     }
/*    */     else {
/* 33 */       if (this.timer > 0)
/*    */       {
/* 35 */         if (this.wasRising)
/* 36 */           this.top = this.timer;
/* 37 */         this.timer -= 1;
/*    */       }
/* 39 */       this.wasRising = false;
/*    */     }
/*    */   }
/*    */   
/*    */   public double getValue()
/*    */   {
/* 45 */     if (this.wasRising) {
/* 46 */       return 
/* 47 */         Math.sin((this.timer - this.bottom) / (this.delay - this.bottom) * 3.141592653589793D / 2.0D);
/*    */     }
/* 49 */     return 1.0D - Math.cos(this.timer / this.top * 3.141592653589793D / 2.0D);
/*    */   }
/*    */ }