package cn.zhouxp.stock.service;

import cn.zhouxp.common.model.EUPageResult;
import cn.zhouxp.common.model.PageBean;
import cn.zhouxp.common.model.R;
import cn.zhouxp.stock.model.Stock;
import cn.zhouxp.stock.model.VStock;

public interface StockService {
  R save(Stock paramStock);
  
  R delete(Long paramLong);
  
  EUPageResult<VStock> list(PageBean paramPageBean, String paramString);
}

