package slientclient.event;

import slientclient.*;

import org.w3c.dom.events.EventTarget;

import net.minecraft.network.Packet;

public class EventPacketSend
  extends EventStoppable
{
  public Packet packet;
  
  public EventPacketSend(Packet packet)
  {
    this.packet = packet;
  }

@Override
public boolean getBubbles() {
	// TODO Auto-generated method stub
	return false;
}

@Override
public boolean getCancelable() {
	// TODO Auto-generated method stub
	return false;
}

@Override
public EventTarget getCurrentTarget() {
	// TODO Auto-generated method stub
	return null;
}

@Override
public short getEventPhase() {
	// TODO Auto-generated method stub
	return 0;
}

@Override
public EventTarget getTarget() {
	// TODO Auto-generated method stub
	return null;
}

@Override
public long getTimeStamp() {
	// TODO Auto-generated method stub
	return 0;
}

@Override
public String getType() {
	// TODO Auto-generated method stub
	return null;
}

@Override
public void initEvent(String arg0, boolean arg1, boolean arg2) {
	// TODO Auto-generated method stub
	
}

@Override
public void preventDefault() {
	// TODO Auto-generated method stub
	
}

private boolean cancelled;

public boolean isCancelled()
{
  return this.cancelled;
}

public void setCancelled(boolean state)
{
  this.cancelled = state;
}

@Override
public void stopPropagation() {
	// TODO Auto-generated method stub
	
}
}
