package slientclient.event;

import slientclient.*;
import net.minecraft.network.Packet;

public class EventPacketReceived
  extends EventCancellable
{
  private Packet packet;
  
  public EventPacketReceived(Packet packet)
  {
    this.packet = packet;
  }
  
  public Packet getPacket()
  {
    return this.packet;
  }
  
  public void setPacket(Packet packet)
  {
    this.packet = packet;
  }
}
