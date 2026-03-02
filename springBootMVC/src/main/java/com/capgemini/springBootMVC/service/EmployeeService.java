package com.capgemini.springBootMVC.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.capgemini.springBootMVC.Entity.Employee;
import com.capgemini.springBootMVC.repo.EmployeeJpaRepository;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeJpaRepository repository;

    // REGISTER LOGIC
    public String register(Employee emp) {

        Employee existing = repository.findByEmail(emp.getEmail());

        if (existing != null) {
            return "userExists";
        }

        repository.save(emp);
        return "login";
    }

    // LOGIN and ROLE LOGIC 
    public ModelAndView loginProcess(String email, String password) {

        ModelAndView mv = new ModelAndView();

        //  email and password matching
        Employee emp = repository.findByEmailAndPassword(email, password);

        // not matched
        if (emp == null) {
            mv.setViewName("invalid");
            return mv;
        }

        // check role 
        if ("Admin".equalsIgnoreCase(emp.getRole())) {

            List<Employee> allEmployees = repository.findAll();
            mv.addObject("employees", allEmployees);
            mv.setViewName("adminDashboard");

        } else {

            mv.addObject("employee", emp);
            mv.setViewName("userDashboard");
        }

        return mv;
    }

    // ADMIN PAGE RELOAD
    public ModelAndView loadAdminDashboard() {

        ModelAndView mv = new ModelAndView();
        mv.addObject("employees", repository.findAll());
        mv.setViewName("adminDashboard");

        return mv;
    }

    // DELETE LOGIC
    public ModelAndView deleteEmployee(String email) {

        repository.deleteById(email);

        return loadAdminDashboard();   
    }

    // LOAD UPDATE PAGE
    public ModelAndView loadUpdatePage(String email) {

        ModelAndView mv = new ModelAndView();
        mv.addObject("employee", repository.findById(email).orElse(null));
        mv.setViewName("updateEmployee");

        return mv;
    }

    // UPDATE LOGIC
    public ModelAndView updateEmployee(Employee emp) {

        repository.save(emp);

        return loadAdminDashboard();   
    }
}