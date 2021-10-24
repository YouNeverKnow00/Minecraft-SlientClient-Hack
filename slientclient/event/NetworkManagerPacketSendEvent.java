/*    */ package slientclient.event;
/*    */ 
/*    */ import net.minecraft.network.Packet;
/*    */ import slientclient.event.EventCancellable;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class NetworkManagerPacketSendEvent
/*    */   extends EventCancellable
/*    */ {
/*    */   private Packet packet;
/*    */   
/*    */   public NetworkManagerPacketSendEvent(Packet packet)
/*    */   {
/* 17 */     this.packet = packet;
/*    */   }
/*    */   
/*    */   public Packet getPacket()
/*    */   {
/* 22 */     return this.packet;
/*    */   }
/*    */   
/*    */   public void setPacket(Packet packet)
/*    */   {
/* 27 */     this.packet = packet;
/*    */   }
/*    */ }
