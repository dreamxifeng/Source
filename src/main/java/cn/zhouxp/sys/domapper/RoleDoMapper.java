package cn.zhouxp.sys.domapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

public interface RoleDoMapper {
  @Update({"UPDATE sys_role SET isdel =1 WHERE id IN(${ids})"})
  int deleteAll(String paramString);
  
  @Insert({"INSERT INTO sys_user_role(userid,roleid) SELECT #{userid},id FROM sys_role WHERE id IN(${roleids})"})
  int insertUserRole(@Param("userid") Long paramLong, @Param("roleids") String paramString);
  
  @Delete({"DELETE FROM sys_user_role WHERE userid=#{userid}"})
  int deleteByUserid(Long paramLong);
}


/* Location:              C:\Users\Administrator\Desktop\classes\!\cn\zhouxp\sys\domapper\RoleDoMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */