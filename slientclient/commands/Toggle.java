package slientclient.commands;

import slientclient.command.Command;
import slientclient.main.Slient;
import slientclient.mods.*;

public class Toggle extends Command{

	@Override
	public String getAlias() {
		// TODO Auto-generated method stub
		return "toggle";
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "Toggles a mod though the console";
	}

	@Override
	public String getSyntax() {
		// TODO Auto-generated method stub
		return ".toggle <Module>";
	}

	@Override
	public void onCommand(String command, String[] args) throws Exception {
		boolean found = false;
		for(Module m: Slient.getModules()){
			if(args[0].equalsIgnoreCase(m.getName())){
				m.toggle();
				found = true;
				Slient.addChatMessage(m.getName() + " was toggled!");
			}
		}
		if(found == false){
			Slient.addChatMessage("Targeted Module was not found!");
		}
	}

}
