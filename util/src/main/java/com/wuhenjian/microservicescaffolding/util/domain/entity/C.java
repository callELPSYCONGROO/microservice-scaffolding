package com.wuhenjian.microservicescaffolding.util.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("C")
public class C implements Serializable {

    @TableId(type = IdType.INPUT)
    private Integer cid;

    private String cname;

    private Date ctime;

    private Integer bid;
}