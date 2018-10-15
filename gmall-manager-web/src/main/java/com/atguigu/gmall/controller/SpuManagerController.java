package com.atguigu.gmall.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import lombok.extern.slf4j.Slf4j;
import manager.SpuInfoService;
import manager.spu.BaseSaleAttr;
import manager.spu.SpuInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
@Slf4j
@RequestMapping("/spu")
@Controller
public class SpuManagerController {
    @ResponseBody
    @RequestMapping("/bigSave")
    public String saveAllSpuInfos(@RequestBody SpuInfo spuInfo){
        log.info("页面提交的spuinfo数据如下:{}",spuInfo);
       spuInfoService.saveBigSpuInfo(spuInfo);
        return "ok";


    }
@ResponseBody
    @RequestMapping("/base_sale_attr")
    public List<BaseSaleAttr> getBaseSaleAttr(){
      return  spuInfoService.getBaseSaleAttr();

    }
    @Reference
    SpuInfoService spuInfoService;
    @RequestMapping("/listPage.html")
    public String listPage(){

        return "spu/spuListPage";
    }
    @ResponseBody
    @RequestMapping("/info.json")
    public List<SpuInfo> getSpuInfoByC3Id(@RequestParam("catalog3Id") Integer catalog3Id){
     return spuInfoService.getSpuInfoByC3Id(catalog3Id);

    }
}