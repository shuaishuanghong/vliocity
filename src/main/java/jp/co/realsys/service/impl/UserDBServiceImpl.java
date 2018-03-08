package jp.co.realsys.service.impl;

import jp.co.realsys.dao.VeliocityuserDao;
import jp.co.realsys.model.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDBServiceImpl {
    @Autowired
    private VeliocityuserDao veliocityuserDao;
    public List<user>  getAllUser(){

        return veliocityuserDao.getAllUser();
    }

    public List<Integer>  getAllSex(){

        return veliocityuserDao.getAllSex();
    }

    public List<user> getStudentByNameOrSex(user u){
        return  veliocityuserDao.getStudentByNameOrSex(u);
    }
    public int doDeleteUSER(user u){
        return  veliocityuserDao.doDeleteUSER(u);
    }
    public int doRegisterUSER(user u){
        return  veliocityuserDao.doRegisterUSER(u);
    }
}
