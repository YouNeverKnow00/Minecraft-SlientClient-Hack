package slientclient.commands;

import slientclient.command.*;
import slientclient.main.Slient;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.util.Session;

public class Help
  extends Command
{
  
  public String getAlias()
  {
    return "help";
  }
  
  public String getDescription()
  {
    return null;
  }
  
  public String getSyntax()
  {
    return ".help";
  }
  
  public void onCommand(String command, String[] args)
    throws Exception
  {
	Slient.addChatMessage("");
	Slient.addChatMessage("" + "");
	Slient.addChatMessage("" + "");
	Slient.addChatMessage("§3.kickall §b[IP] [PORT] " + "§8// §bKickall Server X_X");
	Slient.addChatMessage("§c.crash §e" + "§8// §cCrash Server @_@");
	Slient.addChatMessage("§6.crash2 §e[IP] [PORT] " + "§8// §cCrash Server ");
	Slient.addChatMessage("§4.ip " + "§8// §dServer information ?");
	Slient.addChatMessage("§3.bind set " + "§8// §eBind Module.");
	Slient.addChatMessage("§5.toggle [MOD] " + "§8// §eToggle mod.");
	Slient.addChatMessage("§9.findop " + "§8// §bFind Online Op players.");
	Slient.addChatMessage("§8.pl " + "§8// §7Find Bug Commands.");
	Slient.addChatMessage("§8.fuck " + "§8// §7Fuck trash C*viAki.");
	Slient.addChatMessage("§8.clear " + "§8// §7Clear Chat.");
  }
}
