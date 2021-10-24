/*    */ package slientclient.compatibility;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import net.minecraft.network.Packet;
/*    */ import net.minecraft.network.PacketBuffer;
/*    */ import net.minecraft.network.play.INetHandlerPlayClient;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class SPacketSomethingNew
/*    */   implements Packet<INetHandlerPlayClient>
/*    */ {
/*    */   public void readPacketData(PacketBuffer buf)
/*    */     throws IOException
/*    */   {
/* 21 */     buf.readByte();
/* 22 */     buf.readVarIntFromBuffer();
/*    */   }
/*    */   
/*    */   public void writePacketData(PacketBuffer buf)
/*    */     throws IOException
/*    */   {
/* 28 */     buf.writeByte(0);
/* 29 */     buf.writeVarIntToBuffer(0);
/*    */   }
/*    */   
/*    */   public void processPacket(INetHandlerPlayClient handler) {}
/*    */ }
