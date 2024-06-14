package org.shopping.gallery.backend.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name="items")
public class Item {

    @Id // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //자동증가
    private int id;

    @Column(length=50, nullable=false)
    private String name;

    @Column(length = 100)
    private String imgPath;

    @Column
    private int price;

    @Column
    private int discountPer;
}
