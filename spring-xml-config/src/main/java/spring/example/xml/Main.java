package spring.example.xml;

import org.springframework.context.ConfigurableApplicationContext;
import spring.example.App;
import spring.example.prototype.EventType;
import spring.example.autowired.AutowiredBean;
import spring.example.prototype.Event;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.example.lazy.LazyInitBean;
import spring.example.util.SpringUtilTestBean;

public class Main {

    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        App app = context.getBean("app", App.class);

        Event e1 = context.getBean("event", Event.class);
        e1.setType(EventType.INFO);
        e1.setMsg("Client '1' event");
        app.logEvent(e1);

        Event e2 = context.getBean("event", Event.class);
        e2.setType(EventType.ERROR);
        e2.setMsg("Client '2' event");
        app.logEvent(e2);

        Event e3 = context.getBean("event", Event.class);
        e3.setMsg("Client '1' event");
        app.logEvent(e3);

        System.out.println("Before get lazy bean");
        LazyInitBean lazy = context.getBean("lazy", LazyInitBean.class);
        System.out.println("After get lazy bean");
        lazy.say();

        // Test spring util
        SpringUtilTestBean utilTest = context.getBean("utilTest", SpringUtilTestBean.class);
        System.out.println("PI: " + utilTest.getMathPi());

        // Testing autowired
        AutowiredBean autowiredBean = context.getBean("testAutowired", AutowiredBean.class);
        autowiredBean.describeClient();

        context.close();
    }
}