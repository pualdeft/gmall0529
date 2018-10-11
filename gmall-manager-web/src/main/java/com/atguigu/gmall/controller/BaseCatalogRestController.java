package com.atguigu.gmall.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import manager.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BaseCatalogRestController {
    @Reference
BaseAttrInfoService baseAttrInfoService;
    @Reference
    CatalogService catalogService;

    @RequestMapping("/attrs.json")
    public List<BaseAttrInfo> getBaseAttrTnFos(Integer id){
        return baseAttrInfoService.getBaseSttrInfoByCatalog3Id(id);
    }
@RequestMapping("/1/list.json")
    public List<BaseCatalog1> listBaseCatalog1(){
return catalogService.getAllBaseCatalog1();
}
    @RequestMapping("/2/list.json")
    public List<BaseCatalog2> listBaseCatalog2(Integer id){
        return catalogService.getAllBaseCatalog2ByC1Id(id);
    }
    @RequestMapping("/3/list.json")
    public List<BaseCatalog3> listBaseCatalog3(Integer id){
        return catalogService.getAllBaseCatalog3byC2Id(id);
    }

}
