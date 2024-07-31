package com.example.transport.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value="运单")
public class TransportOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "装货地点")
    private String loadPlace;

    @ApiModelProperty(value = "卸货地点")
    private String unloadPlace;

    @ApiModelProperty(value = "装货时间")
    private LocalDate loadTime;

    @ApiModelProperty(value = "运输类型")
    private Integer transportCategory;

    @ApiModelProperty(value = "车型")
    private String carCategory;

    @ApiModelProperty(value = "车长")
    private String carLength;

    @ApiModelProperty(value = "货物名称")
    private String goodsName;

    @ApiModelProperty(value = "运费")
    private Integer transportPrice;

    @ApiModelProperty(value = "联系人")
    private String linkman;


}
