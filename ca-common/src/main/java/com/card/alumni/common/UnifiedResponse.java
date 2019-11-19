package com.card.alumni.common;


import com.card.alumni.exception.ResultCodeInterface;

import java.util.HashMap;
import java.util.Map;

/**
 * 统一响应体
 *
 * @author liumingyu
 * @date 2019-11-19 10:32 PM
 */
public class UnifiedResponse {

    private int status;

    private String message;

    private Object data;

    public UnifiedResponse() {
        this.status = ResultCodeInterface.SUCCESS_CODE;
        this.message = ResultCodeInterface.SUCCESS_MSG;
    }

    public UnifiedResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public UnifiedResponse(Object data) {
        this.status = ResultCodeInterface.SUCCESS_CODE;
        this.message = ResultCodeInterface.SUCCESS_MSG;

        if (data instanceof Long) {
            Map<String, Object> attachment = new HashMap<>();
            attachment.put("id", data);
            this.data = attachment;
        } else {
            this.data = data;
        }
    }

    public UnifiedResponse(ResultCodeInterface resultCodeInterface) {
        this.status = resultCodeInterface.getCode();
        this.message = resultCodeInterface.getMsg();
    }

    public UnifiedResponse(int status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
