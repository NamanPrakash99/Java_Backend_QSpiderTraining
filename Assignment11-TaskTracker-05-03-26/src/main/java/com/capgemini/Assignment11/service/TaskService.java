package com.capgemini.Assignment11.service;

import com.capgemini.Assignment11.entity.Task;
import com.capgemini.Assignment11.repo.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public void saveTask(Task task, MultipartFile file) throws IOException {
        if (file != null && !file.isEmpty()) {
            task.setImageData(file.getBytes());
            task.setImageName(file.getOriginalFilename());
            task.setImageType(file.getContentType());
        }
        
        if (task.getId() == null) {
            task.setStatus("PENDING");
        }
        
        taskRepository.save(task);
    }

    public void toggleStatus(Long id) {
        Task task = taskRepository.findById(id).orElse(null);
        if (task != null) {
            if ("PENDING".equals(task.getStatus())) {
                task.setStatus("COMPLETE");
            } else {
                task.setStatus("PENDING");
            }
            taskRepository.save(task);
        }
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    public byte[] getTaskImage(Long id) {
        Task task = taskRepository.findById(id).orElse(null);
        return (task != null) ? task.getImageData() : null;
    }

    public Task getTaskById(Long id) {
        return taskRepository.findById(id).orElse(null);
    }
}
