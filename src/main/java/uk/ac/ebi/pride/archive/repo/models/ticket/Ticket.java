package uk.ac.ebi.pride.archive.repo.models.ticket;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import java.util.Date;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
public class Ticket {

    @Id
    private String ticketId;

    private String accession;

    private String submittedFilesPath;

    private String state;

    @CreatedDate
    private Date createdDate;

    @LastModifiedDate
    private Date lastModifiedDate;

    private String submitterEmail;

}
