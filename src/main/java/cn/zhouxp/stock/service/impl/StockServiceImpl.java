/*     */ package cn.zhouxp.stock.service.impl;
/*     */ 
/*     */

import cn.zhouxp.common.exception.RRException;
import cn.zhouxp.common.model.EUPageResult;
import cn.zhouxp.common.model.PageBean;
import cn.zhouxp.common.model.R;
import cn.zhouxp.common.service.BaseService;
import cn.zhouxp.contract.mapper.ContractMapper;
import cn.zhouxp.contract.model.Contract;
import cn.zhouxp.stock.mapper.StockMapper;
import cn.zhouxp.stock.mapper.StockSumMapper;
import cn.zhouxp.stock.mapper.VStockMapper;
import cn.zhouxp.stock.model.*;
import cn.zhouxp.stock.service.StockService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

/*     */ @Service
/*     */ public class StockServiceImpl extends BaseService implements StockService {
/*     */   @Autowired
/*     */   private StockMapper stockMapper;
/*     */   @Autowired
/*     */   private ContractMapper contractMapper;
/*     */   @Autowired
/*     */   private StockSumMapper stockSumMapper;
/*     */   @Autowired
/*     */   private VStockMapper vStockMapper;
/*     */   
/*     */   @Transactional
/*     */   public R save(Stock stock) {
/*  41 */     stock.setOpid(this.opid);
/*  42 */     stock.setOptime(new Date());
/*  43 */     isFlower(stock);
/*  44 */     StockSum stockSum = get(stock);
/*  45 */     initStock(stock);
/*  46 */     if (stock.getId() == null) {
/*  47 */       add(stock, stockSum);
/*  48 */       this.stockMapper.insertSelective(stock);
/*     */     } else {
/*  50 */       update(stock, stockSum);
/*  51 */       this.stockMapper.updateByPrimaryKeySelective(stock);
/*     */     } 
/*  53 */     return R.OK();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @Transactional
/*     */   public R delete(Long id) {
/*  60 */     Stock stock = new Stock();
/*  61 */     stock.setId(id);
/*  62 */     stock.setIsdel(Boolean.valueOf(true));
/*  63 */     stock.setOpid(this.opid);
/*  64 */     stock.setOptime(new Date());
/*  65 */     Stock stock1 = this.stockMapper.selectByPrimaryKey(id);
/*  66 */     isFlower(stock1);
/*  67 */     StockSum stockSum = get(stock1);
/*  68 */     del(stock1, stockSum);
/*  69 */     this.stockMapper.updateByPrimaryKeySelective(stock);
/*  70 */     return R.OK();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void isFlower(Stock stock) {
/*  77 */     if (stock.getOrderId() == null) {
/*  78 */       throw new RRException("此花号在订单中不存在！");
/*     */     }
/*  80 */     Contract contract = this.contractMapper.selectByPrimaryKey(stock.getOrderId());
/*  81 */     if (contract == null) {
/*  82 */       throw new RRException("此花号在订单中不存在！");
/*     */     }
/*  84 */     if (contract.getIsdel().booleanValue()) {
/*  85 */       throw new RRException("此花号已经删除！");
/*     */     }
/*  87 */     if (contract.getIsfinish().booleanValue()) {
/*  88 */       throw new RRException("此花号已经完成！");
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private StockSum get(Stock stock) {
/*  96 */     StockSumExample example = new StockSumExample();
/*  97 */     example.createCriteria()
/*  98 */       .andOrderIdEqualTo(stock.getOrderId());
/*  99 */     List<StockSum> stockSums = this.stockSumMapper.selectByExample(example);
/* 100 */     if (stockSums.size() > 0) {
/* 101 */       return stockSums.get(0);
/*     */     }
/* 103 */     throw new RRException("数据错误！");
/*     */   }
/*     */   
/*     */   public void initStock(Stock stock) {
/* 107 */     stock.setPa(Integer.valueOf((stock.getPa() == null) ? 0 : stock.getPa().intValue()));
/* 108 */     stock.setRa(Integer.valueOf((stock.getRa() == null) ? 0 : stock.getRa().intValue()));
/* 109 */     stock.setPb(Integer.valueOf((stock.getPb() == null) ? 0 : stock.getPb().intValue()));
/* 110 */     stock.setRb(Integer.valueOf((stock.getRb() == null) ? 0 : stock.getRb().intValue()));
/* 111 */     stock.setP24(Integer.valueOf((stock.getP24() == null) ? 0 : stock.getP24().intValue()));
/* 112 */     stock.setR24(Integer.valueOf((stock.getR24() == null) ? 0 : stock.getR24().intValue()));
/* 113 */     stock.setP119(Integer.valueOf((stock.getP119() == null) ? 0 : stock.getP119().intValue()));
/* 114 */     stock.setR119(Integer.valueOf((stock.getR119() == null) ? 0 : stock.getR119().intValue()));
/* 115 */     stock.setPremnant(Integer.valueOf((stock.getPremnant() == null) ? 0 : stock.getPremnant().intValue()));
/* 116 */     stock.setRremnant(Integer.valueOf((stock.getRremnant() == null) ? 0 : stock.getRremnant().intValue()));
/*     */   }
/*     */   
/*     */   private void update(Stock stock, StockSum stockSum) {
/* 120 */     sub(stock, stockSum);
/* 121 */     plus(stock, stockSum);
/* 122 */     sum(stockSum);
/* 123 */     updateStockSum(stockSum);
/*     */   }
/*     */   
/*     */   private void sub(Stock stock, StockSum stockSum) {
/* 127 */     Stock stock1 = this.stockMapper.selectByPrimaryKey(stock.getId());
/* 128 */     Integer rnum = Integer.valueOf(stockSum.getRa().intValue() - stock1.getRa().intValue());
/* 129 */     Integer pnum = Integer.valueOf(stockSum.getPa().intValue() - stock1.getPa().intValue());
/* 130 */     if (rnum.intValue() < 0) {
/* 131 */       pnum = Integer.valueOf(pnum.intValue() - 1);
/* 132 */       rnum = Integer.valueOf(rnum.intValue() + stockSum.getCodelen().intValue());
/*     */     } 
/* 134 */     stockSum.setPa(pnum);
/* 135 */     stockSum.setRa(rnum);
/*     */     
/* 137 */     rnum = Integer.valueOf(stockSum.getRb().intValue() - stock1.getRb().intValue());
/* 138 */     pnum = Integer.valueOf(stockSum.getPb().intValue() - stock1.getPb().intValue());
/* 139 */     if (rnum.intValue() < 0) {
/* 140 */       pnum = Integer.valueOf(pnum.intValue() - 1);
/* 141 */       rnum = Integer.valueOf(rnum.intValue() + stockSum.getCodelen().intValue());
/*     */     } 
/* 143 */     stockSum.setPb(pnum);
/* 144 */     stockSum.setRb(rnum);
/*     */     
/* 146 */     rnum = Integer.valueOf(stockSum.getR24().intValue() - stock1.getR24().intValue());
/* 147 */     pnum = Integer.valueOf(stockSum.getP24().intValue() - stock1.getP24().intValue());
/* 148 */     if (rnum.intValue() < 0) {
/* 149 */       pnum = Integer.valueOf(pnum.intValue() - 1);
/* 150 */       rnum = Integer.valueOf(rnum.intValue() + stockSum.getCodelen().intValue());
/*     */     } 
/* 152 */     stockSum.setP24(pnum);
/* 153 */     stockSum.setR24(rnum);
/*     */     
/* 155 */     rnum = Integer.valueOf(stockSum.getR119().intValue() - stock1.getR119().intValue());
/* 156 */     pnum = Integer.valueOf(stockSum.getP119().intValue() - stock1.getP119().intValue());
/* 157 */     if (rnum.intValue() < 0) {
/* 158 */       pnum = Integer.valueOf(pnum.intValue() - 1);
/* 159 */       rnum = Integer.valueOf(rnum.intValue() + stockSum.getCodelen().intValue());
/*     */     } 
/* 161 */     stockSum.setP119(pnum);
/* 162 */     stockSum.setR119(rnum);
/*     */     
/* 164 */     rnum = Integer.valueOf(stockSum.getRremnant().intValue() - stock1.getRremnant().intValue());
/* 165 */     pnum = Integer.valueOf(stockSum.getPremnant().intValue() - stock1.getPremnant().intValue());
/* 166 */     if (rnum.intValue() < 0) {
/* 167 */       pnum = Integer.valueOf(pnum.intValue() - 1);
/* 168 */       rnum = Integer.valueOf(rnum.intValue() + stockSum.getCodelen().intValue());
/*     */     } 
/* 170 */     stockSum.setPremnant(pnum);
/* 171 */     stockSum.setRremnant(rnum);
/*     */   }
/*     */   
/*     */   private void add(Stock stock, StockSum stockSum) {
/* 175 */     plus(stock, stockSum);
/* 176 */     sum(stockSum);
/* 177 */     updateStockSum(stockSum);
/*     */   }
/*     */   
/*     */   private void del(Stock stock, StockSum stockSum) {
/* 181 */     sub(stock, stockSum);
/* 182 */     sum(stockSum);
/* 183 */     updateStockSum(stockSum);
/*     */   }
/*     */   
/*     */   private void plus(Stock stock, StockSum stockSum) {
/* 187 */     stockSum.setPa(Integer.valueOf(stockSum.getPa().intValue() + stock.getPa().intValue()));
/* 188 */     stockSum.setRa(Integer.valueOf(stockSum.getRa().intValue() + stock.getRa().intValue()));
/* 189 */     stockSum.setRb(Integer.valueOf(stockSum.getRb().intValue() + stock.getRb().intValue()));
/* 190 */     stockSum.setPb(Integer.valueOf(stockSum.getPb().intValue() + stock.getPb().intValue()));
/* 191 */     stockSum.setP24(Integer.valueOf(stockSum.getP24().intValue() + stock.getP24().intValue()));
/* 192 */     stockSum.setR24(Integer.valueOf(stockSum.getR24().intValue() + stock.getR24().intValue()));
/* 193 */     stockSum.setP119(Integer.valueOf(stockSum.getP119().intValue() + stock.getP119().intValue()));
/* 194 */     stockSum.setR119(Integer.valueOf(stockSum.getR119().intValue() + stock.getR119().intValue()));
/* 195 */     stockSum.setPremnant(Integer.valueOf(stockSum.getPremnant().intValue() + stock.getPremnant().intValue()));
/* 196 */     stockSum.setRremnant(Integer.valueOf(stockSum.getRremnant().intValue() + stock.getRremnant().intValue()));
/* 197 */     stockSum.setFactoryId(stock.getFactoryId());
/*     */   }
/*     */   
/*     */   private void sum(StockSum stockSum) {
/* 201 */     Integer codelen = stockSum.getCodelen();
/* 202 */     int t = stockSum.getPa().intValue() * codelen.intValue() + stockSum.getRa().intValue();
/* 203 */     t += stockSum.getPb().intValue() * codelen.intValue() + stockSum.getRb().intValue();
/* 204 */     t += stockSum.getP24().intValue() * codelen.intValue() + stockSum.getR24().intValue();
/* 205 */     t += stockSum.getP119().intValue() * codelen.intValue() + stockSum.getR119().intValue();
/* 206 */     t += stockSum.getPremnant().intValue() * codelen.intValue() + stockSum.getRremnant().intValue();
/* 207 */     stockSum.setSsum(Integer.valueOf(t));
/* 208 */     if (stockSum.getRb().intValue() > codelen.intValue() || stockSum.getRa().intValue() > codelen.intValue() || stockSum.getR24().intValue() > codelen.intValue() || stockSum.getR119().intValue() > codelen.intValue() || stockSum.getRremnant().intValue() > codelen.intValue()) {
/* 209 */       stockSum.setIspack(Boolean.valueOf(true));
/*     */     } else {
/* 211 */       stockSum.setIspack(Boolean.valueOf(false));
/*     */     } 
/* 213 */     stockSum.setPrate(Integer.valueOf(t * 100 / stockSum.getTsum().intValue()));
/*     */   }
/*     */   
/*     */   private void updateStockSum(StockSum stockSum) {
/* 217 */     StockSumExample example = new StockSumExample();
/* 218 */     example.createCriteria()
/* 219 */       .andIdEqualTo(stockSum.getId())
/* 220 */       .andVersionEqualTo(stockSum.getVersion());
/* 221 */     stockSum.setVersion(Long.valueOf(stockSum.getVersion().longValue() + 1L));
/* 222 */     if (this.stockSumMapper.updateByExample(stockSum, example) < 1) {
/* 223 */       throw new RRException("打包处理中...,请等待！");
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public EUPageResult<VStock> list(PageBean pageBean, String name) {
/* 230 */     VStockExample example = null;
/* 231 */     if (!StringUtils.isEmpty(name)) {
/* 232 */       example = new VStockExample();
/* 233 */       example.createCriteria().andFlowerNoLike("%%" + name + "%%");
/*     */     } 
/*     */     
/* 236 */     PageHelper.startPage(pageBean.getPage().intValue(), pageBean.getRows().intValue());
/* 237 */     PageInfo<VStock> info = new PageInfo(this.vStockMapper.selectByExample(example));
/*     */     
/* 239 */     return new EUPageResult(Long.valueOf(info.getTotal()), info.getList());
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\classes\!\cn\zhouxp\stock\service\impl\StockServiceImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */