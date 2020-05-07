package cn.zhouxp.sys.service;

import cn.zhouxp.common.model.EUPageResult;
import cn.zhouxp.common.model.PageBean;
import cn.zhouxp.common.model.R;
import cn.zhouxp.sys.model.Role;

public interface RoleService {
  EUPageResult<Role> list(PageBean paramPageBean, String paramString);
  
  R save(Role paramRole);
  
  R delete(Long paramLong);
  
  R deleteAll(String paramString);
  
  EUPageResult<Role> getAll();
}