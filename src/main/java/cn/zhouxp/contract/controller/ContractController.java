/*    */ package cn.zhouxp.contract.controller;
/*    */ 
/*    */ import cn.zhouxp.common.model.EUPageResult;
/*    */ import cn.zhouxp.common.model.PageBean;
/*    */ import cn.zhouxp.common.model.R;
/*    */ import cn.zhouxp.common.model.SearchCon;
/*    */ import cn.zhouxp.contract.model.Contract;
/*    */ import cn.zhouxp.contract.model.VContract;
/*    */ import cn.zhouxp.contract.service.ContractService;
/*    */ import java.util.List;
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
/*    */ @Controller
/*    */ @RequestMapping({"contract/contract"})
/*    */ public class ContractController
/*    */ {
/*    */   @Autowired
/*    */   private ContractService contractService;
/*    */   
/*    */   @GetMapping({"page"})
/* 32 */   public String contract() { return "contract/contract"; }
/*    */ 
/*    */ 
/*    */   
/*    */   @PostMapping({"save"})
/*    */   @ResponseBody
/* 38 */   public R save(Contract contract) { return this.contractService.save(contract); }
/*    */ 
/*    */ 
/*    */   
/*    */   @PostMapping({"delete"})
/*    */   @ResponseBody
/* 44 */   public R delete(Long id) { return this.contractService.delete(id); }
/*    */ 
/*    */ 
/*    */   
/*    */   @ResponseBody
/*    */   @GetMapping({"listall"})
/* 50 */   public List<Contract> listall() { return this.contractService.listall(); }
/*    */ 
/*    */ 
/*    */   
/*    */   @ResponseBody
/*    */   @RequestMapping({"downloadFile"})
/* 56 */   public void downloadFile(HttpServletResponse response) { this.contractService.downloadFile(response); }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @ResponseBody
/*    */   @RequestMapping({"list"})
/* 63 */   public EUPageResult<VContract> list(PageBean pageBean, SearchCon searchCon) { return this.contractService.list(pageBean, searchCon); }
/*    */ 
/*    */ 
/*    */   
/*    */   @ResponseBody
/*    */   @RequestMapping({"getFlowerNo"})
/* 69 */   public List<Contract> getFlowerNo(String q) { return this.contractService.getFlowerNo(q); }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\classes\!\cn\zhouxp\contract\controller\ContractController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */