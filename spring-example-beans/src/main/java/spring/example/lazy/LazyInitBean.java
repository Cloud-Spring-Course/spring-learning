package spring.example.lazy;

public class LazyInitBean {

    public void init() {
        System.out.println("LazyInitBean.init()");
    }

    public void say() {
        System.out.println("I am lazy");
    }
}
