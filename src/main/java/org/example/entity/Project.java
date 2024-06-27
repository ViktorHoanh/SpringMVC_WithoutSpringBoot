package org.example.entity;

public class Project {
    private Integer projectID;
    private String projectName;

    public Project(Integer projectID, String projectName) {
        this.projectID = projectID;
        this.projectName = projectName;
    }

    public Project() {
    }

    public Integer getProjectID() {
        return projectID;
    }

    public void setProjectID(Integer projectID) {
        this.projectID = projectID;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
}
