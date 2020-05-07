/*    */ package cn.zhouxp.stock.controller;
/*    */ 
/*    */ import cn.zhouxp.common.model.EUPageResult;
/*    */ import cn.zhouxp.common.model.PageBean;
/*    */ import cn.zhouxp.common.model.R;
/*    */ import cn.zhouxp.common.model.SearchCon;
/*    */ import cn.zhouxp.stock.model.VStockSum;
/*    */ import cn.zhouxp.stock.service.StockSumService;
/*    */ import javax.servlet.http.HttpServletResponse;
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
/*    */ 
/*    */ @Controller
/*    */ @RequestMapping({"stock/stocksum"})
/*    */ public class StockSumController
/*    */ {
/*    */   @Autowired
/*    */   private StockSumService stockSumService;
/*    */   
/*    */   @GetMapping({"list"})
/*    */   @ResponseBody
/* 34 */   public EUPageResult<VStockSum> list(PageBean pageBean, SearchCon con) { return this.stockSumService.list(pageBean, con); }
/*    */ 
/*    */ 
/*    */   
/*    */   @GetMapping({"page"})
/* 39 */   public String page() { return "stock/stocksum"; }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @PostMapping({"package"})
/*    */   @ResponseBody
/* 46 */   public R packageStock(Long id) { return this.stockSumService.packageStock(id); }
/*    */ 
/*    */ 
/*    */   
/*    */   @PostMapping({"finish"})
/*    */   @ResponseBody
/* 52 */   public R finishStock(Long id) { return this.stockSumService.finishStock(id); }
/*    */ 
/*    */ 
/*    */   
/*    */   @RequestMapping({"download"})
/*    */   @ResponseBody
/* 58 */   public void download(HttpServletResponse response) { this.stockSumService.download(response); }
/*    */ 
/*    */   
/*    */   @ResponseBody
/*    */   @GetMapping({"echart"})
/* 63 */   public R echart() { return this.stockSumService.echart(); }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\classes\!\cn\zhouxp\stock\controller\StockSumController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */