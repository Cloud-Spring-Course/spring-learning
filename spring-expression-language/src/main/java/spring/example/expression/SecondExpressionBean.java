package spring.example.expression;

import java.util.Date;

public class SecondExpressionBean {

    protected String value;

    public String getValue() {
        return value;
    }

    public String someMethod() {
        return "Date: " + new Date();
    }

    public void setValue(String value) {
        this.value = value;
    }
}
