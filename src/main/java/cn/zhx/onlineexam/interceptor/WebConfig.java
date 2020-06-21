package cn.zhx.onlineexam.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 访问页面拦截,登录后才能访问
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    //登录拦截
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/","/users","/class","/login","/assembly/**","/css/**","/images/**","/js/**","/layui/**");

    }
//   // 放行静态资源
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/static/**")
//                .addResourceLocations("classpath:/static/");
//    }
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //到登录界面
        registry.addViewController("/").setViewName("/login");
        registry.addViewController("/toLogin").setViewName("/login");
        //管理员后台主页
        registry.addViewController("/admin").setViewName("/admin/home");
        //教师端后台主页
        registry.addViewController("/teacher").setViewName("/admin/teaHome");
        //学生前台主页

        registry.addViewController("/student").setViewName("/index");
        //用户管理界面
        registry.addViewController("/user").setViewName("/admin/user/student");
        //用户管理-老师界面
        registry.addViewController("/user/teacher").setViewName("/admin/user/teacher");
        //用户管理-学生界面
        registry.addViewController("/user/student").setViewName("/admin/user/student");
        //试卷历史界面
        registry.addViewController("/toHisExam").setViewName("/admin/exam/hisExam");
        //试卷管理界面
        registry.addViewController("/exam").setViewName("/admin/exam/exam");
        //跳转到添加学生页面
        registry.addViewController("/toaddStudentPage").setViewName("/admin/user/addStudentPage");
        //跳转到添加老师页面
        registry.addViewController("/toaddTeacherPage").setViewName("/admin/user/addTeacherPage");
        //题目管理界面
        registry.addViewController("/question").setViewName("/admin/question/question");
        //跳转到添加试题页面
        registry.addViewController("/toaddQuestionPage").setViewName("/admin/question/addQuestionPage");
        //跳转到添加试题页面
        registry.addViewController("/toaddExamPage").setViewName("/admin/exam/addExamPage");
        //学生点击考试
        registry.addViewController("/toExam").setViewName("/exam");
        //跳转到成绩管理界面
        registry.addViewController("/toScorePage").setViewName("/admin/score/allExam");
        //跳转到班级管理界面
        registry.addViewController("/toClassPage").setViewName("/admin/ClassACourse/class");
        //跳转到课程管理界面
        registry.addViewController("/toCoursePage").setViewName("/admin/ClassACourse/course");

    }
}
