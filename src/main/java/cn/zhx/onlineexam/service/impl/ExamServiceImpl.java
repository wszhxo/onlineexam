package cn.zhx.onlineexam.service.impl;

import cn.zhx.onlineexam.entity.Criteria;
import cn.zhx.onlineexam.mapper.ClassCourseMapper;
import cn.zhx.onlineexam.mapper.ExamMapper;
import cn.zhx.onlineexam.pojo.Class;
import cn.zhx.onlineexam.pojo.Exam;
import cn.zhx.onlineexam.pojo.User;
import cn.zhx.onlineexam.service.ExamService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ExamServiceImpl implements ExamService {
    @Resource
    ExamMapper examMapper;
    @Resource
    ClassCourseMapper classCourseMapper;
    @Override
    public List<Exam> listExams(Criteria criteria) {

        //为了把1,2,3,4转化为对应数字的班级 一班,二班,三班,四班
        List<Class> classes = classCourseMapper.listClass();
        List<Exam> exams = examMapper.listExams(criteria);
        for (Exam exam : exams) {
            String[] split = exam.getClassids().split(",");
            StringBuffer ids = new StringBuffer();
            for (int i = 0; i < split.length; i++) {
                for (Class aClass : classes) {
                    if (aClass.getId().toString().equals(split[i])){
                        ids.append(aClass.getName()+",");
                    }
                }
            }
            exam.setClassidsname(ids.substring(0,ids.length()-1));
        }
        return exams;
    }

    @Override
    public int addExam(Exam exam) {
        //设置总分
        Double d1=exam.getChoicenum()*exam.getChoicescore();
        Double d2=exam.getChoicesnum()*exam.getChoicesscore();
        Double d3=exam.getTofnum()*exam.getTofscore();
        Double d4=exam.getFillnum()*exam.getFillscore();
        Double d5=exam.getSubjectivenum()*exam.getSubjectscore();
        exam.setTotal(d1+d5+d3+d2+d4);
        return examMapper.addExam(exam);
    }

    @Override
    public int delExam(Long id) {
        return examMapper.delExam(id);
    }

    @Override
    public int editExam(Exam exam) {
        return examMapper.editExam(exam);
    }

    @Override
    public List<Exam> findExamsByClassId(User user) {
        return examMapper.findExamsByClassId(user);
    }

    @Override
    public Exam findExamsByid(Long id) {
        return examMapper.findExamsByid(id);
    }

    @Override
    public int addExamQuestion(Long examid, Long userid, Long questionid, int i) {
        return examMapper.addExamQuestion(examid,userid,questionid,i);
    }

    @Override
    public int findExamsByexamidAnduserid(Long examid, Long userid) {
        return examMapper.findExamsByexamidAnduserid(examid,userid);
    }


    @Override
    public int updateExamQuestion(Long questionid,Long userid, String answer, Integer istrue, Double score,Long examid) {
        return examMapper.updateExamQuestion(questionid, userid,answer,istrue,score,examid);
    }


    @Override
    public int addStudentExam(Long examid, String begintime, String endtime, Double total, Long userid) {
        return examMapper.addStudentExam(examid,begintime,endtime,total,userid);
    }

    @Override
    public List<Exam> findHisExamsByClassId(User user) {
        return examMapper.findHisExamsByClassId(user);
    }

    @Override
    public List<Exam> listHisExams(Criteria criteria) {

        return examMapper.listHisExams(criteria);
    }

    @Override
    public Exam getExamById(Long id) {
        return examMapper.getExamById(id);
    }

    @Override
    public void delStudentExamByExamId(Long id) {
        examMapper.delStudentExamByExamId(id);
    }

    @Override
    public void delExamQuestionByExamId(Long id) {
        examMapper.delExamQuestionByExamId(id);
    }

    @Override
    public int delStudentExam(Long userid, Long examid) {
        return examMapper.delStudentExam(userid,examid);
    }

    @Override
    public int updateStudentExam(Long userid, Long examid,Double score) {
        Integer i=examMapper.checkSubject(userid,examid);//判断某位同学的试卷主观题是否全部批改
        if (i>0){
            return examMapper.updateStudentExam(userid,examid,score,0);
        }else {

            return examMapper.updateStudentExam(userid,examid,score,1);
        }
    }

    @Override
    public int delExamQuestion(Long userid, Long examid) {
        return examMapper.delExamQuestion(userid,examid);
    }

    @Override
    public List<Exam> findExpireExamsByClassId(User user) {
        return examMapper.findExpireExamsByClassId(user);
    }
}
