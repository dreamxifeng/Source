package cn.zhouxp.base.mapper;

import cn.zhouxp.base.model.PrintingFactory;
import cn.zhouxp.base.model.PrintingFactoryExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PrintingFactoryMapper {
  long countByExample(PrintingFactoryExample paramPrintingFactoryExample);
  
  int deleteByExample(PrintingFactoryExample paramPrintingFactoryExample);
  
  int deleteByPrimaryKey(Long paramLong);
  
  int insert(PrintingFactory paramPrintingFactory);
  
  int insertSelective(PrintingFactory paramPrintingFactory);
  
  List<PrintingFactory> selectByExample(PrintingFactoryExample paramPrintingFactoryExample);
  
  PrintingFactory selectByPrimaryKey(Long paramLong);
  
  int updateByExampleSelective(@Param("record") PrintingFactory paramPrintingFactory, @Param("example") PrintingFactoryExample paramPrintingFactoryExample);
  
  int updateByExample(@Param("record") PrintingFactory paramPrintingFactory, @Param("example") PrintingFactoryExample paramPrintingFactoryExample);
  
  int updateByPrimaryKeySelective(PrintingFactory paramPrintingFactory);
  
  int updateByPrimaryKey(PrintingFactory paramPrintingFactory);
}


/* Location:              C:\Users\Administrator\Desktop\classes\!\cn\zhouxp\base\mapper\PrintingFactoryMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */