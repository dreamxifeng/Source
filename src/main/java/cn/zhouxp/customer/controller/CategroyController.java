/*    */ package cn.zhouxp.customer.controller;
/*    */ 
/*    */ import cn.zhouxp.common.model.EUPageResult;
/*    */ import cn.zhouxp.common.model.PageBean;
/*    */ import cn.zhouxp.common.model.R;
/*    */ import cn.zhouxp.customer.model.Categroy;
/*    */ import cn.zhouxp.customer.service.CategroyService;
/*    */ import java.util.List;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Controller;
/*    */ import org.springframework.web.bind.annotation.GetMapping;
/*    */ import org.springframework.web.bind.annotation.PostMapping;
/*    */ import org.springframework.web.bind.annotation.RequestMapping;
/*    */ import org.springframework.web.bind.annotation.ResponseBody;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Controller
/*    */ @RequestMapping({"customer/categroy"})
/*    */ public class CategroyController
/*    */ {
/*    */   @Autowired
/*    */   private CategroyService categroyService;
/*    */   
/*    */   @GetMapping({"page"})
/* 31 */   public String page() { return "customer/categroy"; }
/*    */ 
/*    */ 
/*    */   
/*    */   @GetMapping({"list"})
/*    */   @ResponseBody
/* 37 */   public EUPageResult<Categroy> list(PageBean pageBean, String name) { return this.categroyService.list(pageBean, name); }
/*    */ 
/*    */ 
/*    */   
/*    */   @PostMapping({"save"})
/*    */   @ResponseBody
/* 43 */   public R save(Categroy categroy) { return this.categroyService.save(categroy); }
/*    */ 
/*    */ 
/*    */   
/*    */   @PostMapping({"delete"})
/*    */   @ResponseBody
/* 49 */   public R delete(Long id) { return this.categroyService.delete(id); }
/*    */ 
/*    */ 
/*    */   
/*    */   @GetMapping({"listall"})
/*    */   @ResponseBody
/* 55 */   public List<Categroy> listall() { return this.categroyService.listall(); }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\classes\!\cn\zhouxp\customer\controller\CategroyController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */