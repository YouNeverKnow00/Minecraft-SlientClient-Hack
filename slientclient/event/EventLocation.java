package slientclient.event;

import slientclient.event.*;

public class EventLocation
  implements Event
{
  private static final EventLocation EVENT = new EventLocation();
  public double posX;
  public double posY;
  public double posZ;
  public boolean onGround;
  
  public static EventLocation get(double posX, double posY, double posZ, boolean onGround)
  {
    EVENT.posX = posX;
    EVENT.posY = posY;
    EVENT.posZ = posZ;
    EVENT.onGround = onGround;
    return EVENT;
  }
}
