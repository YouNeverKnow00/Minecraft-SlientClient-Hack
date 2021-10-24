package slientclient.event;

import slientclient.*;
import net.minecraft.*;

public class Render3DEvent implements Event
{
  private float partialTicks;
  
  public Render3DEvent(float partialTicks)
  {
    this.partialTicks = partialTicks;
  }
  
  public float getPartialTicks()
  {
    return this.partialTicks;
  }
  
  public void setPartialTicks(float partialTicks)
  {
    this.partialTicks = partialTicks;
  }
}
