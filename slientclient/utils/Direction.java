/*    */ package slientclient.utils;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Direction
/*    */ {
/*  7 */   public static final int[] offsetX = { 0, -1, 01 };
/*  8 */   public static final int[] offsetZ = { 1, 0-1 };
/*    */   
/* 10 */   public static final String[] directions = { "SOUTH", "WEST", "NORTH", "EAST" };
/* 11 */   public static final int[] directionToFacing = { 3, 4, 2, 5 };
/* 12 */   public static final int[] facingToDirection = { -1, -1, 2, 0, 1, 3 };
/* 13 */   public static final int[] rotateOpposite = { 2, 3, 01 };
/* 14 */   public static final int[] rotateRight = { 1, 2, 3 };
/* 15 */   public static final int[] rotateLeft = { 3, 0, 1, 2 };
/* 16 */   public static final int[][] bedDirection = { { 1, 0, 3, 2, 5, 4 }, 
/* 17 */     { 1, 0, 5, 4, 2, 3 }, { 1, 0, 2, 3, 4, 5 }, { 1, 0, 4, 5, 3, 2 } };
/*    */ }
