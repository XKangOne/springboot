package com.example.controller;

import io.minio.BucketExistsArgs;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import io.minio.errors.*;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/***
 * @description: 文件上传
 * @author: yk
 **/
@RestController
public class FileUploadController {

    //如果想要动态读取配置文件中的某个系统属性，可以使用@Value注解。
    //单独注入
    @Value("${web.upload-path}")
    private String uploadPath;

    //创建日期的格式
    DateFormat df = new SimpleDateFormat("yyyyMMdd");
    @PostMapping("/upload")
    public String upload(MultipartFile file, HttpServletRequest request) throws IOException {
        //创建子目录,实现了在uploadPath 目录中通过日期对上传文件归类保存
        String format = df.format(new Date());
        File folder = new File(uploadPath + format);
        if (!folder.isDirectory()){
            //创建文件夹
            folder.mkdirs();
        }
        //对上传文件重命名,避免冲突
         String oldName = file.getOriginalFilename();
         String newName = null;
         //原始文件名字不为空
        if (oldName !=null){
            newName = UUID.randomUUID() + oldName.substring(oldName.lastIndexOf("."), oldName.length());
        }

        //上传：文件复制搬运
        file.transferTo(new File(folder,newName));

        //拼接返回上传后的访问路径
        //http://localhost:8080/20230410/443kaikds.jpg

        return  request.getScheme() + "://"
                +request.getServerName()+":"+request.getServerPort()+"/" + format+"/"+newName;
    }
}
