package org.shopping.gallery.backend.entity;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name="members")
public class Member {

    @Id // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //자동증가
    private int id;

    @Column(length=50, nullable=false, unique=true)
    private String email;

    @Column(length = 100, nullable = false)
    private String password;
}
