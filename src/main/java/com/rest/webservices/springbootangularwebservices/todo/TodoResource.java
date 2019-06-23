package com.rest.webservices.springbootangularwebservices.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class TodoResource {

      @Autowired
     private TodoDaoService todoDaoService;

     @GetMapping("/users/{username}/todos")
     public List<Todo> retrieveAllTodos(@PathVariable String username){

          return todoDaoService.findAll();
     }

    @GetMapping("/users/{username}/todos/{id}")
    public Todo TodoretrieveTodo(@PathVariable String username, @PathVariable long id){

        return todoDaoService.findById(id);
    }


     @DeleteMapping("/users/{username}/todos/{id}")
     public ResponseEntity<Void> deleteTodo(@PathVariable String username, @PathVariable long id){

           Todo todo = todoDaoService.deleteById(id);

            if(todo != null ){
                 return  ResponseEntity.noContent().build();
            }

            return  ResponseEntity.notFound().build();
     }

      @PutMapping("/users/{username}/todos/{id}")
      public ResponseEntity<Todo> upadateTodo(@PathVariable String username, @PathVariable long id, @RequestBody Todo todo){

           Todo todoUpdated = todoDaoService.save(todo);

           return  new ResponseEntity<Todo>(todo, HttpStatus.OK);
      }

      @PostMapping("/users/{username}/todos")
      public ResponseEntity<Void> createTodo(@PathVariable String username, @RequestBody Todo todo) {

          Todo createdTodo = todoDaoService.save(todo);
          URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                      .path("/{id}")
                      .buildAndExpand(createdTodo.getId())
                      .toUri();
          return  ResponseEntity.created(location)
                               .build();
      }
}
