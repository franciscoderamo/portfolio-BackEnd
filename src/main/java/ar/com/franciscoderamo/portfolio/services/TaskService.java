package ar.com.franciscoderamo.portfolio.services;

import ar.com.franciscoderamo.portfolio.interfaces.TaskInterface;
import ar.com.franciscoderamo.portfolio.models.TaskModel;
import ar.com.franciscoderamo.portfolio.repositories.TaskRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService implements TaskInterface{
    //to deploy repository we used Autowired
    //dependency injection
    @Autowired
    public TaskRepository taskRepo;
    
    @Override
    public List<TaskModel> getTask() {
        return taskRepo.findAll();
    }

    @Override
    public void saveTask(TaskModel task) {
        taskRepo.save(task) ;
    }

    @Override
    public void deleteTask(Long id) {
        taskRepo.deleteById(id);
    }

    @Override
    public TaskModel findTask(Long id) {
        TaskModel task = taskRepo.findById(id).orElse(null);
        return task;
    }  
}
