package com.atguigu.gmall.manager.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.atguigu.gmall.mapper.BaseCatalog1Mapper;
import com.atguigu.gmall.mapper.BaseCatalog2Mapper;
import com.atguigu.gmall.mapper.BaseCatalog3Mapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import manager.*;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
@Slf4j
@Service
public class CatalogServiceImpl implements CatalogService {
@Autowired
    BaseCatalog1Mapper baseCatalog1Mapper;
    @Autowired
    BaseCatalog2Mapper baseCatalog2Mapper;
    @Autowired
    BaseCatalog3Mapper baseCatalog3Mapper;

@Override
    public List<BaseCatalog1> getAllBaseCatalog1()
{
        return baseCatalog1Mapper.selectList(null);
    }

    @Override
    public List<BaseCatalog2> getAllBaseCatalog2ByC1Id(Integer catalog1Id) {
        QueryWrapper  <BaseCatalog2> catalog1_id = new QueryWrapper<BaseCatalog2>().eq("catalog1_id", catalog1Id);
       return baseCatalog2Mapper.selectList(catalog1_id);


    }

    @Override
    public List<BaseCatalog3> getAllBaseCatalog3byC2Id(Integer catalog2Id) {

        QueryWrapper<BaseCatalog3> catalog2_id = new QueryWrapper<BaseCatalog3>().eq("catalog2_id", catalog2Id);

        return baseCatalog3Mapper.selectList(catalog2_id);
    }

    @Override
    public void addBaseInfo(BaseCatalog3 baseCatalog3) {
        log.info("准备修改的BaseAttrInfo信息是:{}",baseCatalog3);
        if(baseCatalog3.getId()!=null){

            baseCatalog3Mapper.updateById(baseCatalog3);


            List<Integer> ids=new ArrayList<>();





            }


        }
    }
