package com.atguigu.gmall.mapper.spu;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import manager.spu.SpuSaleAttr;

import java.util.List;

public interface SpuSaleAttrMapper extends BaseMapper<SpuSaleAttr> {
    List<SpuSaleAttr> getSpuSaleAttrBySpuId(Integer spuId);
}
