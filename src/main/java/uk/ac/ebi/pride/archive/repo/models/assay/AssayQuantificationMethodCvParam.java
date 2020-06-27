package uk.ac.ebi.pride.archive.repo.models.assay;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * @author Jose A. Dianes
 * @version $Id$
 */
@Entity
@DiscriminatorValue("QUANTIFICATION_METHOD")
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property="id", scope= AssayQuantificationMethodCvParam.class)
public class AssayQuantificationMethodCvParam extends AssayCvParam {}
