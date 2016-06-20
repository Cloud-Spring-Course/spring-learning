package spring.example.expression;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("application.xml");

        ExpressionBean eb = context.getBean(ExpressionBean.class);
        SecondExpressionBean seb = context.getBean(SecondExpressionBean.class);

        System.out.println(eb);

        // Change value in second bean and print again - no changes
        seb.setValue("new value");
        System.out.println(eb);


        System.currentTimeMillis();

        context.close();
    }
}