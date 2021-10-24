package slientclient.commands;

import org.lwjgl.input.Keyboard;

import slientclient.command.Command;
import slientclient.main.Slient;
import slientclient.mods.Module;

public class Bind extends Command {

	@Override
	public String getAlias() {
		return "bind";
	}

	@Override
	public String getDescription() {
		return "Allows user to change keybind of module";
	}

	@Override
	public String getSyntax() {

		return "§3.bind set [MOD] [KEY] §8| §b.bind del [MOD] §8| §3.bind clear";
	}

	@Override
	public void onCommand(String command, String[] args) throws Exception {
		if(args[0].equalsIgnoreCase("set")){
			args[2] = args[2].toUpperCase();
			int key = Keyboard.getKeyIndex(args[2]);
			
			for(Module m: Slient.getModules()){
				if(args[1].equalsIgnoreCase(m.getName())){
					m.setKey(Keyboard.getKeyIndex(Keyboard.getKeyName(key)));
					Slient.addChatMessage(args[1] + " §ehas been binded to " + args[2]);
				}
			}
			
		}else if(args[0].equalsIgnoreCase("del")){
			for(Module m: Slient.getModules()){
				if(m.getName().equalsIgnoreCase(args[1])){
					m.setKey(0);
					Slient.addChatMessage(args[1] + " §ehas been unbinded");
				}
			}
		}else if(args[0].equalsIgnoreCase("clear")){
			for(Module m: Slient.getModules()){
				m.setKey(0);
			}
			Slient.addChatMessage(" §eAll keys cleared");
		}
	}

}
