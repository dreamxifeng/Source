package cn.zhouxp.sys.domapper;

import cn.zhouxp.sys.model.Permission;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PermissomDoMapper {
  @Select({"select id,pid,cname,url,icon from sys_permission where id in(select permid from sys_role_permission where roleid in (select roleid from sys_user_role where userid=#{userid})) and isdel=0 and ctype=0"})
  List<Permission> getMenu(@Param("userid") Long paramLong);
  
  @Select({"SELECT id,pid,cname,icon,IF(p1.permid IS NULL,0,1) isdel FROM sys_permission p  LEFT JOIN (SELECT permid FROM sys_role_permission WHERE roleid =#{roleid}) p1 ON(p.id=p1.permid) WHERE p.isdel=0"})
  List<Permission> getRight(@Param("roleid") Long paramLong);
  
  @Insert({"INSERT INTO sys_role_permission(roleid,permid) SELECT #{roleid},id FROM sys_permission WHERE id IN(${permids})"})
  Integer insertRolePerms(@Param("roleid") Long paramLong, @Param("permids") String paramString);
  
  @Delete({"DELETE FROM sys_role_permission WHERE roleid=#{roleid}"})
  Integer deleteRolePerms(@Param("roleid") Long paramLong);
  
  @Select({"SELECT perm FROM sys_permission  WHERE id IN(SELECT permid FROM sys_role_permission WHERE roleid IN(SELECT roleid FROM sys_user_role WHERE userid=#{userid}))"})
  List<String> getPermByUserid(@Param("userid") Long paramLong);
}


/* Location:              C:\Users\Administrator\Desktop\classes\!\cn\zhouxp\sys\domapper\PermissomDoMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */