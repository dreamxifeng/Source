package cn.zhouxp.customer.mapper;

import cn.zhouxp.customer.model.Categroy;
import cn.zhouxp.customer.model.CategroyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CategroyMapper {
  long countByExample(CategroyExample paramCategroyExample);
  
  int deleteByExample(CategroyExample paramCategroyExample);
  
  int deleteByPrimaryKey(Long paramLong);
  
  int insert(Categroy paramCategroy);
  
  int insertSelective(Categroy paramCategroy);
  
  List<Categroy> selectByExample(CategroyExample paramCategroyExample);
  
  Categroy selectByPrimaryKey(Long paramLong);
  
  int updateByExampleSelective(@Param("record") Categroy paramCategroy, @Param("example") CategroyExample paramCategroyExample);
  
  int updateByExample(@Param("record") Categroy paramCategroy, @Param("example") CategroyExample paramCategroyExample);
  
  int updateByPrimaryKeySelective(Categroy paramCategroy);
  
  int updateByPrimaryKey(Categroy paramCategroy);
}


/* Location:              C:\Users\Administrator\Desktop\classes\!\cn\zhouxp\customer\mapper\CategroyMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */