/*    */ package cn.zhouxp.sys.service.impl;
/*    */ 
/*    */

import cn.zhouxp.common.model.EUPageResult;
import cn.zhouxp.common.model.PageBean;
import cn.zhouxp.common.model.R;
import cn.zhouxp.common.service.BaseService;
import cn.zhouxp.sys.domapper.RoleDoMapper;
import cn.zhouxp.sys.mapper.RoleMapper;
import cn.zhouxp.sys.model.Role;
import cn.zhouxp.sys.model.RoleExample;
import cn.zhouxp.sys.service.RoleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
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
/*    */ @Service
/*    */ public class
RoleServiceImpl extends BaseService implements RoleService
/*    */ {
/*    */   @Autowired
/*    */   private RoleMapper roleMapper;
/*    */   @Autowired
/*    */   private RoleDoMapper roleDoMapper;
/*    */   
/*    */   public EUPageResult<Role> list(PageBean pageBean, String name) {
/* 33 */     RoleExample example = new RoleExample();
/*    */     
/* 35 */     RoleExample.Criteria criteria = example.createCriteria().andIsdelEqualTo(Boolean.valueOf(false));
/* 36 */     if (!StringUtils.isEmpty(name)) {
/* 37 */       criteria.andCnameLike("%" + name + "%");
/*    */     }
/* 39 */     PageHelper.startPage(pageBean.getPage().intValue(), pageBean.getRows().intValue());
/* 40 */     PageInfo<Role> info = new PageInfo(this.roleMapper.selectByExample(example));
/* 41 */     return new EUPageResult(Long.valueOf(info.getTotal()), info.getList());
/*    */   }
/*    */ 
/*    */   
/*    */   public R save(Role role) {
/* 46 */     role.setOpid(this.opid);
/* 47 */     role.setOptime(new Date());
/* 48 */     if (isRepeat(role)) {
/* 49 */       return R.ERROR("登录重复");
/*    */     }
/* 51 */     if (role.getId() != null) {
/* 52 */       this.roleMapper.updateByPrimaryKeySelective(role);
/*    */     } else {
/* 54 */       this.roleMapper.insertSelective(role);
/*    */     } 
/* 56 */     return R.OK();
/*    */   }
/*    */   private boolean isRepeat(Role role) {
/* 59 */     RoleExample example = new RoleExample();
/*    */ 
/*    */     
/* 62 */     RoleExample.Criteria criteria = example.createCriteria().andCnameEqualTo(role.getCname()).andIsdelEqualTo(Boolean.valueOf(false));
/* 63 */     if (role.getId() != null) {
/* 64 */       criteria.andIdNotEqualTo(role.getId());
/*    */     }
/* 66 */     List<Role> roles = this.roleMapper.selectByExample(example);
/* 67 */     if (roles.size() == 0) {
/* 68 */       return false;
/*    */     }
/* 70 */     return true;
/*    */   }
/*    */   
/*    */   public R delete(Long id) {
/* 74 */     Role role = new Role();
/* 75 */     role.setId(id);
/* 76 */     role.setIsdel(Boolean.valueOf(true));
/* 77 */     this.roleMapper.updateByPrimaryKeySelective(role);
/* 78 */     return R.OK();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public R deleteAll(String ids) {
/* 86 */     this.roleDoMapper.deleteAll(ids);
/* 87 */     return R.OK();
/*    */   }
/*    */ 
/*    */   
/*    */   public EUPageResult<Role> getAll() {
/* 92 */     RoleExample example = new RoleExample();
/* 93 */     example.createCriteria()
/* 94 */       .andIsdelEqualTo(Boolean.valueOf(false));
/* 95 */     return new EUPageResult(Long.valueOf(1L), this.roleMapper.selectByExample(example));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\classes\!\cn\zhouxp\sys\service\impl\RoleServiceImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */