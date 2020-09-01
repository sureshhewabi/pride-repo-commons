package uk.ac.ebi.pride.archive.repo.models.accession;


import javax.persistence.*;

@Entity
@Table(name = "pride_accession")
public class PrideAccession {

    @Id
    private String entity;

    @Column(name = "LAST_ID")
    private Long lastId;

    public PrideAccession() {
    }

    public PrideAccession(String entity, Long lastId) {
        this.entity = entity;
        this.lastId = lastId;
    }

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public Long getLastId() {
        return lastId;
    }

    public void setLastId(Long lastId) {
        this.lastId = lastId;
    }
}
