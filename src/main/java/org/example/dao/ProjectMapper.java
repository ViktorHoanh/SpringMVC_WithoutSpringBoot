package org.example.dao;

import org.apache.ibatis.session.SqlSession;
import org.example.entity.Employee;
import org.example.entity.Project;
import org.example.util.MyBatisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProjectMapper {

    public List<Project> getAllProject(){
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        List<Project> projectList = session.selectList("getAllProject");
        session.commit();
        session.close();
        return projectList;
    }

}
