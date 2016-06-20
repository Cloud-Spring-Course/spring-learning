package spring.example.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.example.App;
import spring.example.prototype.Event;

public class MainChildParentContext {

    public static void main(String[] args) throws Exception {
        ApplicationContext parent = new ClassPathXmlApplicationContext("parent-child/parent.xml");
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(
                new String[] { "parent-child/child.xml" }, parent);
        App app = context.getBean("app", App.class);

        Event e1 = context.getBean("event", Event.class);
        e1.setMsg("Client '1' event");
        app.logEvent(e1);
    }
}