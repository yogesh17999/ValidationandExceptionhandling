package com.passwordValidation.PasswordValidation.Controller;

import com.passwordValidation.PasswordValidation.Dto.ApiMessage;
import com.passwordValidation.PasswordValidation.Dto.Create_user;
import com.passwordValidation.PasswordValidation.Dto.Updaterequest;
import com.passwordValidation.PasswordValidation.Exception.Usernamenotfoundexception;
import com.passwordValidation.PasswordValidation.Model.User;
import com.passwordValidation.PasswordValidation.Service.User_service;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class User_controller {

    @Autowired
    User_service service;
    @PostMapping("/register")
    public ResponseEntity<?> RegisterUser(@RequestBody @Valid Create_user request)
    {
        System.out.println(request.getUsername());
        ApiMessage apiMessage =service.Createuser(request);
        return ResponseEntity.status(apiMessage.getStatuscode()).body(apiMessage);
    }

    @GetMapping("/username/{username}")
    public  ResponseEntity<ApiMessage> getuser(@PathVariable("username") String username) throws Usernamenotfoundexception {
        System.out.println(username);
          ApiMessage apiMessage=  service.getuserbyusername(username);
          return  ResponseEntity.status(apiMessage.getStatuscode()).body(apiMessage);
    }

    @GetMapping("/alluser")
    public  ResponseEntity getalluser()
    {
        return ResponseEntity.ok(service.getalluser());
    }

    @DeleteMapping("/delete/{username}/{email}")
    public ResponseEntity<?> deleteuser(@PathVariable String username, @PathVariable String email) throws Usernamenotfoundexception {
                ApiMessage apiMessage= service.deleteuser(username,email);
                  return ResponseEntity.status(apiMessage.getStatuscode()).body(apiMessage);


    }
    @PutMapping("/update")
    public  ResponseEntity<?> updateuser(@RequestBody @Valid Updaterequest updaterequest) throws Usernamenotfoundexception
    {
        ApiMessage apiMessage=  service.updateuser(updaterequest);
            return ResponseEntity.status(apiMessage.getStatuscode()).body(apiMessage);
    }
}
