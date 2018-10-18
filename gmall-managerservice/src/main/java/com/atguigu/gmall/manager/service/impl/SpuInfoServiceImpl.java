package com.atguigu.gmall.manager.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.atguigu.gmall.mapper.spu.*;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import manager.SpuInfoService;
import manager.spu.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
@Slf4j
@Service
public class SpuInfoServiceImpl implements SpuInfoService {
   @Autowired
    SpuInfoMapper spuInfoMapper;
   @Autowired
   BaseSaleAttrMapper baseSaleAttrMapper;
@Autowired
    SpuImageMapper spuImageMapper;
@Autowired
    SpuSaleAttrMapper spuSaleAttrMapper;
@Autowired
    SpuSaleAttrValueMapper spuSaleAttrValueMapper;
    @Override
    public List<SpuInfo> getSpuInfoByC3Id(Integer catalog3Id) {
       return spuInfoMapper.selectList(new QueryWrapper<SpuInfo>().eq("catalog3_id",catalog3Id));

    }

    @Override
    public List<BaseSaleAttr> getBaseSaleAttr() {
        return baseSaleAttrMapper.selectList(null);
    }

    @Override
    public void saveBigSpuInfo(SpuInfo spuInfo) {
        spuInfoMapper.insert(spuInfo);
        Integer id = spuInfo.getId();
        List<SpuImage> spuImages = spuInfo.getSpuImages();
        log.info("kankan tupainxinxi "+spuInfo);
        for(SpuImage spuImage : spuImages){
            spuImage.setSpuId(id);
            spuImageMapper.insert(spuImage);
        }
        List<SpuSaleAttr> spuSaleAttrs = spuInfo.getSpuSaleAttrs();
for (SpuSaleAttr spuSaleAttr : spuSaleAttrs){
    spuSaleAttr.setSpuId(id);
    spuSaleAttrMapper.insert(spuSaleAttr);
    List<SpuSaleAttrValue> saleAttrValues = spuSaleAttr.getSaleAttrValues();
    for (SpuSaleAttrValue saleAttrValue : saleAttrValues) {
        saleAttrValue.setSpuId(id);
        saleAttrValue.setSaleAttrId(spuSaleAttr.getSaleAttrId());
spuSaleAttrValueMapper.insert(saleAttrValue);
    }


}
    }

    @Override
    public List<SpuImage> getSpuImages(Integer spuId) {
        return spuImageMapper.selectList(new QueryWrapper<SpuImage>().eq("spu_id",spuId));
    }

}
