package cn.zhouxp.contract.mapper;

import cn.zhouxp.contract.model.VContract;
import cn.zhouxp.contract.model.VContractExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VContractMapper {
  long countByExample(VContractExample paramVContractExample);
  
  int deleteByExample(VContractExample paramVContractExample);
  
  int insert(VContract paramVContract);
  
  int insertSelective(VContract paramVContract);
  
  List<VContract> selectByExample(VContractExample paramVContractExample);
  
  int updateByExampleSelective(@Param("record") VContract paramVContract, @Param("example") VContractExample paramVContractExample);
  
  int updateByExample(@Param("record") VContract paramVContract, @Param("example") VContractExample paramVContractExample);
}


