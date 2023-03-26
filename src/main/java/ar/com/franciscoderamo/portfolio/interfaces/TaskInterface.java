package ar.com.franciscoderamo.portfolio.interfaces;

import ar.com.franciscoderamo.portfolio.models.TaskModel;
import java.util.List;

public interface TaskInterface {
    
    public List<TaskModel> getTask();
    
    public void saveTask(TaskModel task);
    
    public void deleteTask (Long id);
    
    public TaskModel findTask(Long id);
}
