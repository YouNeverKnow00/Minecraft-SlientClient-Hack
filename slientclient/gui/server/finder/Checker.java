/*    */ package slientclient.gui.server.finder;
/*    */ 
/*    */ import java.net.UnknownHostException;
/*    */ import java.util.concurrent.atomic.AtomicInteger;
/*    */ import net.minecraft.client.multiplayer.ServerData;
/*    */ import net.minecraft.client.network.ServerPinger;
/*    */ import org.apache.logging.log4j.LogManager;
/*    */ import org.apache.logging.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Checker
/*    */ {
/* 15 */   private static final AtomicInteger threadNumber = new AtomicInteger(0);
/* 16 */   public static final Logger logger = LogManager.getLogger();
/*    */   public ServerData server;
/* 18 */   private boolean done = false;
/* 19 */   private boolean failed = false;
/*    */   
/*    */   public void ping(final String ip, final int port)
/*    */   {
/* 23 */     this.server = new ServerData("", ip + ":" + port, done);
/* 24 */     new Thread("Server Connector #" + threadNumber.incrementAndGet())
/*    */     {
/*    */ 
/*    */       public void run()
/*    */       {
/* 29 */         ServerPinger pinger = new ServerPinger();
/*    */         try
/*    */         {
/* 32 */           Checker.logger.info("Pinging " + ip + ":" + port + "...");
/* 33 */           pinger.ping(Checker.this.server);
/* 34 */           Thread.sleep(250L);
/* 35 */           Checker.logger.info("Ping successful: " + ip + ":" + port);
/*    */         }
/*    */         catch (UnknownHostException e) {
/* 38 */           Checker.logger.info("Unknown host: " + ip + ":" + port);
/* 39 */           Checker.this.failed = true;
/*    */         }
/*    */         catch (Exception e2) {
/* 42 */           Checker.logger.info("Ping failed: " + ip + ":" + port);
/* 43 */           Checker.this.failed = true;
/*    */         }
/* 45 */         pinger.clearPendingNetworks();
/* 46 */         Checker.this.done = true;
/*    */       }
/*    */     }.start();
/*    */   }
/*    */   
/*    */   public boolean isStillPinging()
/*    */   {
/* 53 */     return !this.done;
/*    */   }
/*    */   
/*    */   public boolean isWorking()
/*    */   {
/* 58 */     return !this.failed;
/*    */   }
/*    */   
/*    */   public boolean isOtherVersion()
/*    */   {
/* 63 */     return (this.server.version != 47) && (this.server.version != 5) && (this.server.version != -1) && (this.server.version != 107);
/*    */   }
/*    */ }


/* Location:              C:\Users\User\Desktop\Cloudy.jar!\it\Seba4316\Loup\gui\mcscreens\server\finder\Checker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */