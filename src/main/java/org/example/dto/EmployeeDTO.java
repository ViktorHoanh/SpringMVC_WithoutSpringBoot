package org.example.dto;

import java.time.LocalDateTime;
import java.util.Date;

public class EmployeeDTO {
    private Integer empID;
    private String empName;
    private Boolean empGender;
    private Date empBirthday;
    private String empPhone;
    private String empEmail;
    private String empAddress;
    private String teamName;
    private String projectName;
    private String leaderName;
    private Date empStartDate;
    private Boolean empStatus;

    public EmployeeDTO(Integer empID, String empName, Boolean empGender, Date empBirthday, String empPhone, String empEmail, String empAddress, String teamName, String projectName, String leaderName, Date empStartDate, Boolean empStatus) {
        this.empID = empID;
        this.empName = empName;
        this.empGender = empGender;
        this.empBirthday = empBirthday;
        this.empPhone = empPhone;
        this.empEmail = empEmail;
        this.empAddress = empAddress;
        this.teamName = teamName;
        this.projectName = projectName;
        this.leaderName = leaderName;
        this.empStartDate = empStartDate;
        this.empStatus = empStatus;
    }

    public EmployeeDTO() {
    }

    public Integer getEmpID() {
        return empID;
    }

    public void setEmpID(Integer empID) {
        this.empID = empID;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Boolean getEmpGender() {
        return empGender;
    }

    public void setEmpGender(Boolean empGender) {
        this.empGender = empGender;
    }

    public Date getEmpBirthday() {
        return empBirthday;
    }

    public void setEmpBirthday(Date empBirthday) {
        this.empBirthday = empBirthday;
    }

    public String getEmpPhone() {
        return empPhone;
    }

    public void setEmpPhone(String empPhone) {
        this.empPhone = empPhone;
    }

    public String getEmpAddress() {
        return empAddress;
    }

    public void setEmpAddress(String empAddress) {
        this.empAddress = empAddress;
    }

    public String getEmpEmail() {
        return empEmail;
    }

    public void setEmpEmail(String empEmail) {
        this.empEmail = empEmail;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getLeaderName() {
        return leaderName;
    }

    public void setLeaderName(String leaderName) {
        this.leaderName = leaderName;
    }

    public Date getEmpStartDate() {
        return empStartDate;
    }

    public void setEmpStartDate(Date empStartDate) {
        this.empStartDate = empStartDate;
    }

    public Boolean getEmpStatus() {
        return empStatus;
    }

    public void setEmpStatus(Boolean empStatus) {
        this.empStatus = empStatus;
    }
}