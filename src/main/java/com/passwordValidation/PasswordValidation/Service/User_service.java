package com.passwordValidation.PasswordValidation.Service;

import com.passwordValidation.PasswordValidation.Dto.ApiMessage;
import com.passwordValidation.PasswordValidation.Dto.Create_user;
import com.passwordValidation.PasswordValidation.Dto.Updaterequest;
import com.passwordValidation.PasswordValidation.Exception.Usernamenotfoundexception;
import com.passwordValidation.PasswordValidation.Mapper.Updateusermapper;
import com.passwordValidation.PasswordValidation.Mapper.Usermapping;
import com.passwordValidation.PasswordValidation.Model.User;
import com.passwordValidation.PasswordValidation.Repository.User_repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.util.List;

@Service
public class User_service {

    @Autowired
    User_repo repo;
    @Autowired
    Usermapping usermapping;
    @Autowired
    Updateusermapper updateusermapper;


    public ApiMessage  Createuser(Create_user request) {
     //   System.out.println(request.getUser_mobile() + " " +request.getReenter_password());
        //User user = User.build(0, request.getUsername(), request.getEmail(),request.getUser_mobile(), request.getGender(), request.getAge(), request.getPassword(),request.getReenter_password(), request.getUser_type());

        //System.out.println(request.getUsername());
        request.setDate(LocalDate.now());
          User user= repo.save(usermapping.Create_usertoUser(request));
        return new ApiMessage(HttpStatus.CREATED, "user successfully registered!!" , usermapping.Usertouserdto(user));
    }

    public ApiMessage getuserbyusername(String username) throws Usernamenotfoundexception {
        System.out.println(username);
        if (repo.existsByUsername(username)){
            return    new ApiMessage(HttpStatus.OK,  usermapping.Usertouserdto( repo.findByUsername(username)));
        }
        else
        {
            return  new ApiMessage(HttpStatus.BAD_REQUEST,"user not found, please enter correct username!!");
        }
    }

    public ApiMessage deleteuser(String username, String email) throws Usernamenotfoundexception{
        if (repo.existsByUsername(username) && repo.existsByEmail(email)) {
            User user = repo.findByUsername(username);
            repo.delete(user);
            return new ApiMessage(HttpStatus.OK,"User Successfully deleted!!", usermapping.Usertouserdto(user));
        }
        return new ApiMessage(HttpStatus.BAD_REQUEST,"Username not found!!");

    }

    public ApiMessage getalluser() {

        List<User> listofuser=repo.findAll();
        ApiMessage apiMessage= new ApiMessage(HttpStatus.OK,usermapping.listofusertoDto(listofuser));
        return apiMessage;
    }
    public ApiMessage updateuser(Updaterequest request) throws  Usernamenotfoundexception
    {
        if(repo.existsByEmail(request.getEmail())&&repo.existsByUsername(request.getUsername()))
        {
            repo.save(updateusermapper.updateusertoUser(request));
            return new ApiMessage(HttpStatus.OK,"User updated!!");

        }
       return new ApiMessage(HttpStatus.BAD_REQUEST, "User does not exist!!");

    }

}