package com.nhnacademy.springmvc.domain;

import lombok.Data;

// [Refactor] - [Delombok] - [@Value]
// @Value
// @Data 기본 생성자랑 Setter 를 제공해준다.
@Data
public class UserRegisterRequest {
    String id;
    String password;
    int age;

    String name;

}
