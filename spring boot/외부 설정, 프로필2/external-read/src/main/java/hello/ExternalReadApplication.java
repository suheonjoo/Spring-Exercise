package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import hello.config.MyDataSourceConfigV1;
import hello.config.MyDataSourceConfigV3;
import hello.config.MyDataSourceEnvConfig;
import hello.config.MyDataSourceValueConfig;

// @Import(MyDataSourceEnvConfig.class)
// @Import(MyDataSourceValueConfig.class)
// @Import(MyDataSourceConfigV1.class)
//@Import(MyDataSourceConfigV2.class)
@Import(MyDataSourceConfigV3.class)
@SpringBootApplication(scanBasePackages = {"hello.datasource", "hello.pay"})
// @SpringBootApplication(scanBasePackages = "hello.datasource")
public class ExternalReadApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExternalReadApplication.class, args);
    }

}
