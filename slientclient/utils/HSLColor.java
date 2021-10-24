/*     */ package slientclient.utils;
/*     */ 
/*     */ import java.awt.Color;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class HSLColor
/*     */ {
/*     */   private Color rgb;
/*     */   private float[] hsl;
/*     */   private float alpha;
/*     */   
/*     */   public HSLColor(Color rgb)
/*     */   {
/*  38 */     this.rgb = rgb;
/*  39 */     this.hsl = fromRGB(rgb);
/*  40 */     this.alpha = (rgb.getAlpha() / 255.0F);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public HSLColor(float h, float s, float l)
/*     */   {
/*  56 */     this(h, s, l, 1.0F);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public HSLColor(float h, float s, float l, float alpha)
/*     */   {
/*  73 */     this.hsl = new float[] { h, s, l };
/*  74 */     this.alpha = alpha;
/*  75 */     this.rgb = toRGB(this.hsl, alpha);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public HSLColor(float[] hsl)
/*     */   {
/*  87 */     this(hsl, 1.0F);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public HSLColor(float[] hsl, float alpha)
/*     */   {
/* 101 */     this.hsl = hsl;
/* 102 */     this.alpha = alpha;
/* 103 */     this.rgb = toRGB(hsl, alpha);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Color adjustHue(float degrees)
/*     */   {
/* 116 */     return toRGB(degrees, this.hsl[1], this.hsl[2], this.alpha);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Color adjustLuminance(float percent)
/*     */   {
/* 129 */     return toRGB(this.hsl[0], this.hsl[1], percent, this.alpha);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Color adjustSaturation(float percent)
/*     */   {
/* 142 */     return toRGB(this.hsl[0], percent, this.hsl[2], this.alpha);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Color adjustShade(float percent)
/*     */   {
/* 156 */     float multiplier = (100.0F - percent) / 100.0F;
/* 157 */     float l = Math.max(0.0F, this.hsl[2] * multiplier);
/*     */     
/* 159 */     return toRGB(this.hsl[0], this.hsl[1], l, this.alpha);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Color adjustTone(float percent)
/*     */   {
/* 173 */     float multiplier = (100.0F + percent) / 100.0F;
/* 174 */     float l = Math.min(100.0F, this.hsl[2] * multiplier);
/*     */     
/* 176 */     return toRGB(this.hsl[0], this.hsl[1], l, this.alpha);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public float getAlpha()
/*     */   {
/* 186 */     return this.alpha;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Color getComplementary()
/*     */   {
/* 198 */     float hue = (this.hsl[0] + 180.0F) % 360.0F;
/* 199 */     return toRGB(hue, this.hsl[1], this.hsl[2]);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public float getHue()
/*     */   {
/* 209 */     return this.hsl[0];
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public float[] getHSL()
/*     */   {
/* 219 */     return this.hsl;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public float getLuminance()
/*     */   {
/* 229 */     return this.hsl[2];
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Color getRGB()
/*     */   {
/* 239 */     return this.rgb;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public float getSaturation()
/*     */   {
/* 249 */     return this.hsl[1];
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 255 */     String toString = "HSLColor[h=" + this.hsl[0] + ",s=" + this.hsl[1] + ",l=" + 
/* 256 */       this.hsl[2] + ",alpha=" + this.alpha + "]";
/*     */     
/* 258 */     return toString;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static float[] fromRGB(Color color)
/*     */   {
/* 270 */     float[] rgb = color.getRGBColorComponents(null);
/* 271 */     float r = rgb[0];
/* 272 */     float g = rgb[1];
/* 273 */     float b = rgb[2];
/*     */     
/*     */ 
/*     */ 
/* 277 */     float min = Math.min(r, Math.min(g, b));
/* 278 */     float max = Math.max(r, Math.max(g, b));
/*     */     
/*     */ 
/*     */ 
/* 282 */     float h = 0.0F;
/*     */     
/* 284 */     if (max == min) {
/* 285 */       h = 0.0F;
/* 286 */     } else if (max == r) {
/* 287 */       h = (60.0F * (g - b) / (max - min) + 360.0F) % 360.0F;
/* 288 */     } else if (max == g) {
/* 289 */       h = 60.0F * (b - r) / (max - min) + 120.0F;
/* 290 */     } else if (max == b) {
/* 291 */       h = 60.0F * (r - g) / (max - min) + 240.0F;
/*     */     }
/*     */     
/*     */ 
/* 295 */     float l = (max + min) / 2.0F;
/*     */     
/*     */ 
/*     */ 
/* 299 */     float s = 0.0F;
/*     */     
/* 301 */     if (max == min) {
/* 302 */       s = 0.0F;
/* 303 */     } else if (l <= 0.5F) {
/* 304 */       s = (max - min) / (max + min);
/*     */     } else {
/* 306 */       s = (max - min) / (2.0F - max - min);
/*     */     }
/* 308 */     return new float[] { h, s * 100.0F, l * 100.0F };
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static Color toRGB(float[] hsl)
/*     */   {
/* 324 */     return toRGB(hsl, 1.0F);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static Color toRGB(float[] hsl, float alpha)
/*     */   {
/* 342 */     return toRGB(hsl[0], hsl[1], hsl[2], alpha);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static Color toRGB(float h, float s, float l)
/*     */   {
/* 359 */     return toRGB(h, s, l, 1.0F);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static Color toRGB(float h, float s, float l, float alpha)
/*     */   {
/* 378 */     if ((s < 0.0F) || (s > 100.0F))
/*     */     {
/* 380 */       String message = 
/* 381 */         "Color parameter outside of expected range - Saturation";
/* 382 */       throw new IllegalArgumentException(message);
/*     */     }
/*     */     
/* 385 */     if ((l < 0.0F) || (l > 100.0F))
/*     */     {
/* 387 */       String message = 
/* 388 */         "Color parameter outside of expected range - Luminance";
/* 389 */       throw new IllegalArgumentException(message);
/*     */     }
/*     */     
/* 392 */     if ((alpha < 0.0F) || (alpha > 1.0F))
/*     */     {
/* 394 */       String message = 
/* 395 */         "Color parameter outside of expected range - Alpha";
/* 396 */       throw new IllegalArgumentException(message);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 401 */     h %= 360.0F;
/* 402 */     h /= 360.0F;
/* 403 */     s /= 100.0F;
/* 404 */     l /= 100.0F;
/*     */     
/* 406 */     float q = 0.0F;
/*     */     
/* 408 */     if (l < 0.5D) {
/* 409 */       q = l * (1.0F + s);
/*     */     } else {
/* 411 */       q = l + s - s * l;
/*     */     }
/* 413 */     float p = 2.0F * l - q;
/*     */     
/* 415 */     float r = Math.max(0.0F, HueToRGB(p, q, h + 0.33333334F));
/* 416 */     float g = Math.max(0.0F, HueToRGB(p, q, h));
/* 417 */     float b = Math.max(0.0F, HueToRGB(p, q, h - 0.33333334F));
/*     */     
/* 419 */     r = Math.min(r, 1.0F);
/* 420 */     g = Math.min(g, 1.0F);
/* 421 */     b = Math.min(b, 1.0F);
/*     */     
/* 423 */     return new Color(r, g, b, alpha);
/*     */   }
/*     */   
/*     */   private static float HueToRGB(float p, float q, float h)
/*     */   {
/* 428 */     if (h < 0.0F) {
/* 429 */       h += 1.0F;
/*     */     }
/* 431 */     if (h > 1.0F) {
/* 432 */       h -= 1.0F;
/*     */     }
/* 434 */     if (6.0F * h < 1.0F) {
/* 435 */       return p + (q - p) * 6.0F * h;
/*     */     }
/* 437 */     if (2.0F * h < 1.0F) {
/* 438 */       return q;
/*     */     }
/* 440 */     if (3.0F * h < 2.0F) {
/* 441 */       return p + (q - p) * 6.0F * (0.6666667F - h);
/*     */     }
/* 443 */     return p;
/*     */   }
/*     */ }
