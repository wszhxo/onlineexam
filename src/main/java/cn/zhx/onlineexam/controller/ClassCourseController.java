package cn.zhx.onlineexam.controller;

import cn.zhx.onlineexam.entity.ClassSelect;
import cn.zhx.onlineexam.pojo.Class;
import cn.zhx.onlineexam.pojo.Course;
import cn.zhx.onlineexam.service.ClassCourseService;
import cn.zhx.onlineexam.service.UserService;
import cn.zhx.onlineexam.utils.LayuiJSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ClassCourseController {

    @Resource
    ClassCourseService classCourseService;
    @Resource
    UserService userService;

    @GetMapping("/class")
    public @ResponseBody
    String classs(@RequestParam(value = "page", defaultValue = "1") Integer page,
                 @RequestParam(value = "limit", defaultValue = "10") Integer limit) {
        PageHelper.startPage(page,limit);
        List<Class> list = classCourseService.listClass();
        PageInfo<Class> pageInfo = new PageInfo<>(list);
        return LayuiJSON.jsonStr("",pageInfo.getTotal(),pageInfo.getList());
    }

    @GetMapping("/course")
    public @ResponseBody
    String courses(@RequestParam(value = "page", defaultValue = "1") Integer page,
                 @RequestParam(value = "limit", defaultValue = "10") Integer limit) {
        PageHelper.startPage(page,limit);
        List<Course> list = classCourseService.listCourse();
        PageInfo<Course> pageInfo = new PageInfo<>(list);
        return LayuiJSON.jsonStr("",pageInfo.getTotal(),pageInfo.getList());
    }
    //添加班级
    @PostMapping("/class")
    public @ResponseBody String addClass(Class c) {
        if (c.getId()==null){
            int a =classCourseService.addClass(c);
            return LayuiJSON.jsonStr("添加班级成功!",a);
        }else{
            int a =classCourseService.editClass(c);
            return LayuiJSON.jsonStr("修改班级成功!",a);
        }
    }
    @Transactional
    @DeleteMapping("/class/{id}")
    public @ResponseBody String delClass(@PathVariable(value = "id") Long id) {
        int a = classCourseService.delClass(id);
        //删除该班级下的所有学生
        userService.delUserByClassid(id);
        return LayuiJSON.jsonStr("删除成功!",a);
    }
    @GetMapping("/courses")
    public @ResponseBody String getCourse() {
        List<Course> list = classCourseService.listCourse();
        return LayuiJSON.jsonStr("",list.size(),list);
    }
    @Transactional
    @DeleteMapping("/course/{id}")
    public @ResponseBody String delCourse(@PathVariable(value = "id") Long id) {
        int a = classCourseService.delCourse(id);
        //删除class表关联course的信息
        classCourseService.delClassACourse(id);
        return LayuiJSON.jsonStr("删除成功!",a);
    }


    //添加班级
    @PostMapping("/course")
    public @ResponseBody String addCourse(Course c) {
        if (c.getId()==null){
            int a =classCourseService.addCourse(c);
            return LayuiJSON.jsonStr("添加课程成功!",a);
        }else{
            int a =classCourseService.editCourse(c);
            return LayuiJSON.jsonStr("修改课程成功!",a);
        }
    }

    //获取所有班级
    @GetMapping("/classs")
    public @ResponseBody String getClasss() {
        List<Class> list = classCourseService.listClass();
        return LayuiJSON.jsonStr("",list.size(),list);
    }
    //获取所有班级多选框
    @GetMapping("/classSelect")
    public @ResponseBody String getClsSelect() {
        List<Class> list = classCourseService.listClass();
        //设置为多选框插件支持的json格式
        List<ClassSelect> classSelects=new ArrayList<>();
        for (Class aClass : list) {
            ClassSelect classSelect=new ClassSelect(aClass.getName(),aClass.getId().toString(),null,null);
            classSelects.add(classSelect);
        }
        return LayuiJSON.jsonStr("",classSelects.size(),classSelects);
    }
}
