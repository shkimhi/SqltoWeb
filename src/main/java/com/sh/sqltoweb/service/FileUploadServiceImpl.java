package com.sh.sqltoweb.service;

import com.sh.sqltoweb.auth.PrincipalDetails;
import com.sh.sqltoweb.dto.User;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@Service
public class FileUploadServiceImpl implements FileUploadService{

    private final JdbcTemplate jdbcTemplate;


    public FileUploadServiceImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void saveFile(MultipartFile file) {
        try{
            User user = null;
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            if (authentication != null && authentication.getPrincipal() != null) {
                PrincipalDetails principalDetails = (PrincipalDetails) authentication.getPrincipal();
                user = principalDetails.getUser();
            }

            if(createSchema(user.getUsername())) {
                File sqlFile = File.createTempFile("temp",".sql");
                file.transferTo(sqlFile);
                executeSQL(sqlFile,user.getUsername());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void executeSQL(File file, String userId) {
        try {
            List<String> lines = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);
            lines.removeIf(line -> line.startsWith("--") || line.startsWith("/*"));
            String sqlScript = String.join("\n", lines);

            jdbcTemplate.execute("USE " + userId);
            jdbcTemplate.execute(sqlScript);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean createSchema(String userId){
        try {
            jdbcTemplate.execute("CREATE SCHEMA IF NOT EXISTS " + userId);
            return true;
        }catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }


}
