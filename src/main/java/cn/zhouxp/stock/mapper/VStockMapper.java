package cn.zhouxp.stock.mapper;

import cn.zhouxp.stock.model.VStock;
import cn.zhouxp.stock.model.VStockExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VStockMapper {
  long countByExample(VStockExample paramVStockExample);
  
  int deleteByExample(VStockExample paramVStockExample);
  
  int insert(VStock paramVStock);
  
  int insertSelective(VStock paramVStock);
  
  List<VStock> selectByExample(VStockExample paramVStockExample);
  
  int updateByExampleSelective(@Param("record") VStock paramVStock, @Param("example") VStockExample paramVStockExample);
  
  int updateByExample(@Param("record") VStock paramVStock, @Param("example") VStockExample paramVStockExample);
}


/* Location:              C:\Users\Administrator\Desktop\classes\!\cn\zhouxp\stock\mapper\VStockMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */