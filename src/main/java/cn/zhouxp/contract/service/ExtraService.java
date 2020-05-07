package cn.zhouxp.contract.service;

import cn.zhouxp.common.model.R;
import cn.zhouxp.contract.model.Extra;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.multipart.MultipartFile;

public interface ExtraService {
  R delete(Long paramLong);
  
  R save(MultipartFile paramMultipartFile, Extra paramExtra);
  
  List<Extra> listall(Long paramLong);
  
  R downloadFile(HttpServletResponse paramHttpServletResponse, Long paramLong);
}


/* Location:              C:\Users\Administrator\Desktop\classes\!\cn\zhouxp\contract\service\ExtraService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.2
 */