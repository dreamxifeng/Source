/*    */ package cn.zhouxp.common.utils;
/*    */ 
/*    */ import java.text.DateFormat;
/*    */ import java.text.SimpleDateFormat;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ import org.springframework.core.convert.converter.Converter;
/*    */ import org.springframework.stereotype.Component;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Component
/*    */ public class DateConverterConfig
/*    */   implements Converter<String, Date>
/*    */ {
/* 18 */   private static final List<String> formarts = new ArrayList<>(4);
/*    */   static  {
/* 20 */     formarts.add("yyyy-MM");
/* 21 */     formarts.add("yyyy-MM-dd");
/* 22 */     formarts.add("yyyy-MM-dd hh:mm");
/* 23 */     formarts.add("yyyy-MM-dd hh:mm:ss");
/*    */   }
/*    */ 
/*    */   
/*    */   public Date convert(String source) {
/* 28 */     String value = source.trim();
/* 29 */     if ("".equals(value)) {
/* 30 */       return null;
/*    */     }
/* 32 */     if (source.matches("^\\d{4}-\\d{1,2}$"))
/* 33 */       return parseDate(source, formarts.get(0)); 
/* 34 */     if (source.matches("^\\d{4}-\\d{1,2}-\\d{1,2}$"))
/* 35 */       return parseDate(source, formarts.get(1)); 
/* 36 */     if (source.matches("^\\d{4}-\\d{1,2}-\\d{1,2} {1}\\d{1,2}:\\d{1,2}$"))
/* 37 */       return parseDate(source, formarts.get(2)); 
/* 38 */     if (source.matches("^\\d{4}-\\d{1,2}-\\d{1,2} {1}\\d{1,2}:\\d{1,2}:\\d{1,2}$")) {
/* 39 */       return parseDate(source, formarts.get(3));
/*    */     }
/* 41 */     throw new IllegalArgumentException("Invalid boolean value '" + source + "'");
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Date parseDate(String dateStr, String format) {
/* 52 */     Date date = null;
/*    */     try {
/* 54 */       DateFormat dateFormat = new SimpleDateFormat(format);
/* 55 */       date = dateFormat.parse(dateStr);
/* 56 */     } catch (Exception exception) {}
/*    */ 
/*    */     
/* 59 */     return date;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\classes\!\cn\zhouxp\commo\\utils\DateConverterConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */