package com.passwordValidation.PasswordValidation.Service;

import com.passwordValidation.PasswordValidation.Dto.Create_user;
import com.passwordValidation.PasswordValidation.Dto.Updaterequest;
import com.passwordValidation.PasswordValidation.Exception.Usernamenotfoundexception;
import com.passwordValidation.PasswordValidation.Model.User;
import com.passwordValidation.PasswordValidation.Repository.User_repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class User_service {

    @Autowired
    User_repo repo;


    public User Createuser(Create_user request) {
        System.out.println(request.getUser_mobile() + " " +request.getReenter_password());
        User user = User.build(0, request.getUsername(), request.getEmail(),request.getUser_mobile(), request.getGender(), request.getAge(), request.getPassword(),request.getReenter_password(), request.getUser_type());

        System.out.println(request.getUsername());
        repo.save(user);
        return user;
    }

    public User getuserbyusername(String username) throws Usernamenotfoundexception {
        System.out.println(username);
        if (repo.existsByUsername(username)){
            return repo.findByUsername(username);
        }
        else
        {
            throw  new Usernamenotfoundexception("Username does not exist!!");

        }
    }

    public boolean deleteuser(String username, String email) throws Usernamenotfoundexception{
        if (repo.existsByUsername(username) && repo.existsByEmail(email)) {
            User user = repo.findByUsername(username);
            repo.delete(user);
            return true;
        }
        else throw new Usernamenotfoundexception("Please enter valid username, given username does not exist!!");
    }

    public List<User> getalluser() {

        return repo.findAll();
    }
    public boolean updateuser(Updaterequest request) throws  Usernamenotfoundexception
    {
        if(repo.existsByEmail(request.getEmail())&&repo.existsByUsername(request.getUsername()))
        {
            User user= repo.findByUsername(request.getUsername());
            user.setUser_mobile(request.getUser_mobile());
            user.setUser_type(request.getUser_type());
            user.setAge(request.getAge());
            user.setGender(request.getGender());
            user.setEmail(request.getEmail());
            user.setPassword(request.getPassword());
            user.setReenter_password(request.getReenter_password()) ;
            repo.save(user);
            return true;

        }
       else throw new Usernamenotfoundexception("Given usernamedoes not exist!!");

    }

}