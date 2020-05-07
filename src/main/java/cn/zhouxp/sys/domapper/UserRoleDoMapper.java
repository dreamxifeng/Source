package cn.zhouxp.sys.domapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

/**
 * @author zhouxp
 * @create 2020-04-23 11:31
 */
public interface UserRoleDoMapper {
    @Insert("INSERT INTO sys_user_role(roleid,userid) SELECT id,#{userId} FROM sys_role WHERE id IN(${roleIds})")
    Integer insert(@Param("roleIds") String roleIds,@Param("userId") Long userId);
}
