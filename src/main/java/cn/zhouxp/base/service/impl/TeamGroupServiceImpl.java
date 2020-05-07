/*    */ package cn.zhouxp.base.service.impl;
/*    */ 
/*    */

import cn.zhouxp.base.domapper.TeamGroupDoMapper;
import cn.zhouxp.base.domapper.UserDoMapper;
import cn.zhouxp.base.mapper.TeamGroupMapper;
import cn.zhouxp.base.model.TeamGroup;
import cn.zhouxp.base.model.TeamGroupExample;
import cn.zhouxp.base.service.TeamGroupService;
import cn.zhouxp.common.model.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
/*    */ public class TeamGroupServiceImpl
/*    */   implements TeamGroupService
/*    */ {
/*    */   @Autowired
/*    */   private TeamGroupMapper teamGroupMapper;
/*    */   @Autowired
/*    */   private UserDoMapper userDoMapper;
/*    */   @Autowired
/*    */   private TeamGroupDoMapper teamGroupDoMapper;
/*    */   
/*    */   public List<TeamGroup> list(Long teamId) {
/* 28 */     if (teamId != null) {
/* 29 */       TeamGroupExample example = new TeamGroupExample();
/* 30 */       example.createCriteria()
/* 31 */         .andTeamIdEqualTo(teamId);
/* 32 */       return this.teamGroupMapper.selectByExample(example);
/*    */     } 
/* 34 */     return null;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @Transactional
/*    */   public R right(String userIds, Long teamId) {
/* 45 */     this.teamGroupDoMapper.batchInsertByUserIds(userIds, teamId);
/* 46 */     this.userDoMapper.batchUpdateByUserIds(userIds, Boolean.valueOf(true));
/* 47 */     return R.OK();
/*    */   }
/*    */ 
/*    */   
/*    */   @Transactional
/*    */   public R left(String userIds, Long teamId) {
/* 53 */     this.teamGroupDoMapper.batchDeleteByUserIds(userIds, teamId);
/* 54 */     this.userDoMapper.batchUpdateByUserIds(userIds, Boolean.valueOf(false));
/* 55 */     return R.OK();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\classes\!\cn\zhouxp\base\service\impl\TeamGroupServiceImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */