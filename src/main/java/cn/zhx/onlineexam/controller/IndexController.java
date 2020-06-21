package cn.zhx.onlineexam.controller;

import cn.zhx.onlineexam.pojo.User;
import cn.zhx.onlineexam.service.UserService;
import cn.zhx.onlineexam.utils.LayuiJSON;
import cn.zhx.onlineexam.utils.MD5Utils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * @author zhx
 * @create 2020-01-21-14
 */
@RestController
public class IndexController {
    @Resource
    UserService userService;

    //点击登录后
    @PostMapping("/login")
    public   String login( HttpSession session, User user) throws Exception {
        User checkUser=  userService.checkUser(user);
        if (checkUser == null) {
            //用户不存在
            return LayuiJSON.jsonStr("账号不存在！",2);
        } else if (!checkUser.getPassword().equals(MD5Utils.code(user.getPassword()))) {
            //密码错误
            return LayuiJSON.jsonStr("密码错误！",3);
        } else if (checkUser.getType()!=user.getType()){
            //权限错误
            return LayuiJSON.jsonStr("请确认身份！",4);
        }else {
            //正确
            session.setAttribute("user", checkUser);
            return LayuiJSON.jsonStr("",checkUser.getType().intValue());
        }
    }

    //注销
    @GetMapping("/logout")
    public  String logout(HttpSession session) {
        session.removeAttribute("user");
        return LayuiJSON.jsonStr("注销成功!",1);
    }
    //修改密码
    @PostMapping("/editPwd")
    public  String editPwd(HttpSession session,@RequestParam String password)throws Exception    {
        User user=(User)session.getAttribute("user");
        user.setPassword(MD5Utils.code(password));
        int a=userService.editPwd(user);
        session.setAttribute("user",user);
        return LayuiJSON.jsonStr("",a);
    }
    //重置密码
    @PostMapping("/editPSW/{id}")
    public String editPSW(@PathVariable(value = "id") Long id) {
        int i = userService.editPSW(id);
        return LayuiJSON.jsonStr("重置密码成功!",i);
    }
}
