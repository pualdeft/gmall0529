package com.atguigu.gmall;

import com.atguigu.gmall.mapper.BaseCatalog1Mapper;
import lombok.extern.slf4j.Slf4j;

import manager.BaseCatalog1;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class GmallManagerserviceApplicationTests {
 @Autowired
    BaseCatalog1Mapper baseCatalog1Mapper;
    @Test
    public void contextLoads() {

        BaseCatalog1 baseCatalog1 = new BaseCatalog1();
        baseCatalog1.setName("呵呵");

        baseCatalog1Mapper.insert(baseCatalog1);
          log.info("成功。。。");
    }

}
