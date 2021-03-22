package com.qiyuesuo.thb.server.exception;

public class FileNotExitException extends RuntimeException{
    public FileNotExitException(String uuid){
        super("uuid为"+uuid+"的文件不存在！");
    }
}
