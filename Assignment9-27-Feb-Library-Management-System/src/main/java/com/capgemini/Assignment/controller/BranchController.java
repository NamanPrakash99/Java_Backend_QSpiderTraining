package com.capgemini.Assignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.capgemini.Assignment.entity.LibraryBranch;
import com.capgemini.Assignment.service.BranchService;

@RestController
@RequestMapping("/api/v1/branches")
public class BranchController {

    @Autowired
    private BranchService branchService;

    @PostMapping
    public ResponseEntity<LibraryBranch> createBranch(@RequestBody LibraryBranch branch) {
        return ResponseEntity.ok(branchService.addBranch(branch));
    }

    @GetMapping("/{id}")
    public ResponseEntity<LibraryBranch> getBranch(@PathVariable Long id) {
        return ResponseEntity.ok(branchService.getBranchById(id));
    }

    @GetMapping
    public ResponseEntity<List<LibraryBranch>> getAllBranches() {
        return ResponseEntity.ok(branchService.getAllBranches());
    }

    @PutMapping("/{id}")
    public ResponseEntity<LibraryBranch> updateBranch(@PathVariable Long id,
                                                      @RequestBody LibraryBranch branch) {
        return ResponseEntity.ok(branchService.updateBranch(id, branch));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBranch(@PathVariable Long id) {
        branchService.deleteBranch(id);
        return ResponseEntity.ok("Branch deleted successfully");
    }
}