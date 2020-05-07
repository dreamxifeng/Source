package cn.zhouxp.base.mapper;

import cn.zhouxp.base.model.Technology;
import cn.zhouxp.base.model.TechnologyExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TechnologyMapper {
  long countByExample(TechnologyExample paramTechnologyExample);
  
  int deleteByExample(TechnologyExample paramTechnologyExample);
  
  int deleteByPrimaryKey(Long paramLong);
  
  int insert(Technology paramTechnology);
  
  int insertSelective(Technology paramTechnology);
  
  List<Technology> selectByExample(TechnologyExample paramTechnologyExample);
  
  Technology selectByPrimaryKey(Long paramLong);
  
  int updateByExampleSelective(@Param("record") Technology paramTechnology, @Param("example") TechnologyExample paramTechnologyExample);
  
  int updateByExample(@Param("record") Technology paramTechnology, @Param("example") TechnologyExample paramTechnologyExample);
  
  int updateByPrimaryKeySelective(Technology paramTechnology);
  
  int updateByPrimaryKey(Technology paramTechnology);
}


/* Location:              C:\Users\Administrator\Desktop\classes\!\cn\zhouxp\base\mapper\TechnologyMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */