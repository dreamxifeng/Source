/*    */ package cn.zhouxp.common.utils;
/*    */ 
/*    */ import cn.afterturn.easypoi.excel.ExcelExportUtil;
/*    */ import cn.afterturn.easypoi.excel.ExcelImportUtil;
/*    */ import cn.afterturn.easypoi.excel.entity.ExportParams;
/*    */ import cn.afterturn.easypoi.excel.entity.ImportParams;
/*    */ import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
/*    */ import cn.zhouxp.common.exception.NormalException;
/*    */ import java.io.File;
/*    */ import java.io.IOException;
/*    */ import java.io.OutputStream;
/*    */ import java.net.URLEncoder;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import java.util.NoSuchElementException;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import org.apache.commons.lang3.StringUtils;
/*    */ import org.apache.poi.ss.usermodel.Workbook;
/*    */ import org.springframework.web.multipart.MultipartFile;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ExcelUtil
/*    */ {
/*    */   public static void exportExcel(List<?> list, String title, String sheetName, Class<?> pojoClass, String fileName, boolean isCreateHeader, HttpServletResponse response) {
/* 28 */     ExportParams exportParams = new ExportParams(title, sheetName);
/* 29 */     exportParams.setCreateHeadRows(isCreateHeader);
/* 30 */     defaultExport(list, pojoClass, fileName, response, exportParams);
/*    */   }
/*    */ 
/*    */   
/* 34 */   public static void exportExcel(List<?> list, String title, String sheetName, Class<?> pojoClass, String fileName, HttpServletResponse response) { defaultExport(list, pojoClass, fileName, response, new ExportParams(title, sheetName)); }
/*    */ 
/*    */   
/* 37 */   public static void exportExcel(List<Map<String, Object>> list, String fileName, HttpServletResponse response) { defaultExport(list, fileName, response); }
/*    */ 
/*    */   
/*    */   private static void defaultExport(List<?> list, Class<?> pojoClass, String fileName, HttpServletResponse response, ExportParams exportParams) {
/* 41 */     Workbook workbook = ExcelExportUtil.exportExcel(exportParams, pojoClass, list);
/* 42 */     if (workbook != null);
/* 43 */     downLoadExcel(fileName, response, workbook);
/*    */   }
/*    */   
/*    */   public static void downLoadExcel(String fileName, HttpServletResponse response, Workbook workbook) {
/*    */     try {
/* 48 */       response.setCharacterEncoding("UTF-8");
/*    */       
/* 50 */       response.setHeader("Content-Disposition", "attachment;filename=" + 
/* 51 */           URLEncoder.encode(fileName, "UTF-8"));
/* 52 */       workbook.write((OutputStream)response.getOutputStream());
/* 53 */     } catch (IOException e) {
/* 54 */       throw new NormalException(e.getMessage());
/*    */     } 
/*    */   }
/*    */   private static void defaultExport(List<Map<String, Object>> list, String fileName, HttpServletResponse response) {
/* 58 */     Workbook workbook = ExcelExportUtil.exportExcel(list, ExcelType.HSSF);
/* 59 */     if (workbook != null);
/* 60 */     downLoadExcel(fileName, response, workbook);
/*    */   }
/*    */   
/*    */   public static <T> List<T> importExcel(String filePath, Integer titleRows, Integer headerRows, Class<T> pojoClass) {
/* 64 */     if (StringUtils.isBlank(filePath)) {
/* 65 */       return null;
/*    */     }
/* 67 */     ImportParams params = new ImportParams();
/* 68 */     params.setTitleRows(titleRows.intValue());
/* 69 */     params.setHeadRows(headerRows.intValue());
/* 70 */     List<T> list = null;
/*    */     try {
/* 72 */       list = ExcelImportUtil.importExcel(new File(filePath), pojoClass, params);
/* 73 */     } catch (NoSuchElementException e) {
/* 74 */       throw new NormalException("模板不能为空");
/* 75 */     } catch (Exception e) {
/* 76 */       e.printStackTrace();
/* 77 */       throw new NormalException(e.getMessage());
/*    */     } 
/* 79 */     return list;
/*    */   }
/*    */   
/*    */   public static <T> List<T> importExcel(MultipartFile file, Integer titleRows, Integer headerRows, Class<T> pojoClass) {
/* 83 */     if (file == null) {
/* 84 */       return null;
/*    */     }
/* 86 */     ImportParams params = new ImportParams();
/* 87 */     params.setTitleRows(titleRows.intValue());
/* 88 */     params.setHeadRows(headerRows.intValue());
/* 89 */     List<T> list = null;
/*    */     try {
/* 91 */       list = ExcelImportUtil.importExcel(file.getInputStream(), pojoClass, params);
/* 92 */     } catch (NoSuchElementException e) {
/* 93 */       throw new NormalException("excel文件不能为空");
/* 94 */     } catch (Exception e) {
/* 95 */       throw new NormalException(e.getMessage());
/*    */     } 
/* 97 */     return list;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\classes\!\cn\zhouxp\commo\\utils\ExcelUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */