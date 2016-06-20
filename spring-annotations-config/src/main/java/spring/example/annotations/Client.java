package spring.example.annotations;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Client {

    protected String greeting;

    @PostConstruct
    public void init() {
        System.out.println("Client.init " + greeting);
    }

    @PostConstruct
    public void init2() {
        System.out.println("Client.init2 " + greeting);
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Client.destroy " + greeting);
    }

    @PreDestroy
    public void destroy2() {
        System.out.println("Client.destroy2 " + greeting);
    }

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }
}
