package org.volhvporechja.demo.conextevents;

import org.springframework.context.ApplicationEvent;

public class PersonRegisteredEvent extends ApplicationEvent {
    public PersonRegisteredEvent(Object source) {
        super(source);
    }
}
