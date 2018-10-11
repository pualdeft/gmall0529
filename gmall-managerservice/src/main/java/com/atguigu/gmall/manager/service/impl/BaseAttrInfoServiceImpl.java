package com.atguigu.gmall.manager.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.atguigu.gmall.mapper.BaseAttrInfoMapper;
import com.atguigu.gmall.mapper.BaseAttrValueMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import manager.BaseAttrInfo;
import manager.BaseAttrInfoService;
import manager.BaseAttrValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
@Slf4j
@Service
public class BaseAttrInfoServiceImpl implements BaseAttrInfoService {
@Autowired
    BaseAttrInfoMapper baseAttrInfoMapper;

    @Autowired
    BaseAttrValueMapper baseAttrValueMapper;
    @Override
    public List<BaseAttrInfo> getBaseSttrInfoByCatalog3Id(Integer catalog3Id) {

        return baseAttrInfoMapper.selectList(new QueryWrapper<BaseAttrInfo>().eq("catalog3_id",catalog3Id));
    }

    @Override
    public List<BaseAttrValue> getBaseAttrValueByAttrId(Integer baseAttrInfoId) {
        return baseAttrValueMapper.selectList(new QueryWrapper<BaseAttrValue>().eq("attr_id",baseAttrInfoId));
    }
@Transactional
    @Override
    public void saveOrUpdateBaseInfo(BaseAttrInfo baseAttrInfo) {
log.info("准备修改的BaseAttrInfo信息是:{}",baseAttrInfo);
    if(baseAttrInfo.getId()!=null){

        baseAttrInfoMapper.updateById(baseAttrInfo);

        List<BaseAttrValue> attrValues = baseAttrInfo.getAttrValues();
List<Integer> ids=new ArrayList<>();
for (BaseAttrValue attrValue:attrValues){
    Integer id= attrValue.getId();
    if(id!=null){
        ids.add(id);
    }
}

        baseAttrValueMapper.delete(new QueryWrapper<BaseAttrValue>().notIn("id",ids).eq("attr_id",baseAttrInfo.getId()));

    for(BaseAttrValue attrValue:attrValues){
        if(attrValue.getId()!=null){
            baseAttrValueMapper.updateById(attrValue);
        }else {
attrValue.setAttrId(baseAttrInfo.getId());
            baseAttrValueMapper.insert(attrValue);

        }
    }


    }


    }
}
