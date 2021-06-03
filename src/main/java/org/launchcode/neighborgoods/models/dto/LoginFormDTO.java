package org.launchcode.neighborgoods.models.dto;

import javax.validation.constraints.*;

public class LoginFormDTO {

    @NotNull
    @NotBlank
    @Size(min = 3, max = 30, message = "Invalid username. Must be between 3 and 30 characters.")
    private String username;

    @NotNull
    @NotBlank
    @Size(min = 3, max = 30, message = "Please enter street address.")
    private String address;

    @NotNull
    @NotBlank
    @Size(min=5, max=11, message = "Please enter zipcode.")
    private String zipcode;

    @NotNull
    @NotBlank
    @Size(min = 3, max = 75, message = "Invalid email address.")
    private String email;

    @NotNull
    @NotBlank
    @Size(min = 5, max = 30, message = "Invalid password. Must be between 5 and 30 characters.")
    private String password;

    public LoginFormDTO() { }

    public String getUsername() { return username; }

    public void setUsername(String username) { this.username = username; }

    public String verifyUsername;

    public String getVerifyUsername() { return verifyUsername; }

    public String getAddress() { return address; }

    public void setAddress(String address) { this.address = address; }

    public String getZipcode() { return zipcode; }

    public void setZipcode(String zipcode) { this.zipcode = zipcode; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    private void verifyEmail(String email) { this.email = email; }

    public String getVerifyEmail() { return email; }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private void verifyPassword(String password) { this.password = password; }

    public String getVerifyPassword() { return password; }


}

