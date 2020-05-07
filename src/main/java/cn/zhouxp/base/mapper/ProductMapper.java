package cn.zhouxp.base.mapper;

import cn.zhouxp.base.model.Product;
import cn.zhouxp.base.model.ProductExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductMapper {
  long countByExample(ProductExample paramProductExample);
  
  int deleteByExample(ProductExample paramProductExample);
  
  int deleteByPrimaryKey(Long paramLong);
  
  int insert(Product paramProduct);
  
  int insertSelective(Product paramProduct);
  
  List<Product> selectByExample(ProductExample paramProductExample);
  
  Product selectByPrimaryKey(Long paramLong);
  
  int updateByExampleSelective(@Param("record") Product paramProduct, @Param("example") ProductExample paramProductExample);
  
  int updateByExample(@Param("record") Product paramProduct, @Param("example") ProductExample paramProductExample);
  
  int updateByPrimaryKeySelective(Product paramProduct);
  
  int updateByPrimaryKey(Product paramProduct);
}


/* Location:              C:\Users\Administrator\Desktop\classes\!\cn\zhouxp\base\mapper\ProductMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */