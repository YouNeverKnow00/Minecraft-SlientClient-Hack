package slientclient.utils;

public class TimeHelper4 {
	private long lastMS = 0;
	
	public boolean isDelayComplete(long delay) {
		if(System.currentTimeMillis() - lastMS >= delay) {
			return true;
		}
		
		return false;
	}
	
	public long getLastMS() {
		return lastMS;
	}
	
	  public long getCurrentMS()
	  {
	    return System.nanoTime() / 1000000L;
	  }
	
	public void setLastMS(long lastMS) {
		this.lastMS = lastMS;
	}
	
	public void setLastMS() {
		this.lastMS = System.currentTimeMillis();
	}
	
	public int convertToMS(int d) {
		return 1000 / d;
	}

	  public boolean hasReached(long milliseconds)
	  {
	    return getCurrentMS() - this.lastMS >= milliseconds;
	  }
	  
	  public void reset()
	  {
	    this.lastMS = getCurrentMS();
	  }
	  
	  public void reset2()
	  {
	    this.lastMS = getCurrentMS() - 200;
	  }
	  
	  public boolean delay(double d)
	  {
	    if (getTime() - getPrevMS() >= d)
	    {
	      reset();
	      return true;
	    }
	    return false;
	  }
	  
	  public long getTime()
	  {
	    return System.nanoTime() / 1000000L;
	  }
	  
	  public long getPrevMS()
	  {
	    return this.getPrevMS();
	  }
}
