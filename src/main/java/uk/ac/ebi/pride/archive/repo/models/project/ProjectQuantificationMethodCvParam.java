package uk.ac.ebi.pride.archive.repo.models.project;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("QUANTIFICATION_METHOD")
public class ProjectQuantificationMethodCvParam extends ProjectCvParam {}
