package uk.ac.ebi.pride.archive.repo.models.project;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * @author Jose A. Dianes
 * @version $Id$
 */
@Entity
@DiscriminatorValue("PROJECT")
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property="id", scope=ProjectGroupCvParam.class)
public class ProjectGroupCvParam extends ProjectCvParam {}
