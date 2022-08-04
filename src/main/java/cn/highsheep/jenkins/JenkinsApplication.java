package cn.highsheep.jenkins;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JenkinsApplication {

    public static void main(String[] args) {
        System.out.println("hello");
        System.out.println("feature-1.1");
        System.out.println("feature-1.2");
        SpringApplication.run(JenkinsApplication.class, args);
    }

}
