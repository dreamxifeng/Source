/*    */ package cn.zhouxp.base.controller;
/*    */ 
/*    */ import cn.zhouxp.base.model.Packaging;
import cn.zhouxp.base.service.PackagingService;
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
/*    */ @RequestMapping({"base/packaging"})
/*    */ public class PackagingController
/*    */ {
/*    */   @Autowired
/*    */   private PackagingService packagingService;
/*    */   
/*    */   @GetMapping({"page"})
/* 30 */   public String page() { return "base/packaging"; }
/*    */ 
/*    */ 
/*    */   
/*    */   @GetMapping({"list"})
/*    */   @ResponseBody
/* 36 */   public EUPageResult<Packaging> list(PageBean pageBean, String name) { return this.packagingService.list(pageBean, name); }
/*    */ 
/*    */ 
/*    */   
/*    */   @PostMapping({"save"})
/*    */   @ResponseBody
/* 42 */   public R save(Packaging packaging) { return this.packagingService.save(packaging); }
/*    */ 
/*    */ 
/*    */   
/*    */   @PostMapping({"delete"})
/*    */   @ResponseBody
/* 48 */   public R delete(Long id) { return this.packagingService.delete(id); }
/*    */ 
/*    */ 
/*    */   
/*    */   @GetMapping({"listall"})
/*    */   @ResponseBody
/* 54 */   public List<Packaging> listall() { return this.packagingService.listall(); }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\classes\!\cn\zhouxp\base\controller\PackagingController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */