package org.volhvporechja.demo.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.volhvporechja.demo.conextevents.PersonRegisteredEvent;

public class Person {
    private int id;
    private String name;
    private String taxId;

    Wallet wallet;

    @Autowired
    private ApplicationEventPublisher publisher;

    @Autowired
    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    @Value("${persons.fucker.taxid}")
    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @EventListener({ContextRefreshedEvent.class})
    public void applicationStarter() {
        publisher.publishEvent(new PersonRegisteredEvent(this));
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", taxId='" + taxId + '\'' +
                ", wallet=" + wallet +
                '}';
    }
}
