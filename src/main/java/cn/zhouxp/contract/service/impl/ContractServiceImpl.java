/*     */ package cn.zhouxp.contract.service.impl;
/*     */ 
/*     */

import cn.zhouxp.base.mapper.ProductMapper;
import cn.zhouxp.base.model.Product;
import cn.zhouxp.common.model.EUPageResult;
import cn.zhouxp.common.model.PageBean;
import cn.zhouxp.common.model.R;
import cn.zhouxp.common.model.SearchCon;
import cn.zhouxp.common.service.BaseService;
import cn.zhouxp.common.utils.BeanCopyUtil;
import cn.zhouxp.common.utils.ExcelUtil;
import cn.zhouxp.contract.domodel.VContractDo;
import cn.zhouxp.contract.mapper.ContractMapper;
import cn.zhouxp.contract.mapper.VContractMapper;
import cn.zhouxp.contract.model.Contract;
import cn.zhouxp.contract.model.ContractExample;
import cn.zhouxp.contract.model.VContract;
import cn.zhouxp.contract.model.VContractExample;
import cn.zhouxp.contract.service.ContractService;
import cn.zhouxp.stock.mapper.StockSumMapper;
import cn.zhouxp.stock.model.StockSum;
import cn.zhouxp.stock.model.StockSumExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
/*     */ @Service
/*     */ public class ContractServiceImpl
/*     */   extends BaseService
/*     */   implements ContractService
/*     */ {
/*     */   @Autowired
/*     */   private ContractMapper contractMapper;
/*     */   @Autowired
/*     */   private StockSumMapper stockSumMapper;
/*     */   @Autowired
/*     */   private ProductMapper productMapper;
/*     */   @Autowired
/*     */   private VContractMapper vContractMapper;
/*     */   
/*     */   public EUPageResult<VContract> list(PageBean pageBean, SearchCon searchCon) {
/*  59 */     VContractExample example = new VContractExample();
/*  60 */     VContractExample.Criteria criteria = example.createCriteria();
/*  61 */     if (!StringUtils.isEmpty(searchCon.getFindDate())) {
/*  62 */       criteria.andCdateEqualTo(searchCon.getFindDate());
/*     */     }
/*  64 */     if (!StringUtils.isEmpty(searchCon.getContainer())) {
/*  65 */       criteria.andContainerLike("%" + searchCon.getContainer() + "%");
/*     */     }
/*  67 */     if (!StringUtils.isEmpty(searchCon.getFlowerNo())) {
/*  68 */       criteria.andFlowerNoLike("%" + searchCon.getFlowerNo() + "%");
/*     */     }
/*  70 */     if (searchCon.getFinish() != null && searchCon.getFinish().intValue() != 2) {
/*  71 */       if (searchCon.getFinish().intValue() == 1) {
/*  72 */         criteria.andIsfinishEqualTo(Boolean.valueOf(true));
/*     */       } else {
/*  74 */         criteria.andIsfinishEqualTo(Boolean.valueOf(false));
/*     */       } 
/*     */     }
/*  77 */     PageHelper.startPage(pageBean.getPage().intValue(), pageBean.getRows().intValue());
/*  78 */     PageInfo<VContract> info = new PageInfo(this.vContractMapper.selectByExample(example));
/*     */     
/*  80 */     return new EUPageResult(Long.valueOf(info.getTotal()), info.getList());
/*     */   }
/*     */ 
/*     */   
/*     */   public List<Contract> getFlowerNo(String q) {
/*  85 */     ContractExample example = new ContractExample();
/*     */ 
/*     */     
/*  88 */     ContractExample.Criteria criteria = example.createCriteria().andIsfinishEqualTo(Boolean.valueOf(false)).andIsdelEqualTo(Boolean.valueOf(false));
/*  89 */     if (!StringUtils.isEmpty(q)) {
/*  90 */       criteria.andFlowerNoLike("%" + q + "%");
/*     */     }
/*     */     
/*  93 */     return this.contractMapper.selectByExample(example);
/*     */   }
/*     */   
/*     */   private void insert(Contract contract) {
/*  97 */     StockSum stockSum = new StockSum();
/*  98 */     stockSum.setOrderId(contract.getId());
/*  99 */     stockSum.setFlowerNo(contract.getFlowerNo());
/* 100 */     stockSum.setCdate(contract.getCdate());
/* 101 */     stockSum.setTsum(contract.getCnumber());
/* 102 */     Product product = this.productMapper.selectByPrimaryKey(contract.getProductId());
/* 103 */     stockSum.setCodelen(product.getProduct());
/* 104 */     stockSum.setOpid(contract.getOpid());
/* 105 */     stockSum.setOptime(contract.getOptime());
/* 106 */     this.stockSumMapper.insertSelective(stockSum);
/*     */   }
/*     */ 
/*     */   
/*     */   @Transactional
/*     */   public R save(Contract contract) {
/* 112 */     if (isRepeat(contract)) {
/* 113 */       return R.ERROR("在未完成订单中花号重复");
/*     */     }
/* 115 */     contract.setOpid(this.opid);
/* 116 */     Date date = new Date();
/* 117 */     contract.setOptime(date);
/* 118 */     if (contract.getId() == null) {
/* 119 */       String strDateFormat = "yyyy-MM-dd";
/* 120 */       SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
/* 121 */       contract.setCdate(sdf.format(date));
/* 122 */       this.contractMapper.insertSelective(contract);
/* 123 */       insert(contract);
/*     */     } else {
/* 125 */       this.contractMapper.updateByPrimaryKeySelective(contract);
/*     */     } 
/* 127 */     return R.OK();
/*     */   }
/*     */   private boolean isRepeat(Contract contract) {
/* 130 */     ContractExample example = new ContractExample();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 135 */     ContractExample.Criteria criteria = example.createCriteria().andFlowerNoEqualTo(contract.getFlowerNo()).andContainerEqualTo(contract.getContainer()).andIsfinishEqualTo(Boolean.valueOf(false)).andIsdelEqualTo(Boolean.valueOf(false));
/* 136 */     if (contract.getId() != null) {
/* 137 */       criteria.andIdNotEqualTo(contract.getId());
/*     */     }
/* 139 */     List<Contract> orders = this.contractMapper.selectByExample(example);
/* 140 */     if (orders.size() == 0) {
/* 141 */       return false;
/*     */     }
/* 143 */     return true;
/*     */   }
/*     */   
/*     */   @Transactional
/*     */   public R delete(Long id) {
/* 148 */     Contract contract = new Contract();
/* 149 */     contract.setId(id);
/* 150 */     contract.setIsdel(Boolean.valueOf(true));
/* 151 */     contract.setOpid(this.opid);
/* 152 */     contract.setOptime(new Date());
/* 153 */     this.contractMapper.updateByPrimaryKeySelective(contract);
/*     */     
/* 155 */     StockSumExample example = new StockSumExample();
/* 156 */     example.createCriteria().andOrderIdEqualTo(id);
/* 157 */     StockSum stockSum = new StockSum();
/* 158 */     stockSum.setIsdel(Boolean.valueOf(true));
/* 159 */     stockSum.setOpid(contract.getOpid());
/* 160 */     stockSum.setOptime(contract.getOptime());
/* 161 */     this.stockSumMapper.updateByExampleSelective(stockSum, example);
/* 162 */     return R.OK();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/* 167 */   public List<Contract> listall() { return null; }
/*     */ 
/*     */ 
/*     */   
/*     */   public R downloadFile(HttpServletResponse response) {
/* 172 */     response.setContentType("application/force-download");
/* 173 */     List<VContract> vContracts = this.vContractMapper.selectByExample(null);
/*     */     
/* 175 */     List<VContractDo> vContractDos = BeanCopyUtil.copyListProperties(vContracts, VContractDo::new);
/*     */     
/* 177 */     ExcelUtil.exportExcel(vContractDos, "订单", "订单", VContractDo.class, "订单.xls", response);
/* 178 */     return R.OK();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\classes\!\cn\zhouxp\contract\service\impl\ContractServiceImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */