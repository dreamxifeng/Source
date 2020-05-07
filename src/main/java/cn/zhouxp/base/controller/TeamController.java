/*    */ package cn.zhouxp.base.controller;
/*    */ 
/*    */ import cn.zhouxp.base.model.Team;
import cn.zhouxp.base.service.TeamService;
import cn.zhouxp.common.model.EUPageResult;
import cn.zhouxp.common.model.PageBean;
import cn.zhouxp.common.model.R;
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

/*    */ @Controller
/*    */ @RequestMapping({"base/team"})
/*    */ public class TeamController
/*    */ {
/*    */   @Autowired
/*    */   private TeamService teamService;
/*    */   
/*    */   @GetMapping({"page"})
/* 30 */   public String page() { return "base/team"; }
/*    */ 
/*    */ 
/*    */   
/*    */   @GetMapping({"list"})
/*    */   @ResponseBody
/* 36 */   public EUPageResult<Team> list(PageBean pageBean, String name) { return this.teamService.list(pageBean, name); }
/*    */ 
/*    */ 
/*    */   
/*    */   @PostMapping({"save"})
/*    */   @ResponseBody
/* 42 */   public R save(Team team) { return this.teamService.save(team); }
/*    */ 
/*    */ 
/*    */   
/*    */   @PostMapping({"delete"})
/*    */   @ResponseBody
/* 48 */   public R delete(Long id) { return this.teamService.delete(id); }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @GetMapping({"listall"})
/*    */   @ResponseBody
/* 55 */   public List<Team> listall() { return this.teamService.listall(); }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\classes\!\cn\zhouxp\base\controller\TeamController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */