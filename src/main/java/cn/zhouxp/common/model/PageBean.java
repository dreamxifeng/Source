package cn.zhouxp.common.model;

import lombok.Data;

/**
 * @author zhouxp
 * @create 2020-04-14 10:02
 */
@Data
public class PageBean {
    private Integer page = 1;
    private Integer rows = 10;
}
