package uk.ac.ebi.pride.archive.repo.models.tokens;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import uk.ac.ebi.pride.archive.repo.util.PasswordUtilities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@Table(name = "user_token")
public class UserToken {

    public enum Type {
        PASSWORD_RESET
    }

    @Id
    @Column(name = "token_id")
    private String tokenId;

    @Column(name = "user_email")
    private String userEmail;

    @Column(name = "pin")
    private String pin;

    @CreatedDate
    @Column(name = "created_date")
    private Date createdDate;

    @LastModifiedDate
    @Column(name = "last_modified_date")
    private Date lastModifiedDate;

    @Column(name = "expiry_date")
    private Date expiryDate;

    @JsonProperty("pin")
    public void setPinOriginal(String pin) {
        this.pin = pin;
    }

    public void SetPin(String pin) {
        this.pin = PasswordUtilities.encode(pin);
    }

    @Override
    public String toString() {
        return "UserToken{" +
                "tokenId='" + tokenId + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", pin='" + pin + '\'' +
                ", createdDate=" + createdDate +
                ", lastModifiedDate=" + lastModifiedDate +
                ", expiryDate=" + expiryDate +
                '}';
    }
}
