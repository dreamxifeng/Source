package cn.zhouxp.base.mapper;

import cn.zhouxp.base.model.Packaging;
import cn.zhouxp.base.model.PackagingExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PackagingMapper {
  long countByExample(PackagingExample paramPackagingExample);
  
  int deleteByExample(PackagingExample paramPackagingExample);
  
  int deleteByPrimaryKey(Long paramLong);
  
  int insert(Packaging paramPackaging);
  
  int insertSelective(Packaging paramPackaging);
  
  List<Packaging> selectByExample(PackagingExample paramPackagingExample);
  
  Packaging selectByPrimaryKey(Long paramLong);
  
  int updateByExampleSelective(@Param("record") Packaging paramPackaging, @Param("example") PackagingExample paramPackagingExample);
  
  int updateByExample(@Param("record") Packaging paramPackaging, @Param("example") PackagingExample paramPackagingExample);
  
  int updateByPrimaryKeySelective(Packaging paramPackaging);
  
  int updateByPrimaryKey(Packaging paramPackaging);
}


/* Location:              C:\Users\Administrator\Desktop\classes\!\cn\zhouxp\base\mapper\PackagingMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */