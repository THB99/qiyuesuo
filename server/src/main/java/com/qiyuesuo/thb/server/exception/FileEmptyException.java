package com.qiyuesuo.thb.server.exception;

public class FileEmptyException extends RuntimeException{
    public FileEmptyException(){
        super("上传文件不能为空！");
    }
}
