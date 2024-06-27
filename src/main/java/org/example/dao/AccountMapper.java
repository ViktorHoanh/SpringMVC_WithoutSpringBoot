package org.example.dao;

import org.apache.ibatis.session.SqlSession;
import org.example.dto.AccountDTO;
import org.example.entity.Account;
import org.example.util.MyBatisUtil;
import org.example.util.AccountHandler;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class AccountMapper {

    public Boolean checkAccount(String username, String password){
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        List<Account> accountList = session.selectList("getAllAccount");
        for (Account account : accountList) {
            if(account.getUsername().equals(username) && account.getPassword().equals(AccountHandler.hashPassword(password))){
                return true;
            }
        }
        session.commit();
        session.close();
        return false;
    }

    public Boolean checkExist(String username){
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        List<Account> accountList = session.selectList("getAllAccount");
        for (Account account : accountList) {
            if(account.getUsername().equals(username)){
                return true;
            }
        }
        session.commit();
        session.close();
        return false;
    }

    public void insertAccount(AccountDTO accountDTO){
        Account account = new Account();
        account.setUsername(accountDTO.getUsername());
        account.setPassword(AccountHandler.hashPassword(accountDTO.getPassword()));
        account.setCreateAt(LocalDateTime.now());
        account.setUpdateAt(LocalDateTime.now());
        account.setUpdateBy(accountDTO.getUsername());
        account.setCreateBy(accountDTO.getUsername());
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        session.update("insertAccount", account);
        session.commit();
        session.close();
    }

}