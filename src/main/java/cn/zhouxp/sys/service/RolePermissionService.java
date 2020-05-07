package cn.zhouxp.sys.service;

import cn.zhouxp.common.model.R;

/**
 * @author zhouxp
 * @create 2020-04-23 10:24
 */
public interface RolePermissionService {
    R saveMenuSet(String menuIds, Long roleId);
}
