package cn.zhouxp.sys.mapper;

import cn.zhouxp.sys.model.Permission;
import cn.zhouxp.sys.model.PermissionExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface PermissionMapper {
  long countByExample(PermissionExample paramPermissionExample);
  
  int deleteByExample(PermissionExample paramPermissionExample);
  
  int deleteByPrimaryKey(Long paramLong);
  
  int insert(Permission paramPermission);
  
  int insertSelective(Permission paramPermission);
  
  List<Permission> selectByExample(PermissionExample paramPermissionExample);
  
  Permission selectByPrimaryKey(Long paramLong);
  
  int updateByExampleSelective(@Param("record") Permission paramPermission, @Param("example") PermissionExample paramPermissionExample);
  
  int updateByExample(@Param("record") Permission paramPermission, @Param("example") PermissionExample paramPermissionExample);
  
  int updateByPrimaryKeySelective(Permission paramPermission);
  
  int updateByPrimaryKey(Permission paramPermission);
}


/* Location:              C:\Users\Administrator\Desktop\classes\!\cn\zhouxp\sys\mapper\PermissionMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */