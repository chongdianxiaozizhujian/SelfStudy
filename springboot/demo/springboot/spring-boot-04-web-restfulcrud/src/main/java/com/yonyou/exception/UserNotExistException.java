package com.yonyou.exception;

/**
 * Created by Administrator on 2018/6/23.
 */
public class UserNotExistException extends RuntimeException{
    public UserNotExistException() {
        super("用户不存在");
    }
}
