package com.nhnacademy.springmvc.domain;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import lombok.Value;
import org.hibernate.validator.constraints.Length;

@Value
public class UserRegisterRequest {
    String id;

    @Length(min = 8, max = 20)
    String password;

    @Min(0)
    int age;

    // TODO #3: 이름 필드 추가
    @NotBlank
    String name;

}
