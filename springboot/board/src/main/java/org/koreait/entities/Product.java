package org.koreait.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

//@Entity @Data
//@IdClass(ProductPk.class)
public class Product {
    @Id
    @Column(length=20)
    private String productNo;

    @Id
    @Column(length=60)
    private String productNm;


    //@ManyToMany(mappedBy="products")
    //private List<Users> users = new ArrayList<>();
}
