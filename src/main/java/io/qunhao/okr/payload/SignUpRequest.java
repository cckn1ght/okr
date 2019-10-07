package io.qunhao.okr.payload;

import lombok.Data;

import javax.validation.constraints.*;

@Data
public class SignUpRequest {
    @NotBlank
    private String name;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String password;

}

