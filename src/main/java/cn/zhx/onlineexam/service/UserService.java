package cn.zhx.onlineexam.service;


import cn.zhx.onlineexam.entity.Criteria;
import cn.zhx.onlineexam.pojo.User;

import java.util.List;

public interface UserService {
    User checkUser(User user) throws Exception;
    int editPwd(User user) throws Exception;
    List<User> listUsers(Criteria criteria);
    int addUser(User user);
    int delUser(Long id);
    int editUser(User user);
    int editPSW(Long id);

    void delUserByClassid(Long id);
    // User findUserById(Long id);
}
