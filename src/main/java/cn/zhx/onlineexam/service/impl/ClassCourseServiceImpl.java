package cn.zhx.onlineexam.service.impl;

import cn.zhx.onlineexam.mapper.ClassCourseMapper;
import cn.zhx.onlineexam.pojo.Class;
import cn.zhx.onlineexam.pojo.Course;
import cn.zhx.onlineexam.pojo.Exam;
import cn.zhx.onlineexam.service.ClassCourseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ClassCourseServiceImpl implements ClassCourseService {

    @Resource
    ClassCourseMapper classCourseMapper;
    @Override
    public List<Class> listClass() {
        //为了把1,2,3,4转化为对应数字的班级 一班,二班,三班,四班
        List<Class> classes = classCourseMapper.listClass();
        List<Course> courses = classCourseMapper.listCourse();
        for (Class cls : classes) {
            String[] split = cls.getCourseid().split(",");
            StringBuffer ids = new StringBuffer();
            for (int i = 0; i < split.length; i++) {
                for (Course c : courses) {
                    if (c.getId().toString().equals(split[i])){
                        ids.append(c.getName()+",");
                    }
                }
            }
            cls.setCourseidnames(ids.substring(0,ids.length()-1));
        }
        return classes;
    }

    @Override
    public int addClass(Class cls) {
        return classCourseMapper.addClass(cls);
    }

    @Override
    public int delClass(Long id) {
        return classCourseMapper.delClass(id);
    }

    @Override
    public int editClass(Class cls) {
        return classCourseMapper.editClass(cls);
    }
    @Override
    public List<Course> listCourse() {
        return classCourseMapper.listCourse();
    }

    @Override
    public int addCourse(Course cls) {
        return classCourseMapper.addCourse(cls);
    }

    @Override
    public int delCourse(Long id) {
        return classCourseMapper.delCourse(id);
    }

    @Override
    public int editCourse(Course cls) {
        return classCourseMapper.editCourse(cls);
    }

    @Override
    public void delClassACourse(Long id) {

        classCourseMapper.delClassACourse(id);
    }


}
