package com.capgemini.Assignment11.service;
import com.capgemini.Assignment11.entity.Task;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface TaskService {
    List<Task> getAllTasks();
    void saveTask(Task task, MultipartFile file) throws IOException;
    void toggleStatus(Long id);
    void deleteTask(Long id);
    byte[] getTaskImage(Long id);
    Task getTaskById(Long id);
}
