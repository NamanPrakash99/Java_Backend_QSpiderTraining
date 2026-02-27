package com.Assignment7;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class AuditService {

    public AuditService() {
        System.out.println("AuditService Constructor Called");
    }

    @PostConstruct
    public void init() {
        System.out.println("AuditService Initialized");
    }

    public void log(String message) {
        System.out.println("AUDIT LOG: " + message);
    }

    @PreDestroy
    public void destroy() {
        System.out.println("AuditService Destroyed");
    }
}
