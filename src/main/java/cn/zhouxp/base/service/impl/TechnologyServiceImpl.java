/*    */ package cn.zhouxp.base.service.impl;
/*    */ 
/*    */

import cn.zhouxp.base.mapper.TechnologyMapper;
import cn.zhouxp.base.model.Technology;
import cn.zhouxp.base.model.TechnologyExample;
import cn.zhouxp.base.service.TechnologyService;
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
/*    */ 
/*    */ @Service
/*    */ public class TechnologyServiceImpl
/*    */   extends BaseService
/*    */   implements TechnologyService
/*    */ {
/*    */   @Autowired
/*    */   private TechnologyMapper technologyMapper;
/*    */   
/*    */   public EUPageResult<Technology> list(PageBean pageBean, String name) {
/* 32 */     TechnologyExample example = new TechnologyExample();
/*    */     
/* 34 */     TechnologyExample.Criteria criteria = example.createCriteria().andIsdelEqualTo(Boolean.valueOf(false));
/* 35 */     if (name != null) {
/* 36 */       criteria.andTechnologyLike("%" + name + "%");
/*    */     }
/*    */     
/* 39 */     PageHelper.startPage(pageBean.getPage().intValue(), pageBean.getRows().intValue());
/* 40 */     PageInfo<Technology> info = new PageInfo(this.technologyMapper.selectByExample(example));
/* 41 */     return new EUPageResult(Long.valueOf(info.getTotal()), info.getList());
/*    */   }
/*    */ 
/*    */   
/*    */   public R delete(Long id) {
/* 46 */     Technology technology = new Technology();
/* 47 */     technology.setId(id);
/* 48 */     technology.setIsdel(Boolean.valueOf(true));
/* 49 */     technology.setOpid(this.opid);
/* 50 */     technology.setOptime(new Date());
/* 51 */     this.technologyMapper.updateByPrimaryKeySelective(technology);
/* 52 */     return R.OK();
/*    */   }
/*    */   
/*    */   private boolean isRepeat(Technology technology) {
/* 56 */     TechnologyExample example = new TechnologyExample();
/*    */ 
/*    */     
/* 59 */     TechnologyExample.Criteria criteria = example.createCriteria().andTechnologyEqualTo(technology.getTechnology()).andIsdelEqualTo(Boolean.valueOf(false));
/* 60 */     if (technology.getId() != null) {
/* 61 */       criteria.andIdNotEqualTo(technology.getId());
/*    */     }
/* 63 */     List<Technology> technologys = this.technologyMapper.selectByExample(example);
/* 64 */     if (technologys.size() == 0) {
/* 65 */       return false;
/*    */     }
/* 67 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public R save(Technology technology) {
/* 72 */     if (isRepeat(technology)) {
/* 73 */       return R.ERROR("工艺要求重复！");
/*    */     }
/* 75 */     technology.setOpid(this.opid);
/* 76 */     technology.setOptime(new Date());
/* 77 */     if (technology.getId() == null) {
/* 78 */       this.technologyMapper.insertSelective(technology);
/*    */     } else {
/* 80 */       this.technologyMapper.updateByPrimaryKeySelective(technology);
/*    */     } 
/* 82 */     return R.OK();
/*    */   }
/*    */   
/*    */   public List<Technology> listall() {
/* 86 */     TechnologyExample example = new TechnologyExample();
/* 87 */     example.createCriteria()
/* 88 */       .andIsdelEqualTo(Boolean.valueOf(false));
/* 89 */     return this.technologyMapper.selectByExample(example);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\classes\!\cn\zhouxp\base\service\impl\TechnologyServiceImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */