package org.example.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class EmployeeModel {
    private String empName;
    private String empGender;
    private String empPhone;
    private String empAddress;
    private LocalDate empBirthday;
    private LocalDate empStartDate;
    private Integer teamID;
    private Integer projectID;
    private Boolean empStatus;
    private String empEmail;

    public EmployeeModel() {
    }

    public EmployeeModel(String empName, String empGender, String empPhone, String empAddress, LocalDate empBirthday, LocalDate empStartDate, Integer teamID, Integer projectID, Boolean empStatus, String empEmail) {
        this.empName = empName;
        this.empGender = empGender;
        this.empPhone = empPhone;
        this.empAddress = empAddress;
        this.empBirthday = empBirthday;
        this.empStartDate = empStartDate;
        this.teamID = teamID;
        this.projectID = projectID;
        this.empStatus = empStatus;
        this.empEmail = empEmail;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpGender() {
        return empGender;
    }

    public void setEmpGender(String empGender) {
        this.empGender = empGender;
    }

    public String getEmpPhone() {
        return empPhone;
    }

    public void setEmpPhone(String empPhone) {
        this.empPhone = empPhone;
    }

    public LocalDate getEmpBirthday() {
        return empBirthday;
    }

    public void setEmpBirthday(LocalDate empBirthday) {
        this.empBirthday = empBirthday;
    }

    public String getEmpEmail() {
        return empEmail;
    }

    public void setEmpEmail(String empEmail) {
        this.empEmail = empEmail;
    }

    public String getEmpAddress() {
        return empAddress;
    }

    public void setEmpAddress(String empAddress) {
        this.empAddress = empAddress;
    }

    public LocalDate getEmpStartDate() {
        return empStartDate;
    }

    public void setEmpStartDate(LocalDate empStartDate) {
        this.empStartDate = empStartDate;
    }

    public Boolean getEmpStatus() {
        return empStatus;
    }

    public void setEmpStatus(Boolean empStatus) {
        this.empStatus = empStatus;
    }

    public Integer getTeamID() {
        return teamID;
    }

    public void setTeamID(Integer teamID) {
        this.teamID = teamID;
    }

    public Integer getProjectID() {
        return projectID;
    }

    public void setProjectID(Integer projectID) {
        this.projectID = projectID;
    }
}