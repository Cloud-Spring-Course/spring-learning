package spring.example.autowired;

import spring.example.Client;

public class AutowiredBean {

    protected Client client;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void describeClient() {
        System.out.println("My client is " + client.getFullName() + " " + client.getGreeting());
    }
}
