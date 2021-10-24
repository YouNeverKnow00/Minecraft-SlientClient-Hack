/*    */ package slientclient.utils;
/*    */ 
/*    */ import java.math.BigInteger;
/*    */ import java.nio.charset.Charset;
/*    */ import java.security.MessageDigest;
/*    */ import java.security.NoSuchAlgorithmException;
/*    */ import java.security.SecureRandom;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class HashUtils
/*    */ {
/*    */   public static String sha256(String s)
/*    */   {
/*    */     try
/*    */     {
/* 18 */       MessageDigest mDigest = MessageDigest.getInstance("SHA-256");
/* 19 */       byte[] shaByteArr = 
/* 20 */         mDigest.digest(s.getBytes(Charset.forName("UTF-8")));
/* 21 */       StringBuilder hexStrBuilder = new StringBuilder();
/* 22 */       byte[] arrayOfByte1; int j = (arrayOfByte1 = shaByteArr).length; for (int i = 0; i < j; i++) { byte element = arrayOfByte1[i];
/* 23 */         hexStrBuilder.append(String.format("%02x", new Object[] { Byte.valueOf(element) }));
/*    */       }
/* 25 */       return hexStrBuilder.toString();
/*    */     }
/*    */     catch (NoSuchAlgorithmException e) {
/* 28 */       e.printStackTrace(); }
/* 29 */     return "";
/*    */   }
/*    */   
/*    */ 
/* 33 */   private static final SecureRandom random = new SecureRandom();
/*    */   
/*    */   public static String nextRandomString()
/*    */   {
/* 37 */     return new BigInteger(130, random).toString(32);
/*    */   }
/*    */ }
