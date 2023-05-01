package com.passwordValidation.PasswordValidation.Dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class ApiMessage {
    private HttpStatus statuscode;
    private  String Message;
    private  Object Data;
  //  private List<Object> listofdata;

    public ApiMessage() {
    }

    public ApiMessage(HttpStatus status, String message, Object data) {
        this.statuscode = status;
        Message = message;
        Data = data;
    }

//    public ApiMessage(HttpStatus statuscode, List<Object> listofdata) {
//        this.statuscode = statuscode;
//        this.listofdata = listofdata;
//    }

    public ApiMessage(HttpStatus statuscode, String message) {
        this.statuscode = statuscode;
        Message = message;
    }
    public ApiMessage(HttpStatus statuscode, Object data) {
        this.statuscode = statuscode;
        this.Data=data;
    }



}
