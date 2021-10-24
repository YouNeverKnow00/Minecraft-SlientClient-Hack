/*    */ package slientclient.utils;
/*    */ 
/*    */ import java.util.Collections;
/*    */ import java.util.List;
/*    */ import java.util.concurrent.CopyOnWriteArrayList;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Manager<Type>
/*    */ {
/* 12 */   private final CopyOnWriteArrayList<Type> list = new CopyOnWriteArrayList();
/*    */   
/*    */   public void add(Type object)
/*    */   {
/* 16 */     this.list.add(object);
/*    */   }
/*    */   
/*    */   public void clear()
/*    */   {
/* 21 */     this.list.clear();
/*    */   }
/*    */   
/*    */   public List<Type> getList()
/*    */   {
/* 26 */     return Collections.unmodifiableList(this.list);
/*    */   }
/*    */   
/*    */   public void remove(Type object)
/*    */   {
/* 31 */     this.list.remove(object);
/*    */   }
/*    */ }