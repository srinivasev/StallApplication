package com.learning.stall.model;

import jakarta.persistence.*;

@Entity
public class Orders {

    @Id
    private Integer addressId;

    @Column
    private String streetName;

    /*@OneToOne(mappedBy = "custId")
    private Customer custId;*/

//    @ManyToOne
//    @JoinColumn(name="custId")
//    private Customer custId;

}
