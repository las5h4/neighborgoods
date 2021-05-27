package org.launchcode.neighborgoods.models;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;


@Entity
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
    private int zipcode;

    @NotNull
    @Column
    private String pwHash;

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public User(String username, String email, String address, int zipcode, String password) {
        this.username = username;
        this.address = address;
        this.zipcode = zipcode;
        this.email = email;
        this.pwHash = password;
    }

    public User(String username, String email, String password) {
        super();
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() { return email; }

    public String getAddress() { return address; }

    public int getZipcode() { return zipcode; }

    public boolean isMatchingPassword(String password) { return encoder.matches(password, pwHash); }

}