/*    */ package cn.zhouxp.stock.controller;
/*    */ 
/*    */ import cn.zhouxp.common.model.EUPageResult;
/*    */ import cn.zhouxp.common.model.PageBean;
/*    */ import cn.zhouxp.common.model.R;
/*    */ import cn.zhouxp.stock.model.Stock;
/*    */ import cn.zhouxp.stock.model.VStock;
/*    */ import cn.zhouxp.stock.service.StockService;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Controller;
/*    */ import org.springframework.web.bind.annotation.GetMapping;
/*    */ import org.springframework.web.bind.annotation.PostMapping;
/*    */ import org.springframework.web.bind.annotation.RequestMapping;
/*    */ import org.springframework.web.bind.annotation.ResponseBody;

/*    */ @Controller
/*    */ @RequestMapping({"stock/stock"})
/*    */ public class StockController
/*    */ {
/*    */   @Autowired
/*    */   private StockService stockService;
/*    */   
/*    */   @GetMapping({"page"})
/* 33 */   public String page() { return "stock/stock"; }
/*    */ 
/*    */ 
/*    */   
/*    */   @PostMapping({"save"})
/*    */   @ResponseBody
/* 39 */   public R save(Stock stock) { return this.stockService.save(stock); }
/*    */ 
/*    */ 
/*    */   
/*    */   @PostMapping({"delete"})
/*    */   @ResponseBody
/* 45 */   public R delete(Long id) { return this.stockService.delete(id); }
/*    */ 
/*    */ 
/*    */   
/*    */   @GetMapping({"list"})
/*    */   @ResponseBody
/* 51 */   public EUPageResult<VStock> list(PageBean pageBean, String name) { return this.stockService.list(pageBean, name); }
/*    */ }

