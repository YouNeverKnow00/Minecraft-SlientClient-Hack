package slientclient.utils;

public class TimeHelper2
{
  private long prevTime;
  
  public TimeHelper2()
  {
    reset();
  }
  
  public boolean hasPassed(double milli)
  {
    return getTime() - this.prevTime >= milli;
  }
  
  public long getTime()
  {
    return System.nanoTime() / 1000000L;
  }
  
  public void reset()
  {
    this.prevTime = getTime();
  }
}
