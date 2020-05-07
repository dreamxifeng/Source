/*    */ package cn.zhouxp.base.service.impl;
/*    */ 
/*    */

import cn.zhouxp.base.mapper.OpenScissorsMapper;
import cn.zhouxp.base.model.OpenScissors;
import cn.zhouxp.base.model.OpenScissorsExample;
import cn.zhouxp.base.service.OpenScissorsService;
import cn.zhouxp.common.model.EUPageResult;
import cn.zhouxp.common.model.PageBean;
import cn.zhouxp.common.model.R;
import cn.zhouxp.common.service.BaseService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Service
/*    */ public class OpenScissorsServiceImpl
/*    */   extends BaseService
/*    */   implements OpenScissorsService
/*    */ {
/*    */   @Autowired
/*    */   private OpenScissorsMapper openScissorsMapper;
/*    */   
/*    */   public EUPageResult<OpenScissors> list(PageBean pageBean, Integer name) {
/* 31 */     OpenScissorsExample example = new OpenScissorsExample();
/*    */     
/* 33 */     OpenScissorsExample.Criteria criteria = example.createCriteria().andIsdelEqualTo(Boolean.valueOf(false));
/* 34 */     if (name != null) {
/* 35 */       criteria.andOpenScissorsEqualTo(name);
/*    */     }
/*    */     
/* 38 */     PageHelper.startPage(pageBean.getPage().intValue(), pageBean.getRows().intValue());
/* 39 */     PageInfo<OpenScissors> info = new PageInfo(this.openScissorsMapper.selectByExample(example));
/* 40 */     return new EUPageResult(Long.valueOf(info.getTotal()), info.getList());
/*    */   }
/*    */ 
/*    */   
/*    */   public R delete(Long id) {
/* 45 */     OpenScissors openScissorss = new OpenScissors();
/* 46 */     openScissorss.setId(id);
/* 47 */     openScissorss.setIsdel(Boolean.valueOf(true));
/* 48 */     openScissorss.setOpid(this.opid);
/* 49 */     openScissorss.setOptime(new Date());
/* 50 */     this.openScissorsMapper.updateByPrimaryKeySelective(openScissorss);
/* 51 */     return R.OK();
/*    */   }
/*    */   
/*    */   private boolean isRepeat(OpenScissors openScissors) {
/* 55 */     OpenScissorsExample example = new OpenScissorsExample();
/*    */ 
/*    */     
/* 58 */     OpenScissorsExample.Criteria criteria = example.createCriteria().andOpenScissorsEqualTo(openScissors.getOpenScissors()).andIsdelEqualTo(Boolean.valueOf(false));
/* 59 */     if (openScissors.getId() != null) {
/* 60 */       criteria.andIdNotEqualTo(openScissors.getId());
/*    */     }
/* 62 */     List<OpenScissors> openScissorss = this.openScissorsMapper.selectByExample(example);
/* 63 */     if (openScissorss.size() == 0) {
/* 64 */       return false;
/*    */     }
/* 66 */     return true;
/*    */   }
/*    */   
/*    */   public R save(OpenScissors openScissors) {
/* 70 */     if (isRepeat(openScissors)) {
/* 71 */       return R.ERROR("码数重复！");
/*    */     }
/* 73 */     openScissors.setOpid(this.opid);
/* 74 */     openScissors.setOptime(new Date());
/* 75 */     if (openScissors.getId() == null) {
/* 76 */       this.openScissorsMapper.insertSelective(openScissors);
/*    */     } else {
/* 78 */       this.openScissorsMapper.updateByPrimaryKeySelective(openScissors);
/*    */     } 
/* 80 */     return R.OK();
/*    */   }
/*    */ 
/*    */   
/*    */   public List<OpenScissors> listall() {
/* 85 */     OpenScissorsExample example = new OpenScissorsExample();
/* 86 */     example.createCriteria()
/* 87 */       .andIsdelEqualTo(Boolean.valueOf(false));
/* 88 */     return this.openScissorsMapper.selectByExample(example);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\classes\!\cn\zhouxp\base\service\impl\OpenScissorsServiceImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */