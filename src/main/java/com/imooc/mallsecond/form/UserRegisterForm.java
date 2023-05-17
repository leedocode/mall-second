package com.imooc.mallsecond.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 描述: TODO
 */

@Data
public class UserRegisterForm {

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    @NotBlank
    private String email;
}
