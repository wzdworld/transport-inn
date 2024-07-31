package com.example.transport.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value="运单详情")
public class TransportOrderDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "重量")
    private Integer weight;

    @ApiModelProperty(value = "体积")
    private Integer volume;

    @ApiModelProperty(value = "装货方式")
    private Integer loadWay;

    @ApiModelProperty(value = "订金")
    private Integer deposit;

    @ApiModelProperty(value = "服务费")
    private Integer servicePrice;

    @ApiModelProperty(value = "公司id")
    private Long companyId;

    @ApiModelProperty(value = "备注")
    private String comment;


}
