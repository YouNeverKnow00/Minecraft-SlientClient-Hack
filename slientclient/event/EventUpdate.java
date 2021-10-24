package slientclient.event;

import java.awt.Event;

public class EventUpdate extends Event{

	public EventUpdate(Object arg0, int arg1, Object arg2) {
		super(arg0, arg1, arg2);
	}

	  public double y;
	  public float yaw;
	  public float pitch;
	  public boolean onGround;
	  public EventState state;
	  
	  public void EventUpdate(double y, float yaw, float pitch, boolean onGround)
	  {
	    this.y = y;
	    this.yaw = yaw;
	    this.pitch = pitch;
	    this.onGround = onGround;
	    this.state = EventState.PRE;
	  }
	  
	  public void EventUpdate()
	  {
	    this.state = EventState.POST;
	  }

}
