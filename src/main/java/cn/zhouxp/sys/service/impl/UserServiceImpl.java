/*     */ package cn.zhouxp.sys.service.impl;
/*     */ 
/*     */

import cn.zhouxp.common.model.EUPageResult;
import cn.zhouxp.common.model.PageBean;
import cn.zhouxp.common.model.R;
import cn.zhouxp.common.service.BaseService;
import cn.zhouxp.common.utils.ShiroUtils;
import cn.zhouxp.sys.domapper.RoleDoMapper;
import cn.zhouxp.sys.mapper.UserMapper;
import cn.zhouxp.sys.model.User;
import cn.zhouxp.sys.model.UserExample;
import cn.zhouxp.sys.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

/*     */ @Service
/*     */ public class UserServiceImpl extends BaseService implements UserService
/*     */ {
/*     */   @Autowired
/*     */   private UserMapper userMapper;
/*     */   @Autowired
/*     */   private RoleDoMapper roleDoMapper;
/*     */   
/*     */   public EUPageResult<User> list(String userName, PageBean pageBean) {
/*  36 */     UserExample example = new UserExample();
/*     */ 
/*     */     
/*  39 */     UserExample.Criteria criteria = example.createCriteria().andIdNotEqualTo(Long.valueOf(1L)).andIsdelEqualTo(Boolean.valueOf(false));
/*     */     
/*  41 */     if (!StringUtils.isEmpty(userName)) {
/*  42 */       criteria.andCnameLike("%" + userName + "%");
/*     */     }
/*  44 */     PageHelper.startPage(pageBean.getPage().intValue(), pageBean.getRows().intValue());
/*  45 */     PageInfo<User> info = new PageInfo(this.userMapper.selectByExample(example));
/*  46 */     return new EUPageResult(Long.valueOf(info.getTotal()), info.getList());
/*     */   }
/*     */ 
/*     */   
/*     */   public R save(User user) {
/*  51 */     if (user.getId().longValue() == 1L) {
/*  52 */       return R.ERROR("不能修改此用户！");
/*     */     }
/*  54 */     user.setOpid(this.opid);
/*  55 */     user.setOptime(new Date());
/*  56 */     user.setUsername(user.getUsername().toUpperCase());
/*  57 */     if (isRepeat(user)) {
/*  58 */       return R.ERROR("登录重复");
/*     */     }
/*  60 */     if (user.getId() == null) {
/*  61 */       user.setPassword(ShiroUtils.sha256("888888", user.getCname()));
/*  62 */       this.userMapper.insertSelective(user);
/*     */     } else {
/*  64 */       this.userMapper.updateByPrimaryKeySelective(user);
/*     */     } 
/*     */     
/*  67 */     return R.OK();
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean isRepeat(User user) {
/*  72 */     UserExample example = new UserExample();
/*     */ 
/*     */     
/*  75 */     UserExample.Criteria criteria = example.createCriteria().andUsernameEqualTo(user.getUsername()).andIsdelEqualTo(Boolean.valueOf(false));
/*  76 */     if (user.getId() != null) {
/*  77 */       criteria.andIdNotEqualTo(user.getId());
/*     */     }
/*  79 */     List<User> users = this.userMapper.selectByExample(example);
/*  80 */     if (users.size() == 0) {
/*  81 */       return false;
/*     */     }
/*  83 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public R delete(Long userid) {
/*  88 */     if (userid.longValue() == 1L) {
/*  89 */       return R.ERROR("不能删除此用户！");
/*     */     }
/*  91 */     User user = new User();
/*  92 */     user.setOptime(new Date());
/*  93 */     user.setOpid(this.opid);
/*  94 */     user.setId(userid);
/*  95 */     user.setIsdel(Boolean.valueOf(true));
/*  96 */     this.userMapper.updateByPrimaryKeySelective(user);
/*  97 */     return R.OK();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Transactional
/*     */   public R saveRoleSet(String roleIds, String roleNames, Long userId) {
/* 106 */     if (userId.longValue() == 1L) {
/* 107 */       return R.ERROR("此用户角色不能修改！");
/*     */     }
/* 109 */     UserExample example = new UserExample();
/* 110 */     example.createCriteria()
/* 111 */       .andIsdelEqualTo(Boolean.valueOf(false))
/* 112 */       .andIdEqualTo(userId);
/* 113 */     if (userId == null || this.userMapper.selectByExample(example).size() < 1) {
/* 114 */       return R.ERROR("用户不存在！");
/*     */     }
/* 116 */     User user = new User();
/* 117 */     user.setId(userId);
/* 118 */     user.setRoles(roleNames);
/* 119 */     user.setOptime(new Date());
/* 120 */     user.setOpid(this.opid);
/* 121 */     this.userMapper.updateByPrimaryKeySelective(user);
/* 122 */     this.roleDoMapper.deleteByUserid(userId);
/* 123 */     if (!StringUtils.isEmpty(roleIds)) {
/* 124 */       this.roleDoMapper.insertUserRole(userId, roleIds);
/*     */     }
/* 126 */     return R.OK();
/*     */   }
/*     */ 
/*     */   
/*     */   public R modifyPassword(String newPassword, String oldPassword) {
/* 131 */     User user = ShiroUtils.getUser();
/* 132 */     String oldpassword = ShiroUtils.sha256(oldPassword, user.getCname());
/* 133 */     String newpassword = ShiroUtils.sha256(newPassword, user.getCname());
/* 134 */     UserExample example = new UserExample();
/* 135 */     example.createCriteria()
/* 136 */       .andIdEqualTo(user.getId())
/* 137 */       .andPasswordEqualTo(oldpassword);
/* 138 */     List<User> users = this.userMapper.selectByExample(example);
/* 139 */     if (users.size() > 0) {
/* 140 */       user.setOptime(new Date());
/* 141 */       user.setOpid(this.opid);
/* 142 */       user.setPassword(newpassword);
/* 143 */       this.userMapper.updateByPrimaryKeySelective(user);
/* 144 */       return R.OK();
/*     */     } 
/* 146 */     return R.ERROR("旧密码错误！");
/*     */   }

/*     */   public List<User> selectByExample() {
/* 151 */     UserExample example = new UserExample();
/* 152 */     example.createCriteria()
/* 153 */       .andIsdelEqualTo(Boolean.valueOf(false))
/* 154 */       .andIdNotEqualTo(Long.valueOf(1L))
/* 155 */       .andIsteamEqualTo(Boolean.valueOf(false));
/*     */     
/* 157 */     return this.userMapper.selectByExample(example);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\classes\!\cn\zhouxp\sys\service\impl\UserServiceImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */