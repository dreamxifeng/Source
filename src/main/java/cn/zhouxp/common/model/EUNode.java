package cn.zhouxp.common.model;

import lombok.Data;

import java.util.List;

/**
 * @author zhouxp
 * @create 2020-04-22 14:18
 */
@Data
public class EUNode {
    private Long id;
    private String text;//菜单显示内容
    private String state;//closed有父节点open叶子节点
    private String iconCls;//图标
    private Boolean checked;//true选中
    private EUAttributes attributes;
    private List<EUNode> children;//叶子节点
}

