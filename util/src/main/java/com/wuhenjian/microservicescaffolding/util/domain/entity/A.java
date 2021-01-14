package com.wuhenjian.microservicescaffolding.util.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("A")
public class A implements Serializable {

    @TableId(type = IdType.INPUT)
    private Integer aid;

    private String aname;

    private Date atime;
}