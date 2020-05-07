package cn.zhouxp.sys.service.impl;

import cn.zhouxp.common.model.ConstUtils;
import cn.zhouxp.common.model.EUAttributes;
import cn.zhouxp.common.model.EUNode;
import cn.zhouxp.common.service.BaseService;
import cn.zhouxp.sys.domapper.PermissionDoMapper;
import cn.zhouxp.sys.domodel.MenuDo;
import cn.zhouxp.sys.mapper.PermissionMapper;
import cn.zhouxp.sys.service.PerssimisonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhouxp
 * @create 2020-04-22 15:48
 */
@Service
public class PerssimisomServiceImpl extends BaseService implements PerssimisonService {
    @Autowired
    private PermissionMapper permissionMapper;
    @Autowired
    private PermissionDoMapper permissionDoMapper;

    @Override
    public List<EUNode> rolePerm(Long roleId) {
        List<EUNode> euNodes = new ArrayList<>();
        List<MenuDo> menuDos = permissionDoMapper.roleMenu(roleId);
        createNode(euNodes, menuDos,ConstUtils.PID);
        return euNodes;
    }

    @Override
    public List<EUNode> getMeun() {
        List<EUNode> euNodes = new ArrayList<>();
        List<MenuDo> menuDos = permissionDoMapper.getMenu(opid);
        createNode(euNodes, menuDos,ConstUtils.PID);
        return euNodes;
    }

    private void createNode(List<EUNode> euNodes, List<MenuDo> menuDos ,Long pid) {
        for (MenuDo menuDo : menuDos) {
            if (menuDo.getPid() == pid) {
                EUNode euNode = new EUNode();
                euNode.setId(menuDo.getId());
                euNode.setChecked(menuDo.getChecked());
                euNode.setIconCls(menuDo.getIcon());
                euNode.setText(menuDo.getCname());
                if (!StringUtils.isEmpty(menuDo.getUrl())) {
                    euNode.setAttributes(new EUAttributes(menuDo.getUrl()));
                }
                List<EUNode> nodes = new ArrayList<>();
                createNode(nodes,menuDos,menuDo.getId());
                if(nodes.size()>0){
                    euNode.setState("closed");
                    euNode.setChildren(nodes);
                }else{
                    euNode.setState("open");
                }

                euNodes.add(euNode);
            }
        }
    }
}
