package uk.ac.ebi.pride.archive.repo.models.project;

import com.fasterxml.jackson.annotation.*;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import uk.ac.ebi.pride.archive.dataprovider.data.peptide.PeptideSequenceProvider;
import uk.ac.ebi.pride.archive.dataprovider.data.protein.ProteinIdentificationProvider;
import uk.ac.ebi.pride.archive.dataprovider.param.ParamProvider;
import uk.ac.ebi.pride.archive.dataprovider.project.ProjectProvider;
import uk.ac.ebi.pride.archive.dataprovider.utils.SubmissionTypeConstants;
import uk.ac.ebi.pride.archive.repo.models.user.User;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Jose A. Dianes
 * @version $Id$
 */
@Entity
@FilterDef(name = "paramType")
@Table(name = "project_2")
//@SequenceGenerator(name = "ProjectSequence", sequenceName = "projectSequence", allocationSize = 100)
//@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property="id", scope=Project.class)
public class Project implements ProjectProvider {

    @Id
    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ProjectSequence")
    @Column(name = "project_pk")
    private Long id;

    //@JsonManagedReference
    @NotNull
    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "submitter_fk")
    private User submitter;

    //@JsonManagedReference
    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(
            name = "project_users_2",
            joinColumns = @JoinColumn(name = "project_fk"),
            inverseJoinColumns = @JoinColumn(name = "user_fk")
    )
    private Collection<User> users;

    @NotNull
    @Column(name = "accession", unique = true)
    private String accession;

    private String doi;

    @NotNull
    private String title;

    @Column(name = "project_description")
    private String projectDescription;

    @Column(name = "data_proc_protocol_descr")
    private String dataProcessingProtocol;

    @Column(name = "sample_proc_protocol_descr")
    private String sampleProcessingProtocol;

    @NotNull
    private String keywords;

    @NotNull
    @Column(name = "num_assays")
    private int numAssays;

    private String reanalysis;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "submission_type")
    private SubmissionTypeConstants submissionType;

    @NotNull
    @Column(name = "submission_date")
    private Date submissionDate;

    @Column(name = "publication_date")
    private Date publicationDate;

    @NotNull
    @Column(name = "update_date")
    private Date updateDate;

    @NotNull
    @Column(name = "is_public")
    private boolean publicProject;

    @Column(name = "other_omics_link")
    private String otherOmicsLink;

    //@JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "project")
    @LazyCollection(LazyCollectionOption.FALSE)
    private Collection<ProjectPTM> ptms;

    //@JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "project")
    @LazyCollection(LazyCollectionOption.FALSE)
    private Collection<Reference> references;

    //@JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "project")
    @LazyCollection(LazyCollectionOption.FALSE)
    private Collection<ProjectTag> projectTags;

    //@JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "project")
    @LazyCollection(LazyCollectionOption.FALSE)
    private Collection<LabHead> labHeads;

    //@JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "project_fk", insertable = false, updatable = false)
    @LazyCollection(LazyCollectionOption.FALSE)
    private Collection<ProjectSampleCvParam> samples;

    //@JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "project_fk", insertable = false, updatable = false)
    @LazyCollection(LazyCollectionOption.FALSE)
    private Collection<ProjectExperimentType> experimentTypes;

    //@JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "project_fk", insertable = false, updatable = false)
    @LazyCollection(LazyCollectionOption.FALSE)
    private Collection<ProjectQuantificationMethodCvParam> quantificationMethods;

    //@JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "project_fk", insertable = false, updatable = false)
    @LazyCollection(LazyCollectionOption.FALSE)
    private Collection<ProjectGroupUserParam> projectGroupUserParams;

    //@JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "project_fk", insertable = false, updatable = false)
    @LazyCollection(LazyCollectionOption.FALSE)
    private Collection<ProjectGroupCvParam> projectGroupCvParams;

    //@JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "project_fk", insertable = false, updatable = false)
    @LazyCollection(LazyCollectionOption.FALSE)
    private Collection<ProjectInstrumentCvParam> instruments;

    //@JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "project_fk", insertable = false, updatable = false)
    @LazyCollection(LazyCollectionOption.FALSE)
    private Collection<ProjectSoftwareCvParam> softwares;

    @NotNull
    private boolean changed;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getSubmitter() {
        return submitter;
    }

    public void setSubmitter(User submitter) {
        this.submitter = submitter;
    }

    public String getAccession() {
        return accession;
    }

    public void setAccession(String accession) {
        this.accession = accession;
    }

    public Optional<String> getDoi() {
        if (doi != null)
            return Optional.of(doi);
        return Optional.empty();
    }

    @JsonProperty("doi")
    public String getDoiOriginal() {
        return doi;
    }

    public void setDoi(String doi) {
        this.doi = doi;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

    public Set<String> getKeywords() {
        if (keywords != null) {
            return Arrays.stream(keywords.split(",")).collect(Collectors.toSet());
        } else {
            return new HashSet<String>();
        }
    }

    @JsonProperty("keywords")
    public String getKeywordsOriginal() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public int getNumAssays() {
        return numAssays;
    }

    public void setNumAssays(int numAssays) {
        this.numAssays = numAssays;
    }

    public String getReanalysis() {
        return reanalysis;
    }

    public void setReanalysis(String reanalysis) {
        this.reanalysis = reanalysis;
    }

    public Collection<ProjectExperimentType> getExperimentTypes() {
        return this.experimentTypes;
    }

    public void setExperimentTypes(Collection<ProjectExperimentType> experimentTypes) {
        this.experimentTypes = experimentTypes;
    }

    public String getSubmissionType() {
        return submissionType.toString();
    }

    public void setSubmissionType(SubmissionTypeConstants submissionType) {
        this.submissionType = submissionType;
    }

    public Date getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(Date submissionDate) {
        this.submissionDate = submissionDate;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Collection<User> getUsers() {
        return users;
    }

    public void setUsers(Collection<User> users) {
        this.users = users;
    }

    public Collection<ProjectPTM> getPtms() {
        return ptms;
    }

    public void setPtms(Collection<ProjectPTM> projectPTMs) {
        this.ptms = projectPTMs;
    }

    public Collection<Reference> getReferences() {
        return references;
    }

    public void setReferences(Collection<Reference> references) {
        this.references = references;
    }

    public Collection<ProjectTag> getProjectTags() {
        return projectTags;
    }

    public void setProjectTags(Collection<ProjectTag> projectTags) {
        this.projectTags = projectTags;
    }

    public Collection<LabHead> getLabHeads() {
        return labHeads;
    }

    public void setLabHeads(Collection<LabHead> labHeads) {
        this.labHeads = labHeads;
    }

    public Collection<ProjectSampleCvParam> getSamples() {
        return samples;
    }

    public void setSamples(Collection<ProjectSampleCvParam> projectSamples) {
        this.samples = projectSamples;
    }

    @JsonIgnore
    public Collection<ParamProvider> getParams() {
        Collection<ParamProvider> params = new LinkedList<>();

        if (this.projectGroupCvParams != null) params.addAll(this.projectGroupCvParams);
        if (this.projectGroupUserParams != null) params.addAll(this.projectGroupUserParams);

        return params;
    }

    public String getSampleProcessingProtocol() {
        return this.sampleProcessingProtocol;
    }

    public void setSampleProcessingProtocol(String sampleProcessingProtocol) {
        this.sampleProcessingProtocol = sampleProcessingProtocol;
    }

    public String getDataProcessingProtocol() {
        return this.dataProcessingProtocol;
    }

    public void setDataProcessingProtocol(String dataProcessingProtocol) {
        this.dataProcessingProtocol = dataProcessingProtocol;
    }

    public Set<String> getOtherOmicsLink() {

        if (otherOmicsLink != null) {
            Set<String> omnicsSet = new HashSet<String>();
            omnicsSet.add(otherOmicsLink);
            return omnicsSet;
        } else {
            return null;
        }
    }

    @JsonProperty("otherOmicsLink")
    public String getOtherOmicsLinkOriginal() {
        return otherOmicsLink;
    }

    public void setOtherOmicsLink(String otherOmicsLink) {
        this.otherOmicsLink = otherOmicsLink;
    }

    public Collection<ProjectInstrumentCvParam> getInstruments() {
        return instruments;
    }

    public void setInstruments(Collection<ProjectInstrumentCvParam> instruments) {
        this.instruments = instruments;
    }

    public Collection<ProjectQuantificationMethodCvParam> getQuantificationMethods() {
        return this.quantificationMethods;
    }

    public void setQuantificationMethods(Collection<ProjectQuantificationMethodCvParam> quantificationMethods) {
        this.quantificationMethods = quantificationMethods;
    }

    public boolean isPublicProject() {
        return this.publicProject;
    }

    public void setPublicProject(boolean publicProject) {
        this.publicProject = publicProject;
    }

    public Collection<ProjectGroupUserParam> getProjectGroupUserParams() {
        return projectGroupUserParams;
    }

    public void setProjectGroupUserParams(Collection<ProjectGroupUserParam> projectGroupUserParams) {
        this.projectGroupUserParams = projectGroupUserParams;
    }

    public Collection<ProjectGroupCvParam> getProjectGroupCvParams() {
        return projectGroupCvParams;
    }

    public void setProjectGroupCvParams(Collection<ProjectGroupCvParam> projectGroupCvParams) {
        this.projectGroupCvParams = projectGroupCvParams;
    }

    public void setSoftwares(Collection<ProjectSoftwareCvParam> softwares) {
        this.softwares = softwares;
    }

   @JsonProperty("softwares")
    public Collection<ProjectSoftwareCvParam> getSoftware() {
        return softwares;
    }

    @Override
    public Collection<? extends String> getSoftwares() {
        return null;
    }

    public boolean isChanged() {
        return changed;
    }

    public void setChanged(boolean changed) {
        this.changed = changed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Project)) return false;

        Project project = (Project) o;

        return accession.equals(project.accession);
    }

    @Override
    public int hashCode() {
        return accession.hashCode();
    }

    @JsonIgnore
    public Map<String, Collection<ProteinIdentificationProvider>> getProteinIdentifications() {
        return null;
    }

    @JsonIgnore
    public Collection<? extends PeptideSequenceProvider> getPeptideSequences() {
        return null;
    }

    @Override
    @JsonIgnore
    public Collection<? extends String> getAdditionalAttributesStrings() {
        return null;
    }

    @Override
    @JsonIgnore
    public String getDescription() {
        return null;
    }

    @Override
    @JsonIgnore
    public Collection<? extends String> getSubmitters() {
        return null;
    }

    @Override
    @JsonIgnore
    public Collection<? extends String> getHeadLab() {
        return null;
    }

    @Override
    @JsonIgnore
    public Collection<? extends String> getExperimentalFactors() {
        return null;
    }

    @Override
    @JsonIgnore
    public Collection<? extends String> getCountries() {
        return null;
    }

    @Override
    @JsonIgnore
    public Collection<? extends String> getAllAffiliations() {
        return null;
    }

    @Override
    @JsonIgnore
    public Collection<? extends String> getSampleAttributes() {
        return null;
    }
}
