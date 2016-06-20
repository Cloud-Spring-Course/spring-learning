package spring.example.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class App {

    @Autowired
    protected Client client;

    public void sayGreetingInEnglish() {
        System.out.println(client.getGreeting("EN"));
    }

    public void sayGreetingInGerman() {
        System.out.println(client.getGreeting("DE"));
    }

    public void sayGreetingInRussian() {
        System.out.println(client.getGreeting("RU"));
    }

    public void sayGreetingInKlingon() {
        System.out.println(client.getGreeting("KG"));
    }

    public void setClient(Client client) {
        this.client = client;
    }
}