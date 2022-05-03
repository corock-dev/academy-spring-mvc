package com.nhnacademy.springmvc.controller;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

// 몇 개는 REST API 랑 뭐랑 같이 나가야 하면 를 쓰고
// @RestController == @Controller + @ResponseBody
// @Controller
// @ResponseBody

// 전체 다(?) REST API 를 쓸 때
@RestController
public class UserRestController {
    // public String htmlRendering() {
    //     // ...
    // }
    //
    // @ResponseBody
    // public User json() {
    //
    // }
}
