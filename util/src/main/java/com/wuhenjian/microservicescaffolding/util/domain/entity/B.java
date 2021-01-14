package com.wuhenjian.microservicescaffolding.util.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("B")
public class B implements Serializable {

    @TableId(type = IdType.INPUT)
    private Integer bid;

    private String bname;

    private Integer aid;

    private Date btime;
}