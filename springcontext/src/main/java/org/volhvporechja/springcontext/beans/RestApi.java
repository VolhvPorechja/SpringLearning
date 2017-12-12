package org.volhvporechja.springcontext.beans;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestApi {

    @RequestMapping("/")
    public String greetings() {
        return "<h1>Test</h1>";
    }
}
