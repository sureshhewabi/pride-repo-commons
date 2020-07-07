package uk.ac.ebi.pride.archive.repo.models.user;

import lombok.Data;

@Data
public class Credentials {
    private String username;
    private String password;
}
