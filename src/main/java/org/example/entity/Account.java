package org.example.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Account {
    private String accountID;
    private String username;
    private String password;
    private String createBy;
    private String updateBy;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;

    public Account(String accountID, String username, String password, String updateBy, String createBy, LocalDateTime createAt, LocalDateTime updateAt) {
        this.accountID = accountID;
        this.username = username;
        this.password = password;
        this.updateBy = updateBy;
        this.createBy = createBy;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }

    public Account() {
    }

    public String getAccountID() {
        return accountID;
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
}
