package uk.ac.ebi.pride.archive.repo.models.submission;

import uk.ac.ebi.pride.archive.repo.models.assay.Assay;
import uk.ac.ebi.pride.archive.repo.models.file.ProjectFile;
import uk.ac.ebi.pride.archive.repo.models.project.Project;

import java.util.List;
import java.util.Map;

public class Submission {

    private Project project;
    private List<Assay> assays;
    private Map<ProjectFile, String> projectFilesMap;

    public Submission(Project project, List<Assay> assays, Map<ProjectFile, String> projectFilesMap) {
        this.project = project;
        this.assays = assays;
        this.projectFilesMap = projectFilesMap;
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

    public Map<ProjectFile, String> getProjectFilesMap() {
        return projectFilesMap;
    }

    public void setProjectFilesMap(Map<ProjectFile, String> projectFilesMap) {
        this.projectFilesMap = projectFilesMap;
    }
}
