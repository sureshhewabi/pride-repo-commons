package uk.ac.ebi.pride.archive.repo.models.project;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * @author Jose A. Dianes
 * @version $Id$
 */
@Entity
@DiscriminatorValue("SAMPLE")
public class ProjectSampleCvParam extends ProjectCvParam {}
