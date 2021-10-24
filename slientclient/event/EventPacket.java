package slientclient.event;

import net.minecraft.network.Packet;

public class EventPacket implements Event
{
  public final Type type;
  private Packet<?> packet;
  
  public EventPacket(Type type, Packet<?> packet)
  {
    this.packet = packet;
    this.type = type;
  }
  
  public Packet getPacket()
  {
    return this.packet;
  }
  
  public void setPacket(Packet<?> packet)
  {
    this.packet = packet;
  }
  
  public static enum Type
  {
    READ,  SENT;
    
    private Type() {}
  }
}
