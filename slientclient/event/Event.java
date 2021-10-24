package slientclient.event;

public interface Event {
	  
	  public static enum State
	  {
	    PRE("PRE", 0),  POST("POST", 1);
	    
	    private State(String s, int n) {}
	  }
}
