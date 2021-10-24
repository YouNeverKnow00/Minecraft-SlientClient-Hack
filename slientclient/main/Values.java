package slientclient.main;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.util.math.AxisAlignedBB;

public class Values {
	
	  public static Values values = new Values();
	  private static Float Bhop = (float) 1;
	  
	  public static Values getValues() {
		  return values;
	  }
	  
	  public boolean shouldbypass = false;
	  public boolean fancyphase = false;
	  public Integer bypasspackets = Integer.valueOf(0);
	  public double motionX = 0.0D;
	  public double motionY = 0.0D;
	  public double motionZ = 0.0D;
	  public static int Glide = 1;
	  public static int Step = 1;
	  public static int jesus = 2;
	  public static int Tower = 1;
	  public static int Killaura = 2;
	  public static int Killaura2 = 1;
	  public static int Spammer = 1;
	  public static int NoSlow = 1;
	  public static double SpammerDelay = 3000;
	  public static double ScaffoldDelay = 0;
	  public static String SpammerMessage = "Zunami beschte Client | by NiroYT";
	  public static double Velocity = 0;
	  public static int VelocityMode = 1;
	  public static int Scaffold = 1;
	  public static int ESP = 1;
	  public static int sneak = 1;
	  public static double GlideHophigh = 4;
	  public float sprintspeed = 4.0F;
	  public float walkspeed = 4.0F;
	  public int ping = 0;
	  public double distance = 4.2D;
	  public double cps = 10;
	  public double cheststealerdelay = 120;
	  public boolean xray = false;
	  public boolean convertpacket = false;
	  public boolean safewalk = false;
	  public boolean sortarraylist = true;
	  public boolean onlymotion = false;
	  public int width = 0;
	  public int height = 0;
	  public String inboundmessage = "";
	  public String outboundmessage = "";
	  public double ticks = 40;
	  public float prepitch = 0.0F;
	  public boolean fastcclimb = false;
	  public String lastIp;
	  public int lastPort;
	  public boolean premium = false;
	  public boolean KAplayers = true;
	  public boolean KAmobs = true;
	  public float Timer = 2;	  
	  public static boolean sound = false;
}
