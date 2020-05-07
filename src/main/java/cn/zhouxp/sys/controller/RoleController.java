/*    */ package cn.zhouxp.sys.controller;
/*    */ 
/*    */

import cn.zhouxp.common.model.EUPageResult;
import cn.zhouxp.common.model.PageBean;
import cn.zhouxp.common.model.R;
import cn.zhouxp.sys.model.Role;
import cn.zhouxp.sys.service.RoleService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
/*    */ @RequestMapping({"sys/role"})
/*    */ public class RoleController
/*    */ {
/*    */   @Autowired
/*    */   private RoleService roleService;
/*    */   
/*    */   @GetMapping({"page"})
/*    */   @RequiresPermissions({"sys:role:page"})
/* 27 */   public String topage() { return "sys/role"; }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @GetMapping
/*    */   @ResponseBody
/*    */   @RequiresPermissions({"sys:role:list"})
/* 35 */   public EUPageResult<Role> list(PageBean pageBean, String name) { return this.roleService.list(pageBean, name); }
/*    */ 
/*    */ 
/*    */   
/*    */   @PostMapping
/*    */   @ResponseBody
/*    */   @RequiresPermissions({"sys:role:sava"})
/* 42 */   public R save(Role role) { return this.roleService.save(role); }
/*    */ 
/*    */   
/*    */   @RequiresPermissions({"sys:role:delete"})
/*    */   @PostMapping({"delete"})
/*    */   @ResponseBody
/* 48 */   public R delete(Long id) { return this.roleService.delete(id); }
/*    */ 
/*    */ 
/*    */   
/*    */   @RequiresPermissions({"sys:role:deleteAll"})
/*    */   @PostMapping({"deleteAll"})
/*    */   @ResponseBody
/* 55 */   public R deleteAll(String ids) { return this.roleService.deleteAll(ids); }
/*    */ 
/*    */ 
/*    */   
/*    */   @GetMapping({"getAll"})
/*    */   @RequiresPermissions({"sys:role:getAll"})
/*    */   @ResponseBody
/* 62 */   public EUPageResult<Role> getAll() { return this.roleService.getAll(); }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\classes\!\cn\zhouxp\sys\controller\RoleController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */