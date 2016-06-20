package spring.example.annotations;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class PrototypeBean {

    protected long timestamp;

    public PrototypeBean() {
        timestamp = System.currentTimeMillis();
    }

    @Override
    public String toString() {
        return "PrototypeBean{" +
                "timestamp=" + timestamp +
                '}';
    }
}