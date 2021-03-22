package com.qiyuesuo.thb.server.exception;

public class FileNameException extends RuntimeException{
    public FileNameException(String filename){
        super(filename+" 文件名错误！");
    }
}
