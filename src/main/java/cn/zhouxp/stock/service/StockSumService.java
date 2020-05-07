package cn.zhouxp.stock.service;

import cn.zhouxp.common.model.EUPageResult;
import cn.zhouxp.common.model.PageBean;
import cn.zhouxp.common.model.R;
import cn.zhouxp.common.model.SearchCon;
import cn.zhouxp.stock.model.VStockSum;
import javax.servlet.http.HttpServletResponse;

public interface StockSumService {
  R packageStock(Long paramLong);
  
  R finishStock(Long paramLong);
  
  EUPageResult<VStockSum> list(PageBean paramPageBean, SearchCon paramSearchCon);
  
  void download(HttpServletResponse paramHttpServletResponse);
  
  R echart();
}

