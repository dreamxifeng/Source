/*    */ package cn.zhouxp.common.utils;
/*    */ 
/*    */ import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/*    */
/*    */

/*    */ public class HttpContextUtils
/*    */ {
/* 19 */   public static HttpServletRequest getHttpServletRequest() { return ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest(); }
/*    */ }
