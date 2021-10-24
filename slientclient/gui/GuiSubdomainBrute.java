/*     */ package slientclient.gui;
/*     */ 
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.GroupLayout.SequentialGroup;
/*     */ import javax.swing.JTextField;
/*     */ 
/*     */ public class GuiSubdomainBrute extends javax.swing.JFrame
/*     */ {
/*     */   private javax.swing.JButton jButton1;
/*     */   private javax.swing.JLabel jLabel1;
/*     */   private javax.swing.JLabel jLabel2;
/*     */   private JTextField jTextField1;
/*     */   private JTextField jTextField2;
/*     */   private java.awt.TextArea textArea1;
/*     */   
/*     */   public GuiSubdomainBrute()
/*     */   {
/*  18 */     initComponents();
/*     */   }
/*     */   
/*     */ 
/*     */   private void initComponents()
/*     */   {
/*  24 */     this.jTextField1 = new JTextField();
/*  25 */     this.jLabel1 = new javax.swing.JLabel();
/*  26 */     this.textArea1 = new java.awt.TextArea();
/*  27 */     this.jButton1 = new javax.swing.JButton();
/*  28 */     this.jLabel2 = new javax.swing.JLabel();
/*  29 */     this.jTextField2 = new JTextField();
/*     */     
/*  31 */     setTitle("Subdomains Brute");
/*     */     
/*  33 */     this.jTextField1.setToolTipText("");
/*     */     
/*  35 */     this.jLabel1.setText("Path to list with Subdomains");
/*     */     
/*  37 */     this.jButton1.setText("Start");
/*  38 */     this.jButton1.setToolTipText("");
/*  39 */     this.jButton1.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(java.awt.event.ActionEvent evt) {
/*  41 */         GuiSubdomainBrute.this.jButton1ActionPerformed(evt);
/*     */       }
/*     */       
/*  44 */     });
/*  45 */     this.jLabel2.setText("Target");
/*     */     
/*  47 */     this.jTextField2.setToolTipText("");
/*  48 */     this.jTextField2.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(java.awt.event.ActionEvent evt) {
/*  50 */         GuiSubdomainBrute.this.jTextField2ActionPerformed(evt);
/*     */       }
/*     */       
/*  53 */     });
/*  54 */     GroupLayout layout = new GroupLayout(getContentPane());
/*  55 */     getContentPane().setLayout(layout);
/*  56 */     layout.setHorizontalGroup(
/*  57 */       layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
/*  58 */       .addGroup(layout.createSequentialGroup()
/*  59 */       .addContainerGap()
/*  60 */       .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
/*  61 */       .addComponent(this.jTextField2)
/*  62 */       .addGroup(layout.createSequentialGroup()
/*  63 */       .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
/*  64 */       .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
/*  65 */       .addComponent(this.jTextField1)
/*  66 */       .addComponent(this.textArea1, -1, 291, 32767)
/*  67 */       .addComponent(this.jButton1, -1, -1, 32767))
/*  68 */       .addComponent(this.jLabel1)
/*  69 */       .addComponent(this.jLabel2))
/*  70 */       .addGap(0, 0, 32767)))
/*  71 */       .addContainerGap()));
/*     */     
/*  73 */     layout.setVerticalGroup(
/*  74 */       layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
/*  75 */       .addGroup(layout.createSequentialGroup()
/*  76 */       .addContainerGap(14, 32767)
/*  77 */       .addComponent(this.jLabel2)
/*  78 */       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
/*  79 */       .addComponent(this.jTextField2, -2, -1, -2)
/*  80 */       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
/*  81 */       .addComponent(this.jLabel1)
/*  82 */       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
/*  83 */       .addComponent(this.jTextField1, -2, -1, -2)
/*  84 */       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
/*  85 */       .addComponent(this.jButton1)
/*  86 */       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
/*  87 */       .addComponent(this.textArea1, -2, 205, -2)
/*  88 */       .addContainerGap()));
/*     */     
/*     */ 
/*  91 */     pack();
/*     */   }
/*     */   
/*     */   private boolean isSubExist(String sub)
/*     */   {
/*     */     try {
/*  97 */       java.net.InetAddress localInetAddress = java.net.InetAddress.getByName(sub + "." + this.jTextField2.getText());
/*     */     } catch (java.net.UnknownHostException ex) {
/*  99 */       return false;
/*     */     }
/* 101 */     return true;
/*     */   }
/*     */   
/*     */   private boolean isExist()
/*     */   {
/*     */     try {
/* 107 */       java.net.InetAddress localInetAddress = java.net.InetAddress.getByName(this.jTextField2.getText());
/*     */     } catch (java.net.UnknownHostException ex) {
/* 109 */       return false;
/*     */     }
/* 111 */     return true;
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
/*     */ 
/*     */ 
/*     */   private void jButton1ActionPerformed(java.awt.event.ActionEvent evt)
/*     */   {
/* 132 */     new Thread()
/*     */     {
/*     */       public void run()
/*     */       {
/* 117 */         GuiSubdomainBrute.this.textArea1.append("Start!\n");
/*     */         try {
/* 119 */           if (GuiSubdomainBrute.this.isExist()) {
/* 120 */             GuiSubdomainBrute.this.textArea1.append(GuiSubdomainBrute.this.jTextField2.getText() + " : " + java.net.InetAddress.getByName(GuiSubdomainBrute.this.jTextField2.getText()).getHostAddress() + " : " + java.net.InetAddress.getByName(GuiSubdomainBrute.this.jTextField2.getText()).getCanonicalHostName() + "\n");
/*     */           }
/* 122 */           java.util.Scanner txtscan = new java.util.Scanner(new java.io.File(GuiSubdomainBrute.this.jTextField1.getText()));
/* 123 */           while (txtscan.hasNextLine()) {
/* 124 */             String str = txtscan.nextLine();
/* 125 */             if (GuiSubdomainBrute.this.isSubExist(str)) {
/* 126 */               GuiSubdomainBrute.this.textArea1.append(str + "." + GuiSubdomainBrute.this.jTextField2.getText() + " : " + java.net.InetAddress.getByName(new StringBuilder(String.valueOf(str)).append(".").append(GuiSubdomainBrute.this.jTextField2.getText()).toString()).getHostAddress() + " : " + java.net.InetAddress.getByName(new StringBuilder(String.valueOf(str)).append(".").append(GuiSubdomainBrute.this.jTextField2.getText()).toString()).getCanonicalHostName() + "\n");
/*     */             }
/*     */           }
/*     */         } catch (Exception localException) {}
/* 130 */         GuiSubdomainBrute.this.textArea1.append("Finish!\n");
/*     */       }
/*     */     }.start();
/*     */   }
/*     */   
/*     */   private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {}
/*     */   
/*     */   public static void main(String[] args)
/*     */   {
/*     */     try
/*     */     {
/*     */       javax.swing.UIManager.LookAndFeelInfo[] arrayOfLookAndFeelInfo;
/* 142 */       int j = (arrayOfLookAndFeelInfo = javax.swing.UIManager.getInstalledLookAndFeels()).length; for (int i = 0; i < j; i++) { javax.swing.UIManager.LookAndFeelInfo info = arrayOfLookAndFeelInfo[i];
/* 143 */         if ("Nimbus".equals(info.getName())) {
/* 144 */           javax.swing.UIManager.setLookAndFeel(info.getClassName());
/* 145 */           break;
/*     */         }
/*     */       }
/*     */     } catch (ClassNotFoundException ex) {
/* 149 */       java.util.logging.Logger.getLogger(GuiSubdomainBrute.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
/*     */     } catch (InstantiationException ex) {
/* 151 */       java.util.logging.Logger.getLogger(GuiSubdomainBrute.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
/*     */     } catch (IllegalAccessException ex) {
/* 153 */       java.util.logging.Logger.getLogger(GuiSubdomainBrute.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
/*     */     } catch (javax.swing.UnsupportedLookAndFeelException ex) {
/* 155 */       java.util.logging.Logger.getLogger(GuiSubdomainBrute.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
/*     */     }
/*     */     
/*     */ 
/* 159 */     java.awt.EventQueue.invokeLater(new Runnable() {
/*     */       public void run() {
/* 161 */         new GuiSubdomainBrute().setVisible(true);
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              C:\Users\User\Desktop\Crasher.jar!\jessica\gui\GuiSubdomainBrute.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */