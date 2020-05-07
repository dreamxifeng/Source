/*    */ package cn.zhouxp.common.config;
/*    */ 
/*    */ import cn.zhouxp.common.realm.UserRealm;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.apache.shiro.web.session.mgt.ServletContainerSessionManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;
/*    */ @Configuration
/*    */ public class ShiroConfig
/*    */ {
/*    */   @Bean
/*    */   @ConditionalOnProperty(prefix = "3T", name = {"cluster"}, havingValue = "false")
/*    */   public DefaultWebSessionManager sessionManager(@Value("${3T.globalSessionTimeout}") long globalSessionTimeout) {
/* 33 */     DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
/* 34 */     sessionManager.setSessionValidationSchedulerEnabled(true);
/* 35 */     sessionManager.setSessionIdUrlRewritingEnabled(false);
/* 36 */     sessionManager.setSessionValidationInterval(globalSessionTimeout * 1000L);
/* 37 */     sessionManager.setGlobalSessionTimeout(globalSessionTimeout * 1000L);
/*    */     
/* 39 */     return sessionManager;
/*    */   }

/*    */   @Bean
/*    */   @ConditionalOnProperty(prefix = "3T", name = {"cluster"}, havingValue = "true")
/* 48 */   public ServletContainerSessionManager servletContainerSessionManager() { return new ServletContainerSessionManager(); }
/*    */ 
/*    */   
/*    */   @Bean({"securityManager"})
/*    */   public SecurityManager securityManager(UserRealm userRealm, SessionManager sessionManager) {
/* 53 */     DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
/* 54 */     securityManager.setRealm((Realm)userRealm);
/* 55 */     securityManager.setSessionManager(sessionManager);
/* 56 */     securityManager.setRememberMeManager(null);
/*    */     
/* 58 */     return (SecurityManager)securityManager;
/*    */   }
/*    */
/*    */   @Bean({"shiroFilter"})
/*    */   public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
/* 64 */     ShiroFilterFactoryBean shiroFilter = new ShiroFilterFactoryBean();
/* 65 */     shiroFilter.setSecurityManager(securityManager);
/* 66 */     shiroFilter.setLoginUrl("/login");
/* 67 */     shiroFilter.setUnauthorizedUrl("/");
/*    */     
/* 69 */     Map<String, String> filterMap = new LinkedHashMap<>();
/* 70 */     filterMap.put("/swagger/**", "anon");
/* 71 */     filterMap.put("/v2/api-docs", "anon");
/* 72 */     filterMap.put("/swagger-ui.html", "anon");
/* 73 */     filterMap.put("/webjars/**", "anon");
/* 74 */     filterMap.put("/swagger-resources/**", "anon");
/*    */     
/* 76 */     filterMap.put("/js/**", "anon");
/* 77 */     filterMap.put("/easyui/**", "anon");
/* 78 */     filterMap.put("/images/**", "anon");
/* 79 */     filterMap.put("/css/**", "anon");
/* 80 */     filterMap.put("/login", "anon");
/* 82 */     filterMap.put("/favicon.ico", "anon");
/* 83 */     filterMap.put("/drawImage", "anon");
/* 84 */     filterMap.put("/**", "authc");
/* 85 */     shiroFilter.setFilterChainDefinitionMap(filterMap);
/*    */     
/* 87 */     return shiroFilter;
/*    */   }
/*    */   
/*    */   @Bean({"lifecycleBeanPostProcessor"})
/* 91 */   public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() { return new LifecycleBeanPostProcessor(); }
/*    */ 
/*    */   
/*    */   @Bean
/*    */   public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
/* 96 */     AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
/* 97 */     advisor.setSecurityManager(securityManager);
/* 98 */     return advisor;
/*    */   }
/*    */ }
