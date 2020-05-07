package cn.zhouxp.stock.mapper;

import cn.zhouxp.stock.model.Stock;
import cn.zhouxp.stock.model.StockExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StockMapper {
  long countByExample(StockExample paramStockExample);
  
  int deleteByExample(StockExample paramStockExample);
  
  int deleteByPrimaryKey(Long paramLong);
  
  int insert(Stock paramStock);
  
  int insertSelective(Stock paramStock);
  
  List<Stock> selectByExample(StockExample paramStockExample);
  
  Stock selectByPrimaryKey(Long paramLong);
  
  int updateByExampleSelective(@Param("record") Stock paramStock, @Param("example") StockExample paramStockExample);
  
  int updateByExample(@Param("record") Stock paramStock, @Param("example") StockExample paramStockExample);
  
  int updateByPrimaryKeySelective(Stock paramStock);
  
  int updateByPrimaryKey(Stock paramStock);
}


/* Location:              C:\Users\Administrator\Desktop\classes\!\cn\zhouxp\stock\mapper\StockMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */