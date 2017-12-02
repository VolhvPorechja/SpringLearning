package org.volhvporechja.springcontext.beans;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.volhvporechja.springcontext.contracts.Quote;

@Component
public class ScheduledTasks {
    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    Person person;

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
        RestTemplate template = new RestTemplate();
        Quote quote = template.getForObject("http://gturnquist-quoters.cfapps.io/api/random", Quote.class);
        log.info(quote.toString());
    }
}
