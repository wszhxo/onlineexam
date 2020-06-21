package cn.zhx.onlineexam.mapper;


import cn.zhx.onlineexam.pojo.Class;
import cn.zhx.onlineexam.pojo.Course;
import org.apache.ibatis.annotations.*;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Mapper
@Configuration
public interface ClassCourseMapper {
    @Select("select * from Class ")
    List<Class> listClass();
    @Insert("insert into class(name) values(#{name})")
    int addClass(Class cls);
    @Delete("delete from class where id=#{id}")
    int delClass(Long id);
    @Update("update class set name=#{name} where id=#{id}")
    int editClass(Class cls);

    @Insert("insert into Course(name) values(#{name})")
    int addCourse(Course cls);
    @Delete("delete from Course where id=#{id}")
    int delCourse(Long id);
    @Update("update Course set name=#{name} where id=#{id}")
    int editCourse(Course cls);
    @Select("select * from course ")
    List<Course> listCourse();

    @Delete("delete from `class-course` where courseid=#{id}")
    void delClassACourse(Long id);
}
