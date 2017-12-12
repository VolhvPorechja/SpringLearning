package org.volhvporechja.demo.components;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.volhvporechja.demo.beans.Person;
import org.volhvporechja.demo.contracts.QuoteServiceResponse;
import org.volhvporechja.demo.services.QuotesService;

@Component
public class ScheduledTasks {
    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    Person person;

    @Autowired
    QuotesService service;

    @Autowired
    @Qualifier("OtherPerson")
    public void setPerson(Person person) {
        this.person = person;
    }

    @Scheduled(fixedRate = 5000)
    public void report() {
        log.info(person.toString());
    }

    @Scheduled(fixedRate = 5000)
    public void reportQuote() {
        QuoteServiceResponse response = service.GetNextQuote();
        log.info(response.toString());
    }
}
