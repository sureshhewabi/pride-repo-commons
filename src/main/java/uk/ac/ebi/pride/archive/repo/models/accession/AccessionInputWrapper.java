package uk.ac.ebi.pride.archive.repo.models.accession;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccessionInputWrapper {
    private String type;
    private int count;
    private String mode;
}
