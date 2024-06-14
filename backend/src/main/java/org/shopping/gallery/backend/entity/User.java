package org.shopping.gallery.backend.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="members")
public class User {

    @Id // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //자동증가
    private Long id;

    @Column(length=50, nullable=false, unique=true)
    private String email;

    //@Column(length=50, nullable=false, unique=true)
    //private String username;

    @Column(length = 50, nullable = false)
    private String password;
}
