package cn.zhx.onlineexam.service;

import cn.zhx.onlineexam.pojo.Class;
import cn.zhx.onlineexam.pojo.Course;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface ClassCourseService {
    List<Class> listClass();
    int addClass(Class cls);
    int delClass(Long id);
    int editClass(Class cls);

    List<Course> listCourse();


    int addCourse(Course cls);
    int delCourse(Long id);
    int editCourse(Course cls);

    void delClassACourse(Long id);
}
