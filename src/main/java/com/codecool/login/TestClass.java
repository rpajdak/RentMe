package com.codecool.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
@RequestMapping()
@CrossOrigin
public class TestClass {
    @GetMapping("/test")
    @ResponseBody
    public String testHello() {
        return "hello from test";
    }
}
