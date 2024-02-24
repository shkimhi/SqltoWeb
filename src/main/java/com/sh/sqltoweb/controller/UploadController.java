package com.sh.sqltoweb.controller;

import com.sh.sqltoweb.service.FileUploadServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1/file")
public class UploadController {

    private final FileUploadServiceImpl fileUploadService;

    public UploadController(FileUploadServiceImpl fileUploadService) {
        this.fileUploadService = fileUploadService;
    }

    /**
     * [API] sql 파일을 업로드 받아 DB에 스키마 및 데이터를 생성합니다.
     *
     * @param file
     * @return
     */
    @PostMapping("/upload")
    public ResponseEntity<Void> uploadSqlFile(@RequestParam("file")MultipartFile file){
        fileUploadService.saveFile(file);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
