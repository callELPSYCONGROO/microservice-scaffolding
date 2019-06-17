package com.wuhenjian.microservicescaffolding.service2.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class C implements Serializable {
    private Integer cid;

    private String cname;

    private Date ctime;

    private Integer bid;
}