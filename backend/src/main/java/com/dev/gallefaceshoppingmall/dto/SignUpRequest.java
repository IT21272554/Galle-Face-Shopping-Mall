package com.dev.gallefaceshoppingmall.dto;

import lombok.Data;

@Data

public class SignUpRequest {

    private String firstName;

    private String lastName;

    private String email;

    private String passoword;

    public CharSequence getPassword() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPassword'");
    }
}
