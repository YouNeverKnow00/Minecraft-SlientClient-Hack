/*    */ package slientclient.utils;

import java.math.RoundingMode;
import java.math.BigDecimal;
import java.math.RoundingMode;

/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MathUtils
/*    */ {
/*    */   public static float map(float x, float prev_min, float prev_max, float new_min, float new_max)
/*    */   {
/* 10 */     return (x - prev_min) / (prev_max - prev_min) * (new_max - new_min) + 
/* 11 */       new_min;
/*    */   }
/*    */   
/*    */ 
/*    */   public static boolean contains(float x, float y, float minX, float minY, float maxX, float maxY)
/*    */   {
/* 17 */     if ((x > minX) && (x < maxX) && 
/* 18 */       (y > minY) && (y < maxY))
/* 19 */       return true;
/* 20 */     return false;
/*    */   }
/*    */
public static double roundToPlace(double value, int places)
{
  if (places < 0) {
    throw new IllegalArgumentException();
  }
  BigDecimal bd = new BigDecimal(value);
  bd = bd.setScale(places, RoundingMode.HALF_UP);
  return bd.doubleValue();
}
}


