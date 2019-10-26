package com.wdzl.service;

import com.wdzl.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserService {
    private UserDao userdao;

    @Autowired(required = false)
    public void setUserDAO(UserDao userdao) {
        this.userdao = userdao;
    }

    public boolean hasMatch(String username,String password){
        System.out.println("============================= con sucess ============================");
        int count=userdao.ValidUser(username,password);
        return count>0;
    }

}
