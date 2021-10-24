/*     */ package slientclient.alt;
/*     */ 
/*     */ import com.google.common.collect.Lists;
/*     */ import slientclient.alt.GuiPlus;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.GuiListExtended;
/*     */ import net.minecraft.client.gui.GuiListExtended.IGuiListEntry;
/*     */ import net.minecraft.client.multiplayer.ServerList;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class AltSelectionList
/*     */   extends GuiListExtended
/*     */ {
/*     */   private final GuiPlus owner;
/*  18 */   private final List field_148198_l = Lists.newArrayList();
/*  19 */   private final List field_148199_m = Lists.newArrayList();
/*  20 */   private final GuiListExtended.IGuiListEntry lanScanEntry = new AltScanEntry();
/*  21 */   private int field_148197_o = -1;
/*     */   private static final String __OBFID = "CL_00000819";
/*     */   
/*     */   public AltSelectionList(GuiPlus p_i45049_1_, Minecraft mcIn, int p_i45049_3_, int p_i45049_4_, int p_i45049_5_, int p_i45049_6_, int p_i45049_7_)
/*     */   {
/*  26 */     super(mcIn, p_i45049_3_, p_i45049_4_, p_i45049_5_, p_i45049_6_, p_i45049_7_);
/*  27 */     this.owner = p_i45049_1_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public GuiListExtended.IGuiListEntry getListEntry(int p_148180_1_)
/*     */   {
/*  35 */     if (p_148180_1_ < this.field_148198_l.size())
/*     */     {
/*  37 */       return (GuiListExtended.IGuiListEntry)this.field_148198_l.get(p_148180_1_);
/*     */     }
/*     */     
/*     */ 
/*  41 */     p_148180_1_ -= this.field_148198_l.size();
/*     */     
/*  43 */     if (p_148180_1_ == 0)
/*     */     {
/*  45 */       return this.lanScanEntry;
/*     */     }
/*     */     
/*     */ 
/*  49 */     p_148180_1_--;
/*  50 */     return (GuiListExtended.IGuiListEntry)this.field_148199_m.get(p_148180_1_);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   protected int getSize()
/*     */   {
/*  57 */     return this.field_148198_l.size() + 1 + this.field_148199_m.size();
/*     */   }
/*     */   
/*     */   public void func_148192_c(int p_148192_1_)
/*     */   {
/*  62 */     this.field_148197_o = p_148192_1_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   protected boolean isSelected(int slotIndex)
/*     */   {
/*  70 */     return slotIndex == this.field_148197_o;
/*     */   }
/*     */   
/*     */   public int func_148193_k()
/*     */   {
/*  75 */     return this.field_148197_o;
/*     */   }
/*     */   
/*     */   public void func_148195_a(ServerList p_148195_1_)
/*     */   {
/*  80 */     this.field_148198_l.clear();
/*     */     
/*  82 */     for (int var2 = 0; var2 < p_148195_1_.countServers(); var2++) {}
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void func_148194_a(List p_148194_1_)
/*     */   {
/*  90 */     this.field_148199_m.clear();
/*  91 */     Iterator var2 = p_148194_1_.iterator();
/*     */   }
/*     */   
/*     */ 
/*     */   protected int getScrollBarX()
/*     */   {
/*  97 */     return super.getScrollBarX() + 30;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getListWidth()
/*     */   {
/* 105 */     return super.getListWidth() + 85;
/*     */   }
/*     */ }
