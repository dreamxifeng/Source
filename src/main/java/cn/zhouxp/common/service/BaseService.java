/*    */ package cn.zhouxp.common.service;
/*    */ 
/*    */

import cn.zhouxp.common.utils.ShiroUtils;
import cn.zhouxp.sys.model.User;
import org.springframework.web.bind.annotation.ModelAttribute;

/*    */ public class BaseService
/*    */ {
/* 13 */   protected Long opid = Long.valueOf(1L);
/*    */   protected User user;
/*    */   
/*    */   @ModelAttribute
/*    */   public void opUser() {
/* 18 */     this.user = ShiroUtils.getUser();
/* 19 */     if (this.user != null)
/* 20 */       this.opid = this.user.getId(); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\classes\!\cn\zhouxp\common\service\BaseService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */