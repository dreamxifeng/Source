package cn.zhouxp.common.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhouxp
 * @create 2020-04-14 11:43
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class R {
    private Boolean success;
    private String message;
    private Object data;

    public static R INFO(Boolean success, String message, Object data) {
        return new R(success, message, data);
    }

    public static R OK(String message, Object data) {
        return INFO(true, message, data);
    }

    public static R OK(String message) {
        return OK(message, null);
    }

    public static R OK() {
        return OK("操作成功！");
    }

    public static R ERROR(String message, Object data) {
        return INFO(false, message, data);
    }

    public static R ERROR(String message) {
        return ERROR( message, null);
    }

    public static R ERROR() {
        return ERROR("操作失败！");
    }
}
