package cn.zhouxp.sys.service;

import cn.zhouxp.common.model.EUNode;

import java.util.List;

/**
 * @author zhouxp
 * @create 2020-04-22 15:48
 */
public interface PerssimisonService {
    List<EUNode> rolePerm(Long roleId);

    List<EUNode> getMeun();
}
