package com.gaounuri.authsessionserver.constant.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum ErrorCode {

    USER_ALREADY_EXIST(HttpStatus.BAD_REQUEST, "이미 해당 정보의 유저가 존재합니다."),
    //404
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "해당하는 유저의 정보를 찾을 수 없습니다."),
    TODO_NOT_FOUND(HttpStatus.NOT_FOUND, "TODO 데이터를 찾을 수 없습니다.");
    private final HttpStatus httpStatus;
    private final String message;
}
