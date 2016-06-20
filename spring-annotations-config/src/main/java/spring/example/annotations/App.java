package spring.example.annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.inject.Named;

// Same as @Component
@Named
public class App {

    @Inject
    @Resource(name = "client1")
    protected Client client1;

    protected Client client2;

    @Inject
    protected Monitoring monitoring;

    @Value("${app.version}")
    protected String appVersion;

    public void start() {
        System.out.println("Starting app, version: " + appVersion);
        System.out.println("Client 1 says greeting: " + client1.getGreeting());
        System.out.println("Client 2 says greeting: " + client2.getGreeting());
        monitoring.monitor();
    }

    public Client getClient1() {
        return client1;
    }

    public void setClient1(Client client1) {
        this.client1 = client1;
    }

    public Client getClient2() {
        return client2;
    }

    @Autowired
    @Qualifier("client2")
    public void setClient2(Client client2) {
        this.client2 = client2;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }
}