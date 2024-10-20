package com.learning.stall.model;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.util.List;



@Entity
@Table(name = "stall_origin_state")
@NoArgsConstructor
public class StallOriginState {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer stall_origin_state_id;

    @Column
    private String stateName;

    @OneToMany(mappedBy = "stallOriginState")
    private List<Stall> stalls;
}
