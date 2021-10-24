package slientclient.event;

import slientclient.*;
import net.minecraft.*;

public class UpdateEvent implements Event
{
  private float yaw;
  private float pitch;
  private double y;
  private boolean onground;
  private boolean alwaysSend;
  
  public UpdateEvent(double y, float yaw, float pitch, boolean ground)
  {
    this.yaw = yaw;
    this.pitch = pitch;
    this.y = y;
    this.onground = ground;
  }
  
  public Event.State getState()
  {
    return this.getState();
  }
  
  public float getYaw()
  {
    return this.yaw;
  }
  
  public float getPitch()
  {
    return this.pitch;
  }
  
  public double getY()
  {
    return this.y;
  }
  
  public boolean isOnground()
  {
    return this.onground;
  }
  
  public boolean shouldAlwaysSend()
  {
    return this.alwaysSend;
  }
  
  public void setYaw(float yaw)
  {
    this.yaw = yaw;
  }
  
  public void setPitch(float pitch)
  {
    this.pitch = pitch;
  }
  
  public void setY(double y)
  {
    this.y = y;
  }
  
  public void setGround(boolean ground)
  {
    this.onground = ground;
  }
  
  public void setAlwaysSend(boolean alwaysSend)
  {
    this.alwaysSend = alwaysSend;
  }
}
