package com.atguigu.gmall.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmall.vo.BaseAttrInfoAndValueVo;
import com.atguigu.gmall.vo.BaseAttrValueVo;
import lombok.extern.slf4j.Slf4j;
import manager.BaseAttrInfo;
import manager.BaseAttrInfoService;
import manager.BaseAttrValue;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
@Slf4j
@Controller
public class AttrManageController {
    @Reference
BaseAttrInfoService  baseAttrInfoService;
@ResponseBody
    @RequestMapping("/updates")
    public String  saveOrUpdateOrDeleteAttrInfoAndValue(@RequestBody BaseAttrInfoAndValueVo baseAttrInfoAndValueVo){
log.info("页面提交来的数据：{}",baseAttrInfoAndValueVo);
     //1.修改还是添加
    if(baseAttrInfoAndValueVo.getId()!=null){
        //修改
        BaseAttrInfo baseAttrInfo = new BaseAttrInfo();
        BeanUtils.copyProperties(baseAttrInfoAndValueVo,baseAttrInfo);
        List<BaseAttrValue> values=new ArrayList<>();
        for(BaseAttrValueVo baseAttrValueVo:baseAttrInfoAndValueVo.getAttrValues()){
            BaseAttrValue baseAttrValue = new BaseAttrValue();
        BeanUtils.copyProperties(baseAttrValueVo,baseAttrValue);
       values.add(baseAttrValue);
        }
        baseAttrInfo.setAttrValues(values);
        baseAttrInfoService.saveOrUpdateBaseInfo(baseAttrInfo);
    }else{

    }
return "ok";
    }
@ResponseBody
    @RequestMapping("/value/{id}")
public List<BaseAttrValue> getBaseAttrValueByAttrId(@PathVariable Integer id){
    return baseAttrInfoService.getBaseAttrValueByAttrId(id);
}


    @RequestMapping("/listPage.html")
public  String getAttrListPage(){

    return "attr/attrListPage";
}



}
