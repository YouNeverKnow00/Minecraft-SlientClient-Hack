package slientclient.tabgui;

import java.util.ArrayList;
import java.util.HashMap;

import org.lwjgl.input.Keyboard;

import slientclient.main.Slient;
import slientclient.mods.*;

public class TabManager {

	private ArrayList<Tab> tabs;
	private int currentTab;

	private HashMap<Integer, Module> renderMods, movementMods, playerMods, combatMods, otherMods, exploitMods;
	private int currentRenderMod, currentMovementMod, currentPlayerMod, currentCombatMod, currentOtherMod, currentExploitMod;

	public TabManager() {
		tabs = new ArrayList();
		currentTab = 0;
		renderMods = new HashMap();
		movementMods = new HashMap();
		playerMods = new HashMap();
		combatMods = new HashMap();
		otherMods = new HashMap();
		exploitMods = new HashMap();
		currentRenderMod = 0;
		currentMovementMod = 0;
		currentPlayerMod= 0;
		currentCombatMod= 0;
		currentOtherMod= 0;
		currentExploitMod= 0;
		tabs.add(new TabOne());
		tabs.add(new TabTwo());
		tabs.add(new TabThree());
		tabs.add(new TabFour());
		tabs.add(new TabFive());
		tabs.add(new TabSix());
		
		// Exploit
		exploitMods.put(0, new Crash());
		
		// Other
		otherMods.put(0, new ClickGui());
		otherMods.put(1, new Twerk());
		otherMods.put(2, new AntiAFK());
		
		// Combat
		combatMods.put(0, new KillAura());
		combatMods.put(1, new NoKnockBack());
		combatMods.put(2, new AutoArmor());
		combatMods.put(3, new Criticals());
		
		// Player
		playerMods.put(0, new Nofall());
		playerMods.put(1, new PingSpoof());
		playerMods.put(2, new ChestStealer());
		playerMods.put(3, new FastBreak());
		playerMods.put(4, new FastPlace());
		
		// Render
		renderMods.put(0, new Fullbright());
		renderMods.put(1, new ChestESP());
		renderMods.put(2, new MobESP());
		renderMods.put(3, new PlayerESP());
		renderMods.put(4, new Tracers());
		renderMods.put(5, new ItemESP());
		renderMods.put(6, new NameTags());
		
		// Movement 
		movementMods.put(0, new Flight());
		movementMods.put(1, new Glide());
		movementMods.put(2, new Sprint());
		movementMods.put(3, new LongJump());
		movementMods.put(4, new Speed());
		movementMods.put(5, new Spider());
		movementMods.put(6, new FastLadder());
		movementMods.put(7, new Bhop());
		movementMods.put(8, new Bhop2());
		movementMods.put(9, new NoWeb());
	}
	
	public ArrayList<Tab> getTabs(){
		return tabs;
	}
	
	public int getCurrentExploitMod(){
		return currentExploitMod;
	}
	
	public int getCurrentOtherMod(){
		return currentOtherMod;
	}
	
	public int getCurrentCombatMod(){
		return currentCombatMod;
	}
	
	public int getCurrentPlayerMod(){
		return currentPlayerMod;
	}
	
	public int getCurrentMovementMod(){
		return currentMovementMod;
	}
	
	public int getCurrentRenderMod(){
		return currentRenderMod;
	}
	
	public int getCurrentTab(){
		return currentTab;
	}

	public void keyPressed(int k) {
		switch (k) {
		case Keyboard.KEY_UP:
			if(tabs.get(currentTab).isExpanded()){
				switch(currentTab){
				case 0:
					if(currentRenderMod != 0){
						currentRenderMod--;
					}
					break;
				case 1:
					if(currentMovementMod != 0){
						currentMovementMod--;
					}
					break;
				case 2:
					if(currentPlayerMod != 0){
						currentPlayerMod--;
					}
					break;
				case 3:
					if(currentCombatMod != 0){
						currentCombatMod--;
					}
					break;
				case 4:
					if(currentOtherMod != 0){
						currentOtherMod--;
					}
					break;
				case 5:
					if(currentExploitMod != 0){
						currentExploitMod--;
					}
					break;
				}
			}else{
				if(currentTab != 0){
					currentTab--;
				}
			}
			break;
		case Keyboard.KEY_DOWN:
			if(tabs.get(currentTab).isExpanded()){
				switch(currentTab){
				case 0:
					if(currentRenderMod != renderMods.size()-1){
						currentRenderMod++;
					}
					break;
				case 1:
					if(currentMovementMod != movementMods.size()-1){
						currentMovementMod++;
					}
					break;
				case 2:
					if(currentPlayerMod != playerMods.size()-1){
						currentPlayerMod++;
					}
					break;
				case 3:
					if(currentCombatMod != combatMods.size()-1){
						currentCombatMod++;
					}
					break;
				case 4:
					if(currentOtherMod != otherMods.size()-1){
						currentOtherMod++;
					}
					break;
				case 5:
					if(currentExploitMod != exploitMods.size()-1){
						currentExploitMod++;
					}
					break;
				}
			}else{
			    if(currentTab != 5){
			     currentTab++;
				}
			}
			break;
		case Keyboard.KEY_RIGHT:
			if(tabs.get(currentTab).isExpanded()){
				switch(currentTab){
				case 0:
					toggleMod(renderMods.get(currentRenderMod).getName());
					break;
				case 1:
					toggleMod(movementMods.get(currentMovementMod).getName());
					break;
				case 2:
					toggleMod(playerMods.get(currentPlayerMod).getName());
					break;
				case 3:
					toggleMod(combatMods.get(currentCombatMod).getName());
					break;
				case 4:
					toggleMod(otherMods.get(currentOtherMod).getName());
					break;
				case 5:
					toggleMod(exploitMods.get(currentExploitMod).getName());
					break;
				}
			}else{
				tabs.get(currentTab).setExpanded(true);
			}
			break;
		case Keyboard.KEY_LEFT:
			if(tabs.get(currentTab).isExpanded()){
				tabs.get(currentTab).setExpanded(false);
			}
			break;
		}
	}
	
	private void toggleMod(String n){
		for(Module m: Slient.getModules()){
			if(m.getName().equalsIgnoreCase(n)){
				m.toggle();
				break;
			}
		}
	}

}
