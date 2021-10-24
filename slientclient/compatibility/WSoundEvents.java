/*    */ package slientclient.compatibility;
/*    */ 
/*    */ import net.minecraft.init.SoundEvents;
/*    */ import net.minecraft.network.play.server.SPacketSoundEffect;
/*    */ 
/*    */ public final class WSoundEvents
/*    */ {
/*    */   public static boolean isBobberSplash(SPacketSoundEffect soundEffect)
/*    */   {
/* 10 */     return SoundEvents.ENTITY_BOBBER_SPLASH.equals(soundEffect.getSound());
/*    */   }
/*    */ }
