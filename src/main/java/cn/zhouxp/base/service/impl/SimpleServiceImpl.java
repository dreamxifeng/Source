/*    */ package cn.zhouxp.base.service.impl;
/*    */ 
/*    */

import cn.zhouxp.base.mapper.SimpleMapper;
import cn.zhouxp.base.model.Simple;
import cn.zhouxp.base.model.SimpleExample;
import cn.zhouxp.base.service.SimpleService;
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
/*    */ public class SimpleServiceImpl
/*    */   extends BaseService
/*    */   implements SimpleService
/*    */ {
/*    */   @Autowired
/*    */   private SimpleMapper simpleMapper;
/*    */   
/*    */   public EUPageResult<Simple> list(PageBean pageBean, String name) {
/* 31 */     SimpleExample example = new SimpleExample();
/*    */     
/* 33 */     SimpleExample.Criteria criteria = example.createCriteria().andIsdelEqualTo(Boolean.valueOf(false));
/* 34 */     if (name != null) {
/* 35 */       criteria.andCnameLike("%" + name + "%");
/*    */     }
/*    */     
/* 38 */     PageHelper.startPage(pageBean.getPage().intValue(), pageBean.getRows().intValue());
/* 39 */     PageInfo<Simple> info = new PageInfo(this.simpleMapper.selectByExample(example));
/* 40 */     return new EUPageResult(Long.valueOf(info.getTotal()), info.getList());
/*    */   }
/*    */ 
/*    */   
/*    */   public R delete(Long id) {
/* 45 */     Simple simples = new Simple();
/* 46 */     simples.setId(id);
/* 47 */     simples.setIsdel(Boolean.valueOf(true));
/* 48 */     simples.setOpid(this.opid);
/* 49 */     simples.setOptime(new Date());
/* 50 */     this.simpleMapper.updateByPrimaryKeySelective(simples);
/* 51 */     return R.OK();
/*    */   }
/*    */   
/*    */   private boolean isRepeat(Simple simple) {
/* 55 */     SimpleExample example = new SimpleExample();
/*    */ 
/*    */     
/* 58 */     SimpleExample.Criteria criteria = example.createCriteria().andCnameEqualTo(simple.getCname()).andIsdelEqualTo(Boolean.valueOf(false));
/* 59 */     if (simple.getId() != null) {
/* 60 */       criteria.andIdNotEqualTo(simple.getId());
/*    */     }
/* 62 */     List<Simple> simples = this.simpleMapper.selectByExample(example);
/* 63 */     if (simples.size() == 0) {
/* 64 */       return false;
/*    */     }
/* 66 */     return true;
/*    */   }
/*    */   
/*    */   public R save(Simple simple) {
/* 70 */     if (isRepeat(simple)) {
/* 71 */       return R.ERROR("样品名称重复！");
/*    */     }
/* 73 */     simple.setOpid(this.opid);
/* 74 */     simple.setOptime(new Date());
/* 75 */     if (simple.getId() == null) {
/* 76 */       this.simpleMapper.insertSelective(simple);
/*    */     } else {
/* 78 */       this.simpleMapper.updateByPrimaryKeySelective(simple);
/*    */     } 
/* 80 */     return R.OK();
/*    */   }
/*    */ 
/*    */   
/*    */   public List<Simple> listall() {
/* 85 */     SimpleExample example = new SimpleExample();
/* 86 */     example.createCriteria()
/* 87 */       .andIsdelEqualTo(Boolean.valueOf(false));
/* 88 */     return this.simpleMapper.selectByExample(example);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\classes\!\cn\zhouxp\base\service\impl\SimpleServiceImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */