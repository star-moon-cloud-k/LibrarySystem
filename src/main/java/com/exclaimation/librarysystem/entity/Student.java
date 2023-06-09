package com.exclaimation.librarysystem.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Student {

    @Id
    String studentId;

    @Column(nullable = false)
    String name;

    @Column(nullable = false)
    String password;

    @CreationTimestamp
    @Column(nullable = false)
    LocalDate created_dt;

    @Column(nullable = false)
    String phone;
    @Column
    boolean delay;

    @Enumerated(EnumType.STRING)
    Role userRole;
}
