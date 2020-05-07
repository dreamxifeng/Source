package cn.zhouxp.sys.mapper;

import cn.zhouxp.sys.model.User;
import cn.zhouxp.sys.model.UserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
  long countByExample(UserExample paramUserExample);
  
  int deleteByExample(UserExample paramUserExample);
  
  int deleteByPrimaryKey(Long paramLong);
  
  int insert(User paramUser);
  
  int insertSelective(User paramUser);
  
  List<User> selectByExample(UserExample paramUserExample);
  
  User selectByPrimaryKey(Long paramLong);
  
  int updateByExampleSelective(@Param("record") User paramUser, @Param("example") UserExample paramUserExample);
  
  int updateByExample(@Param("record") User paramUser, @Param("example") UserExample paramUserExample);
  
  int updateByPrimaryKeySelective(User paramUser);
  
  int updateByPrimaryKey(User paramUser);
}


/* Location:              C:\Users\Administrator\Desktop\classes\!\cn\zhouxp\sys\mapper\UserMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */