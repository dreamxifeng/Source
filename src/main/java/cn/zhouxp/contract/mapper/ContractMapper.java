package cn.zhouxp.contract.mapper;

import cn.zhouxp.contract.model.Contract;
import cn.zhouxp.contract.model.ContractExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ContractMapper {
  long countByExample(ContractExample paramContractExample);
  
  int deleteByExample(ContractExample paramContractExample);
  
  int deleteByPrimaryKey(Long paramLong);
  
  int insert(Contract paramContract);
  
  int insertSelective(Contract paramContract);
  
  List<Contract> selectByExample(ContractExample paramContractExample);
  
  Contract selectByPrimaryKey(Long paramLong);
  
  int updateByExampleSelective(@Param("record") Contract paramContract, @Param("example") ContractExample paramContractExample);
  
  int updateByExample(@Param("record") Contract paramContract, @Param("example") ContractExample paramContractExample);
  
  int updateByPrimaryKeySelective(Contract paramContract);
  
  int updateByPrimaryKey(Contract paramContract);
}


/* Location:              C:\Users\Administrator\Desktop\classes\!\cn\zhouxp\contract\mapper\ContractMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */