package com.example.LibraryApplication.model;

import com.example.LibraryApplication.constants.StringConstants;
import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor(staticName = "build")
@Data
public class NewProfile {

    @NotEmpty(message = StringConstants.UserName)
    public String userName;

    @NotBlank(message = StringConstants.MailRequired)
    @Email(message = StringConstants.ValidMail)
    public String email;


    @NotBlank(message = StringConstants.MobileNumberRequired)
    @Pattern(regexp = "^[7-9]\\d{9}$", message = StringConstants.ValidMobileNumber)
    public String mobileNumber;

    @Column
    @NotBlank(message = StringConstants.ValidPassword)
    @Size(min = 8, message =StringConstants.PasswordLength)
    @Pattern.List({
            @Pattern(regexp = ".*[A-Z].*", message =StringConstants.UpperCase),
            @Pattern(regexp = ".*[a-z].*", message = StringConstants.LowerCase),
            @Pattern(regexp = ".*\\d.*", message = StringConstants.Numeric),
            @Pattern(regexp = ".*[@#$%^&+=].*", message =StringConstants.SpecialCharacter) })
    public String password;


}