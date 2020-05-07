package cn.zhouxp.stock.mapper;

import cn.zhouxp.stock.model.StockSum;
import cn.zhouxp.stock.model.StockSumExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StockSumMapper {
  long countByExample(StockSumExample paramStockSumExample);
  
  int deleteByExample(StockSumExample paramStockSumExample);
  
  int deleteByPrimaryKey(Long paramLong);
  
  int insert(StockSum paramStockSum);
  
  int insertSelective(StockSum paramStockSum);
  
  List<StockSum> selectByExample(StockSumExample paramStockSumExample);
  
  StockSum selectByPrimaryKey(Long paramLong);
  
  int updateByExampleSelective(@Param("record") StockSum paramStockSum, @Param("example") StockSumExample paramStockSumExample);
  
  int updateByExample(@Param("record") StockSum paramStockSum, @Param("example") StockSumExample paramStockSumExample);
  
  int updateByPrimaryKeySelective(StockSum paramStockSum);
  
  int updateByPrimaryKey(StockSum paramStockSum);
}


/* Location:              C:\Users\Administrator\Desktop\classes\!\cn\zhouxp\stock\mapper\StockSumMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */