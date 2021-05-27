package org.launchcode.neighborgoods.models.dto;

public class RegisterFormDTO extends LoginFormDTO {

    private String verifyPassword;

    public String getVerifyPassword() { return verifyPassword; }

    private String verifyEmail;

    public String getVerifyEmail() { return verifyEmail; }

}