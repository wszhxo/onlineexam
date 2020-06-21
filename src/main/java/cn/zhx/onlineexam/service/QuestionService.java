package cn.zhx.onlineexam.service;

import cn.zhx.onlineexam.entity.Criteria;
import cn.zhx.onlineexam.pojo.Category;
import cn.zhx.onlineexam.pojo.Difficult;
import cn.zhx.onlineexam.pojo.ExamQuestion;
import cn.zhx.onlineexam.pojo.Question;

import java.util.List;

public interface QuestionService {

    List<Question> listQuestion(Criteria criteria);

    int addQuestion(Question question);

    int delQuestion(Long id);

    int editQuestion(Question question);

    List<Category> listCategory();

    List<Difficult> listDifficult();

    Question findQuestionById(Long id);

    List<Question> listQuestionsByNum(Long num,int Category,Long difficultid);

    List<Question> findHisQuestions(Long examid, Long userid, int category);

    List<ExamQuestion> findHisExamQuestions(Long id, Long id1, Integer i);
}
