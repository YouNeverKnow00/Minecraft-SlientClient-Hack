package slientclient.command;

import java.util.ArrayList;

import slientclient.commands.*;
import slientclient.main.Slient;

public class CommandManager {

	private ArrayList<Command> commands;
	
	public CommandManager(){
		commands = new ArrayList();
		addCommand(new Bind());
		addCommand(new Help());
		addCommand(new getip());
		addCommand(new connect());
		addCommand(new Toggle());
		addCommand(new BugCommand());
		addCommand(new FuckProtector());
		addCommand(new Clear());
		addCommand(new Criticals_Settings());
	}
	
	public void addCommand(Command c){
		commands.add(c);
	}
	
	public ArrayList<Command> getCommands(){
		return commands;
	}
	
	public void callCommand(String input){
		String[] split = input.split(" ");
		String command = split[0];
		String args = input.substring(command.length()).trim();
		for(Command c: getCommands()){
			if(c.getAlias().equalsIgnoreCase(command)){
				try{
					c.onCommand(args, args.split(" "));
				}catch(Exception e){
					Slient.addChatMessage("§4Invalid Command Usage!");
					Slient.addChatMessage(c.getSyntax());
				}
				return;
			}
		}
		Slient.addChatMessage("§cCommand not found!");
	}

}


