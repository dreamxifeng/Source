package cn.zhouxp.sys.domodel;

import lombok.Data;

/**
 * @author zhouxp
 * @create 2020-04-22 15:09
 */
@Data
public class MenuDo {
    private Long id;
    private Long pid;
    private String cname;
    private String icon;
    private String url;
    private Boolean checked;
}
