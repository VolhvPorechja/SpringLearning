package org.volhvporechja.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.volhvporechja.demo.contracts.Greetings;

@RestController
@RequestMapping("/fgreetings")
public class RestApi {

    @RequestMapping(method = RequestMethod.GET)
    public Greetings greetings() {
        return new Greetings(123, "Fuck you stranger!!");
    }
}
