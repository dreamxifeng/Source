/*    */ package cn.zhouxp.contract.controller;
/*    */ 
/*    */ import cn.zhouxp.common.model.R;
/*    */ import cn.zhouxp.contract.model.Extra;
/*    */ import cn.zhouxp.contract.service.ExtraService;
/*    */ import java.util.List;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.web.bind.annotation.GetMapping;
/*    */ import org.springframework.web.bind.annotation.PostMapping;
/*    */ import org.springframework.web.bind.annotation.RequestMapping;
/*    */ import org.springframework.web.bind.annotation.RequestParam;
/*    */ import org.springframework.web.bind.annotation.RestController;
/*    */ import org.springframework.web.multipart.MultipartFile;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @RestController
/*    */ @RequestMapping({"contract/extra"})
/*    */ public class ExtraController
/*    */ {
/*    */   @Autowired
/*    */   private ExtraService extraService;
/*    */   
/*    */   @PostMapping({"save"})
/* 28 */   public R save(@RequestParam(value = "file", required = false) MultipartFile file, Extra extra) { return this.extraService.save(file, extra); }
/*    */ 
/*    */ 
/*    */   
/*    */   @PostMapping({"delete"})
/* 33 */   public R delete(Long id) { return this.extraService.delete(id); }
/*    */ 
/*    */ 
/*    */   
/*    */   @GetMapping({"listall"})
/* 38 */   public List<Extra> listall(@RequestParam(value = "orderid", required = true) Long orderid) { return this.extraService.listall(orderid); }
/*    */ 
/*    */ 
/*    */   
/*    */   @RequestMapping({"downloadFile"})
/* 43 */   public R downloadFile(HttpServletResponse response, Long id) { return this.extraService.downloadFile(response, id); }
/*    */ }


/* Location:              C:\Users\Administrator\Desktop\classes\!\cn\zhouxp\contract\controller\ExtraController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */