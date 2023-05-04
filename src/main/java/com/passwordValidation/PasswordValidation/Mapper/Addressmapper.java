package com.passwordValidation.PasswordValidation.Mapper;



import com.passwordValidation.PasswordValidation.Dto.addressdto;
import com.passwordValidation.PasswordValidation.Model.Address;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface Addressmapper {

@Mapping(source ="type" ,target = "address_type")
    addressdto addresstoaddressdto(Address address);

@InheritInverseConfiguration
    Address dtotoaddress(addressdto dto);
}
