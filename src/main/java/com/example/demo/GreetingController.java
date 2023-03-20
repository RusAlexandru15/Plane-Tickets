package com.example.demo;

import model.Zboruri;
import org.springframework.web.bind.annotation.*;

@RestController
public class GreetingController {
    private Zboruri zbor;
    @GetMapping("/greet")
    public String greet(){
        if(zbor!=null)
           return zbor.toString();
        else
            return "NULL";
    }

    @PutMapping("/put{newMessage}")
    public String put1(@PathVariable("newRoute1") String from,@PathVariable("newRoute2") String to){
        zbor.setRoute(from,to);
       return "ruta modificata";
    }

    @DeleteMapping("/del")
   public void removeMessage(){
        zbor=null;
    }

    @PostMapping("/post")
    public void generate(){
        zbor=new Zboruri("02-03-2022","Cluj","Bucuresti",1);
    }




}