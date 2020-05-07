/*    */ package cn.zhouxp.base.controller;
/*    */ 
/*    */ import cn.zhouxp.base.model.Simple;
import cn.zhouxp.base.service.SimpleService;
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
/*    */ @RequestMapping({"base/simple"})
/*    */ public class SimpleController
/*    */ {
/*    */   @Autowired
/*    */   private SimpleService simpleService;
/*    */   
/*    */   @GetMapping({"page"})
/* 29 */   public String page() { return "base/simple"; }
/*    */ 
/*    */ 
/*    */   
/*    */   @GetMapping({"list"})
/*    */   @ResponseBody
/* 35 */   public EUPageResult<Simple> list(PageBean pageBean, String name) { return this.simpleService.list(pageBean, name); }
/*    */ 
/*    */ 
/*    */   
/*    */   @PostMapping({"save"})
/*    */   @ResponseBody
/* 41 */   public R save(Simple simple) { return this.simpleService.save(simple); }
/*    */ 
/*    */ 
/*    */   
/*    */   @PostMapping({"delete"})
/*    */   @ResponseBody
/* 47 */   public R delete(Long id) { return this.simpleService.delete(id); }
/*    */ 
/*    */ 
/*    */   
/*    */   @GetMapping({"listall"})
/*    */   @ResponseBody
/* 53 */   public List<Simple> listall() { return this.simpleService.listall(); }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\classes\!\cn\zhouxp\base\controller\SimpleController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */