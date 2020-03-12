package io.viren.demo.springsecurity.resources;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
public class DemoResource implements ErrorController {

    @GetMapping
    public String hello() {
        return "Hello Spring..!!";
    }

    @GetMapping("/user")
    public String helloUser() {
        return "Hello User..!!";
    }

    @GetMapping("/admin")
    public String helloAdmin() {
        return "Hello Admin";
    }

    @Override
    @GetMapping("/error")
    public String getErrorPath() {
        return "Kat Gaya Tumhara";
    }
}
