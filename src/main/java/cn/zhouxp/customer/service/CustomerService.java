package cn.zhouxp.customer.service;

import cn.zhouxp.common.model.EUPageResult;
import cn.zhouxp.common.model.PageBean;
import cn.zhouxp.common.model.R;
import cn.zhouxp.customer.domodel.CustomerDo;
import cn.zhouxp.customer.model.Customer;
import java.util.List;

public interface CustomerService {
  EUPageResult<CustomerDo> list(PageBean paramPageBean, String paramString);
  
  R save(Customer paramCustomer);
  
  R delete(Long paramLong);
  
  List<Customer> listall();
}


/* Location:              C:\Users\Administrator\Desktop\classes\!\cn\zhouxp\customer\service\CustomerService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */