package com.wuhenjian.microservicescaffolding.util.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class B implements Serializable {
    private Integer bid;

    private String bname;

    private Integer aid;

    private Date btime;
}