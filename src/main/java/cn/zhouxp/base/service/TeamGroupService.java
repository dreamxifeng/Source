package cn.zhouxp.base.service;

import cn.zhouxp.base.model.TeamGroup;
import cn.zhouxp.common.model.R;
import java.util.List;

public interface TeamGroupService {
  List<TeamGroup> list(Long paramLong);
  
  R right(String paramString, Long paramLong);
  
  R left(String paramString, Long paramLong);
}


/* Location:              C:\Users\Administrator\Desktop\classes\!\cn\zhouxp\base\service\TeamGroupService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */