/*    */ package slientclient.utils;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.util.List;
/*    */ 
/*    */ public class FileUtils
/*    */ {
/*    */   /* Error */
/*    */   public static synchronized void readFile(File file)
/*    */   {
/*    */     // Byte code:
/*    */     //   0: new 18	java/util/ArrayList
/*    */     //   3: dup
/*    */     //   4: invokespecial 20	java/util/ArrayList:<init>	()V
/*    */     //   7: astore_1
/*    */     //   8: new 21	java/io/FileReader
/*    */     //   11: dup
/*    */     //   12: aload_0
/*    */     //   13: invokespecial 23	java/io/FileReader:<init>	(Ljava/io/File;)V
/*    */     //   16: astore_2
/*    */     //   17: goto +19 -> 36
/*    */     //   20: astore_3
/*    */     //   21: invokestatic 26	net/wolframclient/Wolfram:getWolfram	()Lnet/wolframclient/Wolfram;
/*    */     //   24: getfield 32	net/wolframclient/Wolfram:logger	Lnet/wolframclient/utils/Logger;
/*    */     //   27: aload_3
/*    */     //   28: invokevirtual 36	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
/*    */     //   31: invokevirtual 42	net/wolframclient/utils/Logger:error	(Ljava/lang/String;)V
/*    */     //   34: aload_1
/*    */     //   35: areturn
/*    */     //   36: aconst_null
/*    */     //   37: astore_3
/*    */     //   38: new 48	java/io/BufferedReader
/*    */     //   41: dup
/*    */     //   42: aload_2
/*    */     //   43: invokespecial 50	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
/*    */     //   46: astore_3
/*    */     //   47: goto +12 -> 59
/*    */     //   50: aload_1
/*    */     //   51: aload 4
/*    */     //   53: invokeinterface 53 2 0
/*    */     //   58: pop
/*    */     //   59: aload_3
/*    */     //   60: invokevirtual 59	java/io/BufferedReader:readLine	()Ljava/lang/String;
/*    */     //   63: dup
/*    */     //   64: astore 4
/*    */     //   66: ifnonnull -16 -> 50
/*    */     //   69: goto +54 -> 123
/*    */     //   72: astore 4
/*    */     //   74: aload 4
/*    */     //   76: invokevirtual 62	java/lang/Exception:printStackTrace	()V
/*    */     //   79: aload_3
/*    */     //   80: ifnull +61 -> 141
/*    */     //   83: aload_3
/*    */     //   84: invokevirtual 67	java/io/BufferedReader:close	()V
/*    */     //   87: goto +54 -> 141
/*    */     //   90: astore 6
/*    */     //   92: aload 6
/*    */     //   94: invokevirtual 70	java/io/IOException:printStackTrace	()V
/*    */     //   97: goto +44 -> 141
/*    */     //   100: astore 5
/*    */     //   102: aload_3
/*    */     //   103: ifnull +17 -> 120
/*    */     //   106: aload_3
/*    */     //   107: invokevirtual 67	java/io/BufferedReader:close	()V
/*    */     //   110: goto +10 -> 120
/*    */     //   113: astore 6
/*    */     //   115: aload 6
/*    */     //   117: invokevirtual 70	java/io/IOException:printStackTrace	()V
/*    */     //   120: aload 5
/*    */     //   122: athrow
/*    */     //   123: aload_3
/*    */     //   124: ifnull +17 -> 141
/*    */     //   127: aload_3
/*    */     //   128: invokevirtual 67	java/io/BufferedReader:close	()V
/*    */     //   131: goto +10 -> 141
/*    */     //   134: astore 6
/*    */     //   136: aload 6
/*    */     //   138: invokevirtual 70	java/io/IOException:printStackTrace	()V
/*    */     //   141: aload_1
/*    */     //   142: areturn
/*    */     // Line number table:
/*    */     //   Java source line #21	-> byte code offset #0
/*    */     //   Java source line #26	-> byte code offset #8
/*    */     //   Java source line #27	-> byte code offset #17
/*    */     //   Java source line #29	-> byte code offset #21
/*    */     //   Java source line #30	-> byte code offset #34
/*    */     //   Java source line #33	-> byte code offset #36
/*    */     //   Java source line #36	-> byte code offset #38
/*    */     //   Java source line #37	-> byte code offset #47
/*    */     //   Java source line #38	-> byte code offset #50
/*    */     //   Java source line #37	-> byte code offset #59
/*    */     //   Java source line #39	-> byte code offset #69
/*    */     //   Java source line #41	-> byte code offset #74
/*    */     //   Java source line #44	-> byte code offset #79
/*    */     //   Java source line #47	-> byte code offset #83
/*    */     //   Java source line #48	-> byte code offset #87
/*    */     //   Java source line #50	-> byte code offset #92
/*    */     //   Java source line #43	-> byte code offset #100
/*    */     //   Java source line #44	-> byte code offset #102
/*    */     //   Java source line #47	-> byte code offset #106
/*    */     //   Java source line #48	-> byte code offset #110
/*    */     //   Java source line #50	-> byte code offset #115
/*    */     //   Java source line #52	-> byte code offset #120
/*    */     //   Java source line #44	-> byte code offset #123
/*    */     //   Java source line #47	-> byte code offset #127
/*    */     //   Java source line #48	-> byte code offset #131
/*    */     //   Java source line #50	-> byte code offset #136
/*    */     //   Java source line #53	-> byte code offset #141
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	signature
/*    */     //   0	143	0	file	File
/*    */     //   7	135	1	tempList	List<String>
/*    */     //   16	2	2	fileReader	java.io.FileReader
/*    */     //   36	7	2	fileReader	java.io.FileReader
/*    */     //   20	8	3	e	java.io.FileNotFoundException
/*    */     //   37	91	3	reader	java.io.BufferedReader
/*    */     //   50	2	4	line	String
/*    */     //   64	3	4	line	String
/*    */     //   72	3	4	e	Exception
/*    */     //   100	21	5	localObject	Object
/*    */     //   90	3	6	e	java.io.IOException
/*    */     //   113	3	6	e	java.io.IOException
/*    */     //   134	3	6	e	java.io.IOException
/*    */     // Exception table:
/*    */     //   from	to	target	type
/*    */     //   8	17	20	java/io/FileNotFoundException
/*    */     //   38	69	72	java/lang/Exception
/*    */     //   83	87	90	java/io/IOException
/*    */     //   38	79	100	finally
/*    */     //   106	110	113	java/io/IOException
/*    */     //   127	131	134	java/io/IOException
/*    */   }
/*    */   
/*    */   public static synchronized void writeToFile(File file, List<String> text)
/*    */   {
/* 59 */     writeToFile(file, (String[])text.toArray(new String[text.size()]));
/*    */   }
/*    */   
/*    */   /* Error */
/*    */   public static synchronized void writeToFile(File file, String[] text)
/*    */   {
/*    */     // Byte code:
/*    */     //   0: aconst_null
/*    */     //   1: astore_2
/*    */     //   2: new 113	java/io/PrintWriter
/*    */     //   5: dup
/*    */     //   6: new 115	java/io/FileWriter
/*    */     //   9: dup
/*    */     //   10: aload_0
/*    */     //   11: invokespecial 117	java/io/FileWriter:<init>	(Ljava/io/File;)V
/*    */     //   14: invokespecial 118	java/io/PrintWriter:<init>	(Ljava/io/Writer;)V
/*    */     //   17: astore_2
/*    */     //   18: aload_1
/*    */     //   19: dup
/*    */     //   20: astore 6
/*    */     //   22: arraylength
/*    */     //   23: istore 5
/*    */     //   25: iconst_0
/*    */     //   26: istore 4
/*    */     //   28: goto +21 -> 49
/*    */     //   31: aload 6
/*    */     //   33: iload 4
/*    */     //   35: aaload
/*    */     //   36: astore_3
/*    */     //   37: aload_2
/*    */     //   38: aload_3
/*    */     //   39: invokevirtual 121	java/io/PrintWriter:println	(Ljava/lang/String;)V
/*    */     //   42: aload_2
/*    */     //   43: invokevirtual 124	java/io/PrintWriter:flush	()V
/*    */     //   46: iinc 4 1
/*    */     //   49: iload 4
/*    */     //   51: iload 5
/*    */     //   53: if_icmplt -22 -> 31
/*    */     //   56: goto +41 -> 97
/*    */     //   59: astore_3
/*    */     //   60: invokestatic 26	net/wolframclient/Wolfram:getWolfram	()Lnet/wolframclient/Wolfram;
/*    */     //   63: getfield 32	net/wolframclient/Wolfram:logger	Lnet/wolframclient/utils/Logger;
/*    */     //   66: aload_3
/*    */     //   67: invokevirtual 127	java/lang/Exception:getMessage	()Ljava/lang/String;
/*    */     //   70: invokevirtual 42	net/wolframclient/utils/Logger:error	(Ljava/lang/String;)V
/*    */     //   73: aload_2
/*    */     //   74: ifnull +31 -> 105
/*    */     //   77: aload_2
/*    */     //   78: invokevirtual 128	java/io/PrintWriter:close	()V
/*    */     //   81: goto +24 -> 105
/*    */     //   84: astore 7
/*    */     //   86: aload_2
/*    */     //   87: ifnull +7 -> 94
/*    */     //   90: aload_2
/*    */     //   91: invokevirtual 128	java/io/PrintWriter:close	()V
/*    */     //   94: aload 7
/*    */     //   96: athrow
/*    */     //   97: aload_2
/*    */     //   98: ifnull +7 -> 105
/*    */     //   101: aload_2
/*    */     //   102: invokevirtual 128	java/io/PrintWriter:close	()V
/*    */     //   105: return
/*    */     // Line number table:
/*    */     //   Java source line #65	-> byte code offset #0
/*    */     //   Java source line #68	-> byte code offset #2
/*    */     //   Java source line #69	-> byte code offset #18
/*    */     //   Java source line #71	-> byte code offset #37
/*    */     //   Java source line #72	-> byte code offset #42
/*    */     //   Java source line #69	-> byte code offset #46
/*    */     //   Java source line #74	-> byte code offset #56
/*    */     //   Java source line #76	-> byte code offset #60
/*    */     //   Java source line #79	-> byte code offset #73
/*    */     //   Java source line #80	-> byte code offset #77
/*    */     //   Java source line #78	-> byte code offset #84
/*    */     //   Java source line #79	-> byte code offset #86
/*    */     //   Java source line #80	-> byte code offset #90
/*    */     //   Java source line #81	-> byte code offset #94
/*    */     //   Java source line #79	-> byte code offset #97
/*    */     //   Java source line #80	-> byte code offset #101
/*    */     //   Java source line #82	-> byte code offset #105
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	signature
/*    */     //   0	106	0	file	File
/*    */     //   0	106	1	text	String[]
/*    */     //   1	101	2	writer	java.io.PrintWriter
/*    */     //   36	3	3	line	String
/*    */     //   59	8	3	localException	Exception
/*    */     //   26	28	4	i	int
/*    */     //   23	31	5	j	int
/*    */     //   20	12	6	arrayOfString	String[]
/*    */     //   84	11	7	localObject	Object
/*    */     // Exception table:
/*    */     //   from	to	target	type
/*    */     //   2	56	59	java/lang/Exception
/*    */     //   2	73	84	finally
/*    */   }
/*    */ }