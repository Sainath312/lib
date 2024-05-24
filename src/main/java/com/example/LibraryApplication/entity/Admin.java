package com.example.LibraryApplication.entity;


import com.example.LibraryApplication.constants.StringConstants;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;

    @Column(unique = true)
    @NotBlank(message = StringConstants.UserName)
    private String userName;

    @NotBlank(message = StringConstants.ValidPassword)
    public String password;

    @NotEmpty(message = StringConstants.MailRequired)
    @Email(message = StringConstants.ValidMail)
    public String email;

    public String roles="ROLE_ADMIN";
    public String mobileNumber;


    public Admin(String userName, String email, String mobileNumber, String password) {
        this.userName = userName;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.password = password;
    }

}
