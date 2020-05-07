package cn.zhouxp.customer.service;

import cn.zhouxp.common.model.EUPageResult;
import cn.zhouxp.common.model.PageBean;
import cn.zhouxp.common.model.R;
import cn.zhouxp.customer.model.Categroy;
import java.util.List;

public interface CategroyService {
  EUPageResult<Categroy> list(PageBean paramPageBean, String paramString);
  
  R save(Categroy paramCategroy);
  
  R delete(Long paramLong);
  
  List<Categroy> listall();
}


/* Location:              C:\Users\Administrator\Desktop\classes\!\cn\zhouxp\customer\service\CategroyService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */