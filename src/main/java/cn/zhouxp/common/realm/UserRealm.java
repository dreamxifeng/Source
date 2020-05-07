/*    */ package cn.zhouxp.common.realm;

import cn.zhouxp.sys.domapper.PermissomDoMapper;
import cn.zhouxp.sys.mapper.UserMapper;
import cn.zhouxp.sys.model.User;
import cn.zhouxp.sys.model.UserExample;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.thymeleaf.util.StringUtils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*    */ @Component
/*    */ public class UserRealm
/*    */   extends AuthorizingRealm
/*    */ {
/*    */   @Autowired
/*    */   private UserMapper userMapper;
/*    */   @Autowired
/*    */   private PermissomDoMapper permissomDoMapper;
/*    */
/*    */   protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
/* 40 */     User user = (User)principalCollection.getPrimaryPrincipal();
/* 41 */     Long userId = user.getId();
/*    */
/* 43 */     List<String> permsList = this.permissomDoMapper.getPermByUserid(userId);
/*    */
/* 45 */     Set<String> permsSet = new HashSet<>();
/* 46 */     for (String perms : permsList) {
/* 47 */       if (StringUtils.isEmpty(perms)) {
/*    */         continue;
/*    */       }
/* 50 */       permsSet.addAll(Arrays.asList(perms.trim().split(",")));
/*    */     }
/*    */
/* 53 */     SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
/* 54 */     info.setStringPermissions(permsSet);
/* 55 */     return info;
/*    */   }

/*    */   protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
/* 60 */     UsernamePasswordToken token = (UsernamePasswordToken)authenticationToken;
/*    */
/* 62 */     UserExample userExample = new UserExample();
/*    */
/* 64 */     userExample.createCriteria().andCnameEqualTo(token.getUsername().toUpperCase());
/*    */
/* 66 */     List<User> users = this.userMapper.selectByExample(userExample);
/*    */
//             System.out.println(users.size()+"让阿发发发嘎嘎嘎嘎嘎");
/* 68 */     if (users.size() == 0) {
/* 69 */       throw new UnknownAccountException("账号或密码不正确");
/*    */     }
/* 71 */     User user = users.get(0);
                System.out.println(user.toString());
/* 72 */     SimpleAuthenticationInfo info =
            new SimpleAuthenticationInfo(user,user.getPassword(), ByteSource.Util.bytes(user.getCname()),getName());
/* 73 */     return (AuthenticationInfo)info;
/*    */   }
/*    */
/*    */   public void setCredentialsMatcher(CredentialsMatcher credentialsMatcher) {
/* 77 */     HashedCredentialsMatcher shaCredentialsMatcher = new HashedCredentialsMatcher();
/* 78 */     shaCredentialsMatcher.setHashAlgorithmName("SHA-256");
/* 79 */     shaCredentialsMatcher.setHashIterations(16);
/* 80 */     super.setCredentialsMatcher((CredentialsMatcher)shaCredentialsMatcher);
/*    */   }
/*    */ }
