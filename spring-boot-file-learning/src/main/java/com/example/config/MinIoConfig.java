package com.example.config;

import io.minio.*;
import io.minio.errors.*;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/***
 * @description:
 * @author: yk
 **/
@Configuration
public class MinIoConfig {
    @Value("${minio.endPoint}")
    private String  endPoint;

    @Value("${minio.accessKey}")
    private String accessKey;

    @Value("${minio.secretKey}")
    private String secretKey;

    private MinioClient instance;
    @PostConstruct
    public void init(){
        instance = MinioClient.builder()
                .endpoint(endPoint)
                .credentials(accessKey, secretKey)
                .build();
    }

    /**
     判断bucket 是否存在
     @param bucketName bucket 名称
     @return boolean
    */
    public boolean bucketExists(String bucketName) throws Exception {
        return instance.bucketExists(BucketExistsArgs.builder().bucket(bucketName).build());
    }

    /**
        创建 bucket
     @param bucketName bucket 名称
    */
    public void makeBucket(String bucketName) throws Exception {
        boolean flag = bucketExists(bucketName);
        if (!flag){
            instance.makeBucket(MakeBucketArgs.builder().bucket(bucketName).build());
        }
    }

    /**
     文件上传
     @param bucketName 存储桶名称
     @param objectName 文件名称，对象名称
     @param filePath 文件路径
     @return 响应结果
    */
    public ObjectWriteResponse uploadObject(String bucketName,String objectName,String filePath) throws IOException, ServerException, InsufficientDataException, ErrorResponseException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        return instance.uploadObject(UploadObjectArgs.builder().bucket(bucketName).object(objectName).filename(filePath).build());
    }
    /**
     文件上传
     @param bucketName 存储桶名称
     @param objectName 文件名称，对象名称
     @param filePath 文件路径
     @return 响应结果
    */
    public ObjectWriteResponse putObject(String bucketName, String objectName, InputStream inputStream) throws Exception {
        return instance.putObject(PutObjectArgs.builder()
                .bucket(bucketName).object(objectName).stream(inputStream,-1,10485760).build());
    }

    /**
    删除文件

     @param bucketName bucket 名称
     @param objectName 对象名称
    */
    public void removeObject(String bucketName,String objectName) throws Exception{
        instance.removeObject(RemoveObjectArgs.builder().bucket(bucketName).object(objectName).build());
    }
}
