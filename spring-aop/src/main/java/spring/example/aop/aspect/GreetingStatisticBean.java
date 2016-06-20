package spring.example.aop.aspect;

import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class GreetingStatisticBean {

    protected Map<String, Integer> languagesCount = new ConcurrentHashMap<>();
    protected Map<String, Integer> responsesCount = new ConcurrentHashMap<>();

    public void incrementLanguage(String language) {
        Integer currentCounter = languagesCount.get(language);
        if (currentCounter != null) {
            languagesCount.put(language, currentCounter + 1);
        } else {
            languagesCount.put(language, 1);
        }
    }

    public void incrementResponse(String greeting) {
        Integer currentCounter = responsesCount.get(greeting);
        if (currentCounter != null) {
            responsesCount.put(greeting, currentCounter + 1);
        } else {
            responsesCount.put(greeting, 1);
        }
    }

    public void printStatistic() {
        System.out.println("Greeting statistic");
        System.out.println(languagesCount);
        System.out.println(responsesCount);
    }
}