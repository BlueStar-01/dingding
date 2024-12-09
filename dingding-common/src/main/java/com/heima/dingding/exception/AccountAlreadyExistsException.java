package com.heima.dingding.exception;

public class AccountAlreadyExistsException extends BaseException {
    AccountAlreadyExistsException(String message) {
        super(message);
    }

    AccountAlreadyExistsException() {
    }
}
