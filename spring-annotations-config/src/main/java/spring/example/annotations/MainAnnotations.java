package spring.example.annotations;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainAnnotations {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        App app = context.getBean(App.class);
        app.start();

        // Get prototype beans
        System.out.println(context.getBean(PrototypeBean.class));
        System.out.println(context.getBean(PrototypeBean.class));
        System.out.println(context.getBean(PrototypeBean.class));

        context.close();
    }
}
