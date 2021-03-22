package com.qiyuesuo.thb.server.service;

import com.qiyuesuo.thb.server.entity.FileEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public interface FileDownloadService {

    FileEntity downLoad(String uuid);

    FileEntity getMetadataByUUID(String uuid);
}
