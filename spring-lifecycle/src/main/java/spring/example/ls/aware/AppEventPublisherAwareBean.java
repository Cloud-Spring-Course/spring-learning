package spring.example.ls.aware;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

@Component
public class AppEventPublisherAwareBean implements ApplicationEventPublisherAware {

    protected ApplicationEventPublisher eventPublisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.eventPublisher = applicationEventPublisher;
    }

    public void publishEvent() {
        eventPublisher.publishEvent(createEvent());
    }

    protected ApplicationEvent createEvent() {
        // TODO what is application event?
        return new ApplicationEvent(this) {

            @Override
            public Object getSource() {
                return this;
            }
        };
    }
}
