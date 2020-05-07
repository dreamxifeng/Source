package cn.zhouxp.sys.controller;

import cn.zhouxp.common.model.R;
import cn.zhouxp.sys.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhouxp
 * @create 2020-04-23 11:38
 */
@RestController
@RequestMapping("sys/userRole")
public class UserRoleController {
    @Autowired
    private UserRoleService userRoleService;

    @PostMapping("saveRoleSet")
    public R saveRoleSet(String roleIds,@RequestParam("userId") Long userId,String roleNames){
        return userRoleService.saveRoleSet(roleIds,userId,roleNames);
    }
}
