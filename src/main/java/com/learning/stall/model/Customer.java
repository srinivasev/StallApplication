package com.learning.stall.model;

import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.web.WebProperties;

import javax.annotation.processing.Generated;
import java.util.List;

@Entity
public class Customer {

    @Id
    private Integer custId;

    @Column
    private String name;

//    @OneToMany(mappedBy = "Customer")
//    private List<Orders> orders;
}
