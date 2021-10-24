/*    */ package slientclient.compatibility;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import net.minecraft.network.Packet;
/*    */ import net.minecraft.network.PacketBuffer;
/*    */ import net.minecraft.network.play.INetHandlerPlayClient;
/*    */ 
/*    */ 
/*    */ public class SPacketNewKeepAlive
/*    */   implements Packet<INetHandlerPlayClient>
/*    */ {
/*    */   private long id;
/*    */   
/*    */   public SPacketNewKeepAlive() {}
/*    */   
/*    */   public SPacketNewKeepAlive(long idIn)
/*    */   {
/* 18 */     this.id = idIn;
/*    */   }
/*    */   
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void readPacketData(PacketBuffer buf)
/*    */     throws IOException
/*    */   {
/* 36 */     this.id = buf.readLong();
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void writePacketData(PacketBuffer buf)
/*    */     throws IOException
/*    */   {
/* 45 */     buf.writeLong(this.id);
/*    */   }
/*    */   
/*    */   public long getId()
/*    */   {
/* 50 */     return this.id;
/*    */   }
/*    */
@Override
public void processPacket(INetHandlerPlayClient handler) {
	// TODO Auto-generated method stub
	
} }