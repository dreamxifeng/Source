package cn.zhouxp.base.mapper;

import cn.zhouxp.base.model.Team;
import cn.zhouxp.base.model.TeamExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeamMapper {
  long countByExample(TeamExample paramTeamExample);
  
  int deleteByExample(TeamExample paramTeamExample);
  
  int deleteByPrimaryKey(Long paramLong);
  
  int insert(Team paramTeam);
  
  int insertSelective(Team paramTeam);
  
  List<Team> selectByExample(TeamExample paramTeamExample);
  
  Team selectByPrimaryKey(Long paramLong);
  
  int updateByExampleSelective(@Param("record") Team paramTeam, @Param("example") TeamExample paramTeamExample);
  
  int updateByExample(@Param("record") Team paramTeam, @Param("example") TeamExample paramTeamExample);
  
  int updateByPrimaryKeySelective(Team paramTeam);
  
  int updateByPrimaryKey(Team paramTeam);
}


/* Location:              C:\Users\Administrator\Desktop\classes\!\cn\zhouxp\base\mapper\TeamMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */