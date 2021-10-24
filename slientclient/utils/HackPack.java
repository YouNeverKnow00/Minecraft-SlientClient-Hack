/*    */ package slientclient.utils;
/*    */ 
/*    */ import java.util.Random;
/*    */ 
/*    */ public class HackPack {
/*  6 */   private static String fakeIP = "";
/*  7 */   private static String fakeUUID = "";
/*  8 */   private static String fakeNick = "";
/*  9 */   private static String currentIPPort = "";
/* 10 */   public Random rand = new Random();
/* 11 */   public Random rand2 = new Random();
/*    */   
/*    */   public static String getFakeIp() {
/* 14 */     return fakeIP;
/*    */   }
/*    */   
/*    */   public static String getFakeUUID() {
/* 18 */     return fakeUUID;
/*    */   }
/*    */   
/*    */   public static String getFakeNick() {
/* 22 */     return fakeNick;
/*    */   }
/*    */   
/*    */   public static String getCurrentIPPort() {
/* 26 */     return currentIPPort;
/*    */   }
/*    */   
/*    */   public static void setFakeIP(String fIP) {
/* 30 */     fakeIP = fIP;
/*    */   }
/*    */   
/*    */   public static void setFakeUUID(String fUUID)
/*    */   {
/* 35 */     fakeUUID = fUUID;
/*    */   }
/*    */   
/*    */   public static void setFakeNick(String fNick) {
/* 39 */     fakeNick = fNick;
/*    */   }
/*    */   
/*    */   public static void setCurrentIPPort(String cIPPort) {
/* 43 */     currentIPPort = cIPPort;
/*    */   }
/*    */ }
