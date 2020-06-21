package cn.zhx.onlineexam.service.impl;

import cn.zhx.onlineexam.entity.Criteria;
import cn.zhx.onlineexam.mapper.UserMapper;
import cn.zhx.onlineexam.pojo.User;
import cn.zhx.onlineexam.service.UserService;
import cn.zhx.onlineexam.utils.MD5Utils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserMapper userMapper;
    @Override
    public User checkUser(User user) throws Exception {
        return userMapper.checkUser(user.getId().intValue());
    }

    @Override
    public int editPwd(User user) throws Exception {
        return userMapper.editPwd(user);
    }

    @Override
    public List<User> listUsers(Criteria criteria) {
        return userMapper.listUsers(criteria);
    }

    @Override
    public int addUser(User user) {
        try{
            if (user.getPassword()==null){//默认密码
                user.setPassword(MD5Utils.code("123456"));
            }
            user.setPassword(MD5Utils.code(user.getPassword()));
            return user.getClassid()==null?userMapper.addTeacher(user):userMapper.addStudent(user);
        }catch (Exception e){
            return 0;
        }

    }

    @Override
    public int delUser(Long id) {
        return userMapper.delUser(id);
    }

    @Override
    public int editUser(User user) {
        return userMapper.editUser(user);
    }

    @Override
    public int editPSW(Long id) {

        return userMapper.editPSW(id);
    }

    @Override
    public void delUserByClassid(Long id) {
        userMapper.delUserByClassid(id);
    }

}
