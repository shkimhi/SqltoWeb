package com.sh.sqltoweb.controller;


import com.sh.sqltoweb.dto.ChatCompletionDto;
import com.sh.sqltoweb.dto.ChatRequestMsgDto;
import com.sh.sqltoweb.service.ChatGPTServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping(value = "/api/v1/chatGpt")
public class ChatGPTController {

    private final ChatGPTServiceImpl chatGPTService;

    public ChatGPTController(ChatGPTServiceImpl chatGPTService) {
        this.chatGPTService = chatGPTService;
    }

    /**
     * [API] ChatGPT 모델 리스트를 조회합니다.
     */
    @GetMapping("/modelList")
    public ResponseEntity<List<Map<String, Object>>> selectModelList() {
        List<Map<String, Object>> result = chatGPTService.modelList();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * [API] ChatGPT 유효한 모델인지 조회합니다.
     *
     * @param modelName
     * @return
     */
    @GetMapping("/model")
    public ResponseEntity<Map<String, Object>> isValidModel(@RequestParam(name = "modelName") String modelName) {
        Map<String, Object> result = chatGPTService.isValidModel(modelName);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    /**
     * [API] 최신 ChatGPT 프롬프트 명령어를 수행합니다. : gpt-4, gpt-4 turbo, gpt-3.5-turbo
     *
     * @param userQuery
     * @return
     */
    @PostMapping("/prompt")
    public ResponseEntity<Map<String, Object>> selectPrompt(@RequestBody String userQuery) {
        log.debug("param :: " + userQuery);

        Map<String, Object> result = chatGPTService.prompt(userQuery);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }


}
