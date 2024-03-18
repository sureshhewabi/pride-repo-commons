package uk.ac.ebi.pride.archive.repo.models.user;

import com.fasterxml.jackson.annotation.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import uk.ac.ebi.pride.archive.dataprovider.utils.TitleConstants;
import uk.ac.ebi.pride.archive.repo.models.project.Project;
import uk.ac.ebi.pride.archive.repo.util.PasswordUtilities;
import uk.ac.ebi.pride.archive.repo.util.AuthorityConstants;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "pride_users")
@SequenceGenerator(name = "UserSequence", sequenceName = "prideUserSequence", allocationSize = 100)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property="id", scope = User.class)
public class User implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "UserSequence")
  @Column(name = "user_pk")
  private Long id;

  @NotNull
  private String password;

  @NotNull
  @Enumerated(EnumType.STRING)
  @Column(name = "title")
  private TitleConstants title;

  @NotNull
  @Column(name = "first_name")
  private String firstName;

  @NotNull
  @Column(name = "last_name")
  private String lastName;

  @NotNull
  private String affiliation;

  @Column(name = "USER_AAP_REF")
  private String userRef;

  @NotNull
  @Column(unique = true)
  private String email;

  @NotNull
  @Column(name = "creation_date")
  private Date createAt;

  @NotNull
  @Column(name = "update_date")
  private Date updateAt;

  @Column(name = "country")
  private String country;

  @Column(name = "orcid")
  private String orcid;

  @Column(name = "accepted_terms")
  private Integer acceptedTermsOfUse;

  @Column(name = "accepted_terms_date")
  private Date acceptedTermsOfUseAt;

  @OneToMany(
          cascade = {CascadeType.PERSIST, CascadeType.MERGE},
          mappedBy = "user"
  )
  @LazyCollection(LazyCollectionOption.FALSE)
  private Collection<Authority> authorities;

  @JsonBackReference
  @ManyToMany(cascade = CascadeType.MERGE, mappedBy = "users")
  private Collection<Project> projects;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getPassword() {
    return password;
  }

  @JsonProperty("password")
  public void setPasswordOriginal(String password) {
    this.password = password;
  }

  public void setPassword(String password) {
    this.password = PasswordUtilities.encode(password);
  }

  public TitleConstants getTitle() {
    return title;
  }

  public String getName() {
    return firstName+" "+lastName;
  }

  public void setTitle(TitleConstants title) {
    this.title = title;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getAffiliation() {
    return affiliation;
  }

  public void setAffiliation(String affiliation) {
    this.affiliation = affiliation;
  }

  public String getUserRef() { return userRef;  }

  public void setUserRef(String userRef) { this.userRef = userRef; }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Date getCreateAt() {
    return createAt;
  }

  public void setCreateAt(Date createAt) {
    this.createAt = createAt;
  }

  public Date getUpdateAt() {
    return updateAt;
  }

  public void setUpdateAt(Date updateAt) {
    this.updateAt = updateAt;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String getOrcid() {
    return orcid;
  }

  public void setOrcid(String orcid) {
    this.orcid = orcid;
  }

  public Integer getAcceptedTermsOfUse() {
    return acceptedTermsOfUse;
  }

  public void setAcceptedTermsOfUse(Integer acceptedTermsOfUse) {
    this.acceptedTermsOfUse = acceptedTermsOfUse;
  }

  public Date getAcceptedTermsOfUseAt() {
    return acceptedTermsOfUseAt;
  }

  public void setAcceptedTermsOfUseAt(Date acceptedTermsOfUseAt) {
    this.acceptedTermsOfUseAt = acceptedTermsOfUseAt;
  }

  public Collection<Project> getProjects() {
    return projects;
  }

  public void setProjects(Collection<Project> projects) {
    this.projects = projects;
  }

  @JsonIgnore
  public Set<AuthorityConstants> getUserAuthorities() {
    Set<AuthorityConstants> userAuthorities = new HashSet<>();
    if (authorities != null) {
      for (Authority authority : authorities) {
        userAuthorities.add(authority.getAuthority());
      }
    }
    return userAuthorities;
  }

  @JsonIgnore
  public void setUserAuthorities(Set<AuthorityConstants> userAuthorities) {
    this.authorities = new HashSet<>();
    for (AuthorityConstants userAuthority : userAuthorities) {
      Authority authority = new Authority();
      authority.setAuthority(userAuthority);
      authority.setUser(this);
      authorities.add(authority);
    }
  }

  public Collection<Authority> getAuthorities() {
    return authorities;
  }

  public void setAuthorities(Collection<Authority> authorities) {
    this.authorities = authorities;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof User)) return false;

    User user = (User) o;

    if (affiliation != null ? !affiliation.equals(user.affiliation) : user.affiliation != null)
      return false;
    if (userRef != null ? !userRef.equals(user.userRef) : user.userRef != null)
      return false;
    if (email != null ? !email.equals(user.email) : user.email != null) return false;
    if (firstName != null ? !firstName.equals(user.firstName) : user.firstName != null)
      return false;
    if (lastName != null ? !lastName.equals(user.lastName) : user.lastName != null) return false;
    if (password != null ? !password.equals(user.password) : user.password != null) return false;
    if (title != user.title) return false;
    if (country != null ? !country.equals(user.country) : user.country != null) return false;
    if (orcid != null ? !orcid.equals(user.orcid) : user.orcid != null) return false;
    if (acceptedTermsOfUseAt != null
            ? !acceptedTermsOfUseAt.equals(user.acceptedTermsOfUseAt)
            : user.acceptedTermsOfUseAt != null) return false;
    return acceptedTermsOfUse != null
            ? acceptedTermsOfUse.equals(user.acceptedTermsOfUse)
            : user.acceptedTermsOfUse == null;
  }

  @Override
  public int hashCode() {
    int result = password != null ? password.hashCode() : 0;
    result = 31 * result + (title != null ? title.hashCode() : 0);
    result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
    result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
    result = 31 * result + (affiliation != null ? affiliation.hashCode() : 0);
    result = 31 * result + (userRef != null ? userRef.hashCode() : 0);
    result = 31 * result + (email != null ? email.hashCode() : 0);
    result = 31 * result + (country != null ? country.hashCode() : 0);
    result = 31 * result + (orcid != null ? orcid.hashCode() : 0);
    result = 31 * result + (acceptedTermsOfUse != null ? acceptedTermsOfUse : 0);
    result = 31 * result + (acceptedTermsOfUseAt != null ? acceptedTermsOfUseAt.hashCode() : 0);
    return result;
  }
}
