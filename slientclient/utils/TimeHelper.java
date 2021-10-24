package slientclient.utils;

import com.ibm.icu.impl.duration.TimeUnit;

public class TimeHelper {
	
    private long lastMS;

    public TimeHelper() {
        lastMS = getCurrentMS();
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
}
