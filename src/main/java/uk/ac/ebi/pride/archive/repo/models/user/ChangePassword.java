package uk.ac.ebi.pride.archive.repo.models.user;

import lombok.Data;

@Data
public class ChangePassword {
    private String email;
    private String oldPassword;
    private String newPassword;
    private String confirmedNewPassword;
}
