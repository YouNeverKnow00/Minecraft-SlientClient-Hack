/*    */ package slientclient.event;
/*    */ 
/*    */ import net.minecraft.util.EnumFacing;
/*    */ import net.minecraft.util.math.BlockPos;
/*    */ import slientclient.*;
/*    */ 
/*    */ public final class ClickBlockEvent implements Event
/*    */ {
/*    */   private final BlockPos pos;
/*    */   private final EnumFacing facing;
/*    */   
/*    */   public ClickBlockEvent(BlockPos pos, EnumFacing facing)
/*    */   {
/* 14 */     this.pos = pos;
/* 15 */     this.facing = facing;
/*    */   }
/*    */   
/*    */   public BlockPos getPos()
/*    */   {
/* 20 */     return this.pos;
/*    */   }
/*    */   
/*    */   public EnumFacing getFacing()
/*    */   {
/* 25 */     return this.facing;
/*    */   }
/*    */ }
