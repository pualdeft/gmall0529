package com.atguigu.gmall.vo;

import lombok.Data;

import java.util.List;

@Data
public class BaseAttrInfoAndValueVo {
private Integer id;
private String attrName;
private List<BaseAttrValueVo> attrValues;
}
