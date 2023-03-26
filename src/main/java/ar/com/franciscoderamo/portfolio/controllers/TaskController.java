package ar.com.franciscoderamo.portfolio.controllers;

import ar.com.franciscoderamo.portfolio.interfaces.TaskInterface;
import ar.com.franciscoderamo.portfolio.models.TaskModel;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/task")//localhost:8080/task
@CrossOrigin(origins = "https://portfolio-francisco-deramo.web.app")
//@CrossOrigin(origin = "http://localhost:4200")
public class TaskController {
    
    @GetMapping("/hola")
    public String decirHola(){
        return "Hola mundoooo";
    }
    
    //to deploy repository we used Autowired
    //dependency injection
    @Autowired
    private TaskInterface taskService;
    
    @GetMapping ("/all")
    @ResponseBody
    public List<TaskModel> getTask(){
        return taskService.getTask();
    }
    
    @GetMapping ("/see/{id}")
    @ResponseBody
    public TaskModel seeTask(@PathVariable Long id){
        return taskService.findTask(id);
    }
    
    @PostMapping("/new")
    public ResponseEntity<TaskModel> addTask(@RequestBody TaskModel task){
        taskService.saveTask(task);
        return ResponseEntity.ok().body(task);
    }
        
    @DeleteMapping ("/delete/{id}")
    public ResponseEntity deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity <?> editTask(@PathVariable("id") Long id, @RequestBody TaskModel task) {
        TaskModel tsk = taskService.findTask(id);

        tsk.setId(task.getId());
        tsk.setTitle(task.getTitle());

        taskService.saveTask(tsk);
        return new ResponseEntity(HttpStatus.OK);
    }    
}
