/*    */ package cn.zhouxp.customer.service.impl;
/*    */ 
/*    */ import cn.zhouxp.common.model.EUPageResult;
/*    */ import cn.zhouxp.common.model.PageBean;
/*    */ import cn.zhouxp.common.model.R;
/*    */ import cn.zhouxp.common.service.BaseService;
/*    */ import cn.zhouxp.customer.mapper.CategroyMapper;
/*    */ import cn.zhouxp.customer.model.Categroy;
/*    */ import cn.zhouxp.customer.model.CategroyExample;
/*    */ import cn.zhouxp.customer.service.CategroyService;
/*    */ import com.github.pagehelper.PageHelper;
/*    */ import com.github.pagehelper.PageInfo;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Service
/*    */ public class CategroyServiceImpl
/*    */   extends BaseService
/*    */   implements CategroyService
/*    */ {
/*    */   @Autowired
/*    */   private CategroyMapper categroyMapper;
/*    */   
/*    */   public EUPageResult<Categroy> list(PageBean pageBean, String name) {
/* 33 */     CategroyExample example = new CategroyExample();
/*    */     
/* 35 */     CategroyExample.Criteria criteria = example.createCriteria().andIsdelEqualTo(Boolean.valueOf(false));
/* 36 */     if (name != null) {
/* 37 */       criteria.andCnameLike("%" + name + "%");
/*    */     }
/*    */     
/* 40 */     PageHelper.startPage(pageBean.getPage().intValue(), pageBean.getRows().intValue());
/* 41 */     PageInfo<Categroy> info = new PageInfo(this.categroyMapper.selectByExample(example));
/* 42 */     return new EUPageResult(Long.valueOf(info.getTotal()), info.getList());
/*    */   }
/*    */ 
/*    */   
/*    */   public R delete(Long id) {
/* 47 */     Categroy categroy = new Categroy();
/* 48 */     categroy.setId(id);
/* 49 */     categroy.setIsdel(Boolean.valueOf(true));
/* 50 */     categroy.setOpid(this.opid);
/* 51 */     categroy.setOptime(new Date());
/* 52 */     this.categroyMapper.updateByPrimaryKeySelective(categroy);
/* 53 */     return R.OK();
/*    */   }
/*    */ 
/*    */   
/*    */   public List<Categroy> listall() {
/* 58 */     CategroyExample example = new CategroyExample();
/*    */     
/* 60 */     CategroyExample.Criteria criteria = example.createCriteria().andIsdelEqualTo(Boolean.valueOf(false));
/* 61 */     return this.categroyMapper.selectByExample(example);
/*    */   }
/*    */   
/*    */   private boolean isRepeat(Categroy categroy) {
/* 65 */     CategroyExample example = new CategroyExample();
/*    */ 
/*    */     
/* 68 */     CategroyExample.Criteria criteria = example.createCriteria().andCnameEqualTo(categroy.getCname()).andIsdelEqualTo(Boolean.valueOf(false));
/* 69 */     if (categroy.getId() != null) {
/* 70 */       criteria.andIdNotEqualTo(categroy.getId());
/*    */     }
/* 72 */     List<Categroy> categroys = this.categroyMapper.selectByExample(example);
/* 73 */     if (categroys.size() == 0) {
/* 74 */       return false;
/*    */     }
/* 76 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public R save(Categroy categroy) {
/* 81 */     if (isRepeat(categroy)) {
/* 82 */       return R.ERROR("客户分类名重复！");
/*    */     }
/* 84 */     categroy.setOpid(this.opid);
/* 85 */     categroy.setOptime(new Date());
/* 86 */     if (categroy.getId() == null) {
/* 87 */       this.categroyMapper.insertSelective(categroy);
/*    */     } else {
/* 89 */       this.categroyMapper.updateByPrimaryKeySelective(categroy);
/*    */     } 
/* 91 */     return R.OK();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\classes\!\cn\zhouxp\customer\service\impl\CategroyServiceImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */