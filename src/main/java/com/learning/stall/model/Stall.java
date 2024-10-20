package com.learning.stall.model;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "stall")
@Cacheable
@org.hibernate.annotations.Cache(usage= CacheConcurrencyStrategy.READ_WRITE)
@NoArgsConstructor
@ToString
public class Stall {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String name;

    @Column
    private String category;

    @OneToOne
    @JoinColumn(name="stall_detail_id")
    private StallDetail stallDetail;

    @ManyToOne
    @JoinColumn(name="stall_origin_state_id")
    private StallOriginState stallOriginState;

    public Stall(String name, String category, StallDetail stallDetail, StallOriginState stallOriginState) {
        this.name = name;
        this.category = category;
        this.stallDetail = stallDetail;
        this.stallOriginState = stallOriginState;
    }
}
