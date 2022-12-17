package com.apiboot.ule.service;

import io.swagger.models.auth.In;
import org.springframework.stereotype.Service;

@Service
public class LogService {
    public String getUserName(String userId) {
        return "bruce" + userId;
    }

    public String getUserList(String uerId) {
        return uerId;
    }

    public Integer getScore(Integer score){
        return score;
    }
}