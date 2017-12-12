package org.volhvporechja.demo.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.volhvporechja.demo.beans.Person;
import org.volhvporechja.demo.components.ScheduledTasks;
import org.volhvporechja.demo.conextevents.PersonRegisteredEvent;

@Service
public class PersonsService {
    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    @EventListener
    public void PersonRegistered(PersonRegisteredEvent event) {
        Person source = (Person) event.getSource();
        log.info(String.format("Registered %s person", source.toString()));
    }
}
