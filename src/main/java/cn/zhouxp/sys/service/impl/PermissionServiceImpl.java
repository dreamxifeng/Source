/*    */ package cn.zhouxp.sys.service.impl;
/*    */ 
/*    */

import cn.zhouxp.common.model.EUAttributes;
import cn.zhouxp.common.model.EUNode;
import cn.zhouxp.common.model.R;
import cn.zhouxp.common.service.BaseService;
import cn.zhouxp.sys.domapper.PermissomDoMapper;
import cn.zhouxp.sys.model.Permission;
import cn.zhouxp.sys.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
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

/*    */ @Service
/*    */ public class PermissionServiceImpl
/*    */   extends BaseService
/*    */   implements PermissionService
/*    */ {
/*    */   @Autowired
/*    */   private PermissomDoMapper permissomDoMapper;
/*    */   
/*    */   public List<EUNode> getMenu() {
/* 31 */     List<Permission> perms = this.permissomDoMapper.getMenu(this.opid);
/* 32 */     List<EUNode> nodes = new ArrayList<>();
/* 33 */     createNode(perms, nodes, Long.valueOf(-1L));
/* 34 */     return nodes;
/*    */   }
/*    */ 
/*    */   
/*    */   public List<EUNode> getRight(Long roleid) {
/* 39 */     List<Permission> perms = this.permissomDoMapper.getRight(roleid);
/* 40 */     List<EUNode> nodes = new ArrayList<>();
/* 41 */     createNode(perms, nodes, Long.valueOf(-1L));
/* 42 */     return nodes;
/*    */   }
/*    */ 
/*    */   
/*    */   @Transactional
/*    */   public R saveRolePerms(String menuIds, Long roleId) {
/* 48 */     this.permissomDoMapper.deleteRolePerms(roleId);
/* 49 */     this.permissomDoMapper.insertRolePerms(roleId, menuIds);
/* 50 */     return R.OK();
/*    */   }
/*    */   
/*    */   private void createNode(List<Permission> perms, List<EUNode> nodes, Long pid) {
/* 54 */     for (Permission perm : perms) {
/* 55 */       if (perm.getPid().equals(pid)) {
/* 56 */         EUNode node = new EUNode();
/* 57 */         node.setId(perm.getId());
/* 58 */         node.setText(perm.getCname());
/* 59 */         node.setIconCls(perm.getIcon());
/* 60 */         node.setChildren(new ArrayList());
/* 61 */         node.setChecked(perm.getIsdel());
/* 62 */         createNode(perms, node.getChildren(), perm.getId());
/* 63 */         if (node.getChildren().size() > 0) {
/* 64 */           node.setState("closed");
/*    */         } else {
/* 66 */           node.setState("open");
/* 67 */           if (!StringUtils.isEmpty(perm.getUrl())) {
/* 68 */             node.setAttributes(new EUAttributes(perm.getUrl()));
/*    */           }
/*    */         } 
/* 71 */         nodes.add(node);
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\classes\!\cn\zhouxp\sys\service\impl\PermissionServiceImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */