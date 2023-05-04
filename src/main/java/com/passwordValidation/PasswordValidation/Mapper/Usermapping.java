package com.passwordValidation.PasswordValidation.Mapper;

import com.passwordValidation.PasswordValidation.Dto.Create_user;
import com.passwordValidation.PasswordValidation.Dto.Updaterequest;
import com.passwordValidation.PasswordValidation.Model.User;
import jakarta.validation.constraints.Max;

import jakarta.validation.groups.Default;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring",uses = Addressmapper.class)
public interface Usermapping {

       @BeforeMapping
       default void validate(Create_user request)
       {
              if(request.getUser_type()== null || request.getUser_type() == "")
                     request.setUser_type("customere");
       }

       @Mapping(source = "user_mobile",target = "contact_no")
       @Mapping(source = "statusofuser", target = "statusofuser", qualifiedByName = "statusmappingtoentity")
       User Create_usertoUser(Create_user request);
       @InheritInverseConfiguration
       @Mapping(source = "statusofuser", target = "statusofuser", qualifiedByName = "statusmappingtodto")
       Create_user Usertouserdto(User user);

       List<Create_user> listofusertoDto(List<User> users);


       @Named("statusmappingtodto")
       default boolean  statusmappingtodto(String status)
       {
              boolean flag;
              if(status.equals("active"))
                     flag=true;
              else flag= false;
              return flag;
       }
       @Named("statusmappingtoentity")
       default String  statusmappingtoentity(boolean status)
       {String current_status;


        if(status == true)
               current_status="active";
        else
               current_status="Inactive";
        return current_status;

       }

}
