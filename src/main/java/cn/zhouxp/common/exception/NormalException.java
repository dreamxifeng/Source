/*    */ package cn.zhouxp.common.exception;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class NormalException
/*    */   extends RuntimeException
/*    */ {
/*    */   public NormalException() {}
/*    */   
/* 13 */   public NormalException(String message) { super(message); }
/*    */ 
/*    */ 
/*    */   
/* 17 */   public NormalException(String message, Throwable cause) { super(message, cause); }
/*    */ 
/*    */ 
/*    */   
/* 21 */   public NormalException(Throwable cause) { super(cause); }
/*    */ 
/*    */ 
/*    */   
/* 25 */   protected NormalException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) { super(message, cause, enableSuppression, writableStackTrace); }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\classes\!\cn\zhouxp\common\exception\NormalException.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */