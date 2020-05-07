package cn.zhouxp.sys.domapper;

import cn.zhouxp.sys.domodel.MenuDo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author zhouxp
 * @create 2020-04-22 15:13
 */
public interface PermissionDoMapper {
    @Select("SELECT p.id,p.pid,p.cname,p.url,p.icon,IF(rp.permid,TRUE,FALSE) AS checked  FROM sys_permission p LEFT JOIN (SELECT permid FROM sys_role_permission WHERE roleid=#{roleId}) rp ON (p.id= rp.permid)")
    List<MenuDo> roleMenu(@Param("roleId") Long roleId);

    @Select("SELECT id,pid,cname,url,icon,1 checked FROM sys_permission WHERE id IN (SELECT permid FROM sys_role_permission WHERE roleid IN(SELECT roleid FROM sys_user_role WHERE userid=#{userId})) AND isdel=0 and ctype=0")
    List<MenuDo> getMenu(@Param("userId") Long userId);
}
