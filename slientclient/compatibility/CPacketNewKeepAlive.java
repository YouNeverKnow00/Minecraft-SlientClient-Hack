/*    */ package slientclient.compatibility;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import net.minecraft.network.Packet;
/*    */ import net.minecraft.network.PacketBuffer;
/*    */ import net.minecraft.network.play.INetHandlerPlayServer;
/*    */ 
/*    */ 
/*    */ public class CPacketNewKeepAlive
/*    */   implements Packet<INetHandlerPlayServer>
/*    */ {
/*    */   private long key;
/*    */   
/*    */   public CPacketNewKeepAlive() {}
/*    */   
/*    */   public CPacketNewKeepAlive(long idIn)
/*    */   {
/* 18 */     this.key = idIn;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public void processPacket(INetHandlerPlayServer handler) {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public void readPacketData(PacketBuffer buf)
/*    */     throws IOException
/*    */   {
/* 36 */     this.key = buf.readLong();
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void writePacketData(PacketBuffer buf)
/*    */     throws IOException
/*    */   {
/* 45 */     buf.writeLong(this.key);
/*    */   }
/*    */   
/*    */   public long getKey()
/*    */   {
/* 50 */     return this.key;
/*    */   }
/*    */ }
