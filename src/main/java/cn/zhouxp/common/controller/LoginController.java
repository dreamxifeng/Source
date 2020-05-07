/*    */ package cn.zhouxp.common.controller;
/*    */ 
/*    */

import cn.zhouxp.common.model.R;
import cn.zhouxp.common.utils.ShiroUtils;
import cn.zhouxp.sys.service.UserService;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/*    */ @Controller
/*    */ public class LoginController {
/*    */   @Autowired
/*    */   private UserService userService;

/*    */   @GetMapping({"/login", "/"})
/* 25 */   public String login() { return "login"; }

/*    */   @PostMapping({"/modifyPassword"})
/*    */   @ResponseBody
/* 31 */   public R modifyPassword(String newPassword, String oldPassword)
            { return this.userService.modifyPassword(newPassword, oldPassword); }
/*    */   @PostMapping({"login"})
/*    */   @ResponseBody
/*    */   public R login(HttpSession request, String userName, String password, String veryCode) {

    String checkcode= (String) request.getAttribute("checkcode");
    System.out.println(veryCode+"=============="+(checkcode));
            if (checkcode.equals(veryCode)){
                Subject subject = ShiroUtils.getSubject();
                UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
                subject.login((AuthenticationToken)token);
                return R.OK();
            }else {
                return R.ERROR("验证码错误");
            }
    }

/*    */   @GetMapping({"logout"})
/*    */   public String logout() {
/* 48 */     ShiroUtils.logout();
/* 49 */     return "redirect:login";
/*    */   }
/*    */ }
