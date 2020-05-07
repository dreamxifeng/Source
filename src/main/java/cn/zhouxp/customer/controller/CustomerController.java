/*    */ package cn.zhouxp.customer.controller;
/*    */ 
/*    */ import cn.zhouxp.common.model.EUPageResult;
/*    */ import cn.zhouxp.common.model.PageBean;
/*    */ import cn.zhouxp.common.model.R;
/*    */ import cn.zhouxp.customer.domodel.CustomerDo;
/*    */ import cn.zhouxp.customer.model.Customer;
/*    */ import cn.zhouxp.customer.service.CustomerService;
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
/*    */ @RequestMapping({"customer/customer"})
/*    */ public class CustomerController
/*    */ {
/*    */   @Autowired
/*    */   private CustomerService customerService;
/*    */   
/*    */   @GetMapping({"page"})
/* 32 */   public String page() { return "customer/customer"; }
/*    */ 
/*    */ 
/*    */   
/*    */   @GetMapping({"list"})
/*    */   @ResponseBody
/* 38 */   public EUPageResult<CustomerDo> list(PageBean pageBean, String name) { return this.customerService.list(pageBean, name); }
/*    */ 
/*    */ 
/*    */   
/*    */   @PostMapping({"save"})
/*    */   @ResponseBody
/* 44 */   public R save(Customer customer) { return this.customerService.save(customer); }
/*    */ 
/*    */ 
/*    */   
/*    */   @PostMapping({"delete"})
/*    */   @ResponseBody
/* 50 */   public R delete(Long id) { return this.customerService.delete(id); }
/*    */ 
/*    */ 
/*    */   
/*    */   @GetMapping({"listall"})
/*    */   @ResponseBody
/* 56 */   public List<Customer> listall() { return this.customerService.listall(); }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\classes\!\cn\zhouxp\customer\controller\CustomerController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */