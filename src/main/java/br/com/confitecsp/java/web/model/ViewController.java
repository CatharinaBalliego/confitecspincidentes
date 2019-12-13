package br.com.confitecsp.java.web.model;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;


//@Controller
//public class ViewController {
////    private String appMode;
////
////    public ViewController(Environment environment){
////        appMode = environment.getProperty("app-mode");
////    }
////
////    @GetMapping("/")
////    public String index(Model model){
////
////        return "home";
////    }
//
//    @RequestMapping(value = {"/"})
//    public String home(){
//        return "home";
//    }

@Controller
public class ViewController {
    @GetMapping("/")
    public String index(Model model) {

        return "index";
    }
}