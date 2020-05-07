package cn.zhouxp.contract.mapper;

import cn.zhouxp.contract.model.Extra;
import cn.zhouxp.contract.model.ExtraExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ExtraMapper {
  long countByExample(ExtraExample paramExtraExample);
  
  int deleteByExample(ExtraExample paramExtraExample);
  
  int insert(Extra paramExtra);
  
  int insertSelective(Extra paramExtra);
  
  List<Extra> selectByExampleWithBLOBs(ExtraExample paramExtraExample);
  
  List<Extra> selectByExample(ExtraExample paramExtraExample);
  
  int updateByExampleSelective(@Param("record") Extra paramExtra, @Param("example") ExtraExample paramExtraExample);
  
  int updateByExampleWithBLOBs(@Param("record") Extra paramExtra, @Param("example") ExtraExample paramExtraExample);
  
  int updateByExample(@Param("record") Extra paramExtra, @Param("example") ExtraExample paramExtraExample);
}


/* Location:              C:\Users\Administrator\Desktop\classes\!\cn\zhouxp\contract\mapper\ExtraMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */