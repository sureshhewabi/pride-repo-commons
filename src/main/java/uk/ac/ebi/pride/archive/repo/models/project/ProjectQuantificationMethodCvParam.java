package uk.ac.ebi.pride.archive.repo.models.project;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("QUANTIFICATION_METHOD")
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property="id", scope=ProjectQuantificationMethodCvParam.class)
public class ProjectQuantificationMethodCvParam extends ProjectCvParam {}
