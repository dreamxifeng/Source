package cn.zhouxp.sys.domapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

/**
 * @author zhouxp
 * @create 2020-04-23 10:39
 */
public interface RolePermissionDoMapper {
    @Insert("INSERT INTO sys_role_permission(roleid,permid) SELECT #{roleId},id FROM sys_permission WHERE id IN(${menuIds})")
    Integer insert(@Param("menuIds") String menuIds, @Param("roleId") Long roleId);
}
