/*    */ package cn.zhouxp.base.service.impl;
/*    */ 
/*    */

import cn.zhouxp.base.mapper.ProductMapper;
import cn.zhouxp.base.model.Product;
import cn.zhouxp.base.model.ProductExample;
import cn.zhouxp.base.service.ProductService;
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
/*    */ public class ProductImpl
/*    */   extends BaseService
/*    */   implements ProductService
/*    */ {
/*    */   @Autowired
/*    */   private ProductMapper productMapper;
/*    */   
/*    */   public EUPageResult<Product> list(PageBean pageBean, Integer name) {
/* 31 */     ProductExample example = new ProductExample();
/*    */     
/* 33 */     ProductExample.Criteria criteria = example.createCriteria().andIsdelEqualTo(Boolean.valueOf(false));
/* 34 */     if (name != null) {
/* 35 */       criteria.andProductEqualTo(name);
/*    */     }
/*    */     
/* 38 */     PageHelper.startPage(pageBean.getPage().intValue(), pageBean.getRows().intValue());
/* 39 */     PageInfo<Product> info = new PageInfo(this.productMapper.selectByExample(example));
/* 40 */     return new EUPageResult(Long.valueOf(info.getTotal()), info.getList());
/*    */   }
/*    */ 
/*    */   
/*    */   public R delete(Long id) {
/* 45 */     Product product = new Product();
/* 46 */     product.setId(id);
/* 47 */     product.setIsdel(Boolean.valueOf(true));
/* 48 */     product.setOpid(this.opid);
/* 49 */     product.setOptime(new Date());
/* 50 */     this.productMapper.updateByPrimaryKeySelective(product);
/* 51 */     return R.OK();
/*    */   }
/*    */   
/*    */   private boolean isRepeat(Product product) {
/* 55 */     ProductExample example = new ProductExample();
/*    */ 
/*    */     
/* 58 */     ProductExample.Criteria criteria = example.createCriteria().andProductEqualTo(product.getProduct()).andIsdelEqualTo(Boolean.valueOf(false));
/* 59 */     if (product.getId() != null) {
/* 60 */       criteria.andIdNotEqualTo(product.getId());
/*    */     }
/* 62 */     List<Product> products = this.productMapper.selectByExample(example);
/* 63 */     if (products.size() == 0) {
/* 64 */       return false;
/*    */     }
/* 66 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public R save(Product product) {
/* 71 */     if (isRepeat(product)) {
/* 72 */       return R.ERROR("成件码数重复！");
/*    */     }
/* 74 */     product.setOpid(this.opid);
/* 75 */     product.setOptime(new Date());
/* 76 */     if (product.getId() == null) {
/* 77 */       this.productMapper.insertSelective(product);
/*    */     } else {
/* 79 */       this.productMapper.updateByPrimaryKeySelective(product);
/*    */     } 
/* 81 */     return R.OK();
/*    */   }
/*    */ 
/*    */   
/*    */   public List<Product> listall() {
/* 86 */     ProductExample example = new ProductExample();
/* 87 */     example.createCriteria()
/* 88 */       .andIsdelEqualTo(Boolean.valueOf(false));
/* 89 */     return this.productMapper.selectByExample(example);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\classes\!\cn\zhouxp\base\service\impl\ProductImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */