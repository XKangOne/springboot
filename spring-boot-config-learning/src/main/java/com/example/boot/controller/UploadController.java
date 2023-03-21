package com.example.boot.controller;

import com.example.boot.service.UploadService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/***
 * @description: UploadController 上传文件的接口
 * @author: yk
 **/
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UploadController {
    private final UploadService uploadService;
    @PostMapping("/upload")
    public String uploadFile(MultipartFile file){
        return uploadService.ossUpload(file);
    }
}
