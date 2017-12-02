package org.volhvporechja.springcontext.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Person {
    private int id;
    private String name;
    private String taxId;

    Wallet wallet;

    @Autowired
    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    @Value("${fucker.taxid}")
    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
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
