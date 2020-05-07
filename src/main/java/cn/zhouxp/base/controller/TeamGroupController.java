/*    */ package cn.zhouxp.base.controller;
/*    */ 
/*    */ import cn.zhouxp.base.model.TeamGroup;
import cn.zhouxp.base.service.TeamGroupService;
import cn.zhouxp.common.model.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */

/*    */ @RestController
/*    */ @RequestMapping({"base/teamgroup"})
/*    */ public class TeamGroupController
/*    */ {
/*    */   @Autowired
/*    */   private TeamGroupService teamGroupService;
/*    */   
/*    */   @GetMapping({"list"})
/* 27 */   public List<TeamGroup> list(Long teamId) { return this.teamGroupService.list(teamId); }
/*    */ 
/*    */ 
/*    */   
/*    */   @PostMapping({"right"})
/* 32 */   public R right(String userIds, Long teamId) { return this.teamGroupService.right(userIds, teamId); }
/*    */ 
/*    */ 
/*    */   
/*    */   @PostMapping({"left"})
/* 37 */   public R left(String userIds, Long teamId) { return this.teamGroupService.left(userIds, teamId); }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\classes\!\cn\zhouxp\base\controller\TeamGroupController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */