package spring.example.aop;

import org.springframework.stereotype.Component;

@Component
public class Client {

    public String getGreeting(String language) {
        switch (language) {
            case "DE":
                return "Guten tag!";
            case "RU":
                return "Privet";
            case "EN":
                return "Hello!";
            default:
                throw new RuntimeException("Greeting for language '" + language + "' not found");
        }
    }
}