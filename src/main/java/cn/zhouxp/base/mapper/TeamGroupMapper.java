package cn.zhouxp.base.mapper;

import cn.zhouxp.base.model.TeamGroup;
import cn.zhouxp.base.model.TeamGroupExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeamGroupMapper {
  long countByExample(TeamGroupExample paramTeamGroupExample);
  
  int deleteByExample(TeamGroupExample paramTeamGroupExample);
  
  int deleteByPrimaryKey(Long paramLong);
  
  int insert(TeamGroup paramTeamGroup);
  
  int insertSelective(TeamGroup paramTeamGroup);
  
  List<TeamGroup> selectByExample(TeamGroupExample paramTeamGroupExample);
  
  TeamGroup selectByPrimaryKey(Long paramLong);
  
  int updateByExampleSelective(@Param("record") TeamGroup paramTeamGroup, @Param("example") TeamGroupExample paramTeamGroupExample);
  
  int updateByExample(@Param("record") TeamGroup paramTeamGroup, @Param("example") TeamGroupExample paramTeamGroupExample);
  
  int updateByPrimaryKeySelective(TeamGroup paramTeamGroup);
  
  int updateByPrimaryKey(TeamGroup paramTeamGroup);
}


/* Location:              C:\Users\Administrator\Desktop\classes\!\cn\zhouxp\base\mapper\TeamGroupMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */