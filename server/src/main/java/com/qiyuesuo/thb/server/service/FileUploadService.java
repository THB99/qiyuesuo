package com.qiyuesuo.thb.server.service;

import com.qiyuesuo.thb.server.entity.FileEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface FileUploadService {
    String upLoad(MultipartFile file) throws IOException;

}
