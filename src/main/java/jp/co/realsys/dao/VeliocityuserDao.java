package jp.co.realsys.dao;

import jp.co.realsys.model.user;

import java.util.List;

public interface VeliocityuserDao {
    public List<user> getAllUser();
    public List<Integer>  getAllSex();
    public List<user> getStudentByNameOrSex(user user);

    public int doDeleteUSER(user user);
    public int doRegisterUSER(user user);
}
