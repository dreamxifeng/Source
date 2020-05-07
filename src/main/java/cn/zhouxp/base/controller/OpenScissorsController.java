/*    */ package cn.zhouxp.base.controller;
/*    */ 
/*    */ import cn.zhouxp.base.model.OpenScissors;
import cn.zhouxp.base.service.OpenScissorsService;
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
/*    */ @RequestMapping({"base/openscissors"})
/*    */ public class OpenScissorsController
/*    */ {
/*    */   @Autowired
/*    */   private OpenScissorsService openScissorsService;
/*    */   
/*    */   @GetMapping({"page"})
/* 30 */   public String page() { return "base/open_scissors"; }
/*    */ 
/*    */ 
/*    */   
/*    */   @GetMapping({"list"})
/*    */   @ResponseBody
/* 36 */   public EUPageResult<OpenScissors> list(PageBean pageBean, Integer name) { return this.openScissorsService.list(pageBean, name); }
/*    */ 
/*    */ 
/*    */   
/*    */   @PostMapping({"save"})
/*    */   @ResponseBody
/* 42 */   public R save(OpenScissors openScissors) { return this.openScissorsService.save(openScissors); }
/*    */ 
/*    */ 
/*    */   
/*    */   @PostMapping({"delete"})
/*    */   @ResponseBody
/* 48 */   public R delete(Long id) { return this.openScissorsService.delete(id); }
/*    */ 
/*    */ 
/*    */   
/*    */   @GetMapping({"listall"})
/*    */   @ResponseBody
/* 54 */   public List<OpenScissors> listall() { return this.openScissorsService.listall(); }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\classes\!\cn\zhouxp\base\controller\OpenScissorsController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */