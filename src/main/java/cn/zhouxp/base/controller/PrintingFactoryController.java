/*    */ package cn.zhouxp.base.controller;
/*    */ 
/*    */ import cn.zhouxp.base.model.PrintingFactory;
import cn.zhouxp.base.service.PrintingFactoryService;
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
/*    */ 
/*    */ @Controller
/*    */ @RequestMapping({"base/printingfactory"})
/*    */ public class PrintingFactoryController
/*    */ {
/*    */   @Autowired
/*    */   private PrintingFactoryService printingFactoryService;
/*    */   
/*    */   @GetMapping({"page"})
/* 30 */   public String page() { return "base/printing_factory"; }
/*    */ 
/*    */ 
/*    */   
/*    */   @GetMapping({"list"})
/*    */   @ResponseBody
/* 36 */   public EUPageResult<PrintingFactory> list(PageBean pageBean, String name) { return this.printingFactoryService.list(pageBean, name); }
/*    */ 
/*    */ 
/*    */   
/*    */   @PostMapping({"save"})
/*    */   @ResponseBody
/* 42 */   public R save(PrintingFactory printingFactory) { return this.printingFactoryService.save(printingFactory); }
/*    */ 
/*    */ 
/*    */   
/*    */   @PostMapping({"delete"})
/*    */   @ResponseBody
/* 48 */   public R delete(Long id) { return this.printingFactoryService.delete(id); }
/*    */ 
/*    */ 
/*    */   
/*    */   @GetMapping({"listall"})
/*    */   @ResponseBody
/* 54 */   public List<PrintingFactory> listall() { return this.printingFactoryService.listall(); }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\classes\!\cn\zhouxp\base\controller\PrintingFactoryController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */