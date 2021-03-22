package com.qiyuesuo.thb.server.entity;

import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.geom.PathIterator;
import java.io.Serializable;
import java.util.Date;

@Data
public class FileEntity implements Serializable {
    //自增id
    public Long id;
    //文件大小
    public Long size;
    //文件类型
    public String type;
    //原始文件名
    public String originalname;
    //创建时间
    public Date createtime;
    //文件保存目录地址
    public String address;

    public String uuid;
}
