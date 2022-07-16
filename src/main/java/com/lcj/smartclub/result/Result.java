package com.lcj.smartclub.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result implements Serializable {
    private int code;
    private String message;
    private Object data;

    public static Result success(){
        return new Result(ResultEnum.SUCCESS.getCode(),ResultEnum.SUCCESS.getMessage(),null);
    }

    public static Result success(Object data){
        return new Result(ResultEnum.SUCCESS.getCode(),ResultEnum.SUCCESS.getMessage(),data);
    }

    public static Result fail(){
        return new Result(ResultEnum.ERROR.getCode(), ResultEnum.ERROR.getMessage(), null);
    }

    public static Result fail(String message){
        return new Result(ResultEnum.ERROR.getCode(), message, null);
    }
}
