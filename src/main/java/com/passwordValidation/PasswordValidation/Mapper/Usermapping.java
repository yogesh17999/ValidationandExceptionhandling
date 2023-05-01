package com.passwordValidation.PasswordValidation.Mapper;

import com.passwordValidation.PasswordValidation.Dto.Create_user;
import com.passwordValidation.PasswordValidation.Dto.Updaterequest;
import com.passwordValidation.PasswordValidation.Model.User;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface Usermapping {

       @Mapping(source = "user_mobile",target = "contact_no")
       User Create_usertoUser(Create_user request);
       @InheritConfiguration
       Create_user Usertouserdto(User user);
       @Mapping(source = "user_mobile",target = "contact_no")
       User updateusertoUser(Updaterequest request);
       @InheritConfiguration
       List<Create_user> listofusertoDto(List<User> users);

}
