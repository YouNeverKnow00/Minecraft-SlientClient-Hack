package slientclient.commands;

import org.lwjgl.input.Keyboard;

import slientclient.command.Command;
import slientclient.main.Slient;
import slientclient.mods.Module;

public class Criticals_Settings extends Command {

	@Override
	public String getAlias() {
		return "criticals";
	}

	@Override
	public String getDescription() {
		return "Criticals ayarlar�n� yapman� sa�lar.";
	}

	@Override
	public String getSyntax() {
		return "�3.criticals [�bPACKET�7/�eJUMP]";
	}

	@Override
	public void onCommand(String command, String[] args) throws Exception {
		if(args[0].equalsIgnoreCase("jump")) {
			Slient.addChatMessage("�bCriticals �et�r� JUMP olarak belirlendi!");
			slientclient.mods.Criticals.jump = 0;
		}
		
		if (args[0].equalsIgnoreCase("packet")) {
			Slient.addChatMessage("�bCriticals �et�r� PACKET olarak belirlendi!");
			slientclient.mods.Criticals.jump = 1;
		}
	}
}
