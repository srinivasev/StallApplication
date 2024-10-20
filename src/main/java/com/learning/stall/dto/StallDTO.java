package com.learning.stall.dto;

import com.learning.stall.model.StallDetail;
import com.learning.stall.model.StallOriginState;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class StallDTO {

    private Integer id;

    private String name;

    private String category;

    private StallDetail stallDetail;

    private StallOriginState stallOriginState;
}
