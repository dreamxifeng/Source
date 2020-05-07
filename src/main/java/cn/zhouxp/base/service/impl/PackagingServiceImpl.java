/*    */ package cn.zhouxp.base.service.impl;
/*    */ 
/*    */

import cn.zhouxp.base.mapper.PackagingMapper;
import cn.zhouxp.base.model.Packaging;
import cn.zhouxp.base.model.PackagingExample;
import cn.zhouxp.base.service.PackagingService;
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
/*    */ public class PackagingServiceImpl
/*    */   extends BaseService
/*    */   implements PackagingService
/*    */ {
/*    */   @Autowired
/*    */   private PackagingMapper packagingMapper;
/*    */   
/*    */   public EUPageResult<Packaging> list(PageBean pageBean, String name) {
/* 31 */     PackagingExample example = new PackagingExample();
/*    */     
/* 33 */     PackagingExample.Criteria criteria = example.createCriteria().andIsdelEqualTo(Boolean.valueOf(false));
/* 34 */     if (name != null) {
/* 35 */       criteria.andPackagingLike("%" + name + "%");
/*    */     }
/*    */     
/* 38 */     PageHelper.startPage(pageBean.getPage().intValue(), pageBean.getRows().intValue());
/* 39 */     PageInfo<Packaging> info = new PageInfo(this.packagingMapper.selectByExample(example));
/* 40 */     return new EUPageResult(Long.valueOf(info.getTotal()), info.getList());
/*    */   }
/*    */ 
/*    */   
/*    */   public R delete(Long id) {
/* 45 */     Packaging packaging = new Packaging();
/* 46 */     packaging.setId(id);
/* 47 */     packaging.setIsdel(Boolean.valueOf(true));
/* 48 */     packaging.setOpid(this.opid);
/* 49 */     packaging.setOptime(new Date());
/* 50 */     this.packagingMapper.updateByPrimaryKeySelective(packaging);
/* 51 */     return R.OK();
/*    */   }
/*    */   
/*    */   private boolean isRepeat(Packaging packaging) {
/* 55 */     PackagingExample example = new PackagingExample();
/*    */ 
/*    */     
/* 58 */     PackagingExample.Criteria criteria = example.createCriteria().andPackagingEqualTo(packaging.getPackaging()).andIsdelEqualTo(Boolean.valueOf(false));
/* 59 */     if (packaging.getId() != null) {
/* 60 */       criteria.andIdNotEqualTo(packaging.getId());
/*    */     }
/* 62 */     List<Packaging> packagings = this.packagingMapper.selectByExample(example);
/* 63 */     if (packagings.size() == 0) {
/* 64 */       return false;
/*    */     }
/* 66 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public R save(Packaging packaging) {
/* 71 */     if (isRepeat(packaging)) {
/* 72 */       return R.ERROR("包装要求重复！");
/*    */     }
/* 74 */     packaging.setOpid(this.opid);
/* 75 */     packaging.setOptime(new Date());
/* 76 */     if (packaging.getId() == null) {
/* 77 */       this.packagingMapper.insertSelective(packaging);
/*    */     } else {
/* 79 */       this.packagingMapper.updateByPrimaryKeySelective(packaging);
/*    */     } 
/* 81 */     return R.OK();
/*    */   }
/*    */   
/*    */   public List<Packaging> listall() {
/* 85 */     PackagingExample example = new PackagingExample();
/* 86 */     example.createCriteria()
/* 87 */       .andIsdelEqualTo(Boolean.valueOf(false));
/* 88 */     return this.packagingMapper.selectByExample(example);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\classes\!\cn\zhouxp\base\service\impl\PackagingServiceImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */