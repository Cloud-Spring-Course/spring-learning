package spring.example.javaconfig;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.example.App;
import spring.example.autowired.AutowiredBean;
import spring.example.lazy.LazyInitBean;
import spring.example.prototype.Event;
import spring.example.prototype.EventType;
import spring.example.util.SpringUtilTestBean;

public class MainAnnotationConfig {

    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class, LoggerConfig.class);
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

        context.close();
    }
}