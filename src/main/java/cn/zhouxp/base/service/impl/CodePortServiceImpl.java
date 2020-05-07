/*    */ package cn.zhouxp.base.service.impl;
/*    */ 
/*    */

import cn.zhouxp.base.mapper.CodePortMapper;
import cn.zhouxp.base.model.CodePort;
import cn.zhouxp.base.model.CodePortExample;
import cn.zhouxp.base.service.CodePortService;
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

/*    */ @Service
/*    */ public class CodePortServiceImpl
/*    */   extends BaseService
/*    */   implements CodePortService
/*    */ {
/*    */   @Autowired
/*    */   private CodePortMapper codePortMapper;
/*    */   
/*    */   public EUPageResult<CodePort> list(PageBean pageBean, Integer name) {
/* 31 */     CodePortExample example = new CodePortExample();
/*    */     
/* 33 */     CodePortExample.Criteria criteria = example.createCriteria().andIsdelEqualTo(Boolean.valueOf(false));
/* 34 */     if (name != null) {
/* 35 */       criteria.andCodePortEqualTo(name);
/*    */     }
/*    */     
/* 38 */     PageHelper.startPage(pageBean.getPage().intValue(), pageBean.getRows().intValue());
/* 39 */     PageInfo<CodePort> info = new PageInfo(this.codePortMapper.selectByExample(example));
/* 40 */     return new EUPageResult(Long.valueOf(info.getTotal()), info.getList());
/*    */   }
/*    */ 
/*    */   
/*    */   public R delete(Long id) {
/* 45 */     CodePort codePort = new CodePort();
/* 46 */     codePort.setId(id);
/* 47 */     codePort.setIsdel(Boolean.valueOf(true));
/* 48 */     codePort.setOpid(this.opid);
/* 49 */     codePort.setOptime(new Date());
/* 50 */     this.codePortMapper.updateByPrimaryKeySelective(codePort);
/* 51 */     return R.OK();
/*    */   }
/*    */   
/*    */   private boolean isRepeat(CodePort codePort) {
/* 55 */     CodePortExample example = new CodePortExample();
/*    */ 
/*    */     
/* 58 */     CodePortExample.Criteria criteria = example.createCriteria().andCodePortEqualTo(codePort.getCodePort()).andIsdelEqualTo(Boolean.valueOf(false));
/* 59 */     if (codePort.getId() != null) {
/* 60 */       criteria.andIdNotEqualTo(codePort.getId());
/*    */     }
/* 62 */     List<CodePort> codePorts = this.codePortMapper.selectByExample(example);
/* 63 */     if (codePorts.size() == 0) {
/* 64 */       return false;
/*    */     }
/* 66 */     return true;
/*    */   }
/*    */   
/*    */   public R save(CodePort codePort) {
/* 70 */     if (isRepeat(codePort)) {
/* 71 */       return R.ERROR("码口重复！");
/*    */     }
/* 73 */     codePort.setOpid(this.opid);
/* 74 */     codePort.setOptime(new Date());
/* 75 */     if (codePort.getId() == null) {
/* 76 */       this.codePortMapper.insertSelective(codePort);
/*    */     } else {
/* 78 */       this.codePortMapper.updateByPrimaryKeySelective(codePort);
/*    */     } 
/* 80 */     return R.OK();
/*    */   }
/*    */   
/*    */   public List<CodePort> listall() {
/* 84 */     CodePortExample example = new CodePortExample();
/* 85 */     example.createCriteria()
/* 86 */       .andIsdelEqualTo(Boolean.valueOf(false));
/* 87 */     return this.codePortMapper.selectByExample(example);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\classes\!\cn\zhouxp\base\service\impl\CodePortServiceImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */