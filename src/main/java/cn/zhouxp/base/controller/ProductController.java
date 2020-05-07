/*    */ package cn.zhouxp.base.controller;
/*    */ 
/*    */ import cn.zhouxp.base.model.Product;
/*    */ import cn.zhouxp.base.service.ProductService;
/*    */ import cn.zhouxp.common.model.EUPageResult;
/*    */ import cn.zhouxp.common.model.PageBean;
/*    */ import cn.zhouxp.common.model.R;
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
/*    */ @Controller
/*    */ @RequestMapping({"base/product"})
/*    */ public class ProductController
/*    */ {
/*    */   @Autowired
/*    */   private ProductService productService;
/*    */   
/*    */   @GetMapping({"page"})
/* 30 */   public String page() { return "base/product"; }
/*    */ 
/*    */ 
/*    */   
/*    */   @GetMapping({"list"})
/*    */   @ResponseBody
/* 36 */   public EUPageResult<Product> list(PageBean pageBean, Integer name) { return this.productService.list(pageBean, name); }
/*    */ 
/*    */ 
/*    */   
/*    */   @PostMapping({"save"})
/*    */   @ResponseBody
/* 42 */   public R save(Product product) { return this.productService.save(product); }
/*    */ 
/*    */ 
/*    */   
/*    */   @PostMapping({"delete"})
/*    */   @ResponseBody
/* 48 */   public R delete(Long id) { return this.productService.delete(id); }
/*    */ 
/*    */ 
/*    */   
/*    */   @GetMapping({"listall"})
/*    */   @ResponseBody
/* 54 */   public List<Product> listall() { return this.productService.listall(); }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\classes\!\cn\zhouxp\base\controller\ProductController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */