package br.com.confitecsp.java.web.model;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
public class StartServer extends SpringBootServletInitializer {
    public static void main(String[] args){
        SpringApplication.run(StartServer.class, args);

    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(StartServer.class);
    }
    @RequestMapping(value = "/")
    public String hello() {
        return "Hello World from Tomcat";
    }
}
