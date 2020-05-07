package cn.zhouxp;


import com.spring4all.swagger.EnableSwagger2Doc;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({"cn.zhouxp.*.mapper","cn.zhouxp.*.domapper"})
@EnableSwagger2Doc
public class OrderingApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderingApplication.class, args);
    }

}
