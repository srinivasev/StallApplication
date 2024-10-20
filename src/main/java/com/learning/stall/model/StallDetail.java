package com.learning.stall.model;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@Table(name= "stall_details")
@NoArgsConstructor
public class StallDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer stall_detail_id;

    @Column
    private String ownerName;

    @Column
    private String ownerAddress;

    @OneToOne(mappedBy = "stallDetail")
    private Stall stall;

}
