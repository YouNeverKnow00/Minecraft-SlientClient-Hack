/*    */ package slientclient.event;
/*    */ 
/*    */ import net.minecraft.util.EnumFacing;
/*    */ import net.minecraft.util.math.BlockPos;
/*    */ import slientclient.*;
/*    */ 
/*    */ public final class PlayerDamageBlockEvent
/*    */   implements Event
/*    */ {
/*    */   private final BlockPos pos;
/*    */   private final EnumFacing direction;
/*    */   private float progress;
/*    */   
/*    */   public PlayerDamageBlockEvent(BlockPos pos, EnumFacing direction, float progress)
/*    */   {
/* 16 */     this.pos = pos;
/* 17 */     this.direction = direction;
/* 18 */     this.progress = progress;
/*    */   }
/*    */   
/*    */   public BlockPos getPos()
/*    */   {
/* 23 */     return this.pos;
/*    */   }
/*    */   
/*    */   public EnumFacing getDirection()
/*    */   {
/* 28 */     return this.direction;
/*    */   }
/*    */   
/*    */   public float getProgress()
/*    */   {
/* 33 */     return this.progress;
/*    */   }
/*    */   
/*    */   public void setProgress(float progress)
/*    */   {
/* 38 */     this.progress = progress;
/*    */   }
/*    */ }
