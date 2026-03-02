package com.capgemini.springBootMVC.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.capgemini.springBootMVC.Entity.Employee;
import com.capgemini.springBootMVC.service.EmployeeService;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService empservice;

    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }

    @PostMapping("/register")
    public String register(Employee emp) {
        return empservice.register(emp);
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public ModelAndView login(String email, String password) {
        return empservice.loginProcess(email, password);
    }

    @GetMapping("/admin")
    public ModelAndView admin() {
        return empservice.loadAdminDashboard();
    }

    @GetMapping("/delete")
    public ModelAndView delete(String email) {
        return empservice.deleteEmployee(email);
    }

    @GetMapping("/update")
    public ModelAndView updatePage(String email) {
        return empservice.loadUpdatePage(email);
    }

    @PostMapping("/update")
    public ModelAndView update(Employee emp) {
        return empservice.updateEmployee(emp);
    }
}