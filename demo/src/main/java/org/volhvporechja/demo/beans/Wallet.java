package org.volhvporechja.demo.beans;

import org.springframework.stereotype.Component;

@Component
public class Wallet {
    String id = "234";

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Wallet{" +
                "id='" + id + '\'' +
                '}';
    }
}
