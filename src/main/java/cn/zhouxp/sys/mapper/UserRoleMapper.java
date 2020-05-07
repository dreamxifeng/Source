package cn.zhouxp.sys.mapper;

import cn.zhouxp.sys.model.UserRole;
import cn.zhouxp.sys.model.UserRoleExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserRoleMapper {
  long countByExample(UserRoleExample paramUserRoleExample);
  
  int deleteByExample(UserRoleExample paramUserRoleExample);
  
  int deleteByPrimaryKey(Long paramLong);
  
  int insert(UserRole paramUserRole);
  
  int insertSelective(UserRole paramUserRole);
  
  List<UserRole> selectByExample(UserRoleExample paramUserRoleExample);
  
  UserRole selectByPrimaryKey(Long paramLong);
  
  int updateByExampleSelective(@Param("record") UserRole paramUserRole, @Param("example") UserRoleExample paramUserRoleExample);
  
  int updateByExample(@Param("record") UserRole paramUserRole, @Param("example") UserRoleExample paramUserRoleExample);
  
  int updateByPrimaryKeySelective(UserRole paramUserRole);
  
  int updateByPrimaryKey(UserRole paramUserRole);
}
