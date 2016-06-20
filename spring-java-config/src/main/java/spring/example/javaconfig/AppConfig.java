package spring.example.javaconfig;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.*;
import org.springframework.core.io.ClassPathResource;
import spring.example.App;
import spring.example.Client;
import spring.example.logger.EventLogger;
import spring.example.prototype.Event;

import java.text.DateFormat;
import java.util.Date;

@Configuration
@ComponentScan(basePackages = "spring.example.javaconfig")
@Import(LoggerConfig.class)
public class AppConfig {

    @Bean
    public PropertyPlaceholderConfigurer createPropertyPlaceholderConfigurer() {
        PropertyPlaceholderConfigurer configurer = new PropertyPlaceholderConfigurer();
        configurer.setLocations(new ClassPathResource("client.properties"));
        return configurer;
    }

    @Bean
    public Client createClient(@Value("${client.id}") String id,
                               @Value("${client.name}") String name,
                               @Value("${client.greeting}")String greeting) {
        Client client = new Client(id, name);
        client.setGreeting(greeting);
        return client;
    }

    @Bean(name = "event")
    @Scope("prototype")
    public Event createEvent(DateFormat format) {
        return new Event(new Date(), format);
    }

    @Bean
    public DateFormat createDateFormat() {
        return DateFormat.getDateInstance();
    }

    @Bean(initMethod = "init", name = "app")
    public App createApp(Client client, @Qualifier("eventLogger") EventLogger eventLogger) {
        App app = new App();
        app.setClient(client);
        app.setEventLogger(eventLogger);
        return app;
    }
}
