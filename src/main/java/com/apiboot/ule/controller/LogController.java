package com.apiboot.ule.controller;

import com.apiboot.ule.service.LogService;
import org.minbox.framework.grace.expression.annotation.GraceRecorder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/log")
public class LogController {
    @Autowired
    private LogService logService;

    @GetMapping(path = "/index")
    @GraceRecorder(success = "用户：{#name}，编号：{#userId} 访问了首页.", category = "example")
    public String index(String name, String userId) {
        name = logService.getUserName(userId);
        logService.getUserList(userId);
        return "Hello, " + name;
    }

    @GetMapping(path = "/grade")
    @GraceRecorder(success = "目前的分数是 ==> {#score} | 成绩 score <60分 是不及格，60 <= score < 80 良好，80 <= score <= 100是优秀",category = "example")
    public String grade(Integer score) {
        score = logService.getScore(score);
        if (score >= 0 && score < 60) {
            return "不及格";
        } else if (score >= 60 && score < 80) {
            return "良好";
        } else if (score >= 80 && score <= 100) {
            return "优秀";
        } else {
            return "分数不在0-100范围内";
        }
    }
}