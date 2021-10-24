/*    */ package slientclient.event;
/*    */ 
/*    */ import net.minecraft.network.Packet;
/*    */ import slientclient.event.EventCancellable;
/*    */ 
/*    */ public final class NetworkManagerPacketReceiveEvent extends EventCancellable
/*    */ {
/*    */   private final Packet packet;
/*    */   
/*    */   public NetworkManagerPacketReceiveEvent(Packet packet)
/*    */   {
/* 12 */     this.packet = packet;
/*    */   }
/*    */   
/*    */   public Packet getPacket()
/*    */   {
/* 17 */     return this.packet;
/*    */   }
/*    */ }
