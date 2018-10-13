package com.atguigu.gmall.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import manager.SpuInfoService;
import manager.spu.SpuInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequestMapping("/spu")
@Controller
public class SpuManagerController {
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