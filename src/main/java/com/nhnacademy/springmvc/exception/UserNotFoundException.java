package com.nhnacademy.springmvc.exception;

// 왜 extends RuntimeException? checked exception 은 메서드 시그니처에 반영된다
public class UserNotFoundException extends RuntimeException {
}
