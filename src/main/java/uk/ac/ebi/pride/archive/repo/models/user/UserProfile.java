package uk.ac.ebi.pride.archive.repo.models.user;

import lombok.Getter;
import lombok.Setter;
import uk.ac.ebi.pride.archive.dataprovider.utils.TitleConstants;

@Getter
@Setter
public class UserProfile {
    private String email;
    private TitleConstants title;
    private String firstName;
    private String lastName;
    private String affiliation;
    private String country;
    private String orcid;
    private Boolean acceptedTermsOfUse;
}
