/*    */ package slientclient.utils;
/*    */ 
/*    */ import net.minecraft.util.EnumFacing;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SwitchEnumFacing
/*    */ {
/* 11 */   public static final int[] values = new int[EnumFacing.values().length];
/*    */   
/*    */   static
/*    */   {
/*    */     try {
/* 16 */       values[EnumFacing.NORTH.ordinal()] = 1;
/*    */     }
/*    */     catch (NoSuchFieldError localNoSuchFieldError1) {}
/*    */     
/*    */ 
/*    */ 
/*    */     try
/*    */     {
/* 24 */       values[EnumFacing.SOUTH.ordinal()] = 2;
/*    */     }
/*    */     catch (NoSuchFieldError localNoSuchFieldError2) {}
/*    */     
/*    */ 
/*    */ 
/*    */     try
/*    */     {
/* 32 */       values[EnumFacing.WEST.ordinal()] = 3;
/*    */     }
/*    */     catch (NoSuchFieldError localNoSuchFieldError3) {}
/*    */     
/*    */ 
/*    */ 
/*    */     try
/*    */     {
/* 40 */       values[EnumFacing.EAST.ordinal()] = 4;
/*    */     }
/*    */     catch (NoSuchFieldError localNoSuchFieldError4) {}
/*    */   }
/*    */ }
