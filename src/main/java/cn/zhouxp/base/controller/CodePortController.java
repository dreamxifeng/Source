/*    */ package cn.zhouxp.base.controller;

/*    */ import cn.zhouxp.base.model.CodePort;
import cn.zhouxp.base.service.CodePortService;
import cn.zhouxp.common.model.EUPageResult;
import cn.zhouxp.common.model.PageBean;
import cn.zhouxp.common.model.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

/*    */ @Controller
/*    */ @RequestMapping({"base/codeport"})
/*    */ public class CodePortController
/*    */ {
/*    */   @Autowired
/*    */   private CodePortService codePortService;
/*    */   
/*    */   @GetMapping({"page"})
/* 30 */   public String page() { return "base/code_port"; }

/*    */   @GetMapping({"list"})
/*    */   @ResponseBody
/* 36 */   public EUPageResult<CodePort> list(PageBean pageBean, Integer name) { return this.codePortService.list(pageBean, name); }

/*    */   @PostMapping({"save"})
/*    */   @ResponseBody
/* 42 */   public R save(CodePort codePort) { return this.codePortService.save(codePort); }

/*    */   @PostMapping({"delete"})
/*    */   @ResponseBody
/* 48 */   public R delete(Long id) { return this.codePortService.delete(id); }

/*    */   @GetMapping({"listall"})
/*    */   @ResponseBody
/* 54 */   public List<CodePort> listall() { return this.codePortService.listall(); }
/*    */ }
