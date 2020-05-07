package cn.zhouxp.stock.mapper;

import cn.zhouxp.stock.model.VStockSum;
import cn.zhouxp.stock.model.VStockSumExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VStockSumMapper {
  long countByExample(VStockSumExample paramVStockSumExample);
  
  int deleteByExample(VStockSumExample paramVStockSumExample);
  
  int insert(VStockSum paramVStockSum);
  
  int insertSelective(VStockSum paramVStockSum);
  
  List<VStockSum> selectByExample(VStockSumExample paramVStockSumExample);
  
  int updateByExampleSelective(@Param("record") VStockSum paramVStockSum, @Param("example") VStockSumExample paramVStockSumExample);
  
  int updateByExample(@Param("record") VStockSum paramVStockSum, @Param("example") VStockSumExample paramVStockSumExample);
}


/* Location:              C:\Users\Administrator\Desktop\classes\!\cn\zhouxp\stock\mapper\VStockSumMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */