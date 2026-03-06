package com.capgemini.Assignment11.controller;

import com.capgemini.Assignment11.entity.Task;
import com.capgemini.Assignment11.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    public String getAllTasks(Model model) {
        List<Task> tasks = taskService.getAllTasks();
        model.addAttribute("taskList", tasks);
        // Counting for stats
        long total = tasks.size();
        long pending = tasks.stream().filter(t -> "PENDING".equals(t.getStatus())).count();
        long completed = total - pending;
        
        model.addAttribute("totalTasks", total);
        model.addAttribute("pendingTasks", pending);
        model.addAttribute("completedTasks", completed);
        
        return "task-list";
    }

    @GetMapping("/new")
    public String showTaskForm(Model model) {
        model.addAttribute("task", new Task());
        return "task-form";
    }

    @PostMapping("/save")
    public String saveTask(@Valid @ModelAttribute("task") Task task,
                           BindingResult result,
                           @RequestParam("imageFile") MultipartFile imageFile,
                           Model model) throws IOException {
        
        if (result.hasErrors()) {
            return "task-form";
        }
        
        taskService.saveTask(task, imageFile);
        return "redirect:/tasks";
    }

    @GetMapping("/toggle/{id}")
    public String toggleTaskStatus(@PathVariable Long id) {
        taskService.toggleStatus(id);
        return "redirect:/tasks";
    }

    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return "redirect:/tasks";
    }

    @GetMapping("/image/{id}")
    public ResponseEntity<byte[]> getTaskImage(@PathVariable Long id) {
        Task task = taskService.getTaskById(id);
        if (task != null && task.getImageData() != null) {
            byte[] imageContent = task.getImageData();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.parseMediaType(task.getImageType()));
            return new ResponseEntity<>(imageContent, headers, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
