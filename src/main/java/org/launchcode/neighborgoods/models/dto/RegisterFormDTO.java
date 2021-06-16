package org.launchcode.neighborgoods.models.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class RegisterFormDTO extends LoginFormDTO {

    @NotNull
    @NotBlank
    @Size(min = 3, max = 30, message = "Please enter street address.")
    private String address;

    @NotNull
    @NotBlank
    @Size(min=5, max=11, message = "Please enter zipcode.")
    private String zipcode;

    public String getAddress() { return address; }

    public void setAddress(String address) { this.address = address; }

    public String getZipcode() { return zipcode; }

    public void setZipcode(String zipcode) { this.zipcode = zipcode; }

    private String verifyPassword;

    public String getVerifyPassword() {
        return verifyPassword;
    }

    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
    }
}
