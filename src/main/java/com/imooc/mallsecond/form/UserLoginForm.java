package com.imooc.mallsecond.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 描述: TODO
 */

@Data
public class UserLoginForm {

    @NotBlank
    private String username;

    @NotBlank
    private String password;

}
