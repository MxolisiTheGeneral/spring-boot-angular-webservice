package com.rest.webservices.springbootangularwebservices.helloworld;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class HelloWorldController {


      @GetMapping("/hello-world")
      public String helloWorld(){

          return  "Hello World";
     }

       @GetMapping("/hello-world-bean")
       public HelloWorldBean helloWorldBean(){
          //throw new RuntimeException("Some error has occured");
          return  new HelloWorldBean("Hello world bean");
      }

      @GetMapping("/hello-world/path-var/{name}")
      public HelloWorldBean helloWorldPath(@PathVariable String name){
          return  new HelloWorldBean(name);
      }
}
