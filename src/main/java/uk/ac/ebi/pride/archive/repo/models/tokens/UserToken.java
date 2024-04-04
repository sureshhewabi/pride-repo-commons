package uk.ac.ebi.pride.archive.repo.models.tokens;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import uk.ac.ebi.pride.archive.repo.util.PasswordUtilities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@Table(name = "user_token")
public class UserToken implements Serializable {

    public enum Type {
        PASSWORD_RESET,
        REVIEWER_ACCESS
    }

    @Id
    @Column(name = "token_id")
    private String tokenId;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private Type type;

    @Column(name = "identifier")
    private String identifier; //email for password_reset, PXD accession for reviewer

    @Column(name = "token")
    private String token;

    @CreatedDate
    @Column(name = "created_date")
    private Date createdDate;

    @LastModifiedDate
    @Column(name = "last_modified_date")
    private Date lastModifiedDate;

    @Column(name = "expiry_date")
    private Date expiryDate;

    @JsonProperty("token")
    public void setTokenOriginal(String token) {
        this.token = token;
    }

    public void setToken(String token) {
        this.token = PasswordUtilities.encode(token);
    }

    @Override
    public String toString() {
        return "UserToken{" +
                "tokenId='" + tokenId + '\'' +
                ", identifier='" + identifier + '\'' +
                ", token='" + token + '\'' +
                ", createdDate=" + createdDate +
                ", lastModifiedDate=" + lastModifiedDate +
                ", expiryDate=" + expiryDate +
                '}';
    }
}
