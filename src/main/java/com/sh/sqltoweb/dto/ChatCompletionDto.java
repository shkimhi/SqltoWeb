package com.sh.sqltoweb.dto;

import lombok.*;

import java.util.List;

@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ChatCompletionDto {

    private String model;
    private List<ChatRequestMsgDto> message;

    @Builder
    public ChatCompletionDto(String model, List<ChatRequestMsgDto> message){
        this.model = model;
        this.message = message;
    }

}
