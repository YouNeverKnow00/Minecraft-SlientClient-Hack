package slientclient.mods;

import java.util.ArrayList;
import java.util.UUID;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityOtherPlayerMP;
import net.minecraft.network.Packet;
import net.minecraft.*;
import net.minecraft.network.play.client.CPacketAnimation;
import net.minecraft.network.play.client.CPacketEntityAction;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.network.play.client.CPacketPlayerDigging;
import net.minecraft.network.play.client.CPacketPlayerTryUseItemOnBlock;
import net.minecraft.network.play.client.CPacketUseEntity;
import slientclient.main.Category;
import slientclient.notification_system.Notification;
import slientclient.notification_system.NotificationManager;
import slientclient.notification_system.NotificationType;
import slientclient.utils.RenderUtils;
import slientclient.utils.TimeHelper4;
import slientclient.*;
import slientclient.compatibility.WConnection;
import slientclient.compatibility.WMinecraft;
import slientclient.event.EventTarget;
import slientclient.event.NetworkManagerPacketSendEvent;
import slientclient.event.WorldRenderEvent;

import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import net.minecraft.client.entity.EntityOtherPlayerMP;
/*     */ import net.minecraft.client.entity.EntityPlayerSP;
/*     */ import net.minecraft.client.renderer.entity.RenderManager;
/*     */ import net.minecraft.network.Packet;
/*     */ import net.minecraft.network.play.client.CPacketKeepAlive;
/*     */ import net.minecraft.util.math.AxisAlignedBB;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import com.mojang.authlib.GameProfile;

import slientclient.*;

public class Blink extends Module {

	
	public Blink() {
		super("Blink", 0, Category.PLAYER);
	}
	
	public void onEnable() {
		NotificationManager.show(new Notification(NotificationType.INFO, "Blink", "Blink was enabled.", 2));
	}
	
	public void onDisable(){
		NotificationManager.show(new Notification(NotificationType.INFO, "Blink", "Blink was disabled.", 2));
    }
	
}
	

