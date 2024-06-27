package org.example.dao;

import org.apache.ibatis.session.SqlSession;
import org.example.dto.EmployeeDTO;
import org.example.entity.Employee;
import org.example.entity.EmployeeModel;
import org.example.util.MyBatisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class EmployeeMapper {

    public List<EmployeeDTO> getAllEmployeeDTO(){
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        List<EmployeeDTO> employeeDTOList = session.selectList("getAllEmployeeDTO");
        session.commit();
        session.close();
        return employeeDTOList;
    }

    public Integer getLastUserId(){
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        return session.selectOne("getLastUserId");
    }

    public void insertEmployee(EmployeeModel employeeModel, String username){
        Employee employee = new Employee();
        employee.setEmpID(getLastUserId()+1);
        employee.setEmpName(employeeModel.getEmpName());
        employee.setEmpGender(employeeModel.getEmpGender().equals("Male"));
        employee.setEmpBirthday(Date.from(employeeModel.getEmpBirthday().atStartOfDay(ZoneId.systemDefault()).toInstant()));
        employee.setEmpPhone(employeeModel.getEmpPhone());
        employee.setEmpEmail(employeeModel.getEmpEmail());
        employee.setEmpAddress(employeeModel.getEmpAddress());
        employee.setTeamID(employeeModel.getTeamID());
        employee.setProjectID(employeeModel.getProjectID());
        employee.setEmpStartDate(Date.from(employeeModel.getEmpStartDate().atStartOfDay(ZoneId.systemDefault()).toInstant()));
        employee.setEmpStatus(employeeModel.getEmpStatus());
        employee.setLeader(false);
        employee.setCreateBy(username);
        employee.setCreateAt(LocalDateTime.now());
        employee.setUpdateBy(username);
        employee.setUpdateAt(LocalDateTime.now());
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        session.update("insertEmployee", employee);
        session.commit();
        session.close();
    }
}