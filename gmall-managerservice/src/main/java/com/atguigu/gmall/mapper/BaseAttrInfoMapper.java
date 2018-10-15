package com.atguigu.gmall.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import manager.BaseAttrInfo;

import java.util.List;

public interface BaseAttrInfoMapper extends BaseMapper<BaseAttrInfo> {
    List<BaseAttrInfo> getBaseAttrInfoByCatalog3Id(Integer catalog3Id);
}
