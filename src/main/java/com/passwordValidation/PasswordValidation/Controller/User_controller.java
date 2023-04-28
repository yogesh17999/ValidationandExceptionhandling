package com.passwordValidation.PasswordValidation.Controller;

import com.passwordValidation.PasswordValidation.Dto.Create_user;
import com.passwordValidation.PasswordValidation.Dto.Updaterequest;
import com.passwordValidation.PasswordValidation.Exception.Usernamenotfoundexception;
import com.passwordValidation.PasswordValidation.Model.User;
import com.passwordValidation.PasswordValidation.Service.User_service;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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
        User user =service.Createuser(request);
        return ResponseEntity.ok("User Sucessfully Registered!");
    }

    @GetMapping("/username/{username}")
    public  ResponseEntity<?> getuser(@PathVariable("username") String username) throws Usernamenotfoundexception {
        System.out.println(username);
          User user=  service.getuserbyusername(username);
          if(user==null)
              throw new Usernamenotfoundexception("Username not found, please enter correct username!!");
          else return  ResponseEntity.ok(user);
    }

    @GetMapping("/alluser")
    public  ResponseEntity getalluser()
    {
        return ResponseEntity.ok(service.getalluser());
    }

    @DeleteMapping("/delete/{username}/{email}")
    public ResponseEntity<?> deleteuser(@PathVariable String username, @PathVariable String email) throws Usernamenotfoundexception {
                 service.deleteuser(username,email);
                  return ResponseEntity.ok("User Successfully deleted!!");


    }
    @PutMapping("/update")
    public  ResponseEntity<?> updateuser(@RequestBody @Valid Updaterequest updaterequest) throws Usernamenotfoundexception
    {
        service.updateuser(updaterequest);
            return  ResponseEntity.ok("User Successfully updated!!");


    }
}
