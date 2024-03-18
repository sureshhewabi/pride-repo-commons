package uk.ac.ebi.pride.archive.repo.models.user;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import uk.ac.ebi.pride.archive.repo.util.AuthorityConstants;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author Jose A. Dianes
 * @version $Id$
 */
@Entity
@Table(name = "authorities")
@SequenceGenerator(
        name = "AuthoritySequence",
        sequenceName = "authoritySequence",
        allocationSize = 100
)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = Authority.class)
public class Authority implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AuthoritySequence")
  @Column(name = "authority_pk")
  private Long id;

  @NotNull
  @ManyToOne
  @JoinColumn(name = "user_fk")
  private User user;

  @NotNull
  @Enumerated(EnumType.STRING)
  private AuthorityConstants authority;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public AuthorityConstants getAuthority() {
    return authority;
  }

  public void setAuthority(AuthorityConstants authority) {
    this.authority = authority;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Authority)) return false;

    Authority authority1 = (Authority) o;

    if (authority != authority1.authority) return false;
    return user != null ? user.equals(authority1.user) : authority1.user == null;
  }

  @Override
  public int hashCode() {
    int result = user != null ? user.hashCode() : 0;
    result = 31 * result + (authority != null ? authority.hashCode() : 0);
    return result;
  }
}
