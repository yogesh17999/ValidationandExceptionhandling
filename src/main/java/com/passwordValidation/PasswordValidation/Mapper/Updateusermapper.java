package com.passwordValidation.PasswordValidation.Mapper;

import com.passwordValidation.PasswordValidation.Dto.Updaterequest;
import com.passwordValidation.PasswordValidation.Model.User;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.control.MappingControl;

@Mapper(componentModel = "spring")
public interface Updateusermapper {

    @Mapping(source = "user_mobile",target = "contact_no")
    User updateusertoUser(Updaterequest request);

    @InheritInverseConfiguration
    Updaterequest todto(User user);


}
