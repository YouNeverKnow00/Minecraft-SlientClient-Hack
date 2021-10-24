/*    */ package slientclient.alt;
/*    */ 
/*    */ import com.mojang.authlib.Agent;
/*    */ import com.mojang.authlib.GameProfile;
/*    */ import com.mojang.authlib.exceptions.AuthenticationException;
/*    */ import com.mojang.authlib.exceptions.AuthenticationUnavailableException;
/*    */ import com.mojang.authlib.yggdrasil.YggdrasilAuthenticationService;
/*    */ import com.mojang.authlib.yggdrasil.YggdrasilUserAuthentication;
/*    */ import java.net.Proxy;
/*    */ import java.util.UUID;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.util.Session;
/*    */ 
/*    */ public class LoginManager
/*    */ {
/*    */   public static String login(String email, String password)
/*    */   {
/* 18 */     YggdrasilUserAuthentication auth = 
/* 19 */       (YggdrasilUserAuthentication)new YggdrasilAuthenticationService(
/* 20 */       Proxy.NO_PROXY, "").createUserAuthentication(Agent.MINECRAFT);
/*    */     
/* 22 */     auth.setUsername(email);
/* 23 */     auth.setPassword(password);
/*    */     try
/*    */     {
/* 26 */       auth.logIn();
/* 27 */       Minecraft.getMinecraft().session = 
/* 28 */         new Session(auth.getSelectedProfile().getName(), auth
/* 29 */         .getSelectedProfile().getId().toString(), 
/* 30 */         auth.getAuthenticatedToken(), "mojang");
/* 31 */       return "§aYou have successfully logged in with premium! " + Minecraft.getMinecraft().getSession().getUsername ();
/*    */     }
/*    */     catch (AuthenticationUnavailableException e)
/*    */     {
/* 35 */       return "§cCommunication with Authentication Servers cannot be established!";
/*    */     }
/*    */     catch (AuthenticationException e)
/*    */     {
/* 39 */       e.printStackTrace();
/* 40 */       if ((e.getMessage().contains("Invalid username or password.")) || 
/* 41 */         (e.getMessage().toLowerCase().contains("Account migrated."))) {
/* 42 */         return "§cWrong password.";
/*    */       }
/* 44 */       return "§cCommunication with Authentication Servers cannot be established!";
/*    */     }
/*    */     catch (NullPointerException localNullPointerException) {}
/* 47 */     return "§cWrong password.";
/*    */   }
/*    */   
/*    */   public static void changeCrackedName(String newName)
/*    */   {
/* 52 */     Minecraft.getMinecraft().session = 
/* 53 */       new Session(newName, "", "", "mojang");
/*    */   }
/*    */ }
