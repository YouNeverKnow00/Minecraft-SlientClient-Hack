package slientclient.event;

import org.w3c.dom.events.Event;

import slientclient.event.*;
import slientclient.*;

public abstract class EventStoppable
  implements Event
{
  private boolean stopped;
  
  public void stop()
  {
    this.stopped = true;
  }
  
  public boolean isStopped()
  {
    return this.stopped;
  }
  
  protected EventStoppable() {
  }
}
