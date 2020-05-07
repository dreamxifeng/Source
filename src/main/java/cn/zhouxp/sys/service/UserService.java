package cn.zhouxp.sys.service;

import cn.zhouxp.common.model.EUPageResult;
import cn.zhouxp.common.model.PageBean;
import cn.zhouxp.common.model.R;
import cn.zhouxp.sys.model.User;

import java.util.List;

public interface UserService {
  EUPageResult<User> list(String paramString, PageBean paramPageBean);
  
  R save(User paramUser);
  
  R delete(Long paramLong);
  
  R saveRoleSet(String paramString1, String paramString2, Long paramLong);
  
  R modifyPassword(String paramString1, String paramString2);
  
  List<User> selectByExample();
}
