/*    */ package slientclient.gui;
/*    */ 
/*    */ import javax.swing.GroupLayout;
/*    */ 
/*    */ public class GuiText extends javax.swing.JFrame {
/*    */   public java.awt.TextArea textArea1;
/*    */   
/*  8 */   public GuiText() { initComponents(); }
/*    */   
/*    */ 
/*    */ 
/*    */   private void initComponents()
/*    */   {
/* 14 */     this.textArea1 = new java.awt.TextArea();
/*    */     
/* 16 */     setTitle("Result");
/*    */     
/* 18 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 19 */     getContentPane().setLayout(layout);
/* 20 */     layout.setHorizontalGroup(
/* 21 */       layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
/* 22 */       .addGroup(layout.createSequentialGroup()
/* 23 */       .addContainerGap()
/* 24 */       .addComponent(this.textArea1, -1, 619, 32767)
/* 25 */       .addContainerGap()));
/*    */     
/* 27 */     layout.setVerticalGroup(
/* 28 */       layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
/* 29 */       .addGroup(layout.createSequentialGroup()
/* 30 */       .addContainerGap()
/* 31 */       .addComponent(this.textArea1, -1, 330, 32767)
/* 32 */       .addContainerGap()));
/*    */     
/*    */ 
/* 35 */     pack();
/*    */   }
/*    */ }
