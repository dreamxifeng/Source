/*    */ package cn.zhouxp.sys.controller;
/*    */ 
/*    */ import cn.zhouxp.common.model.EUNode;
/*    */ import cn.zhouxp.common.model.R;
/*    */ import cn.zhouxp.sys.service.PermissionService;
/*    */ import java.util.List;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.web.bind.annotation.GetMapping;
/*    */ import org.springframework.web.bind.annotation.PostMapping;
/*    */ import org.springframework.web.bind.annotation.RequestMapping;
/*    */ import org.springframework.web.bind.annotation.RestController;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @RestController
/*    */ @RequestMapping({"sys/perm"})
/*    */ public class PermissionController
/*    */ {
/*    */   @Autowired
/*    */   private PermissionService permissionService;
/*    */   
/*    */   @GetMapping
/* 27 */   public List<EUNode> list() { return this.permissionService.getMenu(); }
/*    */ 
/*    */ 
/*    */   
/*    */   @GetMapping({"right"})
/* 32 */   public List<EUNode> getRight(Long roleid) { return this.permissionService.getRight(roleid); }
/*    */ 
/*    */ 
/*    */   
/*    */   @PostMapping({"saveRolePerms"})
/* 37 */   public R saveRolePerms(String menuIds, Long roleId) { return this.permissionService.saveRolePerms(menuIds, roleId); }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\classes\!\cn\zhouxp\sys\controller\PermissionController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */