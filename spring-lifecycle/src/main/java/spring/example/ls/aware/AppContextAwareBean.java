package spring.example.ls.aware;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class AppContextAwareBean implements ApplicationContextAware {

    protected ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }

    public void printStartupDate() {
        System.out.println("App context startup date: " + new Date(context.getStartupDate()));
    }
}