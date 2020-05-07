/*    */ package cn.zhouxp.common.controller;
/*    */ 
/*    */ import org.springframework.stereotype.Controller;
/*    */ import org.springframework.web.bind.annotation.GetMapping;

/*    */ @Controller
/*    */ public class PageController
/*    */ {
/*    */   @GetMapping({"index"})
/* 14 */   public String index() { return "main"; }

/*    */   @GetMapping({"first"})
/* 19 */   public String first() { return "first"; }
           @GetMapping({"main"})
           public String main() { return "main"; }
    /*    */ }
