package cn.ahpu.springmvc.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

public class baseController {
    @ExceptionHandler
    public String ex(HttpServletRequest req,Exception e){
        req.setAttribute("ex",e);
        return "error";
    }
}
