/*    */ package cn.zhouxp.common.controller;
/*    */ 
/*    */ import cn.afterturn.easypoi.excel.ExcelExportUtil;
/*    */ import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
/*    */ import cn.zhouxp.common.utils.ExcelUtil;
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import org.apache.poi.ss.usermodel.Workbook;
/*    */ import org.springframework.web.bind.annotation.RequestMapping;
/*    */ import org.springframework.web.bind.annotation.RestController;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @RestController
/*    */ public class TestController
/*    */ {
/*    */   @RequestMapping({"test"})
/*    */   public void test(HttpServletResponse response) {
/* 24 */     TemplateExportParams params = new TemplateExportParams("sum.xlsx", new Integer[0]);
/*    */     
/* 26 */     Map<String, Object> map = new HashMap<>();
/* 27 */     map.put("container", "xww");
/* 28 */     map.put("packages", Integer.valueOf(20));
/* 29 */     map.put("cnumber", Integer.valueOf(12));
/* 30 */     map.put("codePort", Integer.valueOf(12));
/* 31 */     map.put("cname", "财政局");
/* 32 */     List<Map<String, String>> listMap = new ArrayList<>();
/* 33 */     for (int i = 0; i < 4; i++) {
/* 34 */       Map<String, String> lm = new HashMap<>();
/* 35 */       lm.put("team", (i + 1) + "");
/* 36 */       lm.put("cdate", (i * 10000) + "");
/* 37 */       lm.put("flowerNo", "A001");
/* 38 */       lm.put("clength", "1");
/* 39 */       lm.put("pa", "21");
/* 40 */       lm.put("ra", "1");
/* 41 */       lm.put("pb", (i * 10000) + "");
/* 42 */       lm.put("rb", (i * 10000) + "");
/* 43 */       lm.put("p24", (i * 10000) + "");
/* 44 */       lm.put("r24", (i * 10000) + "");
/* 45 */       lm.put("p119", (i * 10000) + "");
/* 46 */       lm.put("r119", (i * 10000) + "");
/* 47 */       lm.put("premnant", (i * 10000) + "");
/* 48 */       lm.put("rremnant", (i * 10000) + "");
/* 49 */       lm.put("tsum", (i * 10000) + "");
/* 50 */       lm.put("reduceRate", (i * 10000) + "");
/* 51 */       listMap.add(lm);
/*    */     } 
/* 53 */     map.put("maplist", listMap);
/* 54 */     response.setContentType("application/force-download");
/* 55 */     response.addHeader("Content-Disposition", "attachment;fileName=test.xls");
/* 56 */     Workbook workbook = ExcelExportUtil.exportExcel(params, map);
/* 57 */     ExcelUtil.downLoadExcel("test.xls", response, workbook);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\classes\!\cn\zhouxp\common\controller\TestController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */