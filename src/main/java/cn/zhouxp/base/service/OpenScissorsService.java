package cn.zhouxp.base.service;

import cn.zhouxp.base.model.OpenScissors;
import cn.zhouxp.common.model.EUPageResult;
import cn.zhouxp.common.model.PageBean;
import cn.zhouxp.common.model.R;
import java.util.List;

public interface OpenScissorsService {
  EUPageResult<OpenScissors> list(PageBean paramPageBean, Integer paramInteger);
  
  R delete(Long paramLong);
  
  R save(OpenScissors paramOpenScissors);
  
  List<OpenScissors> listall();
}


/* Location:              C:\Users\Administrator\Desktop\classes\!\cn\zhouxp\base\service\OpenScissorsService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */