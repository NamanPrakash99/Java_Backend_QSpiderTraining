package com.cpgemini.Assignment14.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "students")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String email;

    private String course;

    private Double marks;

    @Lob
    @Column(columnDefinition = "BYTEA")
    private byte[] profileImage;

    @Lob
    @Column(columnDefinition = "BYTEA")
    private byte[] assignmentFile;
}
