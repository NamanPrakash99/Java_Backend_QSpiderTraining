package com.capgemini.Assignment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.Assignment.entity.Member;
import com.capgemini.Assignment.exception.ResourceNotFoundException;
import com.capgemini.Assignment.repository.MemberRepository;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    // Get all members
    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    // Get member by ID
    public Member getMemberById(Long id) {
        return memberRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Member not found with id: " + id));
    }

    // Create member
    public Member addMember(Member member) {
        member.setStatus("ACTIVE");   // default status
        return memberRepository.save(member);
    }

    // Update member
    public Member updateMember(Long id, Member member) {
        Member existing = getMemberById(id);

        existing.setName(member.getName());
        existing.setEmail(member.getEmail());
        existing.setPhone(member.getPhone());
        existing.setMemberSince(member.getMemberSince());
        existing.setStatus(member.getStatus());

        return memberRepository.save(existing);
    }

    // Block (soft delete) member
    public void deleteOrDisableMember(Long id) {
        Member existing = getMemberById(id);
        existing.setStatus("BLOCKED");
        memberRepository.save(existing);
    }
}