/*    */ package cn.zhouxp.customer.service.impl;
/*    */ 
/*    */ import cn.zhouxp.common.model.EUPageResult;
/*    */ import cn.zhouxp.common.model.PageBean;
/*    */ import cn.zhouxp.common.model.R;
/*    */ import cn.zhouxp.common.service.BaseService;
/*    */ import cn.zhouxp.customer.domapper.CustomerDoMapper;
/*    */ import cn.zhouxp.customer.domodel.CustomerDo;
/*    */ import cn.zhouxp.customer.mapper.CustomerMapper;
/*    */ import cn.zhouxp.customer.model.Customer;
/*    */ import cn.zhouxp.customer.model.CustomerExample;
/*    */ import cn.zhouxp.customer.service.CustomerService;
/*    */ import com.github.pagehelper.PageHelper;
/*    */ import com.github.pagehelper.PageInfo;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Service
/*    */ public class CustomerServiceImpl
/*    */   extends BaseService
/*    */   implements CustomerService
/*    */ {
/*    */   @Autowired
/*    */   private CustomerMapper customerMapper;
/*    */   @Autowired
/*    */   private CustomerDoMapper customerDoMapper;
/*    */   
/*    */   public EUPageResult<CustomerDo> list(PageBean pageBean, String name) {
/* 37 */     PageHelper.startPage(pageBean.getPage().intValue(), pageBean.getRows().intValue());
/* 38 */     PageInfo<CustomerDo> info = new PageInfo(this.customerDoMapper.findByName(name));
/* 39 */     return new EUPageResult(Long.valueOf(info.getTotal()), info.getList());
/*    */   }
/*    */ 
/*    */   
/*    */   public R delete(Long id) {
/* 44 */     Customer customer = new Customer();
/* 45 */     customer.setId(id);
/* 46 */     customer.setIsdel(Boolean.valueOf(true));
/* 47 */     customer.setOpid(this.opid);
/* 48 */     customer.setOptime(new Date());
/* 49 */     this.customerMapper.updateByPrimaryKeySelective(customer);
/* 50 */     return R.OK();
/*    */   }
/*    */ 
/*    */   
/*    */   public List<Customer> listall() {
/* 55 */     CustomerExample example = new CustomerExample();
/* 56 */     example.createCriteria()
/* 57 */       .andIsdelEqualTo(Boolean.valueOf(false));
/* 58 */     return this.customerMapper.selectByExample(example);
/*    */   }
/*    */   
/*    */   private boolean isRepeat(Customer customer) {
/* 62 */     CustomerExample example = new CustomerExample();
/*    */ 
/*    */     
/* 65 */     CustomerExample.Criteria criteria = example.createCriteria().andCnameEqualTo(customer.getCname()).andIsdelEqualTo(Boolean.valueOf(false));
/* 66 */     if (customer.getId() != null) {
/* 67 */       criteria.andIdNotEqualTo(customer.getId());
/*    */     }
/* 69 */     List<Customer> customers = this.customerMapper.selectByExample(example);
/* 70 */     if (customers.size() == 0) {
/* 71 */       return false;
/*    */     }
/* 73 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public R save(Customer customer) {
/* 78 */     if (isRepeat(customer)) {
/* 79 */       return R.ERROR("客户名重复！");
/*    */     }
/* 81 */     customer.setOpid(this.opid);
/* 82 */     customer.setOptime(new Date());
/* 83 */     if (customer.getId() == null) {
/* 84 */       this.customerMapper.insertSelective(customer);
/*    */     } else {
/* 86 */       this.customerMapper.updateByPrimaryKeySelective(customer);
/*    */     } 
/* 88 */     return R.OK();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\classes\!\cn\zhouxp\customer\service\impl\CustomerServiceImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */