/*    */ package cn.zhouxp.base.controller;
/*    */ 
/*    */ import cn.zhouxp.base.model.Technology;
import cn.zhouxp.base.service.TechnologyService;
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
/*    */ @RequestMapping({"base/technology"})
/*    */ public class TechnologyController
/*    */ {
/*    */   @Autowired
/*    */   private TechnologyService technologyService;
/*    */   
/*    */   @GetMapping({"page"})
/* 30 */   public String page() { return "base/technology"; }
/*    */ 
/*    */ 
/*    */   
/*    */   @GetMapping({"list"})
/*    */   @ResponseBody
/* 36 */   public EUPageResult<Technology> list(PageBean pageBean, String name) { return this.technologyService.list(pageBean, name); }
/*    */ 
/*    */ 
/*    */   
/*    */   @PostMapping({"save"})
/*    */   @ResponseBody
/* 42 */   public R save(Technology technology) { return this.technologyService.save(technology); }
/*    */ 
/*    */ 
/*    */   
/*    */   @PostMapping({"delete"})
/*    */   @ResponseBody
/* 48 */   public R delete(Long id) { return this.technologyService.delete(id); }
/*    */ 
/*    */ 
/*    */   
/*    */   @GetMapping({"listall"})
/*    */   @ResponseBody
/* 54 */   public List<Technology> listall() { return this.technologyService.listall(); }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\classes\!\cn\zhouxp\base\controller\TechnologyController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */