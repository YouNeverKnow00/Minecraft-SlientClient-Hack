/*    */ package slientclient.event;
/*    */ 
/*    */ import net.minecraft.network.Packet;
/*    */ import slientclient.event.EventCancellable;
/*    */ 
/*    */ public final class AddPacketToQueueEvent extends EventCancellable
/*    */ {
/*    */   private final Packet packet;
/*    */   
/*    */   public AddPacketToQueueEvent(Packet packet)
/*    */   {
/* 12 */     this.packet = packet;
/*    */   }
/*    */   
/*    */   public Packet getPacket()
/*    */   {
/* 17 */     return this.packet;
/*    */   }
/*    */ }


/* Location:              C:\Users\User\Desktop\Wolfram MC 1.12.jar!\net\wolframclient\event\events\AddPacketToQueueEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */