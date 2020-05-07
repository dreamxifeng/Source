package cn.zhouxp.sys.service.impl;

import cn.zhouxp.common.model.R;
import cn.zhouxp.common.service.BaseService;
import cn.zhouxp.sys.domapper.UserRoleDoMapper;
import cn.zhouxp.sys.mapper.UserMapper;
import cn.zhouxp.sys.mapper.UserRoleMapper;
import cn.zhouxp.sys.model.User;
import cn.zhouxp.sys.model.UserRoleExample;
import cn.zhouxp.sys.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

/**
 * @author zhouxp
 * @create 2020-04-23 11:36
 */
@Service
public class UserRoleServiceImpl extends BaseService implements UserRoleService {
    @Autowired
    private UserRoleMapper userRoleMapper;
    @Autowired
    private UserRoleDoMapper userRoleDoMapper;

    @Autowired
    private UserMapper userMapper;

    @Transactional
    @Override
    public R saveRoleSet(String roleIds, Long userId, String roleNames) {
        UserRoleExample example =new UserRoleExample();
        example.createCriteria().andUseridEqualTo(userId);
        userRoleMapper.deleteByExample(example);
        if(!StringUtils.isEmpty(roleIds)) {
            userRoleDoMapper.insert(roleIds, userId);
        }
        User user =new User();
        user.setId(userId);
        if(StringUtils.isEmpty(roleNames)){
            roleNames="" ;
        }
        user.setRoles(roleNames);
        userMapper.updateByPrimaryKeySelective(user);
        return R.OK();
    }
}
