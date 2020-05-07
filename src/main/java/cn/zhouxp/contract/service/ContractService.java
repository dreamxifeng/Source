package cn.zhouxp.contract.service;

import cn.zhouxp.common.model.EUPageResult;
import cn.zhouxp.common.model.PageBean;
import cn.zhouxp.common.model.R;
import cn.zhouxp.common.model.SearchCon;
import cn.zhouxp.contract.model.Contract;
import cn.zhouxp.contract.model.VContract;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

public interface ContractService {
  R save(Contract paramContract);
  
  R delete(Long paramLong);
  
  List<Contract> listall();
  
  R downloadFile(HttpServletResponse paramHttpServletResponse);
  
  EUPageResult<VContract> list(PageBean paramPageBean, SearchCon paramSearchCon);
  
  List<Contract> getFlowerNo(String paramString);
}


/* Location:              C:\Users\Administrator\Desktop\classes\!\cn\zhouxp\contract\service\ContractService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */