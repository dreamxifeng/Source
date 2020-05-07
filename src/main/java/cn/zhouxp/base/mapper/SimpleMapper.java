package cn.zhouxp.base.mapper;

import cn.zhouxp.base.model.Simple;
import cn.zhouxp.base.model.SimpleExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SimpleMapper {
  long countByExample(SimpleExample paramSimpleExample);
  
  int deleteByExample(SimpleExample paramSimpleExample);
  
  int deleteByPrimaryKey(Long paramLong);
  
  int insert(Simple paramSimple);
  
  int insertSelective(Simple paramSimple);
  
  List<Simple> selectByExample(SimpleExample paramSimpleExample);
  
  Simple selectByPrimaryKey(Long paramLong);
  
  int updateByExampleSelective(@Param("record") Simple paramSimple, @Param("example") SimpleExample paramSimpleExample);
  
  int updateByExample(@Param("record") Simple paramSimple, @Param("example") SimpleExample paramSimpleExample);
  
  int updateByPrimaryKeySelective(Simple paramSimple);
  
  int updateByPrimaryKey(Simple paramSimple);
}


/* Location:              C:\Users\Administrator\Desktop\classes\!\cn\zhouxp\base\mapper\SimpleMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */