/*    */ package slientclient.compatibility;
/*    */ 
/*    */ import net.minecraft.client.entity.EntityPlayerSP;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.network.datasync.EntityDataManager;
/*    */ 
/*    */ public final class WPlayer
/*    */ {
/*    */   public static void swingArmClient()
/*    */   {
/* 11 */     WMinecraft.getPlayer().swingArm(net.minecraft.util.EnumHand.MAIN_HAND);
/*    */   }
/*    */   
/*    */   public static float getCooldown()
/*    */   {
/* 16 */     return WMinecraft.getPlayer().getCooledAttackStrength(0.0F);
/*    */   }
/*    */   
/*    */   public static net.minecraft.util.EnumFacing getHorizontalFacing()
/*    */   {
/* 21 */     return WMinecraft.getPlayer().getHorizontalFacing();
/*    */   }
/*    */   
/*    */   public static void copyPlayerModel(EntityPlayer from, EntityPlayer to)
/*    */   {
/* 26 */     to.getDataManager().set(EntityPlayer.PLAYER_MODEL_FLAG, 
/* 27 */       (Byte)from.getDataManager().get(EntityPlayer.PLAYER_MODEL_FLAG));
/*    */   }
/*    */ }
