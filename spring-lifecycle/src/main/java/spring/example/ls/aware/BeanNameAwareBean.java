package spring.example.ls.aware;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Component;

@Component
public class BeanNameAwareBean implements BeanNameAware {

    protected String beanName;

    @Override
    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    public void sayMyName() {
        System.out.println("My name is " + beanName);
    }
}