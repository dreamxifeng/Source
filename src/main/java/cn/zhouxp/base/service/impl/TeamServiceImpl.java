/*     */ package cn.zhouxp.base.service.impl;

import cn.zhouxp.base.mapper.TeamGroupMapper;
import cn.zhouxp.base.mapper.TeamMapper;
import cn.zhouxp.base.model.Team;
import cn.zhouxp.base.model.TeamExample;
import cn.zhouxp.base.service.TeamService;
import cn.zhouxp.common.model.EUPageResult;
import cn.zhouxp.common.model.PageBean;
import cn.zhouxp.common.model.R;
import cn.zhouxp.common.service.BaseService;
import cn.zhouxp.sys.mapper.UserMapper;
import cn.zhouxp.sys.model.User;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/*     */ @Service
/*     */ public class TeamServiceImpl
/*     */   extends BaseService
/*     */   implements TeamService
/*     */ {
/*     */   @Autowired
/*     */   private TeamMapper teamMapper;
/*     */   @Autowired
/*     */   private UserMapper userMapper;
/*     */   @Autowired
/*     */   TeamGroupMapper teamGroupMapper;
/*     */   
/*     */   public EUPageResult<Team> list(PageBean pageBean, String name) {
/*  35 */     TeamExample example = new TeamExample();
/*     */     
/*  37 */     TeamExample.Criteria criteria = example.createCriteria().andIsdelEqualTo(Boolean.valueOf(false));
/*  38 */     if (name != null) {
/*  39 */       criteria.andCnameLike("%" + name + "%");
/*     */     }
/*     */     
/*  42 */     PageHelper.startPage(pageBean.getPage().intValue(), pageBean.getRows().intValue());
/*  43 */     PageInfo<Team> info = new PageInfo(this.teamMapper.selectByExample(example));
/*  44 */     return new EUPageResult(Long.valueOf(info.getTotal()), info.getList());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Transactional
/*     */   public R delete(Long id) {
/*  55 */     Team team = this.teamMapper.selectByPrimaryKey(id);
/*  56 */     team.setIsdel(Boolean.valueOf(true));
/*  57 */     team.setOpid(this.opid);
/*  58 */     team.setOptime(new Date());
/*  59 */     this.teamMapper.updateByPrimaryKeySelective(team);
/*     */     
/*  61 */     User user = new User();
/*  62 */     user.setId(team.getLeaderId());
/*  63 */     user.setIsteam(Boolean.valueOf(false));
/*  64 */     this.userMapper.updateByPrimaryKeySelective(user);
/*     */     
/*  66 */     return R.OK();
/*     */   }
/*     */   
/*     */   private boolean isRepeat(Team team) {
/*  70 */     TeamExample example = new TeamExample();
/*     */ 
/*     */     
/*  73 */     TeamExample.Criteria criteria = example.createCriteria().andCnameLike(team.getCname()).andIsdelEqualTo(Boolean.valueOf(false));
/*  74 */     if (team.getId() != null) {
/*  75 */       criteria.andIdNotEqualTo(team.getId());
/*     */     }
/*  77 */     List<Team> teams = this.teamMapper.selectByExample(example);
/*  78 */     if (teams.size() == 0) {
/*  79 */       return false;
/*     */     }
/*  81 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   @Transactional
/*     */   public R save(Team team) {
/*  87 */     if (isRepeat(team)) {
/*  88 */       return R.ERROR("班组名称重复！");
/*     */     }
/*  90 */     team.setOpid(this.opid);
/*  91 */     team.setOptime(new Date());
/*     */     
/*  93 */     User user = new User();
/*  94 */     if (team.getId() == null) {
/*  95 */       this.teamMapper.insertSelective(team);
/*  96 */       user.setId(team.getLeaderId());
/*  97 */       user.setIsteam(Boolean.valueOf(true));
/*  98 */       this.userMapper.updateByPrimaryKeySelective(user);
/*     */     } else {
/* 100 */       Team team1 = this.teamMapper.selectByPrimaryKey(team.getId());
/* 101 */       this.teamMapper.updateByPrimaryKeySelective(team);
/*     */       
/* 103 */       user.setId(team.getLeaderId());
/* 104 */       user.setIsteam(Boolean.valueOf(true));
/* 105 */       this.userMapper.updateByPrimaryKeySelective(user);
/*     */       
/* 107 */       user.setId(team1.getLeaderId());
/* 108 */       user.setIsteam(Boolean.valueOf(false));
/* 109 */       this.userMapper.updateByPrimaryKeySelective(user);
/*     */     } 
/*     */     
/* 112 */     return R.OK();
/*     */   }
/*     */ 
/*     */   
/*     */   public List<Team> listall() {
/* 117 */     TeamExample example = new TeamExample();
/* 118 */     example.createCriteria()
/* 119 */       .andIsdelEqualTo(Boolean.valueOf(false));
/* 120 */     return this.teamMapper.selectByExample(example);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\classes\!\cn\zhouxp\base\service\impl\TeamServiceImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */