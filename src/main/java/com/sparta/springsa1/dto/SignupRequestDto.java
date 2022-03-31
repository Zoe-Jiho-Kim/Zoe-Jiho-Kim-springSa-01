package com.sparta.springsa1.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Setter
@Getter
public class SignupRequestDto {
    @NotBlank(message = "필수 정보입니다.")
    @Size(min = 3,max = 10, message = "아이디는 3자 이상 10자 이하로 입력해 주세요!")
    @Pattern(regexp= "^[a-zA-Z0-9]{3,20}$",message = "알파벳 대소문자, 숫자만 입력 가능합니다!")
    private String username;

    @NotBlank(message = "필수 정보입니다.")
    @Pattern(regexp="(?=.*[0-9])(?=.*[a-z]).{5,12}",
            message = "비밀번호는 영문자와 숫자가 적어도 1개 이상 포함된 5자~12자의 비밀번호여야 합니다.")
    private String password;

    @NotBlank(message = "필수 정보입니다.")
    private String passwordCheck;

}
