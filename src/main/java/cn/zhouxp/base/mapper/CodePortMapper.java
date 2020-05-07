package cn.zhouxp.base.mapper;

import cn.zhouxp.base.model.CodePort;
import cn.zhouxp.base.model.CodePortExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CodePortMapper {
  long countByExample(CodePortExample paramCodePortExample);
  
  int deleteByExample(CodePortExample paramCodePortExample);
  
  int deleteByPrimaryKey(Long paramLong);
  
  int insert(CodePort paramCodePort);
  
  int insertSelective(CodePort paramCodePort);
  
  List<CodePort> selectByExample(CodePortExample paramCodePortExample);
  
  CodePort selectByPrimaryKey(Long paramLong);
  
  int updateByExampleSelective(@Param("record") CodePort paramCodePort, @Param("example") CodePortExample paramCodePortExample);
  
  int updateByExample(@Param("record") CodePort paramCodePort, @Param("example") CodePortExample paramCodePortExample);
  
  int updateByPrimaryKeySelective(CodePort paramCodePort);
  
  int updateByPrimaryKey(CodePort paramCodePort);
}


/* Location:              C:\Users\Administrator\Desktop\classes\!\cn\zhouxp\base\mapper\CodePortMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */