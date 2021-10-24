package slientclient.event;

import slientclient.event.*;

public class EventPreMotion
  implements Event
{
  private double motionX;
  private double motionY;
  private double motionZ;
  
  public double getMotionX()
  {
    return this.motionX;
  }
  
  public double getMotionY()
  {
    return this.motionY;
  }
  
  public double getMotionZ()
  {
    return this.motionZ;
  }
  
  public void setMotion(double motionX, double motionY, double motionZ)
  {
    this.motionX = motionX;
    this.motionY = motionY;
    this.motionZ = motionZ;
  }
}

