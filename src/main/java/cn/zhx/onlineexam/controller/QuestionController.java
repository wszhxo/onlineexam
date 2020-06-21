package cn.zhx.onlineexam.controller;

import cn.zhx.onlineexam.entity.Criteria;
import cn.zhx.onlineexam.pojo.Category;
import cn.zhx.onlineexam.pojo.Course;
import cn.zhx.onlineexam.pojo.Difficult;
import cn.zhx.onlineexam.pojo.Question;
import cn.zhx.onlineexam.service.ClassCourseService;
import cn.zhx.onlineexam.service.QuestionService;
import cn.zhx.onlineexam.utils.LayuiJSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class QuestionController {
    @Resource
    QuestionService questionService;
    @Resource
    ClassCourseService classCourseService;
    //点击登录
    @GetMapping("/questions")
    public @ResponseBody String question(@RequestParam(value = "page", defaultValue = "1") Integer page,
                           @RequestParam(value = "limit", defaultValue = "10") Integer limit, Criteria criteria) {
        PageHelper.startPage(page,limit);
        List<Question> list = questionService.listQuestion(criteria);
        PageInfo<Question> pageInfo = new PageInfo<>(list);
        return LayuiJSON.jsonStr("",pageInfo.getTotal(),pageInfo.getList());
    }
    //添加题目信息
    @PostMapping("/questions")
    public @ResponseBody String addQuestion(Question question) {
        if (question.getId()==null){
            int i = questionService.addQuestion(question);
            return LayuiJSON.jsonStr("添加成功!",i);
        }else{
            int i = questionService.editQuestion(question);
            return LayuiJSON.jsonStr("修改成功!",i);
        }
    }
    //删除题目信息
    @DeleteMapping("/questions/{id}")
    public @ResponseBody  String delQuestion(@PathVariable(value = "id") Long id) {
        int i = questionService.delQuestion(id);
        return LayuiJSON.jsonStr("删除成功!",i);
    }
    //跳转到修改信息页面
    @GetMapping("/questions/{id}")
    public String toEditdQuestion(@PathVariable(value = "id") Long id, Model model) {
        Question questionById = questionService.findQuestionById(id);
        List<Category> listCategory = questionService.listCategory();
        List<Difficult> listDifficult = questionService.listDifficult();
        List<Course> listCourse = classCourseService.listCourse();
        model.addAttribute("listCategory",listCategory);
        model.addAttribute("listDifficult",listDifficult);
        model.addAttribute("listCourse",listCourse);
        model.addAttribute("questionById",questionById);
        return "admin/question/addQuestionPage";
    }
    //获取所有题目种类
    @GetMapping("/categorys")
    public @ResponseBody String getCategory() {
        List<Category> list = questionService.listCategory();
        return LayuiJSON.jsonStr("",list.size(),list);
    }
    //获取所有题目种类
    @GetMapping("/difficults")
    public @ResponseBody String getDifficult() {
        List<Difficult> list = questionService.listDifficult();
        return LayuiJSON.jsonStr("",list.size(),list);
    }

}
