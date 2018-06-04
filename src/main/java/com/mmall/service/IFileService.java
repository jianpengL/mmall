package com.mmall.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by liujianp on 2018/1/29.
 */
public interface IFileService {
    String upload(MultipartFile file, String path);
}
