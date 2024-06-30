package org.example.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.example.dto.EmployeeDTO;
import org.example.entity.Employee;
import org.example.entity.EmployeeModel;
import org.example.util.EmployeeHandler;
import org.example.util.MyBatisUtil;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class EmployeeMapper {

    public List<EmployeeDTO> getAllEmployeeDTO(){
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        List<EmployeeDTO> employeeDTOList = session.selectList("getAllEmployeeDTO");
        session.commit();
        session.close();
        return employeeDTOList;
    }

    public Employee getEmployeeById(int empID){
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        Employee employee = session.selectOne("getEmployeeByID", empID);
        session.commit();
        session.close();
        return employee;
    }

    public void updateEmployee(EmployeeModel employeeModel, String username, Integer empID){
        if(checkValidEmp(employeeModel.getEmpName(), employeeModel.getEmpPhone(),employeeModel.getEmpStartDate(), employeeModel.getEmpBirthday(), employeeModel.getEmpEmail())) {
            SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
            Employee employee = new Employee();
            employee.setEmpID(empID);
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
            employee.setUpdateBy(username);
            employee.setUpdateAt(LocalDateTime.now());
            session.update("updateEmployee", employee);
            session.commit();
            session.close();
        }
    }

    public Integer getLastUserId(){
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        return session.selectOne("getLastUserId");
    }

    public void insertEmployee(EmployeeModel employeeModel, String username){
        if(checkValidEmp(employeeModel.getEmpName(), employeeModel.getEmpPhone(),employeeModel.getEmpStartDate(), employeeModel.getEmpBirthday(), employeeModel.getEmpEmail())){
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

    public void deleteEmployee(List<Integer> empIDs){
        try (SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession()) {
            session.delete("deleteEmployees", empIDs);
            session.commit();
        }
    }

    private Boolean checkValidEmp(String username, String phoneNumber, LocalDate startDate, LocalDate Birthday , String email){
        return EmployeeHandler.checkUsername(username) && EmployeeHandler.checkPhonenumber(phoneNumber) && EmployeeHandler.checkDate(startDate, Birthday) && EmployeeHandler.checkEmail(email);
    }

}