package cn.vxnm.component.springboot.properties;

import cn.vxnm.component.springboot.properties.config.DemoProperties;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootPropertiesApplication implements CommandLineRunner {

    private final DemoProperties demoProperties;

    public SpringBootPropertiesApplication(DemoProperties demoProperties) {
        this.demoProperties = demoProperties;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootPropertiesApplication.class, args);
    }

    @Override
    public void run(String... args) {
        System.out.println(demoProperties.getName());
    }
}
