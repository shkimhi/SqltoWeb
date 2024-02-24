package com.sh.sqltoweb.controller;

import com.sh.sqltoweb.dto.DBInfoDto;
import com.sh.sqltoweb.service.DBInfoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/db")
public class DBController {

    private final DBInfoService dbInfoService;

    public DBController(DBInfoService dbInfoService){
        this.dbInfoService = dbInfoService;
    }

    @GetMapping()
    public String dbConnectionTest(){

        return "";
    }

    @GetMapping("info")
    public String dbInfo(@RequestBody DBInfoDto dbInfoDto){
        String result = dbInfoService.dbInfo(dbInfoDto);
        return result;
    }
}
