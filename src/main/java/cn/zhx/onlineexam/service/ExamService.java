package cn.zhx.onlineexam.service;

import cn.zhx.onlineexam.entity.Criteria;
import cn.zhx.onlineexam.pojo.Exam;
import cn.zhx.onlineexam.pojo.User;

import java.util.List;

public interface ExamService {
    List<Exam> listExams(Criteria criteria);

    int addExam(Exam exam);

    int delExam(Long id);

    int editExam(Exam exam);


    List<Exam> findExamsByClassId(User user);

    Exam findExamsByid(Long id);

    int addExamQuestion(Long examid, Long userid, Long questionid, int i);

    int findExamsByexamidAnduserid(Long id, Long id1);

    int updateExamQuestion(Long questionid, Long userid,  String answer, Integer istrue, Double score,Long examid);

    int addStudentExam(Long examid,String begintime, String endtime, Double total, Long userid);

    List<Exam> findHisExamsByClassId(User user);

    List<Exam> listHisExams(Criteria criteria);

    Exam getExamById(Long id);

    void delStudentExamByExamId(Long id);

    void delExamQuestionByExamId(Long id);

    int delStudentExam(Long userid, Long examid);

    int updateStudentExam(Long userid, Long examid,Double score);

    int delExamQuestion(Long userid, Long examid);

    List<Exam> findExpireExamsByClassId(User user);
}
