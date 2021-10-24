package slientclient.main;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.UUID;

import org.darkstorm.minecraft.gui.theme.simple.SimpleTheme;
import org.lwjgl.input.Keyboard;

import net.minecraft.client.Minecraft;
import net.minecraft.network.EnumConnectionState;
import net.minecraft.network.Packet;
import net.minecraft.network.handshake.client.C00Handshake;
import net.minecraft.network.play.server.SPacketChat;
import net.minecraft.util.text.TextComponentString;
import slientclient.command.CommandManager;
import slientclient.gui.*;
import slientclient.guint.gui.SlientGuiManager;
import slientclient.mods.*;
import slientclient.tabgui.TabManager;

public class Slient {
	
	public static HashSet<Class<? extends Packet>> FREECAM_PACKETS = new HashSet();
	public static boolean FREECAM = false;
	
	private Minecraft mc = Minecraft.getMinecraft();
	
	// solda yazan renkli yazi
	public static String clientnamecolor = "§8[§2§lSlient§a§lClient§8] ";
	public static String clientversioncolor = "§bb3";
	
	// Renkli client yazisi
	public static String clientnamecolorgui = "§2§lSlient§a§lClient";
	public static String clientversioncolorgui = "§bb3";
	
	// Gui menu buyuk yazilar
	public static String clientnamecolorainbow1 = "§lSlient";
	public static String clientnamecolorainbow2 = "§9§lClient";
	
	// Menuda yanda yazan mavi yazi
	public static String clientdes = "§6Minecraft §e1.12.2";
	
	// Oyunun basliktaki yazi
	public static String clientName = "Slient Client";
	public static String clientVersion = "b3";
	
	// Managerlar 
	private static ArrayList<Module> mods;
	private static CommandManager cmdManager;
	public static SlientGuiManager guiManager;
	public static TabManager tabManager;
	
	public Slient(){
		mods = new ArrayList<Module>();
		cmdManager = new CommandManager();
		tabManager = new TabManager();
		addMod(new Flight());
		addMod(new Nofall());
		addMod(new Fullbright());
		addMod(new ClickGui());
		addMod(new LongJump());
		addMod(new Sprint());
		addMod(new Speed());
		addMod(new KillAura());
		addMod(new MobESP());
		addMod(new Glide());
		addMod(new ChestESP());
		addMod(new PingSpoof());
		addMod(new Spider());
		addMod(new NoKnockBack());
		addMod(new Bhop());
		addMod(new Twerk());
		addMod(new Sneak());
		addMod(new FastPlace());
		addMod(new PlayerESP());
		addMod(new AntiAFK());
		addMod(new NoWeb());
		addMod(new Bhop2());
		addMod(new Criticals());
		addMod(new AutoArmor());
		addMod(new Tracers());
		addMod(new Dolphin());
		addMod(new FastBreak());
		addMod(new ItemESP());
		addMod(new NameTags());
		addMod(new FastLadder());
		addMod(new Scaffold());
		
		/**  Ayarlanacak Yeni **/
		//addMod(new SpeedAAC1());
		
		// Calismaz tabiki :)
		//addMod(new AutoSoup());
		
		// Calismiyor :(
		//addMod(new AutoGapple());
		
		// Calismiyor :/
		addMod(new Blink());
		
		// Calismiyor AYARLANMALI 31.07.2019
		// addMod(new ChestStealer());

		// Crash ayarlanacak
		//   addMod(new Crash());
		guiManager = new SlientGuiManager();
		guiManager.setTheme(new SimpleTheme());
		guiManager.setup();		
	}

	public static void addMod(Module m) {
		mods.add(m);
	}
	
	public static ArrayList<Module> getModules(){
		return mods;
	}

	public static void onUpdate() {
		for(Module m: mods){
			m.onUpdate();
		}
	}
	
	public static void onRender(){
		for(Module m: mods){
			m.onRender();
		}
	}
	
	public static void onKeyPressed(int i){
		for(Module m: mods) {
			if(m.getKey() == i ){
				m.toggle();
			}
		}
	}
	
	public static void addChatMessage(String s){
		Minecraft.getMinecraft().player.addChatMessage(new TextComponentString("§2§lSlient§a§lClient§7: " + s));
	}
	
	public static boolean onSendChatMessage(String s){//EntityPlayerSP
		if(s.startsWith(".")){
			cmdManager.callCommand(s.substring(1));
			return false;
		}
		for(Module m: getModules()){
			if(m.isToggled()){
				return m.onSendChatMessage(s);
			}
		}
		return true;
	}
	
	public static boolean onRecieveChatMessage(SPacketChat packet){
		for(Module m: getModules()){
			if(m.isToggled()){
				return m.onRecieveChatMessage(packet);
			}
		}
		return true;
	}
	
	  public static boolean handleOutPacket(Packet packet, EnumConnectionState packetState)
	  {
	    if ((Minecraft.getMinecraft().isUUIDHack) && 
	      ((packet instanceof C00Handshake)))
	    {
	      if (((C00Handshake)packet).getRequestedState() == EnumConnectionState.LOGIN) {
	        ((C00Handshake)packet).setIp(((C00Handshake)packet)
	          .getIp() + "\000" + Minecraft.getMinecraft()
	          
	          .getFakeIp() + "\000" + 
	          
	          UUID.nameUUIDFromBytes(new StringBuilder().append("OfflinePlayer:")
	          .append(Minecraft.getMinecraft().getFakeNick()).toString()
	          .getBytes()).toString()
	          .replace("-", ""));
	      }
	      System.out.println(((C00Handshake)packet).getIp());
	    }
	    if (packetState != EnumConnectionState.PLAY) {
	      return true;
	    }
	    if (FREECAM) {
	      return FREECAM_PACKETS.contains(packet.getClass());
	    }
	    return true;
	  }
	  
	  public static boolean handleInPacket(Packet packet, EnumConnectionState packetState)
	  {
	    return true;
	  }
	  
	  
	
}
