/*     */ package slientclient.gui;
/*     */ 
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.GroupLayout.ParallelGroup;
/*     */ import javax.swing.GroupLayout.SequentialGroup;
/*     */ 
/*     */ public class GuiOfflineCheckerDB extends javax.swing.JFrame
/*     */ {
/*     */   private javax.swing.JButton jButton1;
/*     */   private javax.swing.JCheckBox jCheckBox1;
/*     */   private javax.swing.JLabel jLabel1;
/*     */   private javax.swing.JLabel jLabel2;
/*     */   private javax.swing.JLabel jLabel3;
/*     */   private javax.swing.JLabel jLabel4;
/*     */   private javax.swing.JLabel jLabel5;
/*     */   private javax.swing.JLabel jLabel6;
/*     */   
/*     */   public GuiOfflineCheckerDB()
/*     */   {
/*  20 */     initComponents();
/*     */   }
/*     */   
/*     */   private javax.swing.JScrollPane jScrollPane1;
/*     */   private javax.swing.JScrollPane jScrollPane2;
/*     */   private javax.swing.JTextField jTextField1;
/*     */   private javax.swing.JTextField jTextField2;
/*     */   private javax.swing.JTextField jTextField3;
/*     */   private javax.swing.JTextPane jTextPane1;
/*     */   private javax.swing.JTextPane jTextPane2;
/*     */   private java.awt.TextArea textArea1;
/*     */   private void initComponents() {
/*  32 */     this.jTextField1 = new javax.swing.JTextField();
/*  33 */     this.jLabel1 = new javax.swing.JLabel();
/*  34 */     this.jTextField2 = new javax.swing.JTextField();
/*  35 */     this.jLabel2 = new javax.swing.JLabel();
/*  36 */     this.textArea1 = new java.awt.TextArea();
/*  37 */     this.jButton1 = new javax.swing.JButton();
/*  38 */     this.jLabel3 = new javax.swing.JLabel();
/*  39 */     this.jScrollPane1 = new javax.swing.JScrollPane();
/*  40 */     this.jTextPane1 = new javax.swing.JTextPane();
/*  41 */     this.jTextField3 = new javax.swing.JTextField();
/*  42 */     this.jLabel4 = new javax.swing.JLabel();
/*  43 */     this.jLabel5 = new javax.swing.JLabel();
/*  44 */     this.jCheckBox1 = new javax.swing.JCheckBox();
/*  45 */     this.jLabel6 = new javax.swing.JLabel();
/*  46 */     this.jScrollPane2 = new javax.swing.JScrollPane();
/*  47 */     this.jTextPane2 = new javax.swing.JTextPane();
/*     */     
/*  49 */     setTitle("CheckedDB");
/*     */     
/*  51 */     this.jTextField1.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(java.awt.event.ActionEvent evt) {
/*  53 */         GuiOfflineCheckerDB.this.jTextField1ActionPerformed(evt);
/*     */       }
/*     */       
/*  56 */     });
/*  57 */     this.jLabel1.setText("Path to list of databases");
/*     */     
/*  59 */     this.jTextField2.setToolTipText("");
/*  60 */     this.jTextField2.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(java.awt.event.ActionEvent evt) {
/*  62 */         GuiOfflineCheckerDB.this.jTextField2ActionPerformed(evt);
/*     */       }
/*     */       
/*  65 */     });
/*  66 */     this.jLabel2.setText("What search?");
/*     */     
/*  68 */     this.jButton1.setText("Search");
/*  69 */     this.jButton1.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(java.awt.event.ActionEvent evt) {
/*  71 */         GuiOfflineCheckerDB.this.jButton1ActionPerformed(evt);
/*     */       }
/*     */       
/*  74 */     });
/*  75 */     this.jLabel3.setText("Current file:");
/*     */     
/*  77 */     this.jScrollPane1.setViewportView(this.jTextPane1);
/*     */     
/*  79 */     this.jTextField3.setToolTipText("");
/*  80 */     this.jTextField3.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(java.awt.event.ActionEvent evt) {
/*  82 */         GuiOfflineCheckerDB.this.jTextField3ActionPerformed(evt);
/*     */       }
/*     */       
/*  85 */     });
/*  86 */     this.jLabel4.setText("Path to list of words");
/*     */     
/*  88 */     this.jLabel5.setText("for search");
/*     */     
/*  90 */     this.jCheckBox1.setText("Search of list");
/*     */     
/*  92 */     this.jLabel6.setText("Current nick:");
/*     */     
/*  94 */     this.jScrollPane2.setViewportView(this.jTextPane2);
/*     */     
/*  96 */     GroupLayout layout = new GroupLayout(getContentPane());
/*  97 */     getContentPane().setLayout(layout);
/*  98 */     layout.setHorizontalGroup(
/*  99 */       layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
/* 100 */       .addGroup(layout.createSequentialGroup()
/* 101 */       .addContainerGap()
/* 102 */       .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
/* 103 */       .addComponent(this.textArea1, -1, -1, 32767)
/* 104 */       .addGroup(layout.createSequentialGroup()
/* 105 */       .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
/* 106 */       .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
/* 107 */       .addComponent(this.jLabel4)
/* 108 */       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
/* 109 */       .addGroup(layout.createSequentialGroup()
/* 110 */       .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
/* 111 */       .addGroup(layout.createSequentialGroup()
/* 112 */       .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
/* 113 */       .addComponent(this.jLabel1)
/* 114 */       .addComponent(this.jTextField1, -2, 142, -2))
/* 115 */       .addGap(53, 53, 53)
/* 116 */       .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
/* 117 */       .addComponent(this.jLabel2)
/* 118 */       .addComponent(this.jTextField2, -2, 132, -2))
/* 119 */       .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
/* 120 */       .addGroup(layout.createSequentialGroup()
/* 121 */       .addGap(10, 10, 10)
/* 122 */       .addComponent(this.jTextField3, -2, 124, -2))
/* 123 */       .addGroup(layout.createSequentialGroup()
/* 124 */       .addGap(11, 11, 11)
/* 125 */       .addComponent(this.jLabel5))))
/* 126 */       .addGroup(layout.createSequentialGroup()
/* 127 */       .addComponent(this.jLabel3)
/* 128 */       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
/* 129 */       .addComponent(this.jScrollPane1, -2, 132, -2)
/* 130 */       .addGap(18, 18, 18)
/* 131 */       .addComponent(this.jLabel6)
/* 132 */       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
/* 133 */       .addComponent(this.jScrollPane2, -2, 132, -2)))
/* 134 */       .addGap(11, 11, 11)))
/* 135 */       .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
/* 136 */       .addComponent(this.jButton1, -1, -1, 32767)
/* 137 */       .addGroup(layout.createSequentialGroup()
/* 138 */       .addComponent(this.jCheckBox1)
/* 139 */       .addGap(0, 71, 32767)))))
/* 140 */       .addContainerGap()));
/*     */     
/* 142 */     layout.setVerticalGroup(
/* 143 */       layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
/* 144 */       .addGroup(layout.createSequentialGroup()
/* 145 */       .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
/* 146 */       .addGroup(layout.createSequentialGroup()
/* 147 */       .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
/* 148 */       .addGroup(layout.createSequentialGroup()
/* 149 */       .addGap(15, 15, 15)
/* 150 */       .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
/* 151 */       .addComponent(this.jLabel1)
/* 152 */       .addComponent(this.jLabel2)
/* 153 */       .addComponent(this.jLabel5)))
/* 154 */       .addComponent(this.jLabel4))
/* 155 */       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
/* 156 */       .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
/* 157 */       .addComponent(this.jTextField1, -2, -1, -2)
/* 158 */       .addComponent(this.jTextField2, -2, -1, -2)
/* 159 */       .addComponent(this.jTextField3, -2, -1, -2)))
/* 160 */       .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
/* 161 */       .addContainerGap()
/* 162 */       .addComponent(this.jButton1, -2, 49, -2)))
/* 163 */       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
/* 164 */       .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
/* 165 */       .addComponent(this.jScrollPane1, -2, -1, -2)
/* 166 */       .addComponent(this.jLabel3, -2, 14, -2)
/* 167 */       .addComponent(this.jCheckBox1)
/* 168 */       .addComponent(this.jScrollPane2, -2, -1, -2)
/* 169 */       .addComponent(this.jLabel6, -2, 14, -2))
/* 170 */       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, 32767)
/* 171 */       .addComponent(this.textArea1, -2, 367, -2)));
/*     */     
/*     */ 
/* 174 */     pack();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {}
/*     */   
/*     */ 
/*     */   private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {}
/*     */   
/*     */ 
/*     */   public void findFile(java.io.File file)
/*     */   {
/* 187 */     java.io.File[] list = file.listFiles();
/* 188 */     if (list != null) { java.io.File[] arrayOfFile1;
/* 189 */       int j = (arrayOfFile1 = list).length; for (int i = 0; i < j; i++) { java.io.File fil = arrayOfFile1[i];
/*     */         
/* 191 */         if (fil.isDirectory())
/*     */         {
/* 193 */           findFile(fil);
/*     */         }
/*     */         else
/*     */         {
/*     */           try {
/* 198 */             this.jTextPane1.setText(fil.getName());
/* 199 */             findTextInFile(fil);
/*     */           } catch (Exception e) {
/* 201 */             e.printStackTrace();
/*     */           }
/* 203 */           this.jTextPane1.setText("Finish!");
/* 204 */           this.jTextPane2.setText("Finish!");
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   void findTextInFile(java.io.File file) throws java.io.FileNotFoundException, java.io.IOException {
/* 211 */     if (this.jCheckBox1.isSelected()) {
/* 212 */       java.util.Scanner txtscan = new java.util.Scanner(new java.io.File(this.jTextField3.getText()));
/* 213 */       java.util.Scanner txtscan2; for (; txtscan.hasNextLine(); 
/*     */           
/*     */ 
/*     */ 
/* 217 */           txtscan2.hasNextLine())
/*     */       {
/* 214 */         String str = txtscan.nextLine();
/* 215 */         this.jTextPane2.setText(str);
/* 216 */         txtscan2 = new java.util.Scanner(file);
/* 217 */         continue;       }
/*     */     }
/*     */     else {
/* 225 */       java.util.Scanner txtscan = new java.util.Scanner(file);
/* 226 */       String words = this.jTextField2.getText();
/* 227 */       while (txtscan.hasNextLine()) {
/* 228 */         String str = txtscan.nextLine();
/* 229 */         if (str.contains(words)) {
/* 230 */           this.textArea1.append(this.jTextField2.getText() + " ||||||||| " + file.getName() + " ||||||||| " + str + "\n");
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private void jButton1ActionPerformed(java.awt.event.ActionEvent evt)
/*     */   {
/* 241 */     new Thread()
/*     */     {
/*     */       public void run()
/*     */       {
/* 239 */         GuiOfflineCheckerDB.this.findFile(new java.io.File(GuiOfflineCheckerDB.this.jTextField1.getText()));
/*     */       }
/*     */     }.start();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {}
/*     */   
/*     */ 
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/*     */     try
/*     */     {
/*     */       javax.swing.UIManager.LookAndFeelInfo[] arrayOfLookAndFeelInfo;
/*     */       
/*     */ 
/* 258 */       int j = (arrayOfLookAndFeelInfo = javax.swing.UIManager.getInstalledLookAndFeels()).length; for (int i = 0; i < j; i++) { javax.swing.UIManager.LookAndFeelInfo info = arrayOfLookAndFeelInfo[i];
/* 259 */         if ("Nimbus".equals(info.getName())) {
/* 260 */           javax.swing.UIManager.setLookAndFeel(info.getClassName());
/* 261 */           break;
/*     */         }
/*     */       }
/*     */     } catch (ClassNotFoundException ex) {
/* 265 */       java.util.logging.Logger.getLogger(GuiOfflineCheckerDB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
/*     */     } catch (InstantiationException ex) {
/* 267 */       java.util.logging.Logger.getLogger(GuiOfflineCheckerDB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
/*     */     } catch (IllegalAccessException ex) {
/* 269 */       java.util.logging.Logger.getLogger(GuiOfflineCheckerDB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
/*     */     } catch (javax.swing.UnsupportedLookAndFeelException ex) {
/* 271 */       java.util.logging.Logger.getLogger(GuiOfflineCheckerDB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 277 */     java.awt.EventQueue.invokeLater(new Runnable() {
/*     */       public void run() {
/* 279 */         new GuiOfflineCheckerDB().setVisible(true);
/*     */       }
/*     */     });
/*     */   }
/*     */ }


/* Location:              C:\Users\User\Desktop\Crasher.jar!\jessica\gui\GuiOfflineCheckerDB.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */