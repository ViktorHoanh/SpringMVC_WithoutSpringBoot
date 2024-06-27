package org.example.entity;

import java.time.LocalDateTime;
import java.util.Date;

public class Employee {
    private Integer empID;
    private String empName;
    private Boolean empGender;
    private Date empBirthday;
    private String empPhone;
    private String empEmail;
    private String empAddress;
    private Date empStartDate;
    private Boolean empStatus;
    private String createBy;
    private String updateBy;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
    private Integer teamID;
    private Integer projectID;
    private Boolean isLeader;

    public Employee() {
    }

    public Employee(Integer empID, String empName, Boolean empGender, Date empBirthday, String empPhone, String empEmail, String empAddress, Date empStartDate, Boolean empStatus, String createBy, String updateBy, LocalDateTime createAt, LocalDateTime updateAt, Integer teamID, Integer projectID, Boolean isLeader) {
        this.empID = empID;
        this.empName = empName;
        this.empGender = empGender;
        this.empBirthday = empBirthday;
        this.empPhone = empPhone;
        this.empEmail = empEmail;
        this.empAddress = empAddress;
        this.empStartDate = empStartDate;
        this.empStatus = empStatus;
        this.createBy = createBy;
        this.updateBy = updateBy;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.teamID = teamID;
        this.projectID = projectID;
        this.isLeader = isLeader;
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

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt;
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

    public Boolean getLeader() {
        return isLeader;
    }

    public void setLeader(Boolean leader) {
        isLeader = leader;
    }
}
