package com.sh.sqltoweb.dto;

import lombok.*;

import java.util.List;

@Data
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ChatCompletionDto {

    private String model;
    private List<ChatRequestMsgDto> messages;

    @Builder
    public ChatCompletionDto(String model, List<ChatRequestMsgDto> messages){
        this.model = model;
        this.messages = messages;
    }

}
