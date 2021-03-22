package com.qiyuesuo.thb.server.service.impl;

import com.qiyuesuo.thb.server.entity.FileEntity;
import com.qiyuesuo.thb.server.exception.FileEmptyException;
import com.qiyuesuo.thb.server.exception.FileNameException;
import com.qiyuesuo.thb.server.exception.FileNotExitException;
import com.qiyuesuo.thb.server.mapper.FileMapper;
import com.qiyuesuo.thb.server.service.FileDownloadService;
import com.qiyuesuo.thb.server.service.FileUploadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;


@Slf4j
@Service("fileDownloadService")
public class FileDwonloadServiceImpl implements FileDownloadService {
    @Autowired
    FileMapper fileMapper;


    @Override
    public FileEntity downLoad(String uuid) {
        FileEntity entity=fileMapper.getFileByUUID(uuid);
        if (entity==null){
            throw new FileNotExitException(uuid);
        }
        return  entity;

    }

    @Override
    public FileEntity getMetadataByUUID(String uuid) {
        FileEntity fileByUUID = fileMapper.getFileByUUID(uuid);
        return fileByUUID;
    }
}
