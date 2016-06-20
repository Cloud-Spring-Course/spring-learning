package spring.example.ls.aware;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;

import java.io.IOException;

public class MainAware {

    public static void main(String[] args) throws IOException {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("spring-lifecycle.xml");

        AppContextAwareBean appContextAwareBean = context.getBean(AppContextAwareBean.class);
        appContextAwareBean.printStartupDate();

        AppEventPublisherAwareBean appEventPublisherAwareBean = context.getBean(AppEventPublisherAwareBean.class);
        appEventPublisherAwareBean.publishEvent();

        BeanFactoryAwareBean beanFactoryAwareBean = context.getBean(BeanFactoryAwareBean.class);
        BeanNameAwareBean beanNameAwareBean = (BeanNameAwareBean)beanFactoryAwareBean.getBean("beanNameAwareBean");
        beanNameAwareBean.sayMyName();

        ResourceLoaderAwareBean resourceLoaderAwareBean = context.getBean(ResourceLoaderAwareBean.class);
        Resource resource = resourceLoaderAwareBean.getResource("classpath:spring-lifecycle.xml");
        System.out.println("File path is: " + resource.getURI());

        context.close();
    }
}