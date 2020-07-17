package uk.ac.ebi.pride.archive.repo.models.user;

import lombok.Data;

@Data
public class ResetPassword {
    private String username;
    private String password;
    private String reference;
    private String pin;
}