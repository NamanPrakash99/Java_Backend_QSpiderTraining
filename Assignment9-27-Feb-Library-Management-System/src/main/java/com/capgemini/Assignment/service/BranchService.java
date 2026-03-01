package com.capgemini.Assignment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.Assignment.entity.LibraryBranch;
import com.capgemini.Assignment.exception.ResourceNotFoundException;
import com.capgemini.Assignment.repository.LibraryBranchRepository;

@Service
public class BranchService {

    @Autowired
    private LibraryBranchRepository branchRepository;

    public List<LibraryBranch> getAllBranches() {
        return branchRepository.findAll();
    }

    public LibraryBranch getBranchById(Long id) {
        return branchRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Branch not found with id: " + id));
    }

    public LibraryBranch addBranch(LibraryBranch branch) {
        return branchRepository.save(branch);
    }

    public LibraryBranch updateBranch(Long id, LibraryBranch branch) {
        LibraryBranch existing = getBranchById(id);
        existing.setName(branch.getName());
        existing.setLocation(branch.getLocation());
        existing.setContactNumber(branch.getContactNumber());
        return branchRepository.save(existing);
    }

    public void deleteBranch(Long id) {
        LibraryBranch branch = getBranchById(id);
        branchRepository.delete(branch);
    }
}