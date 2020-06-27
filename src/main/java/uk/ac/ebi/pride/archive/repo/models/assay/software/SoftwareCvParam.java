package uk.ac.ebi.pride.archive.repo.models.assay.software;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import uk.ac.ebi.pride.archive.dataprovider.param.CvParamProvider;
import uk.ac.ebi.pride.archive.repo.models.param.CvParam;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * @author Jose A. Dianes
 * @version $Id$
 */
@Entity
@Table(name = "software_cvparam_2")
//@SequenceGenerator(name = "SoftwareParamSequence", sequenceName = "softwareParamSequence", allocationSize = 100)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property="id", scope = SoftwareCvParam.class)
public class SoftwareCvParam implements CvParamProvider {

  @Id
  //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SoftwareParamSequence")
  @Column(name = "param_pk")
  private Long id;

  @NotNull
  @ManyToOne
  @JoinColumn(name = "software_fk")
  private Software software;

  @NotNull
  @ManyToOne(cascade = {CascadeType.MERGE})
  @JoinColumn(name = "cv_param_fk")
  private CvParam cvParam;

  @Column(name = "value")
  private String value;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Software getSoftware() {
    return software;
  }

  public void setSoftware(Software software) {
    this.software = software;
  }

  public CvParam getCvParam() {
    return cvParam;
  }

  public void setCvParam(CvParam cvParam) {
    this.cvParam = cvParam;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  @JsonIgnore
  public String getName() {
    return this.cvParam.getName();
  }

  @JsonIgnore
  public String getCvLabel() {
    return this.cvParam.getCvLabel();
  }

  @JsonIgnore
  public String getAccession() {
    return this.cvParam.getAccession();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof SoftwareCvParam)) return false;

    SoftwareCvParam that = (SoftwareCvParam) o;

    if (cvParam != null ? !cvParam.equals(that.cvParam) : that.cvParam != null) return false;
    return value != null ? value.equals(that.value) : that.value == null;
  }

  @Override
  public int hashCode() {
    int result = cvParam != null ? cvParam.hashCode() : 0;
    result = 31 * result + (value != null ? value.hashCode() : 0);
    return result;
  }
}
