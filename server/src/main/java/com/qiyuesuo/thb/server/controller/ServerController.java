package com.qiyuesuo.thb.server.controller;

import com.qiyuesuo.thb.server.entity.FileEntity;
import com.qiyuesuo.thb.server.exception.FileEmptyException;
import com.qiyuesuo.thb.server.exception.FileNameException;
import com.qiyuesuo.thb.server.service.FileDownloadService;
import com.qiyuesuo.thb.server.service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

@Controller
public class ServerController {

    @Autowired
    FileUploadService fileUploadService;

    @Autowired
    FileDownloadService fileDownloadService;

    /*
    1. 上传文件接口：
     */
    @PostMapping("/upLoad")
    public String upLoad(MultipartFile file, RedirectAttributes redirectAttributes) throws IOException {
        try {
            String uuid=fileUploadService.upLoad(file);
            redirectAttributes.addFlashAttribute("msg",uuid);
        }catch (Exception e){
            if (e instanceof FileNameException){
                redirectAttributes.addFlashAttribute("msg",e.getMessage());
            }else if (e instanceof FileEmptyException){
                redirectAttributes.addFlashAttribute("msg",e.getMessage());
            }
            return "redirect:/";
        }
        return "redirect:/";
    }

    /*
    2. 下载文件接口：
     */
    @GetMapping("/downLoad")
    public void downLoad(@RequestParam("uuid")String uuid, HttpServletResponse response, HttpServletRequest request) throws IOException {
        FileInputStream inputStream=null;
        ServletOutputStream outputStream=null;
        try {
            FileEntity entity = fileDownloadService.downLoad(uuid);
            inputStream = new FileInputStream(entity.getAddress());
            //中文编码
            String newName = URLEncoder.encode(entity.getOriginalname(), "UTF-8");
            response.addHeader("content-disposition", "attachment;filename=" + newName);// 设置文件名
            response.setContentType("text/html;charset=UTF-8");

            //将输入流的数据写入输出流中
            outputStream= response.getOutputStream();
            byte[] buff = new byte[1024 * 8];
            int len=0;
            while ((len=inputStream.read(buff))!=-1){
                outputStream.write(buff,0,len);
            }
        }catch (Exception e){
            response.setStatus(410);
        }finally {
            if (inputStream!=null){
                inputStream.close();
            }
            if (outputStream!=null){
                outputStream.close();
            }
        }
    }

    /*
    3. 获取文件元数据接口：
     */
    @ResponseBody
    @GetMapping("/getMetadata")
    public FileEntity getMetadata(@RequestParam("uuid")String uuid){
        FileEntity fileEntity=fileDownloadService.getMetadataByUUID(uuid);
        return fileEntity;
    }

    @GetMapping("/")
    public String index(){
        return "index";
    }
}
