package com.atguigu.gmall.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
@Slf4j
@RequestMapping("/file")
@Controller
public class FileController {
    @ResponseBody
    @RequestMapping("/upload")
    public String fileUpload(@RequestParam("file") MultipartFile file){
        if(!file.isEmpty()){
            String originalFilename = file.getOriginalFilename();
            long size = file.getSize();
            String name = file.getName();
            log.info("文件：{}；名字：{}；大小：{}；上传成功",name,originalFilename,size);
        }
        return "";
    }
}
