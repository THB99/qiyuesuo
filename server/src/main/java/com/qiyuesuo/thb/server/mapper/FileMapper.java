package com.qiyuesuo.thb.server.mapper;

import com.qiyuesuo.thb.server.entity.FileEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface FileMapper {
    public List<FileEntity> queryFileList();

    void saveFile(FileEntity fileEntity);

    FileEntity getFileByUUID(@Param("uuid") String uuid);
}
