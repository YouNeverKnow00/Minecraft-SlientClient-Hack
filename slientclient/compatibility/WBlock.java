/*    */ package slientclient.compatibility;
/*    */ 
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.block.state.IBlockState;
/*    */ import net.minecraft.util.math.AxisAlignedBB;
/*    */ import net.minecraft.util.math.BlockPos;
/*    */ import net.minecraft.util.registry.RegistryNamespacedDefaultedByKey;
/*    */ 
/*    */ public final class WBlock
/*    */ {
/*    */   public static IBlockState getState(BlockPos pos)
/*    */   {
/* 13 */     return WMinecraft.getWorld().getBlockState(pos);
/*    */   }
/*    */   
/*    */   public static Block getBlock(BlockPos pos)
/*    */   {
/* 18 */     return getState(pos).getBlock();
/*    */   }
/*    */   
/*    */   public static int getId(BlockPos pos)
/*    */   {
/* 23 */     return Block.getIdFromBlock(getBlock(pos));
/*    */   }
/*    */   
/*    */   public static net.minecraft.block.material.Material getMaterial(BlockPos pos)
/*    */   {
/* 33 */     return getState(pos).getMaterial();
/*    */   }
/*    */   
/*    */   public static AxisAlignedBB getBoundingBox(BlockPos pos)
/*    */   {
/* 38 */     return 
/* 39 */       getState(pos).getBoundingBox(WMinecraft.getWorld(), pos).offset(pos);
/*    */   }
/*    */   
/*    */   public static boolean canBeClicked(BlockPos pos)
/*    */   {
/* 44 */     return getBlock(pos).canCollideCheck(getState(pos), false);
/*    */   }
/*    */   
/*    */   public static float getHardness(BlockPos pos)
/*    */   {
/* 49 */     return getState(pos).getPlayerRelativeBlockHardness(
/* 50 */       WMinecraft.getPlayer(), WMinecraft.getWorld(), pos);
/*    */   }
/*    */   
/*    */   public static boolean isFullyOpaque(BlockPos pos)
/*    */   {
/* 55 */     return getState(pos).isFullyOpaque();
/*    */   }
/*    */ }


/* Location:              C:\Users\User\Desktop\Wolfram MC 1.12.jar!\net\wolframclient\compatibility\WBlock.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */