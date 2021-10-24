package slientclient.commands;

import slientclient.command.*;
import slientclient.main.Slient;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.util.Session;

public class getip
  extends Command
{
  
  public String getAlias()
  {
    return "ip";
  }
  
  public String getDescription()
  {
    return null;
  }
  
  public String getSyntax()
  {
    return ".ip";
  }
  
  public void onCommand(String command, String[] args)
    throws Exception
  {
	    if (!Minecraft.getMinecraft().isSingleplayer())
	    {
	    	Slient.addChatMessage("§bIP: §r " + Minecraft.getMinecraft().getCurrentServerData().serverIP);
	      Slient.addChatMessage("§9Version: §r" + Minecraft.getMinecraft().getCurrentServerData().gameVersion);
	    }
	    else
	    {
	    	Slient.addChatMessage("The command runs in multiplayer mode!");
	    }
	  }
	}

