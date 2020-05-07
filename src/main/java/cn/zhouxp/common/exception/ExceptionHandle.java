/*    */ package cn.zhouxp.common.exception;
/*    */ 
/*    */ import cn.zhouxp.common.model.R;
/*    */ import org.apache.shiro.authc.AuthenticationException;
/*    */ import org.apache.shiro.authc.IncorrectCredentialsException;
/*    */ import org.apache.shiro.authc.UnknownAccountException;
/*    */ import org.apache.shiro.authz.AuthorizationException;
/*    */ import org.slf4j.Logger;
/*    */ import org.slf4j.LoggerFactory;
/*    */ import org.springframework.dao.TransientDataAccessResourceException;
/*    */ import org.springframework.web.bind.annotation.ExceptionHandler;
/*    */ import org.springframework.web.bind.annotation.RestControllerAdvice;

/*    */ @RestControllerAdvice
/*    */ public class ExceptionHandle
/*    */ {
/* 21 */   private static final Logger log = LoggerFactory.getLogger(ExceptionHandle.class);

/*    */   @ExceptionHandler({Exception.class})
/*    */   public R exception(Exception e) {
/* 26 */     log.error(e.getMessage());
/* 27 */     return R.ERROR("系统错误,请与管理员联系");
/*    */   }
/*    */   @ExceptionHandler({RRException.class})
/* 32 */   public R exception(RRException e) { return R.ERROR(e.getMessage()); }
/*    */
/*    */   @ExceptionHandler({TransientDataAccessResourceException.class})
/*    */   public R pcketTooBigException(TransientDataAccessResourceException e) {
/* 37 */     if (e.getMessage().contains("max_allowed_packet")) {
/* 38 */       return R.ERROR("上传文件不能大于4MB");
/*    */     }
/* 40 */     return R.ERROR("系统错误,请与管理员联系");
/*    */   }
/*    */   
/*    */   @ExceptionHandler({AuthorizationException.class})
/* 44 */   public R authorizationException(AuthorizationException e) { return R.ERROR("没有授权！"); }

/*    */   @ExceptionHandler({IncorrectCredentialsException.class})
/* 49 */   public R authenticationException(IncorrectCredentialsException e) { return R.ERROR("账号或密码不正确"); }

/*    */   @ExceptionHandler({AuthenticationException.class})
/* 54 */   public R authenticationException(AuthenticationException e) { return R.ERROR("账号或密码不正确"); }

/*    */   @ExceptionHandler({UnknownAccountException.class})
/* 59 */   public R authorizationException(UnknownAccountException e) { return R.ERROR(e.getMessage()); }
/*    */ }
