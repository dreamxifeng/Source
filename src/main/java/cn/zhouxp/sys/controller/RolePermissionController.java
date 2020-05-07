package cn.zhouxp.sys.controller;

import cn.zhouxp.common.model.R;
import cn.zhouxp.sys.service.RolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhouxp
 * @create 2020-04-23 10:26
 */
@RestController
@RequestMapping("sys/rolePermission")
public class RolePermissionController {
    @Autowired
    private RolePermissionService rolePermissionService;

    @PostMapping("saveMenuSet")
    public R saveMenuSet(String menuIds,@RequestParam(value = "roleId")Long roleId){
        return rolePermissionService.saveMenuSet(menuIds,roleId);
    }
}
