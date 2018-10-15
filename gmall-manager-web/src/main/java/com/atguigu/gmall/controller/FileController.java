package com.atguigu.gmall.controller;

import com.atguigu.gmall.components.FastDFSTemplate;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.csource.common.MyException;
import org.csource.fastdfs.StorageClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Slf4j
@RequestMapping("/file")
@Controller
public class FileController {
    @Autowired
    FastDFSTemplate fastDFSTemplate;
    @ResponseBody
    @RequestMapping("/upload")
    public String fileUpload(@RequestParam("file") MultipartFile file) throws IOException {
        if(!file.isEmpty()){
            String originalFilename = file.getOriginalFilename();
            long size = file.getSize();
            String name = file.getName();
            log.info("文件：{}；名字：{}；大小：{}；上传成功",name,originalFilename,size);

            StorageClient storageClient = fastDFSTemplate.getStorageClient();
            String s = StringUtils.substringAfterLast(originalFilename, ".");
            try {
                String[] strings = storageClient.upload_file(file.getBytes(), s, null);
                String path = fastDFSTemplate.getPath(strings);
                 return path;
            } catch (MyException e) {
               log.error("文件上传出错：{}",e);
            }

        }
        return "";
    }
}
