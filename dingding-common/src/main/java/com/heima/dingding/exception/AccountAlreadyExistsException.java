package com.heima.dingding.exception;

public class AccountAlreadyExistsException extends BaseException {
    public  AccountAlreadyExistsException(String message) {
        super(message);
    }

    public AccountAlreadyExistsException() {
    }
}
