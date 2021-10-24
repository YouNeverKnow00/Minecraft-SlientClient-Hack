package slientclient.event;

public class EventSafewalk
  implements Event
{
  private boolean shouldWalkSafely;
  
  public EventSafewalk(boolean shouldWalkSafely) { this.shouldWalkSafely = shouldWalkSafely; }



  
  public boolean getShouldWalkSafely() { return this.shouldWalkSafely; }



  
  public void setShouldWalkSafely(boolean shouldWalkSafely) { this.shouldWalkSafely = shouldWalkSafely; }
}
