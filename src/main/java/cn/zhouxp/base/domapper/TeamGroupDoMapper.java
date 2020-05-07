package cn.zhouxp.base.domapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

public interface TeamGroupDoMapper {
  @Insert({"INSERT INTO b_team_group(team_id,user_id,cname) SELECT #{teamid},id,cname FROM sys_user WHERE id IN(${userids})"})
  Integer batchInsertByUserIds(@Param("userids") String paramString, @Param("teamid") Long paramLong);
  
  @Delete({"DELETE FROM b_team_group WHERE user_id IN(${userids}) and team_id=#{teamid}"})
  Integer batchDeleteByUserIds(@Param("userids") String paramString, @Param("teamid") Long paramLong);
}


/* Location:              C:\Users\Administrator\Desktop\classes\!\cn\zhouxp\base\domapper\TeamGroupDoMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */