package com.sh.sqltoweb.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileUploadService {

    public void saveFile(MultipartFile file);
}
