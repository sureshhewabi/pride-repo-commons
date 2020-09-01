package uk.ac.ebi.pride.archive.repo.models.accession;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class AccessionInputWrapper {
    private String type;
    private int count;
    private String mode;

    public AccessionInputWrapper() {
    }

    public AccessionInputWrapper(String type, int count, String mode) {
        this.type = type;
        this.count = count;
        this.mode = mode;
    }
}
