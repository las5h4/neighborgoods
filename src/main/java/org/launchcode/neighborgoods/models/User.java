package org.launchcode.neighborgoods.models;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="user")
public class User extends AbstractEntity {

    @NotNull
    @Column(name = "username", unique = true)
    private String username;

    @NotNull
    @Column(name = "email", unique = true)
    private String email;

    @NotNull
    @Column(name = "address")
    private String address;

    @NotNull
    @Column(name = "zipcode")
    private String zipcode;

    @NotNull
    @Column
    private String pwHash;

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public User() {}

    public User(String username, String email, String address, String zipcode, String password) {
        this.username = username;
        this.address = address;
        this.zipcode = zipcode;
        this.email = email;
        this.pwHash = password;
    }

    public String getUsername() {
        return username;
    }

    public String getAddress() { return address; }

    public String getEmail() { return email; }

    public String getZipcode() { return zipcode; }

    public boolean isMatchingPassword(String password) { return encoder.matches(password, pwHash); }

}