package com.atguigu.gmall.mapper.sku;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import manager.sku.SkuAllSaveAttrAndValueTo;
import manager.sku.SkuImage;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SkuImageMapper extends BaseMapper<SkuImage> {
    List<SkuAllSaveAttrAndValueTo> getSkuAllSaveAttrAndValue(@Param("id") Integer id,@Param("spuId") Integer spuId);
}
