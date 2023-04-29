package org.koreait.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Product {
    @Id @GeneratedValue
    private Long id;
    private String productNm;

    @ManyToMany(mappedBy = "products")
    private List<Users> users = new ArrayList<>();

}
