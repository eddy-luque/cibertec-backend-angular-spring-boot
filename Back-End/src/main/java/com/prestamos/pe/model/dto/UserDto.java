package com.prestamos.pe.model.dto;


import com.prestamos.pe.config.UserMapper;
import com.prestamos.pe.security.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Integer id;
    private String firstname;
    private String lastname;

    public static List<UserDto> getUserDtoList(List<User> list) {
        return UserMapper.INSTANCE.convierteListEntityToDto( list );
    }

}
