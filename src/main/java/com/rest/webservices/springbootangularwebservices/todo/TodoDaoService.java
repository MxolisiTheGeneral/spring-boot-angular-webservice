package com.rest.webservices.springbootangularwebservices.todo;


import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TodoDaoService {


      private static List<Todo> todos = new ArrayList<>();
      private  static long id = 0;

      static {
          todos.add(new Todo(++id, "mxolisi", "Learn Angular 2", new Date(), false));
          todos.add(new Todo(++id, "mxolisi", "Visit Durban", new Date(), true));
          todos.add(new Todo(++id, "mxolisi", "Learn microservice", new Date(), false));
      }

      public List<Todo> findAll(){
           return todos;
      }



      public Todo deleteById(long id){
           Todo todo = findById(id);

           if(todo == null) return null;

           if(todos.remove(todo)) {
               return todo;
           }
            return  null;
      }

       public Todo save(Todo todo){
             if(todo.getId() == -1) {
                 todo.setId(++id);
                   todos.add(todo);
             } else{
                  deleteById(todo.getId());
                  todos.add(todo);
             }

             return  todo;
       }
    public Todo findById(long id) {

          for(Todo todo: todos){
               if(todo.getId() == id)
                    return todo;
          }
           return  null;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
