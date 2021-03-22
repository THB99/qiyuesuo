package com.qiyuesuo.thb.server.service.impl;

import com.qiyuesuo.thb.server.entity.FileEntity;
import com.qiyuesuo.thb.server.exception.FileEmptyException;
import com.qiyuesuo.thb.server.exception.FileNameException;
import com.qiyuesuo.thb.server.mapper.FileMapper;
import com.qiyuesuo.thb.server.service.FileUploadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.print.DocFlavor;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ListResourceBundle;
import java.util.UUID;


@Slf4j
@Service("fileUploadService")
public class FileUploadServiceImpl implements FileUploadService {
    @Autowired
    FileMapper fileMapper;

    @Transactional
    @Override
    public String upLoad(MultipartFile file) throws IOException {
        if (file.isEmpty()){
            throw new FileEmptyException();
        }
        //获取上传文件名称
        long size = file.getSize();
        String originalname = file.getOriginalFilename();
        System.out.println(originalname);
        String[] split = originalname.split("\\.");

        int length = split.length;
        if (length==1){
            log.error("文件名格式不正确",originalname);
            throw new FileNameException(originalname);
        }
        //文件后缀名
        String houzhui = split[length - 1];
        String pwd = System.getProperty("user.dir");
        String uuid= UUID.randomUUID().toString();

        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        String dir_date = dateFormat.format(date);
        //拼装文件名（/uploadFile/yyyyMMdd/uuid.后缀）
        String filename=pwd+"\\uploadFile\\"+dir_date+"\\"+uuid+"."+houzhui;

        File dest = new File(filename);
        if (!dest.getParentFile().exists()){
            dest.getParentFile().mkdirs();
        }
        //文件保存
        file.transferTo(dest);
        //文件基本信息持久化
        FileEntity fileEntity = new FileEntity();
        fileEntity.setUuid(uuid);
        fileEntity.setSize(size);
        fileEntity.setType(houzhui);
        fileEntity.setOriginalname(originalname);
        fileEntity.setCreatetime(new Date());
        fileEntity.setAddress(filename);
        fileMapper.saveFile(fileEntity);
        return uuid;
    }

}
