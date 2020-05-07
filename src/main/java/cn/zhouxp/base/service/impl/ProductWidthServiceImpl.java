/*    */ package cn.zhouxp.base.service.impl;
/*    */ 
/*    */

import cn.zhouxp.base.mapper.ProductWidthMapper;
import cn.zhouxp.base.model.ProductWidth;
import cn.zhouxp.base.model.ProductWidthExample;
import cn.zhouxp.base.service.ProductWidthService;
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
/*    */ public class ProductWidthServiceImpl
/*    */   extends BaseService
/*    */   implements ProductWidthService
/*    */ {
/*    */   @Autowired
/*    */   private ProductWidthMapper productWidthMapper;
/*    */   
/*    */   public EUPageResult<ProductWidth> list(PageBean pageBean, Integer name) {
/* 31 */     ProductWidthExample example = new ProductWidthExample();
/*    */     
/* 33 */     ProductWidthExample.Criteria criteria = example.createCriteria().andIsdelEqualTo(Boolean.valueOf(false));
/* 34 */     if (name != null) {
/* 35 */       criteria.andProductWidthEqualTo(name);
/*    */     }
/*    */     
/* 38 */     PageHelper.startPage(pageBean.getPage().intValue(), pageBean.getRows().intValue());
/* 39 */     PageInfo<ProductWidth> info = new PageInfo(this.productWidthMapper.selectByExample(example));
/* 40 */     return new EUPageResult(Long.valueOf(info.getTotal()), info.getList());
/*    */   }
/*    */ 
/*    */   
/*    */   public R delete(Long id) {
/* 45 */     ProductWidth productWidth = new ProductWidth();
/* 46 */     productWidth.setId(id);
/* 47 */     productWidth.setIsdel(Boolean.valueOf(true));
/* 48 */     productWidth.setOpid(this.opid);
/* 49 */     productWidth.setOptime(new Date());
/* 50 */     this.productWidthMapper.updateByPrimaryKeySelective(productWidth);
/* 51 */     return R.OK();
/*    */   }
/*    */   
/*    */   private boolean isRepeat(ProductWidth productWidth) {
/* 55 */     ProductWidthExample example = new ProductWidthExample();
/*    */ 
/*    */     
/* 58 */     ProductWidthExample.Criteria criteria = example.createCriteria().andProductWidthEqualTo(productWidth.getProductWidth()).andIsdelEqualTo(Boolean.valueOf(false));
/* 59 */     if (productWidth.getId() != null) {
/* 60 */       criteria.andIdNotEqualTo(productWidth.getId());
/*    */     }
/* 62 */     List<ProductWidth> productWidths = this.productWidthMapper.selectByExample(example);
/* 63 */     if (productWidths.size() == 0) {
/* 64 */       return false;
/*    */     }
/* 66 */     return true;
/*    */   }
/*    */   
/*    */   public R save(ProductWidth productWidth) {
/* 70 */     if (isRepeat(productWidth)) {
/* 71 */       return R.ERROR("成品幅宽重复！");
/*    */     }
/* 73 */     productWidth.setOpid(this.opid);
/* 74 */     productWidth.setOptime(new Date());
/* 75 */     if (productWidth.getId() == null) {
/* 76 */       this.productWidthMapper.insertSelective(productWidth);
/*    */     } else {
/* 78 */       this.productWidthMapper.updateByPrimaryKeySelective(productWidth);
/*    */     } 
/* 80 */     return R.OK();
/*    */   }
/*    */ 
/*    */   
/*    */   public List<ProductWidth> listall() {
/* 85 */     ProductWidthExample example = new ProductWidthExample();
/* 86 */     example.createCriteria()
/* 87 */       .andIsdelEqualTo(Boolean.valueOf(false));
/* 88 */     return this.productWidthMapper.selectByExample(example);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\classes\!\cn\zhouxp\base\service\impl\ProductWidthServiceImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */