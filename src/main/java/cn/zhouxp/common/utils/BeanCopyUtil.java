/*    */ package cn.zhouxp.common.utils;
/*    */ 
/*    */ import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

/*    */ public class BeanCopyUtil
/*    */   extends BeanUtils
/*    */ {
/* 24 */   public static <S, T> List<T> copyListProperties(List<S> sources, Supplier<T> target) { return copyListProperties(sources, target, null); }

/*    */   public static <S, T> List<T> copyListProperties(List<S> sources, Supplier<T> target, BeanCopyUtilCallBack<S, T> callBack) {
/* 37 */     List<T> list = new ArrayList<>(sources.size());
/* 38 */     for (S source : sources) {
/* 39 */       T t = target.get();
/*    */       try {
/* 41 */         copyProperties(t, source);
/* 42 */       } catch (IllegalAccessException e) {
/* 43 */         e.printStackTrace();
/* 44 */       } catch (InvocationTargetException e) {
/* 45 */         e.printStackTrace();
/*    */       } 
/* 47 */       list.add(t);
/* 48 */       if (callBack != null)
/*    */       {
/* 50 */         callBack.callBack(source, t);
/*    */       }
/*    */     } 
/* 53 */     return list;
/*    */   }
/*    */ }

