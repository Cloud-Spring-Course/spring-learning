package spring.example.annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class Monitoring {

    @Autowired
    protected ApplicationContext context;

    public void monitor() {
        System.out.println("Monitoring: " + new Date() + " - everything is ok");
        System.out.println("Context start date is " + new Date(context.getStartupDate()));
    }
}
