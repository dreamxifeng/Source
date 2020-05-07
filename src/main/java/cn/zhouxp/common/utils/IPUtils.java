/*    */ package cn.zhouxp.common.utils;
/*    */ 
/*    */ import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

/*    */ public class IPUtils
/*    */ {
/* 24 */   private static Logger logger = LoggerFactory.getLogger(IPUtils.class);

/*    */   public static String getIpAddr(HttpServletRequest request) {
/* 33 */     String ip = null;
/*    */     try {
/* 35 */       ip = request.getHeader("x-forwarded-for");
/* 36 */       if (StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
/* 37 */         ip = request.getHeader("Proxy-Client-IP");
/*    */       }
/* 39 */       if (StringUtils.isEmpty(ip) || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
/* 40 */         ip = request.getHeader("WL-Proxy-Client-IP");
/*    */       }
/* 42 */       if (StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
/* 43 */         ip = request.getHeader("HTTP_CLIENT_IP");
/*    */       }
/* 45 */       if (StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
/* 46 */         ip = request.getHeader("HTTP_X_FORWARDED_FOR");
/*    */       }
/* 48 */       if (StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
/* 49 */         ip = request.getRemoteAddr();
/*    */       }
/* 51 */     } catch (Exception e) {
/* 52 */       logger.error("IPUtils ERROR ", e);
/*    */     } 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 62 */     return ip;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\classes\!\cn\zhouxp\commo\\utils\IPUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */