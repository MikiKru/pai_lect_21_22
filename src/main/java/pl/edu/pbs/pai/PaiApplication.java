package pl.edu.pbs.pai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2 // należy dodać aby korzystać ze swagger ui
@SpringBootApplication
public class PaiApplication {

    public static void main(String[] args) {
        SpringApplication.run(PaiApplication.class, args);

    }

}
