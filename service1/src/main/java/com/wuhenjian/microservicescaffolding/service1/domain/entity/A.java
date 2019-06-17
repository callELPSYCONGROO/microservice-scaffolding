package com.wuhenjian.microservicescaffolding.service1.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class A implements Serializable {
    private Integer aid;

    private String aname;

    private Date atime;
}