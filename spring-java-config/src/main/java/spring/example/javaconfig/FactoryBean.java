package spring.example.javaconfig;

import org.springframework.stereotype.Component;

@Component
public class FactoryBean {

    public void printHello() {
        System.out.println("Hello!");
    }
}
