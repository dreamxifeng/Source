/*     */ package cn.zhouxp.contract.service.impl;
/*     */ 
/*     */ import cn.zhouxp.common.model.R;
/*     */ import cn.zhouxp.common.service.BaseService;
/*     */ import cn.zhouxp.contract.mapper.ExtraMapper;
/*     */ import cn.zhouxp.contract.model.Extra;
/*     */ import cn.zhouxp.contract.model.ExtraExample;
/*     */ import cn.zhouxp.contract.service.ExtraService;
/*     */ import java.io.IOException;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import javax.servlet.ServletOutputStream;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Service;
/*     */ import org.springframework.web.multipart.MultipartFile;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Service
/*     */ public class ExtraServiceImpl
/*     */   extends BaseService
/*     */   implements ExtraService
/*     */ {
/*     */   @Autowired
/*     */   private ExtraMapper extraMapper;
/*     */   
/*     */   public R delete(Long id) {
/*  33 */     Extra extra = new Extra();
/*  34 */     extra.setId(id);
/*  35 */     extra.setIsdel(Boolean.valueOf(true));
/*  36 */     extra.setOpid(this.opid);
/*  37 */     extra.setOptime(new Date());
/*  38 */     ExtraExample extraExample = new ExtraExample();
/*  39 */     extraExample.createCriteria()
/*  40 */       .andIdEqualTo(id);
/*  41 */     this.extraMapper.updateByExampleSelective(extra, extraExample);
/*  42 */     return R.OK();
/*     */   }
/*     */   
/*     */   private boolean isRepeat(Extra extra) {
/*  46 */     ExtraExample example = new ExtraExample();
/*     */ 
/*     */     
/*  49 */     ExtraExample.Criteria criteria = example.createCriteria().andSummaryEqualTo(extra.getSummary()).andIsdelEqualTo(Boolean.valueOf(false));
/*  50 */     if (extra.getId() != null) {
/*  51 */       criteria.andIdNotEqualTo(extra.getId());
/*     */     }
/*  53 */     List<Extra> extras = this.extraMapper.selectByExample(example);
/*  54 */     if (extras.size() == 0) {
/*  55 */       return false;
/*     */     }
/*  57 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public R save(MultipartFile file, Extra extra) {
/*  62 */     if (isRepeat(extra)) {
/*  63 */       return R.ERROR("附件说明不能重复！");
/*     */     }
/*  65 */     extra.setOpid(this.opid);
/*  66 */     extra.setOptime(new Date());
/*  67 */     int r = getR(file, extra);
/*  68 */     if (r == 2) {
/*  69 */       return R.ERROR("系统错误！");
/*     */     }
/*  71 */     if (extra.getId() == null) {
/*  72 */       if (r == -1) {
/*  73 */         return R.ERROR("附件不能为空！");
/*     */       }
/*  75 */       this.extraMapper.insertSelective(extra);
/*     */     } else {
/*  77 */       ExtraExample example = new ExtraExample();
/*  78 */       example.createCriteria().andIdEqualTo(extra.getId());
/*  79 */       this.extraMapper.updateByExampleSelective(extra, example);
/*     */     } 
/*  81 */     return R.OK();
/*     */   }
/*     */   
/*     */   private int getR(MultipartFile file, Extra extra) {
/*  85 */     if (file.isEmpty()) {
/*  86 */       return -1;
/*     */     }
/*  88 */     String fileName = file.getOriginalFilename();
/*  89 */     extra.setFilename(fileName);
/*     */     try {
/*  91 */       extra.setExtra(file.getBytes());
/*  92 */     } catch (IOException e) {
/*  93 */       e.printStackTrace();
/*  94 */       return 2;
/*     */     } 
/*  96 */     return 3;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<Extra> listall(Long orderid) {
/* 101 */     ExtraExample example = new ExtraExample();
/* 102 */     example.createCriteria()
/* 103 */       .andOrderIdEqualTo(orderid)
/* 104 */       .andIsdelEqualTo(Boolean.valueOf(false));
/* 105 */     return this.extraMapper.selectByExample(example);
/*     */   }
/*     */ 
/*     */   
/*     */   public R downloadFile(HttpServletResponse response, Long id) {
/* 110 */     ExtraExample example = new ExtraExample();
/* 111 */     example.createCriteria()
/* 112 */       .andIdEqualTo(id);
/* 113 */     List<Extra> extras = this.extraMapper.selectByExampleWithBLOBs(example);
/* 114 */     if (extras == null || extras.size() < 1) {
/* 115 */       return R.ERROR("下载失败1");
/*     */     }
/* 117 */     Extra extra = extras.get(0);
/* 118 */     response.setContentType("application/force-download");
/* 119 */     response.addHeader("Content-Disposition", "attachment;fileName=" + extra.getFilename());
/*     */     try {
/* 121 */       ServletOutputStream outputStream = response.getOutputStream();
/* 122 */       outputStream.write(extra.getExtra());
/* 123 */     } catch (IOException e) {
/* 124 */       e.printStackTrace();
/* 125 */       return R.ERROR("下载失败");
/*     */     } 
/*     */     
/* 128 */     return R.OK();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\classes\!\cn\zhouxp\contract\service\impl\ExtraServiceImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */