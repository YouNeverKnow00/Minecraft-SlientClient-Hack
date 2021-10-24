package slientclient.commands;

import slientclient.command.*;
import slientclient.main.Slient;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.multiplayer.GuiConnecting;
import net.minecraft.client.multiplayer.ServerData;
import net.minecraft.util.Session;

public class connect
  extends Command
{
  
  private Minecraft mc;
public String getAlias()
  {
    return "connect";
  }
  
  public String getDescription()
  {
    return null;
  }
  
  public String getSyntax()
  {
    return "§3.connect §8[§5ip:§dport§8]";
  }
  
  public void onCommand(String command, String[] p0 )
    throws Exception
  {
	    if (p0.length > 0)
	    {
	      ServerData theServer = new ServerData("server", p0[0], false);
	      if (!this.mc.isSingleplayer()) {
	        mc.world.sendQuittingDisconnectingPacket();
	      }
	      this.mc.displayGuiScreen(new GuiConnecting(null, this.mc, theServer));
	    }
	    else
	    {
	    	getSyntax();
	    }
	  }
}