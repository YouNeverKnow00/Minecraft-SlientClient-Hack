package slientclient.commands;

import org.lwjgl.input.Keyboard;

import net.minecraft.client.Minecraft;
import net.minecraft.util.Session;
import slientclient.command.Command;
import slientclient.main.Slient;
import slientclient.mods.Module;

public class BugCommand extends Command {

	@Override
	public String getAlias() {
		return "pl";
	}

	@Override
	public String getDescription() {
		return "Allows user to change keybind of module";
	}

	@Override
	public String getSyntax() {

		return "§9.pl";
	}

	  public void onCommand(String command, String[] args)
			    throws Exception
			  {

			    Minecraft.getMinecraft().player.sendChatMessage("/ehelp");
			    Minecraft.getMinecraft().player.sendChatMessage("/bukkit:plugins");
			    Minecraft.getMinecraft().player.sendChatMessage("/about");
			    Minecraft.getMinecraft().player.sendChatMessage("/?");
			  }
			}
