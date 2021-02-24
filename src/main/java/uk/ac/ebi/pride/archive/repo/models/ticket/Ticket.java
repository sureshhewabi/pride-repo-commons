package uk.ac.ebi.pride.archive.repo.models.ticket;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
@Table(name = "ticket")
public class Ticket {

    public enum State {
        INCOMING,
        VALIDATED,
        SUBMITTED,
        PUBLISHED
    }

    @Id
    @Column(name = "ticket_id")
    private String ticketId;

    @Column(name = "accession")
    private String accession;

    @NotNull
    @Column(name = "submitted_files_path")
    private String submittedFilesPath;

    @Enumerated(EnumType.STRING)
    @Column(name = "state")
    private State state;

    @CreatedDate
    @Column(name = "created_date")
    private Date createdDate;

    @LastModifiedDate
    @Column(name = "last_modified_date")
    private Date lastModifiedDate;

    @Column(name = "submitter_email")
    private String submitterEmail;
}
