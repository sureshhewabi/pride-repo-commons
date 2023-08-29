package uk.ac.ebi.pride.archive.repo.models.param;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import uk.ac.ebi.pride.archive.dataprovider.param.CvParamProvider;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * @author Jose A. Dianes
 * @version $Id$
 */
@Entity
@Table(name = "cv_param", uniqueConstraints={@UniqueConstraint(columnNames = {"cv_label", "accession"})})
@SequenceGenerator(name = "ParamSequence", sequenceName = "paramSequence", allocationSize = 100)
@JsonTypeInfo(use=JsonTypeInfo.Id.CLASS, property="@class")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property="id", scope= CvParam.class)
public class CvParam implements CvParamProvider {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ParamSequence")
  @Column(name = "cv_param_pk")
  private Long id;

  @NotNull
  @Column(name = "cv_label")
  private String cvLabel;

  @NotNull
  @Column(name = "accession", unique = true)
  private String accession;

  @NotNull
  @Column(name = "name")
  private String name;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getCvLabel() {
    return cvLabel;
  }

  public void setCvLabel(String cvLabel) {
    this.cvLabel = cvLabel;
  }

  public String getAccession() {
    return accession;
  }

  public void setAccession(String accession) {
    this.accession = accession;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @JsonIgnore
  public String getValue() {
    return null;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof CvParam)) return false;

    CvParam cvParam = (CvParam) o;

    if (accession != null ? !accession.equals(cvParam.accession) : cvParam.accession != null)
      return false;
    if (cvLabel != null ? !cvLabel.equals(cvParam.cvLabel) : cvParam.cvLabel != null) return false;
    return name != null ? name.equals(cvParam.name) : cvParam.name == null;
  }

  @Override
  public int hashCode() {
    int result = cvLabel != null ? cvLabel.hashCode() : 0;
    result = 31 * result + (accession != null ? accession.hashCode() : 0);
    result = 31 * result + (name != null ? name.hashCode() : 0);
    return result;
  }
}
