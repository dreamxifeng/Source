package cn.zhouxp.sys.service;

import cn.zhouxp.common.model.EUNode;
import cn.zhouxp.common.model.R;
import java.util.List;

public interface PermissionService {
  List<EUNode> getMenu();
  
  List<EUNode> getRight(Long paramLong);
  
  R saveRolePerms(String paramString, Long paramLong);
}


/* Location:              C:\Users\Administrator\Desktop\classes\!\cn\zhouxp\sys\service\PermissionService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */