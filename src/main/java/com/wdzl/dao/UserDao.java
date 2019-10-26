package com.wdzl.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {


    private JdbcTemplate jdbcTemplate;
    private final static String Match_COUNT_SQL="Select count(*) from User where username=? and password=?";

    @Autowired(required = false)
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int ValidUser(String username,String password){
        System.out.println("=========================== 查到数据啦 ======================="+username);
        System.out.println("=========================== 查到数据啦 ======================="+password);
        return jdbcTemplate.queryForObject(Match_COUNT_SQL,new Object[]{username,password},Integer.class);
    }
}
