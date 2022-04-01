package com.consultancy.app.Consultancy.Service.controller;

import lombok.Data;

@Data
public class APIResponse {

    private String status;

    private String errorCode;

    private String message;

    private Object data;
}
