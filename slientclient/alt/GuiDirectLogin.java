/*     */ package slientclient.alt;
/*     */ 
/*     */ import com.google.common.collect.Lists;
/*     */ import java.io.IOException;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.UUID;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.GuiButton;
/*     */ import net.minecraft.client.gui.GuiScreen;
/*     */ import net.minecraft.client.gui.GuiTextField;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class GuiDirectLogin
/*     */   extends GuiScreen
/*     */ {
/*     */   protected GuiAltManager parentScreen;
/*     */   protected String messageLine1;
/*     */   private String messageLine2;
/*  25 */   private final List field_175298_s = Lists.newArrayList();
/*     */   
/*     */   protected String confirmButtonText;
/*     */   
/*     */   protected String cancelButtonText;
/*     */   
/*     */   protected int parentButtonClickedId;
/*     */   
/*     */   private int ticksUntilEnable;
/*     */   
/*     */   private static final String __OBFID = "CL_00000684";
/*     */   private GuiTextField email;
/*     */   private GuiTextField pswd;
/*     */   
/*     */   public GuiDirectLogin(GuiAltManager p_i1082_1_)
/*     */   {
/*  41 */     this.parentScreen = p_i1082_1_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void initGui()
/*     */   {
/*  49 */     this.buttonList.add(new GuiButton(1, this.width / 2 - 100, this.height - 50 - 20 - 5, 200, 20, "§aLogin"));
/*     */     
/*  51 */     this.buttonList.add(new GuiButton(666, this.width / 2 - 100, this.height - 50, 200, 20, "Back to Sub Manager"));
/*     */     
/*     */ 
/*  54 */     this.email = 
/*  55 */       new GuiTextField(1, this.fontRendererObj, this.width / 2 - 100, 
/*  56 */       this.height / 4 + 5, 200, 20);
/*  57 */     this.email.setMaxStringLength(64);
/*  58 */     this.email.setFocused(false);
/*     */     
/*  60 */     this.pswd = 
/*  61 */       new GuiTextField(1, this.fontRendererObj, this.width / 2 - 100, 
/*  62 */       this.height / 4 + 35, 200, 20);
/*  63 */     this.pswd.setMaxStringLength(200);
/*  64 */     this.pswd.setFocused(false);
/*     */   }
/*     */   
/*     */ 
/*  68 */   String s = "§fClick `§aLogin§f` to logins.";
/*     */   
/*     */   protected void actionPerformed(GuiButton button) throws IOException
/*     */   {
/*  72 */     if (button.enabled)
/*     */     {
/*  74 */       if (button.id == 666)
/*     */       {
/*  76 */         this.mc.displayGuiScreen(this.parentScreen);
/*  77 */       } else if (button.id == 1)
/*     */       {
/*  79 */         if ((this.pswd.getText() == null) || (this.pswd.getText() == "") || (this.pswd.getText() == " "))
/*     */         {
/*  81 */           if ((this.email.getText() == null) || (this.email.getText() == "") || (this.email.getText() == " "))
/*     */           {
/*  83 */             this.s = "§c§lUsername can not be empty";
/*  84 */             return;
/*     */           }
/*  86 */           if (this.email.getText().length() < 3)
/*     */           {
/*  88 */             this.s = "§c§lUser Name Too Short.";
/*  89 */             return;
/*     */           }
/*  91 */           if (this.email.getText().length() > 16)
/*     */           {
/*  93 */             this.s = "§cÂ§lUser Name Too Long.";
/*  94 */             return;
/*     */           }
/*  96 */           net.minecraft.util.Session.username = this.email.getText();
/*  97 */           net.minecraft.util.Session.playerID = UUID.randomUUID().toString();
/*     */           
/*  99 */           this.s = "§a§lSuccessful, You logged in with a cracked account!";
/*     */           
/* 101 */           return;
/*     */         }
/* 103 */         this.s = LoginManager.login(this.email.getText(), this.pswd.getText());
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   protected void keyTyped(char par1, int par2)
/*     */   {
/* 112 */     this.email.textboxKeyTyped(par1, par2);
/* 113 */     this.pswd.textboxKeyTyped(par1, par2);
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
/*     */   protected void mouseClicked(int par1, int par2, int par3)
/*     */     throws IOException
/*     */   {
/* 128 */     super.mouseClicked(par1, par2, par3);
/* 129 */     this.email.mouseClicked(par1, par2, par3);
/* 130 */     this.pswd.mouseClicked(par1, par2, par3);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void drawScreen(int mouseX, int mouseY, float partialTicks)
/*     */   {
/* 138 */     drawDefaultBackground();
/*     */     
/* 140 */     drawCenteredString(this.fontRendererObj, this.s, this.width / 2, this.height - 90, 16777215);
/*     */     
/* 142 */     drawCenteredString(this.fontRendererObj, "Login", this.width / 2, 20, 
/* 143 */       16777215);
/* 144 */     drawCenteredString(this.fontRendererObj, "You can login here with Premium or you can log in with your Crack account.", this.width / 2, 35, 
/* 145 */       10526880);
/* 146 */     drawCenteredString(this.fontRendererObj, 
/* 147 */       "", this.width / 2, 45, 10526880);
/*     */     
/* 149 */     this.email.drawTextBox();
/* 150 */     this.pswd.drawTextBox();
/*     */     
/* 152 */     super.drawScreen(mouseX, mouseY, partialTicks);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setButtonDelay(int p_146350_1_)
/*     */   {
/* 159 */     this.ticksUntilEnable = p_146350_1_;
/*     */     
/*     */     GuiButton var3;
/* 162 */     for (Iterator var2 = this.buttonList.iterator(); var2.hasNext(); var3.enabled = false)
/*     */     {
/* 164 */       var3 = (GuiButton)var2.next();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void updateScreen()
/*     */   {
/* 173 */     super.updateScreen();
/*     */     
/*     */ 
/* 176 */     if (--this.ticksUntilEnable == 0) {
/*     */       GuiButton var2;
/* 178 */       for (Iterator var1 = this.buttonList.iterator(); var1.hasNext(); var2.enabled = true)
/*     */       {
/* 180 */         var2 = (GuiButton)var1.next();
/*     */       }
/*     */     }
/*     */   }
/*     */ }
