package uk.ac.ebi.pride.archive.repo.models.user;

import lombok.Getter;
import lombok.Setter;
import uk.ac.ebi.pride.archive.dataprovider.utils.TitleConstants;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class UserProfile {
    @NotBlank
    @Email
    private String email;
    private TitleConstants title;
    @NotBlank
    private String firstName;
    private String lastName;
    private String affiliation;
    private String country;
    private String orcid;
    private Boolean acceptedTermsOfUse;
}
