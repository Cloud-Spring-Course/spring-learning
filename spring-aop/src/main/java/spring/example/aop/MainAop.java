package spring.example.aop;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.example.aop.aspect.GreetingStatisticBean;

public class MainAop {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        App app = context.getBean(App.class);

        app.sayGreetingInEnglish();
        app.sayGreetingInGerman();
        app.sayGreetingInGerman();
        app.sayGreetingInRussian();
        app.sayGreetingInRussian();
        app.sayGreetingInRussian();

        try {
            app.sayGreetingInKlingon();
        } catch (RuntimeException e) {
            System.out.println("EXCEPTION!!!! " + e.getMessage());
        }

        GreetingStatisticBean stats = context.getBean(GreetingStatisticBean.class);
        stats.printStatistic();

        // Get prototype beans
        PrototypeBean prototypeBean = context.getBean(PrototypeBean.class);
        System.out.println(prototypeBean);

        context.close();
    }
}