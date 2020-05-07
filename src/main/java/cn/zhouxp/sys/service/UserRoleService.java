package cn.zhouxp.sys.service;

import cn.zhouxp.common.model.R;

/**
 * @author zhouxp
 * @create 2020-04-23 11:36
 */
public interface UserRoleService {

    R saveRoleSet(String roleIds, Long userId, String roleNames);
}
