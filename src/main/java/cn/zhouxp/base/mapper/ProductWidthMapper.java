package cn.zhouxp.base.mapper;

import cn.zhouxp.base.model.ProductWidth;
import cn.zhouxp.base.model.ProductWidthExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductWidthMapper {
  long countByExample(ProductWidthExample paramProductWidthExample);
  
  int deleteByExample(ProductWidthExample paramProductWidthExample);
  
  int deleteByPrimaryKey(Long paramLong);
  
  int insert(ProductWidth paramProductWidth);
  
  int insertSelective(ProductWidth paramProductWidth);
  
  List<ProductWidth> selectByExample(ProductWidthExample paramProductWidthExample);
  
  ProductWidth selectByPrimaryKey(Long paramLong);
  
  int updateByExampleSelective(@Param("record") ProductWidth paramProductWidth, @Param("example") ProductWidthExample paramProductWidthExample);
  
  int updateByExample(@Param("record") ProductWidth paramProductWidth, @Param("example") ProductWidthExample paramProductWidthExample);
  
  int updateByPrimaryKeySelective(ProductWidth paramProductWidth);
  
  int updateByPrimaryKey(ProductWidth paramProductWidth);
}


/* Location:              C:\Users\Administrator\Desktop\classes\!\cn\zhouxp\base\mapper\ProductWidthMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */