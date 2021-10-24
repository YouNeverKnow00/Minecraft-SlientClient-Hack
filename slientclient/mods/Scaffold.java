package slientclient.mods;

import java.util.Arrays;

import org.lwjgl.input.Keyboard;

import java.util.Arrays;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.state.pattern.BlockMaterialMatcher;
import net.minecraft.block.state.pattern.BlockPattern;
import net.minecraft.block.state.pattern.BlockStateMatcher;
import net.minecraft.block.state.pattern.FactoryBlockPattern;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.PlayerControllerMP;
import net.minecraft.init.Blocks;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import slientclient.event.EventSendPacket;
import slientclient.event.EventTarget;
import slientclient.event.EventUpdate;
import slientclient.event.EventSafewalk;
import slientclient.main.Category;
import slientclient.notification_system.Notification;
import slientclient.notification_system.NotificationManager;
import slientclient.notification_system.NotificationType;
import slientclient.utils.PlayerUtils;
import slientclient.utils.TimeHelper;

public class Scaffold extends Module{

	public static PlayerControllerMP playerController;

	  private float lastYaw;
	  private float lastPitch;
	
	public Scaffold() {
		super("Scaffold", 0, Category.OTHER);
		
	    this.blockData = null;
	    this.time = new TimeHelper();
	    
	    this.blacklist = Arrays.asList(new Block[] { Blocks.AIR, Blocks.WATER, Blocks.FLOWING_WATER, Blocks.LAVA, Blocks.FLOWING_LAVA });
	  }
	  private BlockData blockData; private TimeHelper time; private List<Block> blacklist;
	  public BlockData getBlockData(BlockPos pos) {
		  
	    Minecraft.getMinecraft(); if (!this.blacklist.contains(Minecraft.getMinecraft().world.getBlockState(pos.add(0, -1, 0)).getBlock())) {
	      return new BlockData(pos.add(0, -1, 0), EnumFacing.UP);
	    }
	    Minecraft.getMinecraft(); if (!this.blacklist.contains(Minecraft.getMinecraft().world.getBlockState(pos.add(-1, 0, 0)).getBlock())) {
	      return new BlockData(pos.add(-1, 0, 0), EnumFacing.EAST);
	    }
	    Minecraft.getMinecraft(); if (!this.blacklist.contains(Minecraft.getMinecraft().world.getBlockState(pos.add(1, 0, 0)).getBlock())) {
	      return new BlockData(pos.add(1, 0, 0), EnumFacing.WEST);
	    }
	    Minecraft.getMinecraft(); if (!this.blacklist.contains(Minecraft.getMinecraft().world.getBlockState(pos.add(0, 0, -1)).getBlock())) {
	      return new BlockData(pos.add(0, 0, -1), EnumFacing.SOUTH);
	    }
	    Minecraft.getMinecraft(); if (!this.blacklist.contains(Minecraft.getMinecraft().world.getBlockState(pos.add(0, 0, 1)).getBlock())) {
	      return new BlockData(pos.add(0, 0, 1), EnumFacing.NORTH);
	    }
	    return null;
	  }
	  
	  private class BlockData {
		    public BlockPos position;
		    public EnumFacing face;
		    
		    public BlockData(BlockPos position, EnumFacing face) {
		      this.position = position;
		      this.face = face;
		  }
		}
	
	public void onDisable(){
		NotificationManager.show(new Notification(NotificationType.INFO, "Scaffold", "Scaffold was disabled.", 2));
	    if (mc.inGameHasFocus) {
	        PlayerUtils.setBindingAsInput(mc.gameSettings.keyBindJump);
	      } else {
	        mc.gameSettings.keyBindJump.pressed = false;
	      } 
	}
	
	public void onEnable() {
		NotificationManager.show(new Notification(NotificationType.INFO, "Scaffold", "Scaffold was enabled.", 2));
		this.blockData = null;
	}
	
	  @EventTarget
	  public void onUpdate(EventUpdate event) {
	    Minecraft.getMinecraft();
	    System.out.println("Update kýsmý");
	    if (Minecraft.getMinecraft().player.getHeldItem(null) != null) {
	      System.out.println("Update kýsmý");
	      if (!Minecraft.getMinecraft().player.isSneaking()) {
	        Minecraft.getMinecraft();
	        if (Minecraft.getMinecraft().player.getHeldItem(null).getItem() instanceof net.minecraft.item.ItemBlock)
	          mc.gameSettings.keyBindJump.pressed = false; 
	      } 
	    } 
	  }
	
	  @EventTarget
	  public void onPreMotion() {
	    this.blockData = null;
	    Minecraft.getMinecraft();
	    if (Minecraft.getMinecraft().player.getHeldItem(null) != null) {
	      Minecraft.getMinecraft();
	      if (!Minecraft.getMinecraft().player.isSneaking()) {
	    	Minecraft.getMinecraft();
	        if (Minecraft.getMinecraft().player.getHeldItem(null).getItem() instanceof net.minecraft.item.ItemBlock) {
	        	Minecraft.getMinecraft();
	        	Minecraft.getMinecraft();
	        	Minecraft.getMinecraft();
	          BlockPos blockBelow = new BlockPos(Minecraft.getMinecraft().player.posX, Minecraft.getMinecraft().player.posY - 1.0D, Minecraft.getMinecraft().player.posZ);
	          Minecraft.getMinecraft();
	          if (Minecraft.getMinecraft().world.getBlockState(blockBelow).getBlock() == Blocks.AIR) {
	            this.blockData = getBlockData(blockBelow);
	            if (this.blockData != null) {
	            	Minecraft.getMinecraft();
	              this.lastPitch =  Minecraft.getMinecraft().player.rotationPitch;
	              Minecraft.getMinecraft();
	              this.lastYaw =  Minecraft.getMinecraft().player.rotationYaw;
	          
	            } 
	          } 
	        } 
	      } 
	    } 
	  }
	  
	  @EventTarget
	  public void onSendPacket(EventSendPacket event) {
	    if (event.getPacket() instanceof CPacketPlayer) {
	      CPacketPlayer packet = (CPacketPlayer)event.getPacket();
	      if (packet.getRotating() && this.blockData != null) {
	        Minecraft.getMinecraft();
	        Minecraft.getMinecraft().player.rotationYaw = this.lastYaw;
	        Minecraft.getMinecraft();
	        Minecraft.getMinecraft().player.rotationPitch = this.lastPitch;
	      } 
	    } 
	  }
	  
	  @EventTarget
	  public void onPostMotion() {
	    if (this.blockData == null)
	      return; 
	    if (!this.time.hasTimerReached(75L))
	      return; 
	    mc.rightClickDelayTimer = 0;
	    Minecraft.getMinecraft();
	    Minecraft.getMinecraft();
	    Minecraft.getMinecraft();
	    Minecraft.getMinecraft();
//	    if (Minecraft.getMinecraft().playerController.processRightClickBlock(Minecraft.getMinecraft().player, Minecraft.getMinecraft().world, Minecraft.getMinecraft().player.getHeldItem(null), this.blockData.position, this.blockData.face, new Vec3d(this.blockData.position.getX(), this.blockData.position.getY(), this.blockData.position.getZ()))) {
//	      Minecraft.getMinecraft();
	//      Minecraft.getMinecraft().player.swingArm(null);
	 //   } 
	  }
	  
	  @EventTarget
	  public void onWalking(slientclient.event.EventSafewalk event) {
	    Minecraft.getMinecraft();
	    if (Minecraft.getMinecraft().player.onGround)
	      event.setShouldWalkSafely(true); 
	  }  
}