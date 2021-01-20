package com.starsturing.bookservice.constants;

public enum  ResponseCode {

    SUCCESS_CODE(0),
    FAIL_CODE(1);

    Integer code;
    ResponseCode(Integer code){
        this.code = code;
    }

    public Integer getCode(){
        return code;
    }


}
