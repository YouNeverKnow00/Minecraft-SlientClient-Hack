package slientclient.discord;

public class ClientDC {

	private static final ClientDC INSTANCE = new ClientDC();
	public static final ClientDC getInstance() { 
		return INSTANCE; 
	}
	
	private Discord discord = new Discord();
	
	public void init() {
		discord.start();
	}
	
	public void shutdown() {
		discord.shutdown();
	}
	
	public Discord getDiscord() {
		return discord;
	}
}
