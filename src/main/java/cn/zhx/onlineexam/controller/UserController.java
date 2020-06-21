package cn.zhx.onlineexam.controller;

import cn.zhx.onlineexam.entity.Criteria;
import cn.zhx.onlineexam.pojo.User;
import cn.zhx.onlineexam.service.UserService;
import cn.zhx.onlineexam.utils.LayuiJSON;
import cn.zhx.onlineexam.utils.MD5Utils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class UserController {
    @Resource
    UserService userService;

    //学生信息管理
    @GetMapping("/users")
    public String users(@RequestParam(value = "page", defaultValue = "1") Integer page,
                 @RequestParam(value = "limit", defaultValue = "10") Integer limit, Criteria criteria) {
        PageHelper.startPage(page,limit);
        List<User> list = userService.listUsers(criteria);
        PageInfo<User> pageInfo = new PageInfo<>(list);
        return LayuiJSON.jsonStr("",pageInfo.getTotal(),pageInfo.getList());
    }
    //注册,添加学生信息,老师信息
    @PostMapping("/users")
    public String adduser(User user) {
        int i = userService.addUser(user);
        return LayuiJSON.jsonStr("注册成功!",i);
    }
    //删除学生信息
    @DeleteMapping("/users/{id}")
    public  String deluser(@PathVariable(value = "id") Long id) {
        int i = userService.delUser(id);
        return LayuiJSON.jsonStr("删除成功!",i);
    }
    //修改信息
    @PostMapping("/editUser")
    public String editduser(User user) {
        int i = userService.editUser(user);
        return LayuiJSON.jsonStr("修改成功!",i);
    }

}
