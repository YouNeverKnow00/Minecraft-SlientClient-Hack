package slientclient.utils;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.EntityRenderer;

public final class WEntityRenderer
{
  public static void drawNameplate(FontRenderer fontRendererIn, String str, float x, float y, float z, int verticalShift, float viewerYaw, float viewerPitch, boolean isThirdPersonFrontal, boolean isSneaking)
  {
    EntityRenderer.drawNameplate(fontRendererIn, str, x, y, z, 
      verticalShift, viewerYaw, viewerPitch, isThirdPersonFrontal, 
      isSneaking);
  }
}
