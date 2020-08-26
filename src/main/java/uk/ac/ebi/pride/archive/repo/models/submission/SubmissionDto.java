package uk.ac.ebi.pride.archive.repo.models.submission;

import uk.ac.ebi.pride.archive.repo.models.assay.Assay;
import uk.ac.ebi.pride.archive.repo.models.file.ProjectFile;
import uk.ac.ebi.pride.archive.repo.models.project.Project;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class SubmissionDto {

    private Project project;
    private List<Assay> assays;
    private Map<String, String> projectFilesAssayMap;
    private Set<ProjectFile> projectFiles;

    public SubmissionDto(Project project, List<Assay> assays, Set<ProjectFile> projectFiles, Map<String, String> projectFilesAssayMap) {
        this.project = project;
        this.assays = assays;
        this.projectFiles = projectFiles;
        this.projectFilesAssayMap = projectFilesAssayMap;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public List<Assay> getAssays() {
        return assays;
    }

    public void setAssays(List<Assay> assays) {
        this.assays = assays;
    }

    public Map<String, String> getProjectFilesAssayMap() {
        return projectFilesAssayMap;
    }

    public Set<ProjectFile> getProjectFiles() {
        return projectFiles;
    }

    public void setProjectFiles(Set<ProjectFile> projectFiles) {
        this.projectFiles = projectFiles;
    }

    public void setProjectFilesAssayMap(Map<String, String> projectFilesAssayMap) {
        this.projectFilesAssayMap = projectFilesAssayMap;
    }
}
