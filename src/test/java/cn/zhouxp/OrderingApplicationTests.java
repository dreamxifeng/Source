package cn.zhouxp;

import cn.zhouxp.sys.domapper.PermissionDoMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class OrderingApplicationTests {

    @Resource
    private PermissionDoMapper permissionDoMapper;
    @Test
    void contextLoads() {
        System.out.println(permissionDoMapper.roleMenu(5L));
    }

}
