package spring.example.expression;

import org.springframework.beans.factory.annotation.Value;

public class ExpressionBean {

    protected String simpleExpression;
    protected String secondBeanValue;
    protected String resultOfMethod;
    protected String staticMethod;

    public void setSimpleExpression(String simpleExpression) {
        this.simpleExpression = simpleExpression;
    }

    public void setSecondBeanValue(String secondBeanValue) {
        this.secondBeanValue = secondBeanValue;
    }

    public void setResultOfMethod(String resultOfMethod) {
        this.resultOfMethod = resultOfMethod;
    }

    public void setStaticMethod(String staticMethod) {
        this.staticMethod = staticMethod;
    }

    @Override
    public String toString() {
        return "ExpressionBean{" +
                "simpleExpression='" + simpleExpression + '\'' +
                ", secondBeanValue='" + secondBeanValue + '\'' +
                ", resultOfMethod='" + resultOfMethod + '\'' +
                ", staticMethod='" + staticMethod + '\'' +
                '}';
    }
}