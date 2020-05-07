package cn.zhouxp.sys.mapper;

import cn.zhouxp.sys.model.Role;
import cn.zhouxp.sys.model.RoleExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMapper {
  long countByExample(RoleExample paramRoleExample);
  
  int deleteByExample(RoleExample paramRoleExample);
  
  int deleteByPrimaryKey(Long paramLong);
  
  int insert(Role paramRole);
  
  int insertSelective(Role paramRole);
  
  List<Role> selectByExample(RoleExample paramRoleExample);
  
  Role selectByPrimaryKey(Long paramLong);
  
  int updateByExampleSelective(@Param("record") Role paramRole, @Param("example") RoleExample paramRoleExample);
  
  int updateByExample(@Param("record") Role paramRole, @Param("example") RoleExample paramRoleExample);
  
  int updateByPrimaryKeySelective(Role paramRole);
  
  int updateByPrimaryKey(Role paramRole);
}


/* Location:              C:\Users\Administrator\Desktop\classes\!\cn\zhouxp\sys\mapper\RoleMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */