/*    */ package slientclient.compatibility;
/*    */ 
/*    */ import net.minecraft.util.math.MathHelper;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class WMath
/*    */ {
/*    */   public static int clamp(int num, int min, int max)
/*    */   {
/* 16 */     return num > max ? max : num < min ? min : num;
/*    */   }
/*    */   
/*    */   public static float clamp(float num, float min, float max)
/*    */   {
/* 21 */     return num > max ? max : num < min ? min : num;
/*    */   }
/*    */   
/*    */   public static double clamp(double num, double min, double max)
/*    */   {
/* 26 */     return num > max ? max : num < min ? min : num;
/*    */   }
/*    */   
/*    */   public static int floor(float value)
/*    */   {
/* 31 */     return MathHelper.floor(value);
/*    */   }
/*    */   
/*    */   public static int floor(double value)
/*    */   {
/* 36 */     return MathHelper.floor(value);
/*    */   }
/*    */   
/*    */   public static int ceil(float value)
/*    */   {
/* 41 */     return MathHelper.ceil(value);
/*    */   }
/*    */   
/*    */   public static int ceil(double value)
/*    */   {
/* 46 */     return MathHelper.ceil(value);
/*    */   }
/*    */   
/*    */   public static float sin(float value)
/*    */   {
/* 51 */     return MathHelper.sin(value);
/*    */   }
/*    */   
/*    */   public static float cos(float value)
/*    */   {
/* 56 */     return MathHelper.cos(value);
/*    */   }
/*    */   
/*    */   public static float wrapDegrees(float value)
/*    */   {
/* 61 */     return MathHelper.wrapDegrees(value);
/*    */   }
/*    */   
/*    */   public static double wrapDegrees(double value)
/*    */   {
/* 66 */     return MathHelper.wrapDegrees(value);
/*    */   }
/*    */ }


/* Location:              C:\Users\User\Desktop\Wolfram MC 1.12.jar!\net\wolframclient\compatibility\WMath.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */