package com.example.boot.service;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.example.boot.config.OssConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

/***
 * @description:文件上传到阿里云 OSS
 * @author: yk
 * @param: file 待上传的文件
 * @return: 上传后的路径
 **/
@Service
public class UploadService {
    @Autowired
    private OssConfig ossConfig;
    public String ossUpload(MultipartFile file){
        String endpoint = ossConfig.getEndpoint();
        String accessKeyId = ossConfig.getAk();
        String accessKeySecret = ossConfig.getSecret();
        String bucket = ossConfig.getBucket();
        String dir = ossConfig.getDir();
        String host = ossConfig.getHost();

        //创建OSSClient实例
        OSS ossClient = new OSSClientBuilder().build(endpoint,accessKeyId,accessKeySecret);
        //上传后文件的服务器路径
        String uploadPath = dir + file.getOriginalFilename();
        //获得上传文件的字节输入流
        InputStream inputStream = null;
        try {
            inputStream = file.getInputStream();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //调用SDK上传对象到指定的bucket的指定路径
        ossClient.putObject(bucket,uploadPath,inputStream);
        //关闭OSSClient
        ossClient.shutdown();
        //返回完整上传后的url
        return host + uploadPath;
    }
}
