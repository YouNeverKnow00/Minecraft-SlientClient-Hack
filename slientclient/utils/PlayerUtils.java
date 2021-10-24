package slientclient.utils;

import com.google.common.collect.Multimap;
import java.util.Iterator;
import java.util.Map;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.item.ItemStack;
import net.minecraft.network.play.client.CPacketPlayer;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

public class PlayerUtils
{
  public static void setBindingAsInput(KeyBinding binding) {
    if (binding.getKeyCode() < 0) {
      KeyBinding.setKeyBindState(binding.getKeyCode(), Mouse.isButtonDown(binding.getKeyCode() + 100));
    } else {
      KeyBinding.setKeyBindState(binding.getKeyCode(), Keyboard.isKeyDown(binding.getKeyCode()));
    } 
  }
}
