/*    */ package cn.zhouxp.common.exception;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RRException
/*    */   extends RuntimeException
/*    */ {
/*    */   public RRException() {}
/*    */   
/* 13 */   public RRException(String message) { super(message); }
/*    */ 
/*    */ 
/*    */   
/* 17 */   public RRException(String message, Throwable cause) { super(message, cause); }
/*    */ 
/*    */ 
/*    */   
/* 21 */   public RRException(Throwable cause) { super(cause); }
/*    */ 
/*    */ 
/*    */   
/* 25 */   protected RRException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) { super(message, cause, enableSuppression, writableStackTrace); }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\classes\!\cn\zhouxp\common\exception\RRException.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */