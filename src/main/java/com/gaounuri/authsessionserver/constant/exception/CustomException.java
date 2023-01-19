package com.gaounuri.authsessionserver.constant.exception;

import com.gaounuri.authsessionserver.constant.enums.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CustomException extends RuntimeException {
    ErrorCode errorCode;
}
