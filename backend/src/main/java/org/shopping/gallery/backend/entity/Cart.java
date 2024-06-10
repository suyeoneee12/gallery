package org.shopping.gallery.backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="carts")
public class Cart {

    @Id // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //자동증가
    private int id;

    @Column
    private int memberId;

    @Column
    private int itemId;
}
