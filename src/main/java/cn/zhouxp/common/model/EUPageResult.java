package cn.zhouxp.common.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author zhouxp
 * @create 2020-04-14 10:10
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EUPageResult<T> {
    private Long total;
    private List<T> rows;
}
