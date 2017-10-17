package com.wolf.liuxue.http;

/**
 * Created by nanchaodong on 2017/5/8.
 */

public class ApiException extends RuntimeException {
    private String msg;
    public ApiException(int errorCode) {

    }

    public ApiException(String msg) {


    }

}
