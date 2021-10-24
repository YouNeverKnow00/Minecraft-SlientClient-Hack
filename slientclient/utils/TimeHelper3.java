package slientclient.utils;

import com.ibm.icu.impl.duration.TimeUnit;

public class TimeHelper3 {
	
    private long lastMS;
	private long prevMS;

    public void TimerHelper3()
    {
      this.prevMS = 0L;
    }

    public long getCurrentMS() {
        return System.nanoTime() / 1000000L;
    }

    public void setLastMS() {
        this.lastMS = System.currentTimeMillis();
    }

    public boolean hasTimerReached(long ms) {
        return getCurrentMS() - lastMS >= ms;
    }

    public void reset() {
        lastMS = getCurrentMS();
    }

    public boolean sleep(long time)
    {
        return sleep(time, TimeUnit.MILLISECOND);
    }

    public boolean sleep(long time, TimeUnit timeUnit)
    {
        long convert = 0;
		if (convert >= time)
            reset();
        return convert >= time;
    }
    
    
    public boolean delay(float milliSec)
    {
      return (float)(getTime() - this.prevMS) >= milliSec;
    }
    
    public void resett()
    {
      this.prevMS = getTime();
    }
    
    public long getTime()
    {
      return System.nanoTime() / 1000000L;
    }
    
    public long getDifference()
    {
      return getTime() - this.prevMS;
    }
}
