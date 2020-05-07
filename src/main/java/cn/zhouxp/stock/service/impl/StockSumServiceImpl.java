/*     */ package cn.zhouxp.stock.service.impl;
/*     */
/*     */

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import cn.zhouxp.common.exception.RRException;
import cn.zhouxp.common.model.EUPageResult;
import cn.zhouxp.common.model.PageBean;
import cn.zhouxp.common.model.R;
import cn.zhouxp.common.model.SearchCon;
import cn.zhouxp.common.service.BaseService;
import cn.zhouxp.common.utils.ExcelUtil;
import cn.zhouxp.contract.mapper.ContractMapper;
import cn.zhouxp.contract.mapper.VContractMapper;
import cn.zhouxp.contract.model.Contract;
import cn.zhouxp.contract.model.VContract;
import cn.zhouxp.contract.model.VContractExample;
import cn.zhouxp.stock.mapper.StockMapper;
import cn.zhouxp.stock.mapper.StockSumMapper;
import cn.zhouxp.stock.mapper.VStockSumMapper;
import cn.zhouxp.stock.model.*;
import cn.zhouxp.stock.service.StockSumService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletResponse;
import java.util.*;

/*     */ @Service
/*     */ public class StockSumServiceImpl extends BaseService implements StockSumService {
/*     */   @Autowired
/*     */   private StockSumMapper stockSumMapper;
/*     */   @Autowired
/*     */   private ContractMapper contractMapper;
/*     */
/*  45 */   public R packageStock(Long id) { StockSum stockSum = getStockSum(id);
/*  46 */     this.stockSumMapper.updateByPrimaryKeySelective(stockSum);
/*  47 */     return R.OK(); }
            @Autowired
/*     */   private StockMapper stockMapper;
@Autowired
/*     */   private VStockSumMapper vStockSumMapper;
@Autowired
/*     */   private VContractMapper vContractMapper;
private StockSum getStockSum(Long id) {
/*  51 */     StockSum stockSum = this.stockSumMapper.selectByPrimaryKey(id);
/*  52 */     if (stockSum == null) {
/*  53 */       throw new RRException("此数据有错！");
/*     */     }
/*  55 */     Integer codelen = stockSum.getCodelen();
/*  56 */     stockSum.setPa(Integer.valueOf(stockSum.getPa().intValue() + stockSum.getRa().intValue() / codelen.intValue()));
/*  57 */     stockSum.setRa(Integer.valueOf(stockSum.getRa().intValue() % codelen.intValue()));
/*  58 */     stockSum.setPb(Integer.valueOf(stockSum.getPb().intValue() + stockSum.getRb().intValue() / codelen.intValue()));
/*  59 */     stockSum.setRb(Integer.valueOf(stockSum.getRb().intValue() % codelen.intValue()));
/*  60 */     stockSum.setP24(Integer.valueOf(stockSum.getP24().intValue() + stockSum.getR24().intValue() / codelen.intValue()));
/*  61 */     stockSum.setR24(Integer.valueOf(stockSum.getR24().intValue() % codelen.intValue()));
/*  62 */     stockSum.setP119(Integer.valueOf(stockSum.getP119().intValue() + stockSum.getR119().intValue() / codelen.intValue()));
/*  63 */     stockSum.setR119(Integer.valueOf(stockSum.getR119().intValue() % codelen.intValue()));
/*  64 */     stockSum.setPremnant(Integer.valueOf(stockSum.getRremnant().intValue() + stockSum.getRremnant().intValue() / codelen.intValue()));
/*  65 */     stockSum.setRremnant(Integer.valueOf(stockSum.getRremnant().intValue() % codelen.intValue()));
/*  66 */     stockSum.setIspack(Boolean.valueOf(false));
/*  67 */     return stockSum;
/*     */   }
    @Transactional
    public R finishStock(Long id) {
        StockSum stockSum = getStockSum(id);
//        stockSum.setReduceRate(Double.valueOf((stockSum.getSsum().intValue() / (stockSum.getTsum().intValue() > 0 ? stockSum.getTsum().intValue() : true) - 1.0D)) * 100.0D);
        stockSum.setIsfinish(Boolean.valueOf(true));
        updateContract(stockSum.getOrderId());
        updateStock(stockSum.getOrderId());
        this.stockSumMapper.updateByPrimaryKeySelective(stockSum);
        return R.OK();
    }
/*     */   private void updateContract(Long id) {
/*  86 */     Contract contract = new Contract();
/*  87 */     contract.setId(id);
/*  88 */     contract.setIsfinish((true));
/*  89 */     contract.setId(this.opid);
/*  90 */     contract.setOptime(new Date());
/*  91 */     this.contractMapper.updateByPrimaryKeySelective(contract);
/*     */   }
/*     */
/*     */
/*     */
/*     */
/*     */   private void updateStock(Long id) {
/*  98 */     StockExample example = new StockExample();
/*  99 */     example.createCriteria().andOrderIdEqualTo(id);
/* 100 */     Stock stock = new Stock();
/* 101 */     stock.setIsfinish(Boolean.valueOf(true));
/* 102 */     this.stockMapper.updateByExampleSelective(stock, example);
/*     */   }
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */   public EUPageResult<VStockSum> list(PageBean pageBean, SearchCon con) {
/* 110 */     VStockSumExample example = new VStockSumExample();
/* 111 */     VStockSumExample.Criteria criteria = example.createCriteria();
/* 112 */     if (!StringUtils.isEmpty(con.getFindDate())) {
/* 113 */       criteria.andCdateEqualTo(con.getFindDate());
/*     */     }
/* 115 */     if (!StringUtils.isEmpty(con.getContainer())) {
/* 116 */       criteria.andContainerLike("%" + con.getContainer() + "%");
/*     */     }
/* 118 */     if (!StringUtils.isEmpty(con.getFlowerNo())) {
/* 119 */       criteria.andFlowerNoLike("%" + con.getFlowerNo() + "%");
/*     */     }
/* 121 */     if (con.getFinish() != null && con.getFinish().intValue() != 2) {
/* 122 */       if (con.getFinish().intValue() == 1) {
/* 123 */         criteria.andIsfinishEqualTo(Boolean.valueOf(true));
/*     */       } else {
/* 125 */         criteria.andIsfinishEqualTo(Boolean.valueOf(false));
/*     */       }
/*     */     }
/* 128 */     PageHelper.startPage(pageBean.getPage().intValue(), pageBean.getRows().intValue());
/* 129 */     PageInfo<VStockSum> info = new PageInfo(this.vStockSumMapper.selectByExample(example));
/*     */
/* 131 */     return new EUPageResult(Long.valueOf(info.getTotal()), info.getList());
/*     */   }
/*     */
/*     */
/*     */   public void download(HttpServletResponse response) {
/* 136 */     TemplateExportParams params = new TemplateExportParams("sum.xlsx", new Integer[0]);
/*     */
/* 138 */     Map<String, Object> map = new HashMap<>();
/* 139 */     List<Map<String, String>> listMap = new ArrayList<>();
/* 140 */     List<VStockSum> vStockSums = this.vStockSumMapper.selectByExample(null);
/* 141 */     Integer ra = Integer.valueOf(0), rb = Integer.valueOf(0), r24 = Integer.valueOf(0), r119 = Integer.valueOf(0), rremnant = Integer.valueOf(0);
/* 142 */     Long orderId = Long.valueOf(0L);
/* 143 */     String factory = "";
/* 144 */     for (VStockSum vStockSum : vStockSums) {
/* 145 */       Map<String, String> lm = new HashMap<>();
/* 146 */       orderId = vStockSum.getOrderId();
/* 147 */       factory = vStockSum.getFactoryName();
/* 148 */       ra = Integer.valueOf(ra.intValue() + vStockSum.getRa().intValue());
/* 149 */       rb = Integer.valueOf(rb.intValue() + vStockSum.getRb().intValue());
/* 150 */       r24 = Integer.valueOf(r24.intValue() + vStockSum.getR24().intValue());
/* 151 */       r119 = Integer.valueOf(r119.intValue() + vStockSum.getR119().intValue());
/* 152 */       rremnant = Integer.valueOf(rremnant.intValue() + vStockSum.getRremnant().intValue());
/*     */
/* 154 */       lm.put("cdate", vStockSum.getCtime());
/* 155 */       lm.put("flowerNo", vStockSum.getFlowerNo());
/* 156 */       lm.put("clength", vStockSum.getTsum() + "");
/* 157 */       lm.put("pa", vStockSum.getPa() + "");
/* 158 */       lm.put("ra", vStockSum.getRa() + "");
/* 159 */       lm.put("pb", vStockSum.getPb() + "");
/* 160 */       lm.put("rb", vStockSum.getRb() + "");
/* 161 */       lm.put("p24", vStockSum.getP24() + "");
/* 162 */       lm.put("r24", vStockSum.getR24() + "");
/* 163 */       lm.put("p119", vStockSum.getP119() + "");
/* 164 */       lm.put("r119", vStockSum.getR119() + "");
/* 165 */       lm.put("premnant", vStockSum.getPremnant() + "");
/* 166 */       lm.put("rremnant", vStockSum.getRremnant() + "");
/* 167 */       lm.put("tsum", vStockSum.getTr() + "");
/* 168 */       lm.put("reduceRate", vStockSum.getReduceRate() + "");
/* 169 */       listMap.add(lm);
/*     */     }
/* 171 */     map.put("tra", ra);
/* 172 */     map.put("trb", rb);
/* 173 */     map.put("tr24", r24);
/* 174 */     map.put("tr119", r119);
/* 175 */     map.put("trremnant", rremnant);
/* 176 */     map.put("factory", factory);
/* 177 */     getContract(orderId, map);
/* 178 */     map.put("maplist", listMap);
/* 179 */     response.setContentType("application/force-download");
/* 180 */     response.addHeader("Content-Disposition", "attachment;fileName=test.xls");
/* 181 */     Workbook workbook = ExcelExportUtil.exportExcel(params, map);
/* 182 */     ExcelUtil.downLoadExcel("sum.xls", response, workbook);
/*     */   }
/*     */
/*     */
/*     */   public R echart() {
/* 187 */     List<VStockSum> vStockSums = this.vStockSumMapper.selectByExample(null);
/* 188 */     List<Integer> sdate = new ArrayList<>();
/* 189 */     List<String> xdata = new ArrayList<>();
/* 190 */     for (VStockSum vStockSum : vStockSums) {
/* 191 */       sdate.add(vStockSum.getPrate());
/* 192 */       xdata.add(vStockSum.getFlowerNo());
/*     */     }
/* 194 */     Map<String, Object> map = new HashMap<>();
/* 195 */     map.put("xdata", xdata);
/* 196 */     map.put("sdate", sdate);
/* 197 */     return R.INFO(Boolean.valueOf(true), "成功", map);
/*     */   }
/*     */
/*     */
/*     */
/*     */   private void getContract(Long orderId, Map<String, Object> map) {
/* 203 */     VContractExample example = new VContractExample();
/* 204 */     example.createCriteria().andIdEqualTo(orderId);
/* 205 */     List<VContract> vContracts = this.vContractMapper.selectByExample(example);
/* 206 */     if (vContracts == null || vContracts.size() < 1) {
/*     */       return;
/*     */     }
/* 209 */     VContract vContract = vContracts.get(0);
/* 210 */     map.put("container", vContract.getContainer());
/* 211 */     map.put("packages", vContract.getProductName());
/* 212 */     map.put("cnumber", vContract.getCodePortName());
/* 213 */     map.put("codePort", vContract.getCodePortName());
/* 214 */     map.put("cname", vContract.getCustomerName());
/*     */   }
/*     */ }
