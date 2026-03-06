package com.securitypractice.springsecuritydbconnection.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.securitypractice.springsecuritydbconnection.dto.AccountRequestDTO;
import com.securitypractice.springsecuritydbconnection.dto.AccountResponseDTO;
import com.securitypractice.springsecuritydbconnection.entity.Account;
import com.securitypractice.springsecuritydbconnection.repo.AccountJpaRepository;

@Service
public class AccountService {
	
	private AccountJpaRepository jpa;
	private PasswordEncoder encode;
	
	
	public AccountService(AccountJpaRepository jpa, PasswordEncoder encode) {
		this.jpa = jpa;
		this.encode = encode;
	}
	
	public AccountResponseDTO createAccount(AccountRequestDTO dto) {
		if (jpa.existsByUsername(dto.getUsername())) {
			throw new RuntimeException("User Name Exist");
		}if(jpa.existsByEmail(dto.getEmail())) {
			throw new RuntimeException("User Email Exist");
		}
		
		Account account=new Account();
		account.setUsername(dto.getUsername());
		account.setFullname(dto.getFullname());
		account.setPassword(encode.encode(dto.getPassword()));
		account.setPhone(dto.getPhone());
		account.setCreatedAt(dto.getCreatedAt());
		account.setEmail(dto.getEmail());
		account.setRole(normalizeAndValidateRole(dto.getRole()));
		
		jpa.save(account);
		return toResponse(account);

	}
	
	
	public String normalizeAndValidateRole(String role) {

		if(role==null || role.trim().isEmpty()) {
			return "ROLE_USER";
		}
		
		String r=role.trim().toUpperCase();
		if(!r.startsWith("ROLE_")) {
			r="ROLE_"+r;
		}
		
		if(!r.equals("ROLE_USER") && !r.equals("ROLE_ADMIN")) {
			throw new RuntimeException("Invalid Role for Authorization");
		}
		return r;
		
	}
	
	
	public AccountResponseDTO toResponse(Account a) {
		
		AccountResponseDTO dto= new AccountResponseDTO();
		dto.setEmail(a.getEmail());
		dto.setPhone(a.getPhone());
		dto.setFullname(a.getFullname());
		dto.setUsername(a.getUsername());
		
		return dto;
	}
	
	public AccountResponseDTO getById(long id) {
		Account a=jpa.findById(id).orElseThrow(()->new RuntimeException("Id not found"));
		
		return toResponse(a);
	}
	
	public List<AccountResponseDTO> getAll() {

	    List<Account> account = jpa.findAll();
	    List<AccountResponseDTO> dto=new ArrayList<AccountResponseDTO>();
	    
	    for(Account a:account) {
	    	dto.add(toResponse(a));
	    }
	    return dto;
	}
	
	
	@PreAuthorize("hasRole('ADMIN')")         // this method can only be accessed by admin
	public String deleteById(Long id) {
	    Account account = jpa.findById(id).orElseThrow(() -> new RuntimeException("Account not found"));

	    jpa.delete(account);
	    return "Deleted";
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	public AccountResponseDTO updateAccount(Long id, AccountRequestDTO dto) {

	    Account account = jpa.findById(id).orElseThrow(() -> new RuntimeException("Account not found"));

	    if(dto.getUsername()!=null) {
	        account.setUsername(dto.getUsername());
	    }

	    if(dto.getFullname()!=null) {
	        account.setFullname(dto.getFullname());
	    }

	    if(dto.getEmail()!=null) {
	        account.setEmail(dto.getEmail());
	    }

	    if(dto.getPhone()!=null) {
	        account.setPhone(dto.getPhone());
	    }

	    if(dto.getPassword()!=null) {
	        account.setPassword(encode.encode(dto.getPassword()));
	    }

	    if(dto.getRole()!=null) {
	        account.setRole(normalizeAndValidateRole(dto.getRole()));
	    }

	    jpa.save(account);

	    return toResponse(account);
	}
	
	
}
