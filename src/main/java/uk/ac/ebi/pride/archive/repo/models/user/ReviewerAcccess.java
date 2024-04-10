package uk.ac.ebi.pride.archive.repo.models.user;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class ReviewerAcccess {
    @NotBlank
    private String accession;
    @NotBlank
    private String reference;
    @NotBlank
    private String token;
}