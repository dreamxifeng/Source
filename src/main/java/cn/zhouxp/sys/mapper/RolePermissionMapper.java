package cn.zhouxp.sys.mapper;

import cn.zhouxp.sys.model.RolePermission;
import cn.zhouxp.sys.model.RolePermissionExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RolePermissionMapper {
  long countByExample(RolePermissionExample paramRolePermissionExample);
  
  int deleteByExample(RolePermissionExample paramRolePermissionExample);
  
  int deleteByPrimaryKey(Long paramLong);
  
  int insert(RolePermission paramRolePermission);
  
  int insertSelective(RolePermission paramRolePermission);
  
  List<RolePermission> selectByExample(RolePermissionExample paramRolePermissionExample);
  
  RolePermission selectByPrimaryKey(Long paramLong);
  
  int updateByExampleSelective(@Param("record") RolePermission paramRolePermission, @Param("example") RolePermissionExample paramRolePermissionExample);
  
  int updateByExample(@Param("record") RolePermission paramRolePermission, @Param("example") RolePermissionExample paramRolePermissionExample);
  
  int updateByPrimaryKeySelective(RolePermission paramRolePermission);
  
  int updateByPrimaryKey(RolePermission paramRolePermission);
}


/* Location:              C:\Users\Administrator\Desktop\classes\!\cn\zhouxp\sys\mapper\RolePermissionMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */