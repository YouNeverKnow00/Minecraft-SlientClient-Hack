/*    */ package slientclient.compatibility;
/*    */ 
/*    */ import net.minecraft.client.network.NetHandlerPlayClient;
/*    */ import net.minecraft.network.Packet;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class WConnection
/*    */ {
/*    */   public static void sendPacket(Packet packet)
/*    */   {
/* 16 */     WMinecraft.getConnection().sendPacket(packet);
/*    */   }
/*    */   
/*    */   public static void sendPacketBypass(Packet packet)
/*    */   {
/* 21 */     WMinecraft.getConnection().sendPacket(packet);
/*    */   }
/*    */ }
