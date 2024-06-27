package org.example.dao;

import org.apache.ibatis.session.SqlSession;
import org.example.entity.Team;
import org.example.util.MyBatisUtil;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TeamMapper {

    public List<Team> getAllTeam(){
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        List<Team> teamList = session.selectList("getAllTeam");
        session.commit();
        session.close();
        return teamList;
    }

}