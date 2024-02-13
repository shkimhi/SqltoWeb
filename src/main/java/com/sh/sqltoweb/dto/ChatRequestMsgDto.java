package com.sh.sqltoweb.dto;


import lombok.*;

@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ChatRequestMsgDto {

    private String role;
    private String content;

    @Builder
    public ChatRequestMsgDto(String role, String content){
        this.role = role;
        this.content = content;
    }
}
