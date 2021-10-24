/*    */ package slientclient.utils;
/*    */ 
/*    */ import java.io.PrintStream;
/*    */ 
/*    */ public final class Logger
/*    */ {
/*    */   public void info(String msg) {
/*  8 */     System.out.println("[Slient]: " + msg);
/*    */   }
/*    */   
/*    */   public void debug(String msg)
/*    */   {
/* 13 */     System.out.println("[Slient] [DEBUG]: " + msg);
/*    */   }
/*    */   
/*    */   public void warn(String msg)
/*    */   {
/* 18 */     System.out.println("[Slient] [WARNING]: " + msg);
/*    */   }
/*    */   
/*    */   public void error(String msg)
/*    */   {
/* 23 */     System.err.println("[Slient] [ERROR]: " + msg);
/*    */   }
/*    */ }
