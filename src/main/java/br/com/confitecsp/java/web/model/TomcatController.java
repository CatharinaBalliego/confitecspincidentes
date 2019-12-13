package br.com.confitecsp.java.web.model;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class TomcatController {

//    @GetMapping("/hello")
//    public Collection<String> sayHello() {
//        return IntStream.range(0, 10)
//                .mapToObj(i -> "Hello number " + i)
//                .collect(Collectors.toList());
//    }
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public @ResponseBody
    String hiThere(){
        return "hello world!";
    }
}