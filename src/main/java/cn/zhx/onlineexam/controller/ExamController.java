package cn.zhx.onlineexam.controller;

import cn.zhx.onlineexam.entity.ClassSelect;
import cn.zhx.onlineexam.entity.Criteria;
import cn.zhx.onlineexam.entity.StudentExam;
import cn.zhx.onlineexam.pojo.*;
import cn.zhx.onlineexam.service.ClassCourseService;
import cn.zhx.onlineexam.service.ExamService;
import cn.zhx.onlineexam.service.QuestionService;
import cn.zhx.onlineexam.utils.LayuiJSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.lang.Class;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

@EnableTransactionManagement
@Controller
public class ExamController {
    @Resource
    ExamService examService;
    @Resource
    ClassCourseService classCourseService;
    @Resource
    QuestionService questionService;
    //信息管理
    @GetMapping("/exams")
    public @ResponseBody String exams(@RequestParam(value = "page", defaultValue = "1") Integer page,
                        @RequestParam(value = "limit", defaultValue = "10") Integer limit, Criteria criteria, HttpSession session) {
        PageHelper.startPage(page,limit);
        User user=(User)session.getAttribute("user");
        List<Exam> list =null;
        if (user.getType().equals(111L)){//表示学生登录
            list = examService.findExamsByClassId(user);
        }else{
            if(user.getType().equals(11L))criteria.setUserid(user.getId().intValue());//表示是老师
            list = examService.listExams(criteria);
        }
        PageInfo<Exam> pageInfo = new PageInfo<>(list);
        return LayuiJSON.jsonStr("",pageInfo.getTotal(),pageInfo.getList());
    }
    @GetMapping("/hisExam")
    public @ResponseBody String hisExams(@RequestParam(value = "page", defaultValue = "1") Integer page,
                        @RequestParam(value = "limit", defaultValue = "10") Integer limit, Criteria criteria, HttpSession session) {
        PageHelper.startPage(page,limit);
        User user=(User)session.getAttribute("user");
        List<Exam> list =null;
        if (user.getType().equals(111L)){//表示学生登录
            list = examService.findHisExamsByClassId(user);
        }else{
            if(user.getType().equals(11L))criteria.setUserid(user.getId().intValue());//表示是老师
            list = examService.listHisExams(criteria);
        }
        PageInfo<Exam> pageInfo = new PageInfo<>(list);
        return LayuiJSON.jsonStr("",pageInfo.getTotal(),pageInfo.getList());
    }
    @GetMapping("/expireExam")
    public @ResponseBody String expireExam(@RequestParam(value = "page", defaultValue = "1") Integer page,
                        @RequestParam(value = "limit", defaultValue = "10") Integer limit, Criteria criteria, HttpSession session) {
        PageHelper.startPage(page,limit);
        User user=(User)session.getAttribute("user");
        List<Exam> list = examService.findExpireExamsByClassId(user);
        PageInfo<Exam> pageInfo = new PageInfo<>(list);
        return LayuiJSON.jsonStr("",pageInfo.getTotal(),pageInfo.getList());
    }


    //跳转到试卷信息
    @GetMapping("/exams/{id}/{type}")
    public    String getexam(@PathVariable(value = "id") Long id,@PathVariable(value = "type") Long type,Model model) {
        Exam examById = examService.getExamById(id);
        List<cn.zhx.onlineexam.pojo.Class> listClass = classCourseService.listClass();
        //设置为多选框插件支持的json格式
        List<ClassSelect> classSelects=new ArrayList<>();
        for (cn.zhx.onlineexam.pojo.Class aClass : listClass) {
            ClassSelect classSelect=new ClassSelect(aClass.getName(),aClass.getId().toString(),null,null);
            //如果班级的id包含在试卷班级中,设置为selected="selected"
            if (examById.getClassids().contains(aClass.getId().toString())){
                classSelect.setSelected("selected");
            }
            classSelects.add(classSelect);
        }
        List<Difficult> listDifficult = questionService.listDifficult();
        List<Course> listCourse = classCourseService.listCourse();
        model.addAttribute("listDifficult",listDifficult);
        model.addAttribute("listClass",listClass);
        model.addAttribute("classSelects",classSelects);
        model.addAttribute("listCourse",listCourse);
        model.addAttribute("examById",examById);
        model.addAttribute("type",type);
        return "/admin/exam/addExamPage";
    }

    //添加试卷信息
    @PostMapping("/exams")
    public @ResponseBody  String addexam(Exam exam, HttpSession session) {
        User user=(User)session.getAttribute("user");
        exam.setTeacherid(user.getId());
        if (exam.getId()==null){
            examService.addExam(exam);
            return LayuiJSON.jsonStr("添加试卷成功!",1);
        }else{
            examService.editExam(exam);
            return LayuiJSON.jsonStr("修改试卷成功!",1);
        }
    }
    //删除试卷信息
    @Transactional
    @DeleteMapping("/exams/{id}")
    public  @ResponseBody  String delexam(@PathVariable(value = "id") Long id) {
        int i = examService.delExam(id);
        //把关联的该试卷的 学生历史试卷student-exam  ,exam-question删除
        examService.delStudentExamByExamId(id);
        examService.delExamQuestionByExamId(id);
        return LayuiJSON.jsonStr("删除成功!",i);
    }
    //修改信息
    @PostMapping("/editexam")
    public  @ResponseBody String editdexam(Exam exam) {
        int i = examService.editExam(exam);
        return LayuiJSON.jsonStr("修改成功!",i);
    }

    //点击开始考试
    @Transactional
    @GetMapping("/beginExam/{id}")
    public String  beginExam(@PathVariable(value = "id") Long id,Model model,HttpSession session) {
        User user=(User)session.getAttribute("user");
        //查看是否有之前的试卷,查询exam-question表
        int i = examService.findExamsByexamidAnduserid(id, user.getId());
        Exam examsByid = examService.findExamsByid(id);

        List<Question> questionsChoice =null;
        List<Question> questionsChoices =null;
        List<Question> questionsFill =null;
        List<Question> questionsTof =null;
        List<Question> questionsSubjective =null;
        if (i>0){
            //直接从数据库取出
            questionsChoice =  questionService.findHisQuestions(id,user.getId(),1);
            questionsChoices =  questionService.findHisQuestions(id,user.getId(),2);
            questionsFill =  questionService.findHisQuestions(id,user.getId(),3);
            questionsTof =  questionService.findHisQuestions(id,user.getId(),4);
            questionsSubjective =  questionService.findHisQuestions(id,user.getId(),5);
        }else {
            //先根据规定数量,难度,随机选出单选多选填空
            questionsChoice = questionService.listQuestionsByNum(examsByid.getChoicenum(), 1,examsByid.getDifficultid());
            questionsChoices = questionService.listQuestionsByNum(examsByid.getChoicesnum(),2,examsByid.getDifficultid());
            questionsFill = questionService.listQuestionsByNum(examsByid.getFillnum(),3,examsByid.getDifficultid());
            questionsTof = questionService.listQuestionsByNum(examsByid.getTofnum(),4,examsByid.getDifficultid());
            questionsSubjective = questionService.listQuestionsByNum(examsByid.getSubjectivenum(),5,examsByid.getDifficultid());
            //之后添加到数据库,记录该试卷,exam-question表
            addExamQuestion(id,user.getId(),questionsChoice, examService,examsByid.getDifficultid());
            addExamQuestion(id,user.getId(),questionsChoices, examService,examsByid.getDifficultid());
            addExamQuestion(id,user.getId(),questionsFill, examService,examsByid.getDifficultid());
            addExamQuestion(id,user.getId(),questionsTof, examService,examsByid.getDifficultid());
            addExamQuestion(id,user.getId(),questionsSubjective, examService,examsByid.getDifficultid());
        }

        model.addAttribute("questionsChoice",questionsChoice);//单选题
        model.addAttribute("questionsChoices",questionsChoices);//多选题
        model.addAttribute("questionsFill",questionsFill);//填空题
        model.addAttribute("questionsTof",questionsTof);//判断题
        model.addAttribute("questionsSubjective",questionsSubjective);//主观题
        model.addAttribute("examsByid",examsByid);
        return "exam";
    }


    //查看历史试卷
    @Transactional
    @GetMapping("/historyExam/{userid}/{examid}/{score}")
    public String  historyExam1(@PathVariable(value = "userid") Long userid,@PathVariable(value = "examid") Long examid,@PathVariable(value = "score") Double score,Model model,HttpSession session) {
        Exam examsByid = examService.findExamsByid(examid);
        //直接从数据库取出
        List<ExamQuestion>     questionsChoice =  questionService.findHisExamQuestions(examid,userid,1);
        List<ExamQuestion>    questionsChoices =  questionService.findHisExamQuestions(examid,userid,2);
        List<ExamQuestion>    questionsFill =  questionService.findHisExamQuestions(examid,userid,3);
        List<ExamQuestion>    questionsTof =  questionService.findHisExamQuestions(examid,userid,4);
        List<ExamQuestion>    questionsSubjective =  questionService.findHisExamQuestions(examid,userid,5);

        model.addAttribute("questionsChoice",questionsChoice);//单选题
        model.addAttribute("questionsChoices",questionsChoices);//多选题
        model.addAttribute("questionsFill",questionsFill);//填空题
        model.addAttribute("questionsTof",questionsTof);//判断题
        model.addAttribute("questionsSubjective",questionsSubjective);//主观题
        model.addAttribute("examsByid",examsByid);
        model.addAttribute("oldScore",score);
        return "historyExam";

    }





    //管理员删除历史试卷
    @Transactional
    @DeleteMapping("/historyExam/{userid}/{examid}")
    public String  historyExam(@PathVariable(value = "userid") Long userid,@PathVariable(value = "examid") Long examid,Model model,HttpSession session) {
      int i=examService.delStudentExam(userid,examid);//删除试卷
      int i2=examService.delExamQuestion(userid,examid);//删除关联试卷的题目信息
        return LayuiJSON.jsonStr("删除历史试卷成功!",i);
    }
    //老师修改主观题分数
    @Transactional
    @PostMapping("/addSubjectScore")
    public @ResponseBody  String addSubjectScore(ExamQuestion examQuestion) {
        int i=examService.updateExamQuestion(examQuestion.getQuestionid(),examQuestion.getUserid(),examQuestion.getAnswer(),null,examQuestion.getScore(),examQuestion.getExamid());
        //修改总分
        if (examQuestion.getOldScore()==null)examQuestion.setOldScore(0.0);
        examService.updateStudentExam(examQuestion.getUserid(),examQuestion.getExamid(),examQuestion.getTotal()-examQuestion.getOldScore()+examQuestion.getScore());
        return LayuiJSON.jsonStr("!",i);
    }

    //考试完后交卷了
    @Transactional
    @PostMapping("/endExam/{id}")
    public @ResponseBody  String endExam(@PathVariable(value = "id") Long id, Model model, HttpSession session, StudentExam studentExam) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        User user=(User)session.getAttribute("user");
        Exam examsByid = examService.findExamsByid(id);
        //查出每道题目的答案
        List<Question>  questionsChoice =  questionService.findHisQuestions(id,user.getId(),1);
        List<Question>  questionsChoices =  questionService.findHisQuestions(id,user.getId(),2);
        List<Question>   questionsFill =  questionService.findHisQuestions(id,user.getId(),3);
        List<Question>   questionsTof =  questionService.findHisQuestions(id,user.getId(),4);
        List<Question>   questionsSubjective =  questionService.findHisQuestions(id,user.getId(),5);
        //每道题目评分,仅限选择,判断,填空, 多选题由老师评分,通过反射
        Class c =studentExam.getClass();

        Double d1= addtoExamQuestion(questionsChoice,examsByid.getChoicescore(),"getQuestionsChoice",examService,c,studentExam,user,id);
        Double d2= addtoExamQuestion(questionsChoices,examsByid.getChoicesscore(),"getQuestionsChoices",examService,c,studentExam,user,id);
        Double d3= addtoExamQuestion(questionsFill,examsByid.getFillscore(),"getQuestionsFill",examService,c,studentExam,user,id);
        Double d4= addtoExamQuestion(questionsTof,examsByid.getTofscore(),"getQuestionsTof",examService,c,studentExam,user,id);
        //主观题
        for (int i = 0; i < questionsSubjective.size(); i++) {
            String methodName="getQuestionsSubjective"+(i+1);//方法名
            Method method =c.getMethod(methodName);
            String answer=(String)method.invoke(studentExam);//answer,学生的回答
            examService.updateExamQuestion(questionsSubjective.get(i).getId(),user.getId(),answer,null,null,id);
        }

        //添加历史试卷student-exam表
        examService.addStudentExam(id,studentExam.getBegintime(),studentExam.getEndtime(),d1+d2+d3+d4,user.getId());
        return LayuiJSON.jsonStr("",1,d1+d2+d3+d4);
    }
    //添加学生回答的客观题exam-question
    public static Double addtoExamQuestion(List<Question>  question,Double questionscore,String methodn,ExamService examService,Class c,StudentExam studentExam,User user,Long id) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Double total=0.0;//记录总分
        for (int i = 0; i < question.size(); i++) {
            String methodName=methodn+(i+1);//方法名
            //反射根据方法名执行方法
            Method method =c.getMethod(methodName);
            String trueAnswer=question.get(i).getAnswer();//正确答案
            String answer=null;
            if (methodn.equals("getQuestionsChoices")){//多选题前台是数组
                answer=studentExam.arrToStr((String[])method.invoke(studentExam));//answer,学生的回答
            }else{
                answer=(String)method.invoke(studentExam);//answer,学生的回答
            }
            if (answer==null)answer="";
            boolean b=answer.trim().equals(trueAnswer);
            int istrue=b?1:0;//回答是否正确istrue
            Double score=b?questionscore:0.0;//得分
            total+=score;//记录总分
            // 把学生的答题情况添加到exam-question表
            examService.updateExamQuestion(question.get(i).getId(),user.getId(),answer,istrue,score,id);
        }
        return  total;
    }
//添加随机形成的试卷顺序
    public static  void addExamQuestion(Long examid, Long userid, List<Question> questions,ExamService examService,Long difficultid){
        for (int i = 0; i < questions.size(); i++) {
            examService.addExamQuestion(examid,userid,questions.get(i).getId(),i+1);
        }
    }
}
