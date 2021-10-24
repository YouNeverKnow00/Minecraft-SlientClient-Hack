package slientclient.event;

import org.w3c.dom.events.Event;

import slientclient.*;

public abstract class EventRender3D
  implements Event
{
  public float partialTicks;
  
  public EventRender3D(float partialTicks)
  {
    this.partialTicks = partialTicks;
  }
}
