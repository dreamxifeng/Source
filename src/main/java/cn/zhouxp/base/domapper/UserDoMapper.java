package cn.zhouxp.base.domapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

public interface UserDoMapper {
  @Update({"UPDATE sys_user SET isteam=#{isteam} WHERE id IN (${userids})"})
  Integer batchUpdateByUserIds(@Param("userids") String paramString, @Param("isteam") Boolean paramBoolean);
}


/* Location:              C:\Users\Administrator\Desktop\classes\!\cn\zhouxp\base\domapper\UserDoMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */