package cn.zhouxp.base.service;

import cn.zhouxp.base.model.Team;
import cn.zhouxp.common.model.EUPageResult;
import cn.zhouxp.common.model.PageBean;
import cn.zhouxp.common.model.R;
import java.util.List;

public interface TeamService {
  EUPageResult<Team> list(PageBean paramPageBean, String paramString);
  
  R delete(Long paramLong);
  
  R save(Team paramTeam);
  
  List<Team> listall();
}


/* Location:              C:\Users\Administrator\Desktop\classes\!\cn\zhouxp\base\service\TeamService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */