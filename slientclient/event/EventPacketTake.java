package slientclient.event;

import slientclient.*;
import net.minecraft.network.Packet;

public class EventPacketTake
  extends EventCancellable
{
  public Packet packet;
  
  public EventPacketTake(Packet packet)
  {
    this.packet = packet;
  }
}
