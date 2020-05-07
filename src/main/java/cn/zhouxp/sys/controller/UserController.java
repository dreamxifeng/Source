/*    */ package cn.zhouxp.sys.controller;
/*    */ 
/*    */

import cn.zhouxp.common.model.EUPageResult;
import cn.zhouxp.common.model.PageBean;
import cn.zhouxp.common.model.R;
import cn.zhouxp.sys.model.User;
import cn.zhouxp.sys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Controller
/*    */ @RequestMapping({"sys/user"})
/*    */ public class UserController
/*    */ {
/*    */   @Autowired
/*    */   private UserService userService;
/*    */   
/*    */   @GetMapping({"page"})
/* 31 */   public String page() { return "sys/user"; }
/*    */ 
/*    */   
/*    */   @GetMapping
/*    */   @ResponseBody
/* 36 */   public EUPageResult<User> list(String userName, PageBean pageBean) { return this.userService.list(userName, pageBean); }
/*    */ 
/*    */ 
/*    */   
/*    */   @PostMapping
/*    */   @ResponseBody
/* 42 */   public R save(User user) { return this.userService.save(user); }
/*    */ 
/*    */ 
/*    */   
/*    */   @PostMapping({"delete"})
/*    */   @ResponseBody
/* 48 */   public R delete(Long userid) { return this.userService.delete(userid); }
/*    */ 
/*    */ 
/*    */   
/*    */   @PostMapping({"saveRoleSet"})
/*    */   @ResponseBody
/* 54 */   public R saveRoleSet(String roleIds, String roleNames, Long userId) { return this.userService.saveRoleSet(roleIds, roleNames, userId); }
/*    */ 
/*    */ 
/*    */   
/*    */   @GetMapping({"listall"})
/*    */   @ResponseBody
/* 60 */   public List<User> listall(String roleIds, String roleNames, Long userId) { return this.userService.selectByExample(); }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\classes\!\cn\zhouxp\sys\controller\UserController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */