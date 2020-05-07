/*    */ package cn.zhouxp.base.service.impl;
/*    */ 
/*    */

import cn.zhouxp.base.mapper.PrintingFactoryMapper;
import cn.zhouxp.base.model.PrintingFactory;
import cn.zhouxp.base.model.PrintingFactoryExample;
import cn.zhouxp.base.service.PrintingFactoryService;
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
/*    */ public class PrintingFactoryServiceImpl
/*    */   extends BaseService
/*    */   implements PrintingFactoryService
/*    */ {
/*    */   @Autowired
/*    */   private PrintingFactoryMapper printingFactoryMapper;
/*    */   
/*    */   public EUPageResult<PrintingFactory> list(PageBean pageBean, String name) {
/* 31 */     PrintingFactoryExample example = new PrintingFactoryExample();
/*    */     
/* 33 */     PrintingFactoryExample.Criteria criteria = example.createCriteria().andIsdelEqualTo(Boolean.valueOf(false));
/* 34 */     if (name != null) {
/* 35 */       criteria.andPrintingFactoryEqualTo("%" + name + "%");
/*    */     }
/*    */     
/* 38 */     PageHelper.startPage(pageBean.getPage().intValue(), pageBean.getRows().intValue());
/* 39 */     PageInfo<PrintingFactory> info = new PageInfo(this.printingFactoryMapper.selectByExample(example));
/* 40 */     return new EUPageResult(Long.valueOf(info.getTotal()), info.getList());
/*    */   }
/*    */ 
/*    */   
/*    */   public R delete(Long id) {
/* 45 */     PrintingFactory printingFactory = new PrintingFactory();
/* 46 */     printingFactory.setId(id);
/* 47 */     printingFactory.setIsdel(Boolean.valueOf(true));
/* 48 */     printingFactory.setOpid(this.opid);
/* 49 */     printingFactory.setOptime(new Date());
/* 50 */     this.printingFactoryMapper.updateByPrimaryKeySelective(printingFactory);
/* 51 */     return R.OK();
/*    */   }
/*    */   
/*    */   private boolean isRepeat(PrintingFactory printingFactory) {
/* 55 */     PrintingFactoryExample example = new PrintingFactoryExample();
/*    */ 
/*    */     
/* 58 */     PrintingFactoryExample.Criteria criteria = example.createCriteria().andCcodeEqualTo(printingFactory.getCcode()).andIsdelEqualTo(Boolean.valueOf(false));
/* 59 */     if (printingFactory.getId() != null) {
/* 60 */       criteria.andIdNotEqualTo(printingFactory.getId());
/*    */     }
/* 62 */     List<PrintingFactory> printingFactorys = this.printingFactoryMapper.selectByExample(example);
/* 63 */     if (printingFactorys.size() == 0) {
/* 64 */       return false;
/*    */     }
/* 66 */     return true;
/*    */   }
/*    */   
/*    */   public R save(PrintingFactory printingFactory) {
/* 70 */     if (isRepeat(printingFactory)) {
/* 71 */       return R.ERROR("厂家代码重复！");
/*    */     }
/* 73 */     printingFactory.setOpid(this.opid);
/* 74 */     printingFactory.setOptime(new Date());
/* 75 */     if (printingFactory.getId() == null) {
/* 76 */       this.printingFactoryMapper.insertSelective(printingFactory);
/*    */     } else {
/* 78 */       this.printingFactoryMapper.updateByPrimaryKeySelective(printingFactory);
/*    */     } 
/* 80 */     return R.OK();
/*    */   }
/*    */ 
/*    */   
/*    */   public List<PrintingFactory> listall() {
/* 85 */     PrintingFactoryExample example = new PrintingFactoryExample();
/* 86 */     example.createCriteria()
/* 87 */       .andIsdelEqualTo(Boolean.valueOf(false));
/* 88 */     return this.printingFactoryMapper.selectByExample(example);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\classes\!\cn\zhouxp\base\service\impl\PrintingFactoryServiceImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */