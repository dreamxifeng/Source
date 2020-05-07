package cn.zhouxp.base.mapper;

import cn.zhouxp.base.model.OpenScissors;
import cn.zhouxp.base.model.OpenScissorsExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OpenScissorsMapper {
  long countByExample(OpenScissorsExample paramOpenScissorsExample);
  
  int deleteByExample(OpenScissorsExample paramOpenScissorsExample);
  
  int deleteByPrimaryKey(Long paramLong);
  
  int insert(OpenScissors paramOpenScissors);
  
  int insertSelective(OpenScissors paramOpenScissors);
  
  List<OpenScissors> selectByExample(OpenScissorsExample paramOpenScissorsExample);
  
  OpenScissors selectByPrimaryKey(Long paramLong);
  
  int updateByExampleSelective(@Param("record") OpenScissors paramOpenScissors, @Param("example") OpenScissorsExample paramOpenScissorsExample);
  
  int updateByExample(@Param("record") OpenScissors paramOpenScissors, @Param("example") OpenScissorsExample paramOpenScissorsExample);
  
  int updateByPrimaryKeySelective(OpenScissors paramOpenScissors);
  
  int updateByPrimaryKey(OpenScissors paramOpenScissors);
}


/* Location:              C:\Users\Administrator\Desktop\classes\!\cn\zhouxp\base\mapper\OpenScissorsMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */