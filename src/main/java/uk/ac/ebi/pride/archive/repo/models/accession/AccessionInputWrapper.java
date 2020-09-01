package uk.ac.ebi.pride.archive.repo.models.accession;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AccessionInputWrapper {
    private String type;
    private int count;
    private String mode;
}
