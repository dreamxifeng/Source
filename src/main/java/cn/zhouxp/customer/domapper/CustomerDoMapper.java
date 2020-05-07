package cn.zhouxp.customer.domapper;

import cn.zhouxp.customer.domodel.CustomerDo;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CustomerDoMapper {
  List<CustomerDo> findByName(@Param("name") String paramString);
}


/* Location:              C:\Users\Administrator\Desktop\classes\!\cn\zhouxp\customer\domapper\CustomerDoMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */