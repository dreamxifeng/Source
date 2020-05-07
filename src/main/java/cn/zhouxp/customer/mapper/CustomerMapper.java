package cn.zhouxp.customer.mapper;

import cn.zhouxp.customer.model.Customer;
import cn.zhouxp.customer.model.CustomerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CustomerMapper {
  long countByExample(CustomerExample paramCustomerExample);
  
  int deleteByExample(CustomerExample paramCustomerExample);
  
  int deleteByPrimaryKey(Long paramLong);
  
  int insert(Customer paramCustomer);
  
  int insertSelective(Customer paramCustomer);
  
  List<Customer> selectByExample(CustomerExample paramCustomerExample);
  
  Customer selectByPrimaryKey(Long paramLong);
  
  int updateByExampleSelective(@Param("record") Customer paramCustomer, @Param("example") CustomerExample paramCustomerExample);
  
  int updateByExample(@Param("record") Customer paramCustomer, @Param("example") CustomerExample paramCustomerExample);
  
  int updateByPrimaryKeySelective(Customer paramCustomer);
  
  int updateByPrimaryKey(Customer paramCustomer);
}


/* Location:              C:\Users\Administrator\Desktop\classes\!\cn\zhouxp\customer\mapper\CustomerMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */