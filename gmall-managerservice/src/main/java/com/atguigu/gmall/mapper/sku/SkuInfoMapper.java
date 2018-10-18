package com.atguigu.gmall.mapper.sku;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import manager.sku.SkuAttrValueMappingTo;
import manager.sku.SkuInfo;

import java.util.List;

public interface SkuInfoMapper extends BaseMapper<SkuInfo> {

    List<SkuAttrValueMappingTo> getSkuAttrValueMapping(Integer spuId);
}
