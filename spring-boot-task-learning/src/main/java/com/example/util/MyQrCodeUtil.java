package com.example.util;

import cn.hutool.core.io.FileUtil;
import cn.hutool.extra.qrcode.QrCodeUtil;
import java.io.*;

/***
 * @description: 二维码工具类
 * @author: yk
 **/
public class MyQrCodeUtil {
    public static void createQrCode(String content,String output) {
        if (FileUtil.exist(output)){
            FileUtil.del(output);
        }
        QrCodeUtil.generate(content,300,300,FileUtil.file(output));
    }
}

