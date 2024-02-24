package com.sh.sqltoweb.dto;


import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DBInfoDto {
    private String connString;
    private String dbName;

    @Builder
    public DBInfoDto(String connString, String dbName){
        this.connString = connString;
        this.dbName = dbName;
    }
}
