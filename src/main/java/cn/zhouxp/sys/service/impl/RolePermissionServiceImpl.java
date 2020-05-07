package cn.zhouxp.sys.service.impl;

import cn.zhouxp.common.model.R;
import cn.zhouxp.common.service.BaseService;
import cn.zhouxp.sys.domapper.RolePermissionDoMapper;
import cn.zhouxp.sys.mapper.RolePermissionMapper;
import cn.zhouxp.sys.model.RolePermissionExample;
import cn.zhouxp.sys.service.RolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

/**
 * @author zhouxp
 * @create 2020-04-23 10:24
 */
@Service
public class RolePermissionServiceImpl extends BaseService implements RolePermissionService {
    @Autowired
    private RolePermissionMapper rolePermissionMapper;

    @Autowired
    private RolePermissionDoMapper rolePermissionDoMapper;
    @Transactional
    @Override
    public R saveMenuSet(String menuIds, Long roleId) {
        RolePermissionExample example =new RolePermissionExample();
        example.createCriteria().andRoleidEqualTo(roleId);
        rolePermissionMapper.deleteByExample(example);
        if(!StringUtils.isEmpty(menuIds)) {
            rolePermissionDoMapper.insert(menuIds, roleId);
        }
        return R.OK();
    }
}
