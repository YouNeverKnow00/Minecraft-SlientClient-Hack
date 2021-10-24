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
/*    */ public final class CPacketSomethingNew
/*    */   implements Packet<INetHandlerPlayClient>
/*    */ {
/*    */   public void readPacketData(PacketBuffer buf)
/*    */     throws IOException
/*    */   {
/* 21 */     buf.readByte();
/* 22 */     buf.readVarIntFromBuffer();
/* 23 */     buf.readBoolean();
/*    */   }
/*    */   
/*    */   public void writePacketData(PacketBuffer buf)
/*    */     throws IOException
/*    */   {
/* 29 */     buf.writeByte(0);
/* 30 */     buf.writeVarIntToBuffer(0);
/* 31 */     buf.writeBoolean(false);
/*    */   }
/*    */   
/*    */   public void processPacket(INetHandlerPlayClient handler) {}
/*    */ }