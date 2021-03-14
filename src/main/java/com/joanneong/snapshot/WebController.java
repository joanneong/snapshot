package com.joanneong.snapshot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {
    @RequestMapping("/")
    public String index() {
        return "Greetings from snapshot!";
    }

}
