package uk.ac.ebi.pride.archive.repo.models.user;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class ResetPassword {
    @NotBlank
    @Email
    private String username;
    @NotBlank
    private String password;
    @NotBlank
    private String reference;
    @NotBlank
    private String pin;
}