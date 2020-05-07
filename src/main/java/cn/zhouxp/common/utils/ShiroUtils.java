/*    */ package cn.zhouxp.common.utils;
/*    */ 
/*    */

/*    */

import cn.zhouxp.sys.model.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

/*    */ public class ShiroUtils
/*    */ {
/*    */   public static final String hashAlgorithmName = "SHA-256";
/*    */   public static final int hashIterations = 16;
/*    */   
/* 22 */   public static String sha256(String password, String salt) { return (new SimpleHash("SHA-256", password, salt, 16)).toString(); }
/*    */ 
/*    */ 
/*    */   
/* 26 */   public static Session getSession() { return SecurityUtils.getSubject().getSession(); }
/*    */ 
/*    */ 
/*    */   
/* 30 */   public static Subject getSubject() { return SecurityUtils.getSubject(); }

/* 34 */   public static User getUser() { return (User)SecurityUtils.getSubject().getPrincipal(); }

/* 38 */   public static Long getUserId() { return getUser().getId(); }

/* 42 */   public static void setSessionAttribute(Object key, Object value) { getSession().setAttribute(key, value); }

/* 46 */   public static Object getSessionAttribute(Object key) { return getSession().getAttribute(key); }

/* 50 */   public static boolean isLogin() { return (SecurityUtils.getSubject().getPrincipal() != null); }

/* 54 */   public static void logout() { SecurityUtils.getSubject().logout(); }

/* 67 */   public static void main(String[] args) { System.out.println(sha256("1", "ADMIN")); }
/*    */ }
