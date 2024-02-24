package com.sh.sqltoweb.service;


import com.sh.sqltoweb.dto.ChatCompletionDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface ChatGPTService {
    List<Map<String,Object>> modelList();
    Map<String,Object> isValidModel(String modelName);
    Map<String, Object> prompt(String userQuery);

}
