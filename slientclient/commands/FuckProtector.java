package slientclient.commands;

import org.lwjgl.input.Keyboard;

import net.minecraft.client.Minecraft;
import net.minecraft.util.Session;
import slientclient.command.Command;
import slientclient.main.Slient;
import slientclient.mods.Module;

public class FuckProtector extends Command {

	@Override
	public String getAlias() {
		return "fuck";
	}

	@Override
	public String getDescription() {
		return "Trash C*viAki Protector";
	}

	@Override
	public String getSyntax() {

		return "§9.fuck";
	}

	  public void onCommand(String command, String[] args)
			    throws Exception
			  {
			    Minecraft.getMinecraft().player.sendChatMessage("//calc");
	            Thread.sleep(100L);
			    Minecraft.getMinecraft().player.sendChatMessage("//eval");
	            Thread.sleep(10L);
			    Minecraft.getMinecraft().player.sendChatMessage("//solve");
		  		Slient.addChatMessage("§eFucked §bC*viAki :)");
		  		Minecraft.getMinecraft().player.sendChatMessage("Trash C*viAki :D");
			  }
			}
